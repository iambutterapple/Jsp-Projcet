package com.bbs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;


//@WebServlet("/VisitInsert")
public class VisitInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestProcess(request, response);
	}
	protected void requestProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		System.out.println("test");
		//인코딩처리
		request.setCharacterEncoding("utf-8");
		
		//클라이언트가 요청한 파라미터를 가지고 옴
		String writer =	request.getParameter("writer");
		String memo = 	request.getParameter("memo");
//		System.out.println("작성자 : " +writer);
//		System.out.println("memo : " +memo);
		//폼에서 가져온 파라미터를 데이터베이스에 저장한다.
		String sql = "INSERT INTO VISIT ( NO,WRITER,MEMO,REGDATE) "
				+ "VALUES(VISIT_SEQ.NEXTVAL,?,?,SYSDATE)";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, writer);
			pstmt.setString(2, memo);
			pstmt.executeUpdate();
		} catch (ClassNotFoundException ce) {

		} catch (SQLException se) {

		} finally {
			try {
				if(pstmt!=null)
				{
					pstmt.close();
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(con!=null)
				{
					con.close();
					
				}
			} catch (SQLException e) {
				e.printStackTrace();			
			}
		}
		response.sendRedirect("VisitList");
				
	}
	

}
