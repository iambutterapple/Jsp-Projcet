package com.jdbc;
//value Object로 사용할 beans 클래스 작성


public class TempMemberVO {

	private String id;
	private String password;
	private String name;
	private String memb_num1;
	private String meme_num2;
	private String e_email;
	private String phone;
	private String address;
	private String job;
	private String zipcode;
	
	
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMemb_num1() {
		return memb_num1;
	}
	public void setMemb_num1(String memb_num1) {
		this.memb_num1 = memb_num1;
	}
	public String getMeme_num2() {
		return meme_num2;
	}
	public void setMeme_num2(String meme_num2) {
		this.meme_num2 = meme_num2;
	}
	public String getE_email() {
		return e_email;
	}
	public void setE_email(String e_email) {
		this.e_email = e_email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	
	
}
