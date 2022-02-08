package com.pjh.model;

public class ClockDto {
	private int no;
	private String category;
	private String title;
	private int depth;
	private int price;
	private String link;
	private String clockImg;
	private String clockRealImg;
	
	public ClockDto() {
		super();
	}

	public ClockDto(int no, String category, String title, int depth, int price, String link, String clockImg,
			String clockRealImg) {
		super();
		this.no = no;
		this.category = category;
		this.title = title;
		this.depth = depth;
		this.price = price;
		this.link = link;
		this.clockImg = clockImg;
		this.clockRealImg = clockRealImg;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getClockImg() {
		return clockImg;
	}

	public void setClockImg(String clockImg) {
		this.clockImg = clockImg;
	}

	public String getClockRealImg() {
		return clockRealImg;
	}

	public void setClockRealImg(String clockRealImg) {
		this.clockRealImg = clockRealImg;
	}

	@Override
	public String toString() {
		return "ClockDto [no=" + no + ", category=" + category + ", title=" + title + ", depth=" + depth + ", price="
				+ price + ", link=" + link + ", clockImg=" + clockImg + ", clockRealImg=" + clockRealImg + "]";
	}
	
}
