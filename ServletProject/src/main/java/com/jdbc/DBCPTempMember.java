package com.jdbc;

import javax.sql.*;
import java.sql.*;
import java.util.*;
import com.jdbc.*;
import javax.naming.*;


public class DBCPTempMember {

	
	
	DataSource ds;
	
	
	public DBCPTempMember() {
		
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/myoracle");
		} catch (NamingException ne) {
			ne.printStackTrace();
		}
	}
	
	
	public Vector<TempMemberVO> getMemberList(){
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		
		Vector<TempMemberVO> vectList = 
				new Vector<TempMemberVO>();
		
		try {
			
			con = ds.getConnection();
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
