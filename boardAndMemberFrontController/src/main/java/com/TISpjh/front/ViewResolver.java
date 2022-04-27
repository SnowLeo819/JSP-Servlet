package com.TISpjh.front;

// 접두, 접미 붙여서 view page 완성하기
public class ViewResolver {
	private String prefix; // 접두어
	private String suffix; // 접미어
	
	public ViewResolver() {
		super();
	}
	
	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	// 메서드 호출하면 접두. 접미 붙여서  ->  /WEB-INF/ + nextPage + .jsp
	public String getViewPage(String nextPage) {
		return prefix+nextPage+suffix;
	}
}
