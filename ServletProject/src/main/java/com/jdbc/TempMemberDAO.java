package com.jdbc;

import java.util.*;
import java.sql.*;
public class TempMemberDAO {

	
	private final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	private final String USER = "scott";
	private final String PASSWORD = "tiger";
	
	public TempMemberDAO() {
		try {
			
			Class.forName(JDBC_DRIVER);
			
		} catch (Exception e) {
			System.out.println("Error:jDBC 로딩 실패");
		}
	
	}
	
	public Vector<TempMemberVO> getMemberList(){
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		
		Vector<TempMemberVO> vectList = 
				new Vector<TempMemberVO>();
		
		try {
			
			con = DriverManager.getConnection(JDBC_URL,USER,PASSWORD);
			stmt = con.createStatement();
			String sql = "SELECT * FROM MEMBER";
			rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				TempMemberVO vo = new TempMemberVO();
				vo.setId(rs.getString("ID"));
				vo.setPassword(rs.getString("PASSWORD"));
				vo.setName(rs.getString("NAME"));
				vo.setMemb_num1(rs.getString("MEMB_NUM1"));
				vo.setMeme_num2(rs.getString("MEME_NUM2"));
				vo.setE_email(rs.getString("E_EMAIL"));
				vo.setPhone(rs.getString("PHONE"));
				vo.setZipcode(rs.getString("ZIPCODE"));
				vo.setE_email(rs.getString("ADDRESS"));
				vo.setJob(rs.getString("JOB"));
				
				vectList.add(vo);
			}
			
			
		}catch(SQLException ss){
			ss.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(rs != null){
				try{
					rs.close();
				}catch(SQLException s){
					s.printStackTrace();
				}
			}
			if(stmt != null){
				try{
					stmt.close();
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
		return vectList;
	}
}
