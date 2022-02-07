package com.jjang051.model;

public class MonsterDto {
	private int no;
	private String title;
	private String contents;
	private String link;
	private String bg;
	private String monsterImg;
	private String monsterRealImg;
	
	public MonsterDto() {
		super();
	}

	public MonsterDto(int no, String title, String contents, String link, String bg, String monsterImg,
			String monsterRealImg) {
		super();
		this.no = no;
		this.title = title;
		this.contents = contents;
		this.link = link;
		this.bg = bg;
		this.monsterImg = monsterImg;
		this.monsterRealImg = monsterRealImg;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getBg() {
		return bg;
	}

	public void setBg(String bg) {
		this.bg = bg;
	}

	public String getMonsterImg() {
		return monsterImg;
	}

	public void setMonsterImg(String monsterImg) {
		this.monsterImg = monsterImg;
	}

	public String getMonsterRealImg() {
		return monsterRealImg;
	}

	public void setMonsterRealImg(String monsterRealImg) {
		this.monsterRealImg = monsterRealImg;
	}

	@Override
	public String toString() {
		return "MonsterDto [no=" + no + ", title=" + title + ", contents=" + contents + ", link=" + link + ", bg=" + bg
				+ ", monsterImg=" + monsterImg + ", monsterRealImg=" + monsterRealImg + "]";
	}
	
}
