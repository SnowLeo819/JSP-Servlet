package com.TISpjh.util;

public class PageWriter {
	// total 전체 게시글..
	// listPerPage 한 페이지에 보일 글 수
	// pageBlock 하단 페이지네이선 블록 수
	// clickPage 현재 눌려진 페이지 번호
	public static String pageWrite(int total, int listPerPage, int pageBlock, int clickPage, String requestURL) {
		String pageString = "";

		String rul = requestURL;
		if(requestURL.contains("search+word")) {
			
		}
		
//		total 로 전체페이지..
		int totalPages = (int)Math.ceil((double)total / listPerPage);
//		System.out.println(totalPages);

		// 페이지수..
		int tempPage = ((clickPage - 1) / pageBlock) * pageBlock + 1; 
		
		if(tempPage != 1 ) {
			pageString += "<li> "
					+ "<a href='"+requestURL+"?clickPage=1'>"
				 	+ "<span class='material-icons'> keyboard_double_arrow_left </span>"
		 			+ "</a>"
				 	+ "</li>";
			
			pageString += "<li> "
						+ "<a href='"+requestURL+"?clickPage="+(tempPage-1)+"'>"
					 	+ "<span class='material-icons'> chevron_left </span>"
			 			+ "</a>"
					 	+ "</li>";
		};	
		
		int pageBlockCount = 1;
		while(pageBlockCount<=pageBlock && tempPage<=totalPages) {
			if(tempPage == clickPage) {
				pageString += "<li class='active'><a href=''>"+tempPage+"</a></li>";
			} else {
				pageString += "<li class='active'>"
							+ "<a href='"+requestURL+"?clickPage="+tempPage+"'>"+tempPage
							+ "</a>"
							+ "</li>";
			}
			tempPage++;
			pageBlockCount++;
		};
		if (tempPage<=totalPages) {

			pageString += "<li> "
						+ "<a href='"+requestURL+"?clickPage="+tempPage+"'>"
					 	+ "<span class='material-icons'> chevron_right </span>"
			 			+ "</a>"
					 	+ "</li>";
			
			pageString += "<li> "
					+ "<a href='"+requestURL+"?clickPage="+totalPages+"'>"
				 	+ "<span class='material-icons'> keyboard_double_arrow_right </span>"
		 			+ "</a>"
				 	+ "</li>";
		}

//		System.out.println(pageString);
		return pageString;
	}
}
