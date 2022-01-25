<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<% 
	String state = "pop";

	String popState = request.getParameter("state");
	System.out.println("ajax 요청 값 == "+popState);
	if(popState != null && popState.equals("noPop")){
		Cookie cookie = new Cookie("setNoPop","noPop");
		cookie.setPath(request.getContextPath());
		cookie.setMaxAge(30);
		response.addCookie(cookie);
	}	
	Cookie cookies [] = request.getCookies();
	for(Cookie cookie : cookies){
		String cookieName = cookie.getName();
		String cookieValue = cookie.getValue();
		out.println(cookieName+"==="+cookieValue);
		if(cookieName.equals("setNoPop"))	{
			state = cookieValue;
		}	
	}
			
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
    	if(state.equals("pop")) {
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
    $(".btnClose").on("click",function(){
    	$("#popup").hide();
    });
	
    $(".btnOneday").on("click",function(){
    	$("#popup").hide();
    	$.ajax({
    		url : "./cookiePopup02.jsp",
    		type : "get",
    		data : {state : "noPop"},
    		success : response(res) 
    	})
    });
    
    </script>
  </body>
</html>
