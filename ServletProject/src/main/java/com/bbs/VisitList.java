package com.bbs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

//@WebServlet("/VisitList")
public class VisitList extends HttpServlet {
	private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			requestProcess(request, response);
		}
	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			requestProcess(request, response);
		}
		protected void requestProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		{
			response.setContentType("text/html;charset=UTF-8");
			
			PrintWriter out = response.getWriter();
			
			try {
				out.print("<html>");
				out.print("<body>");
				
				out.print("<head><title> 방명록 리스트</title></head>");
				
				String sql = "SELECT NO,WRITER,MEMO,REGDATE FROM VISIT ORDER BY NO DESC";
				
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try {
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con = DriverManager.getConnection(
							"jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
					pstmt = con.prepareStatement(sql);
					rs = pstmt.executeQuery();

					while (rs.next()) {
						int no = rs.getInt("NO");
						String writer = rs.getString("WRITER");
						String memo = rs.getString("MEMO");
						Date regdate = rs.getDate("REGDATE");
						
						
						out.print("<table align=center width=500 border=1 >");
						out.print("<tr>");

						out.print("<th width=50> 번호 </th>");
						out.print("<td width=50 align=center > "+ no+ "</td>");
						
						out.print("<th width=70> 작성자 </th>");
						out.print("<td width=180 align=center > "+ writer+ "</td>");
						
						out.print("<th width=70> 메모 </th>");
						out.print("<td width=180 align=center > "+ memo+ "</td>");
						
						out.print("<th width=50> 날짜 </th>");
						out.print("<td width=100 align=center > "+ regdate+ "</td>");
						
						out.print("<tr>");
						out.print("<th width=50> 내용 </th>");
						out.print("<td colspan =5> &nbsp;");
						
						out.print("<textarea row = 3 cols=50>");
						out.print(memo);
						out.print("</textarea>");
						
						out.print("</td>");
						out.print("</tr>");
						
						out.print("</tr>");
						out.print("</table>");
						out.print("<p>");
					}
					
					
				} catch (ClassNotFoundException ce) {
					ce.printStackTrace();
				} catch (SQLException se) {
					se.printStackTrace();
				} finally {
					try {
						if(rs!=null)
						{
							rs.close();
							
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
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
				}//finally end
				
				out.print("<p align = center >");
				out.print("<a href=/bbs/write.html >글쓰기 </a>");
				out.print("</p>");
				
				
				out.print("</body>");
				out.print("</html>");
				
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

}
