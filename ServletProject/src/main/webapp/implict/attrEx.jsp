<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--

	속성
		pageContext, HttpServletRequest 객체 중 하나
		설정해 놓은 객체를 의미함

		속성은 이들 객체에 Map 인스턴스와 마찬가지로 이름/값 쌍으로 저장되어 진다.
  		각각의 객체에 저장된 속성들을 서로 다른 생존범위(scope)를 가진다.
  		
  		
  	속성과 스코프
  	구분					접근				생존범위					사용
  	---------------------------------------------------------------------------------------------
  	ServletContext		|웹 어플리케이션 	| WAS가 Shutdown 			전체 어플리케이션에 공유되는
  						내의 모든 자원들	  되기 전 까지는 유효함		자원(Connection Pool,JINDI,
  																		이메일등)
   ---------------------------------------------------------------------------------------------------
    HttpSession			| 특정 세션에 접근할 | HttpSession 객체의 		| 클라이언트의 상태유지
    					 수 있는 서블릿이나		생존시까지 유효하다.	  정보나 장바구니
    					 JSP
   ---------------------------------------------------------------------------------------------------
  	HttpServletRequest  | 어플리케이션에서	| 클라리언트 요청 객체가	| MVC 패턴에서 
  						  request 접근 		유지되는 동안 유효하다.			model 정보를 View 에
  						  가능한 것들										전달할떄 사용한
   ---------------------------------------------------------------------------------------------------
	PageContext			| 해당 JSP내에서만	| JSP 내에서만 유효합니다.  						  
  
  	
  	속성과 파라미터의 차이점
  	
  	타입						속성				파라미터
  						ServletContext				ServletContext의 초기화 파라미터
  						HttpSession					ServletConfig의 초기화 파라미터
  						HttpServletRequest			HttpSErvletRequest의 파라미터
  						PageContext
  	---------------------------------------------------------------------------------------------------
  	설정메소드			setAttribute(String			초기파라미터
  						name,Object,value)			HttpServletRequest 의 경우 was가 한다.
  	---------------------------------------------------------------------------------------------------
  	리턴타입			Object						String
  	---------------------------------------------------------------------------------------------------
  	참조 메소드			getAttribute				getInitParameter(String name)
  						(String name)				또는 getParameter(String)
  						
  
  	**
  			request 속성과 requestDispatcher
  				-MVC 웹 어플리케이션에서 Model 에서 View 측으로 데이터를 넘겨줄때,
  				request scope에 데이터를 저장해서 View 측으로 전달해 주게 됨
  -->
<!DOCTYPE html>
<%
	//pageContextScope에 속성 저장하기
	pageContext.setAttribute("pageAttribtue", "홍길동");
	//pageContext.setAttribute("pageAttribtue", "홍길동",PageContext.PAGE_SCOPE);
	
	//request Scope에 속성 저장하기
	request.setAttribute("requestAttribute", "010-1234-10234");
	//pageContext.setAttribute("requestAttribute", "010-1234-1234",pageContext.REQUEST_SCOPE);
	
	
	//session Scope에 속성 저장하기
	session.setAttribute("sessionAttribute", "hong@naver.com");
	//pageContext.setAttribute("sessionAttribute", "hong@naver.com",
	//pageContext.SESSION_SCOPE);
	
	//application Scope에 속성 저장하기
	application.setAttribute("applicationAttribute", "Globalin(주)");
	//pageContext.setAttribute("applicationAttribute", "hong@naver.com",
	//pageContext.APPLICATION_SCOPE);
	

%>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
	<ul>
		<li>이름 : <%=pageContext.getAttribute("pageAttribtue") %>	</li>
		<li>전화번호 : <%=request.getAttribute("requestAttribute") %>	</li>
		<li>메일 : <%=session.getAttribute("sessionAttribute") %>	</li>
		<li>회사명 : <%=application.getAttribute("applicationAttribute") %>	</li>
		
	</ul>
</body>
</html>