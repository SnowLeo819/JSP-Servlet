<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<% 
	String popupOn = "on";
	
	String oneDay = request.getParameter("oneDay");
	System.out.println("클라이언트에서 ajax로 요청보낸 값 oneDay : "+oneDay);
	if(oneDay != null && oneDay.equals("off")) {
		Cookie cookie = new Cookie("popupClose","off");
		cookie.setPath(request.getContextPath());
		cookie.setMaxAge(60*60*24);
		response.addCookie(cookie);
	}
	
	Cookie cookies [] = request.getCookies();
	for(Cookie cookie : cookies){
		String cookieName = cookie.getName();
		String cookieValue = cookie.getValue();
		out.println(cookieName+" : "+cookieValue+"<br>");
		if(cookieName.equals("popupClose")){
			popupOn = cookieValue;
		}
	};
%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <link rel="stylesheet" href="css/reset.css" />
    <link rel="stylesheet" href="css/layout.css" />
    <script src="js/jquery-3.6.0.min.js"></script>
  </head>
  <body>
    <h1>쿠키를 통한 팝업 띄우기</h1>
    
    <%
    	if(popupOn.equals("on")) {
    %>
    
    
    <div id="popup">
      <div class="contents">
        <h2>Notice</h2>
        <p>공지사항.. 텍스트</p>
        <p>공지사항.. 텍스트</p>
        <p>공지사항.. 텍스트</p>
        <p>공지사항.. 텍스트</p>
        <p>공지사항.. 텍스트</p>
      </div>
      <div class="btns">
        <button class="btn btnOneday">오늘 하루 이 창을 열지 않기</button>
        <button class="btn btnClose">닫기</button>
      </div>
    </div>
    <% 
    	} 
    %>
    <script>
      $(".btnClose").on("click", function () {
        $("#popup").hide();
      });
      $(".btnOneday").on("click", function () {
        $("#popup").hide();
        $.ajax({
        	url:"./cookiePopup01.jsp",
        	type: "get", // 기본이 get
        	data : {oneDay : "off"},
        	success : function(res){
        		if(res!=="") location.reload();
        	}
        })
      });
    </script>
  </body>
</html>
