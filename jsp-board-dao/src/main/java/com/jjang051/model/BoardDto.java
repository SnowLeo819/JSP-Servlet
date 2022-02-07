package com.jjang051.model;
//lombok (매운 고추 이름)
public class BoardDto {
	private int no;
	private String name;
	private String subject;
	private String email;
	private String password;
	private String contents;
	private String regDate;
	private int hit;
	public BoardDto() {	}
	public BoardDto(int no, String name, String subject, String email, String password, String contents, String regDate,
			int hit) {
		this.no = no;
		this.name = name;
		this.subject = subject;
		this.email = email;
		this.password = password;
		this.contents = contents;
		this.regDate = regDate;
		this.hit = hit;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	@Override
	public String toString() {
		return "BoardDto [no=" + no + ", name=" + name + ", subject=" + subject + ", email=" + email + ", password="
				+ password + ", contents=" + contents + ", regDate=" + regDate + ", hit=" + hit + "]";
	}
	
	
}
