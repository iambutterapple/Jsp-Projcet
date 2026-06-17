package com.sample;

/*
 * 자바빈즈 : 자바클래스 중에 자바빈즈 규약에 맞게 작성된 클래스
 * 		
 * 			멤버변수가 getter/setter 메소드로 이루어짐
 * 			값을 저장하는 Value Object를 저장함
 * 
 * 액션태그
 * 	<jsp:useBean> 액션 태그
 * 		- 객체의 이름과 사용범위, 빈의 저장위치 등을 통해서 객체를 생성함
 * 		자바코드에서 action의 id속성에 지정된 값을 통해서 객체를 참조함
 * 		- 형식 : <jsp:useBean id ="빈이름" scope="범위"class="빈의 위치"/>
 * 		id		=> 객체 인스턴스를 식별하는 이름(객체명)
 * 		scope	=> 객체의 참조 유효범위(기본:page)
 * 		class	=> 클래스 이름
 * 
 * <jsp:setProperty> : 빈의 속성에 값을 설정하는 태그
 * 		형식
 * 		<jsp:setProperty name="빈 이름" property="프로퍼티명" value="저장할값"/>
 * 			name -> <jsp:useBean> 태그에 정의된 빈 객체의 이름
 * 			property -> 값을 설정하고자 하는 빈 속성의 이름, '*' 설정시 모든 인자값중
 * 						빈 속성과 데이터 자료형이 일치한는 것을 찾아 각각의 속성들을
 * 						각각의 인자값으로 설정한다.
 * 			value ->	빈 속성에 저장할 값을 읨함
 * <jsp:getProperty> : 빈의 속성값을 가져오는 태그
 * 		<jsp:getProperty name="빈 이름" property="프로퍼티명" value="저장할값"/>
 * 		name -> 속성을 가져올 빈 인스턴스 이름(객체명)
 * 		property-> 가져올 속성을 이름
 * */



public class SimpleData {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
