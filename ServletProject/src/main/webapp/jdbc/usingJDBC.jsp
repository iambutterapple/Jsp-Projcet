<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"	%>
<%

	Class.forName("oracle.jdbc.driver.OracleDriver");//oracle 데이터베이스 드라이버 검색
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	
     String id= ""
	,password = ""
	,name=""
	,memb_num1=""
	,meme_num2=""
	,e_email=""
	,phone=""
	,address=""
	,job=""; 

	
	
	int counter=0;
	
	try{
	
	con = DriverManager.getConnection(
			"jdbc:oracle:thin:@localhost:1521:orcl"
			,"scott"
			,"tiger");
	
	//오라클 데이터베이스 연결
	
	stmt = con.createStatement();
	String sql = "SELECT * FROM MEMBER";
	rs=stmt.executeQuery(sql);
	
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body bgcolor="#ffffcc">
<h2>JSP 스크립트릿에서 데이터베이스 연동</h2> <br>
<h3>회원정보</h3>
<table bordercolor="#0000ff" border="1">
	<tr>
		<td><strong>ID</strong></td>
		<td><strong>PW</strong></td>
		<td><strong>NAME</strong></td>
		<td><strong>MENU_NUM1</strong></td>
		<td><strong>MENU_NUM2</strong></td>
		<td><strong>E_MAIL</strong></td>
		<td><strong>PHONE</strong></td>
		<td><strong>ZIPCODE/ADDRESS</strong></td>
		<td><strong>JOB</strong></td>
	</tr>
	<%
		if(rs!=null){
			while(rs.next()){
				id=rs.getString("id");
				password=rs.getString("password");
				name=rs.getString("name");
				memb_num1=rs.getString("memb_num1");
				meme_num2=rs.getString("meme_num2");
				e_email=rs.getString("e_email");
				phone=rs.getString("phone");
				address=rs.getString("address");
				job=rs.getString("job");

		
	%>
	<tr>
	<td><%=id %></td>
	<td><%=password %></td>
	<td><%=name %></td>
	<td><%=memb_num1 %></td>
	<td><%=meme_num2 %></td>
	<td><%=e_email %></td>
	<td><%=phone %></td>
	<td><%=address %></td>
	<td><%=job %></td>
	<%
		counter++;
		
		}//end while
	}//enf if
	%>
	
	
	</tr>
	
</table>

<br>
total record: <%=counter %>

<%
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

%>
</body>
</html>