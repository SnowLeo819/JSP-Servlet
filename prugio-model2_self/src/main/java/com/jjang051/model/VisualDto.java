package com.jjang051.model;

public class VisualDto {
	private int no;
	private String slogan;
	private String visualImg;
	private String visualRealImg;
	private String regDate;
	public VisualDto() {
		super();
	}
	public VisualDto(int no, String slogan, String visualImg, String visualRealImg, String regDate) {
		super();
		this.no = no;
		this.slogan = slogan;
		this.visualImg = visualImg;
		this.visualRealImg = visualRealImg;
		this.regDate = regDate;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getSlogan() {
		return slogan;
	}
	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}
	public String getVisualImg() {
		return visualImg;
	}
	public void setVisualImg(String visualImg) {
		this.visualImg = visualImg;
	}
	public String getVisualRealImg() {
		return visualRealImg;
	}
	public void setVisualRealImg(String visualRealImg) {
		this.visualRealImg = visualRealImg;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "VisualDto [no=" + no + ", slogan=" + slogan + ", visualImg=" + visualImg + ", visualRealImg="
				+ visualRealImg + ", regDate=" + regDate + "]";
	}
	
	
}
