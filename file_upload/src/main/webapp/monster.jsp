<%@page import="com.jjang051.model.MonsterDto"%>
<%@page import="com.jjang051.model.MonsterDao"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%	
	MonsterDao monsterDao = new MonsterDao();
	ArrayList<MonsterDto> monsterList =  monsterDao.getAllList();
	request.setAttribute("monsterList", monsterList);
%>

<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>&#128148;&#128148;&#128148;Hi~~ Clock Gallery</title>
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link
      href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&family=PT+Serif:wght@400;700&family=Raleway:wght@100;200;300;400;500;600;700;800;900&family=Titillium+Web:wght@200;300;400;600;700;900&display=swap"
      rel="stylesheet"
    />
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />
    <link rel="stylesheet" href="css/reset.css" />
    <link rel="stylesheet" href="css/common.css" />
    <link rel="stylesheet" href="css/splitting.css" />
    <link rel="stylesheet" href="css/swiper-bundle.css" />
    <link rel="stylesheet" href="css/fullpage.css" />
    <link rel="stylesheet" href="css/index.css" />
    <link rel="stylesheet" href="css/main02.css" />
    <script src="js/jquery-3.6.0.min.js"></script>
    <script src="js/js.cookie.min.js"></script>
    <script src="js/splitting.min.js"></script>
    <script src="js/swiper-bundle.min.js"></script>
    <script src="js/gsap/gsap.min.js"></script>
    <script src="js/gsap/CSSRulePlugin.min.js"></script>
    <script src="js/fullpage.min.js"></script>
    <script src="js/fullpage.extensions.min.js"></script>
    <script src="js/axios.min.js"></script>
    <script src="js/particles.min.js"></script>
    <script src="js/main.js" defer></script>
  </head>
  <body>
    <header id="header">
      <h1 id="logo">
        <img src="../images/logo.png" alt="" />
      </h1>
      <nav id="gnb">
        <ul>
          <li data-json="../data/mario.json" class="selected">
            <a href="/file_upload">MARIO</a>
          </li>
          <li data-json="../data/monster.json"><a href="">MONSTER</a></li>
        </ul>
      </nav>
      <div class="util">
        <a href="">JHyung's test page</a>
        <a href=""><span class="material-icons">favorite_border</span></a>
        <a href=""><span class="material-icons">search</span></a>
      </div>
    </header>
    <main id="main">
      <ul class="swiper-wrapper" id="monsterList">
      	<c:forEach items = "${monsterList }" var="monsterDto" varStatus="loop">
      		<li style="background:${monsterDto.bg}" class="swiper-slide">
      			<div class="info">
      				<h2 class="title" data-splitting>${monsterDto.title}</h2>
      				<p class="desc" data-splitting>${monsterDto.desc}</p>
      				<a href="${monsterDto.link}" target="">MORE</a>
    			</div>
	            <div class="img">
	            	<img src="${monsterDto.marioRealImg}">
	            </div>
          	</li>
      
      
      </c:forEach>

      
      </ul>
      <div class="pagination"></div>
    </main>
    <div id="loop">
      <img src="../images/supermario/supermario01.png" alt="" />
    </div>
  </body>
</html>
