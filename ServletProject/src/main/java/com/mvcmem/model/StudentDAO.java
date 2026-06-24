package com.mvcmem.model;

import java.sql.*;
import javax.sql.*;


import javax.naming.*;
import java.util.*;

public class StudentDAO {
	private static StudentDAO instance = null;
	public StudentDAO() {}
	
	public static StudentDAO getInstance() {
		if(instance == null) {
			synchronized (StudentDAO.class) {
				instance = new StudentDAO();
			}
		}
		return instance;
	}
	
	private Connection getConnection() {
		Connection con = null;
		
		try {

			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource	ds = (DataSource)envContext.lookup("jdbc/myoracle");
			con = ds.getConnection();
			
			
		} catch (NamingException ne) {
			System.out.println("Connection 생성 실패");
			ne.printStackTrace();
		} catch (SQLException se) {
			System.out.println("Connection 생성 실패");
			se.printStackTrace();
		}
		return con;
	}
	
	//아이디 중복체크 기능 구현
		public boolean idCheck(String id) {
			
			boolean result = true;
			
			Connection con = null;
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			
			try {
				
				
				//데이터베이스 연결
				con = getConnection();
				String sql = "SELECT * FROM STUDENT WHERE 1=1 AND ID = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				
				
				rs = pstmt.executeQuery();
				
				if(!rs.next()) 
					result = false;
				
				
			} catch (SQLException se) {
				se.printStackTrace();
				
			} finally{
				if(rs != null){
					try{
						rs.close();
					}catch(SQLException s){
						s.printStackTrace();
					}
				}
				if(pstmt != null){
					try{
						pstmt.close();
					}catch(SQLException s){
						s.printStackTrace();
					}
				}
				if(con != null){
					try{
						con.close();
					}catch(SQLException s){
						s.printStackTrace();
					}
				}
			}
			

			return result;
			
		}//end idCheck
		
		
		
		
		
		
		
		
		/*
		 * 우편번호 DB에서 검색해서 결과를 Vector에 저장해서 리턴해주는 
		 * 기능을 구현한다.
		 * 
		 * */
		public Vector<ZipCodeVO> zipcodeRead(String dong){
			
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			Vector<ZipCodeVO> vecList = new Vector<ZipCodeVO>();
			
			
			
			try {
				
				con = getConnection();
				
				//동이름을 조건으로 하여 데이터베이스에서 우편번호를 검색하는 쿼리문 작성
				String sql = "SELECT * FROM ZIPCODE WHERE 1=1 AND DONG LIKE '" + dong + "%'";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				
				while(rs.next()) {
					ZipCodeVO tempZipcode = new ZipCodeVO();
					tempZipcode.setZipcode(rs.getString("zipcode"));
					tempZipcode.setSido(rs.getString("sido"));
					tempZipcode.setGugun(rs.getString("gugun"));
					tempZipcode.setDong(rs.getString("dong"));
					tempZipcode.setRi(rs.getString("ri"));
					tempZipcode.setBunji(rs.getString("bunji"));
					
					vecList.add(tempZipcode);
				}
				
			} catch (SQLException se) {
				se.printStackTrace();
				
			} finally{
				if(rs != null){
					try{
						rs.close();
					}catch(SQLException s){
						s.printStackTrace();
					}
				}
				if(pstmt != null){
					try{
						pstmt.close();
					}catch(SQLException s){
						s.printStackTrace();
					}
				}
				if(con != null){
					try{
						con.close();
					}catch(SQLException s){
						s.printStackTrace();
					}
				}
			}
			return vecList;
		}//end zipcodeRead
		
		
		/*
		 * 회원가입처리
		 * 실제로 데이터베이스에 회원데이터를 저장하기 위하여 메소드 구현한다.
		 * */
		public boolean memeberInsert(StudnetVO vo) {
			Connection con = null;
			PreparedStatement pstmt = null;
			
			boolean flag = false;
			
			try {
				
				con = getConnection();
				
				String sql = "INSERT INTO STUDENT VALUES(?,?,?,?,?,?,?,?,?,?)";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, vo.getId());
				pstmt.setString(2, vo.getPass());
				pstmt.setString(3, vo.getName());
				pstmt.setString(4, vo.getPhone1());
				pstmt.setString(5, vo.getPhone2());
				pstmt.setString(6, vo.getPhone3());
				pstmt.setString(7, vo.getEmail());
				pstmt.setString(8, vo.getZipcode());
				pstmt.setString(9, vo.getAddress1());
				pstmt.setString(10, vo.getAddress2());
				
				int count = pstmt.executeUpdate();
				
				if(count > 0)
					flag = true;
				
				
			} catch (SQLException se) {
				se.printStackTrace();
				
			} finally{
				if(pstmt != null){
					try{
						pstmt.close();
					}catch(SQLException s){
						s.printStackTrace();
					}
				}
				if(con != null){
					try{
						con.close();
					}catch(SQLException s){
						s.printStackTrace();
					}
				}
			}
			
