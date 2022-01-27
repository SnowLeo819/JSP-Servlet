<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
 	String loggedName = (String)session.getAttribute("name");
	String loggedId = (String)session.getAttribute("id");
%>	
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>INCLUDE</title>
    <link rel="stylesheet" href="css/reset.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&family=PT+Serif:wght@400;700&family=Raleway:wght@100;200;300;400;500;600;700;800;900&family=Titillium+Web:wght@200;300;400;600;700;900&display=swap"
      rel="stylesheet"
    />
    <link rel="stylesheet" href="css/layout.css" />
    <link rel="stylesheet" href="css/form.css" />
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="js/jquery-3.6.0.min.js"></script>  
    <script src="js/main.js" defer></script>
  </head>
  <body>
    <header id="header">
      <div class="container">
        <h1> <a href="/member">Snow Loepard</a></h1>
        <nav id="gnb">
          <h2 class="hidden">global navigation bar</h2>
              <ul>
                <li><a href="./login.jsp">로그인</a></li>
                <li><a href="./board.jsp">게시판</a></li>
                <li><a href="./join.jsp">회원가입</a></li>
                <li><a href="./list.jsp">회원관리</a></li>
              </ul>        
            	<!-- 
            	<ul>
                  <li><a href="./member_info.jsp?user_id=<%=loggedId %>"><%=loggedName %>님 </a></li>
                  <li><a href="./logout.jsp">로그아웃</a></li>
                  <li><a href="./board.jsp">게시판</a></li>
                  <li><a href="./list.jsp">회원관리</a></li>
                </ul> 
                -->        
        </nav>
      </div>
    </header>