			return flag;
			
		}//end memberInsert
		
		/*
		 * 로그인 버튼을 클릭하면 로그인 폼에 입력한 아이디와 비밀번호가
		 * 데이터베이스에 저장된 정보와 비교해서 같으면 로그인 성공
		 * 다르면 로그인 실패를 처리하는 메소드 구현
		 * 
		 * 반환값이
		 * 1 : 로그인 성공, 0: 비밀번호 오류, -1 : 아이디가 없음
		 * */
		
		public int loginCheck(String id,String pass) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			int check = -1;
			
			try {
			
				con = getConnection();
				String sql = "SELECT PASS FROM STUDENT WHERE 1=1 AND ID = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					//아이디로 비밀번호를 검색한 결과가 있다면
					String dbPass = rs.getString("pass");
					
					if(pass.equals(dbPass))
					{
						//사용자가 입력한 비밀번호화 데이터베이스에 저장된 비밀번호가
						//같으면
						check = 1;
						
					}else
						//비밀번호가 같지 않을 경우
						check = 0;
					
					
				}
				
			} catch (SQLException e) {

			} finally{
				if(rs != null){
					try{
						rs.close();
					}catch(SQLException s){
						s.printStackTrace();
					}
				}
				if(pstmt != null){
					try{
						pstmt.close();
					}catch(SQLException s){
						s.printStackTrace();
					}
				}
				if(con != null){
					try{
						con.close();
					}catch(SQLException s){
						s.printStackTrace();
					}
				}
			}
			
			return check;
			
		}//end loginCheck
		
		
		/*
		 * 로그인 성공 후 회원정보 수정 버튼을 클릭하면 회원 정보를 수정할 수 있도록
		 * 미리 화면에 보여줌
		 * 세션에 설정된 아이디를 가지고 회원정보를 가져오는 메소드를 구현
		 * */
		public StudnetVO getMember(String id) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			StudnetVO vo = null;
			
			try {
				 con = getConnection();
				 String sql = "SELECT * FROM STUDENT WHERE 1=1 AND ID = ?";
				 pstmt = con.prepareStatement(sql);
				 
				 pstmt.setString(1, id);
				 rs = pstmt.executeQuery();
				 
				 if(rs.next())
				 {
					 //해당 아이디에 대한 회원 정보가 존재한다면
					 vo = new StudnetVO();
					 vo.setId(rs.getString("id"));
					 vo.setPass(rs.getString("pass"));
					 vo.setName(rs.getString("name"));
					 vo.setPhone1(rs.getString("phone1"));
					 vo.setPhone2(rs.getString("phone2"));
					 vo.setPhone3(rs.getString("phone3"));
					 vo.setEmail(rs.getString("email"));
					 vo.setZipcode(rs.getString("zipcode"));
					 vo.setAddress1(rs.getString("address1"));
					 vo.setAddress2(rs.getString("address2"));
				 }
				
				
			} catch (SQLException se) {
				se.printStackTrace();
			} finally{
				if(rs != null){
					try{
						rs.close();
					}catch(SQLException s){
						s.printStackTrace();
					}
				}
				if(pstmt != null){
					try{
						pstmt.close();
					}catch(SQLException s){
						s.printStackTrace();
					}
				}
				if(con != null){
					try{
						con.close();
					}catch(SQLException s){
						s.printStackTrace();
					}
				}
			}
			return vo;
		}//end getMember
		
		
		/*
		 * 회원정보를 수정하는 메소드를 구현한다.
		 * 회원정보수정 버튼을 클릭하여 데이터베이스에 저장된 정보가
		 * 수정되도록 메소드로 구현한다.
		 * 
		 * */
		public void updateMember(StudnetVO vo) {
			
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = getConnection();
				
				String sql = "UPDATE STUDENT SET PASS=?, PHONE1=?, PHONE2=?, PHONE3=? "
						+ ", EMAIL=? , ZIPCODE=? , ADDRESS1=? , ADDRESS2=? "
						+ "WHERE 1=1 AND ID=? ";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, vo.getPass());
				pstmt.setString(2, vo.getPhone1());
				pstmt.setString(3, vo.getPhone2());
				pstmt.setString(4, vo.getPhone3());
				pstmt.setString(5, vo.getEmail());
				pstmt.setString(6, vo.getZipcode());
				pstmt.setString(7, vo.getAddress1());
				pstmt.setString(8, vo.getAddress2());
				pstmt.setString(9, vo.getId());
				pstmt.executeUpdate();
				
			} catch (SQLException se) {
				se.printStackTrace();
			} finally{
				if(pstmt != null){
					try{
						pstmt.close();
					}catch(SQLException s){
						s.printStackTrace();
					}
				}
				if(con != null){
					try{
						con.close();
					}catch(SQLException s){
						s.printStackTrace();
					}
				}
			}
			
		}//end updateMember
		
		
		/*
		 * 회원탈퇴 버튼을 클릭하면 실제로 데이터베이스에서 회원 데이터가 삭제 처리 되어야한다.
		 * 회원삭제처리할 메소드 구현
		 * */
		public int deleteMember(String id,String pass){
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			int check = -1;
			
			try {
			
				con = getConnection();
				String sql = "SELECT PASS FROM STUDENT WHERE 1=1 AND ID = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					//아이디로 비밀번호를 검색한 결과가 있다면
					String dbPass = rs.getString("pass");
					
					if(pass.equals(dbPass))
					{
						//사용자가 입력한 비밀번호화 데이터베이스에 저장된 비밀번호가
						//같으면 삭제 처리
						String sql1  = "DELETE FROM STUDENT WHERE 1=1 AND ID = ?";
						pstmt = con.prepareStatement(sql1);
						pstmt.setString(1, id);
						pstmt.executeUpdate();
						check = 1;//회원탈퇴성공
						
					}else
						//비밀번호가 같지 않을 경우
						check = 0;
					
					
				}
				
			} catch (SQLException e) {

			} finally{
				if(rs != null){
					try{
						rs.close();
					}catch(SQLException s){
						s.printStackTrace();
					}
				}
				if(pstmt != null){
					try{
						pstmt.close();
					}catch(SQLException s){
						s.printStackTrace();
					}
				}
				if(con != null){
					try{
						con.close();
					}catch(SQLException s){
						s.printStackTrace();
					}
				}
			}
			return check;
		}
}
