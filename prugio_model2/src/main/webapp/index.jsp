<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.pjh.jdbc.JDBCConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./include/header.jsp"  %>

<%
	String user_title = request.getParameter("user_title");
	String user_contents = request.getParameter("user_contents");
	
	System.out.println(user_title+"=="+user_contents);
	
	JDBCConnection  jdbc = new JDBCConnection();
	PreparedStatement pstmt = jdbc.pstmt;
	Connection conn = jdbc.conn;
	ResultSet rs = jdbc.rs;
	String sql = "SELECT * FROM PRUGIO";
	pstmt = conn.prepareStatement(sql);
	rs = pstmt.executeQuery();
%>

   <div id="mainVisual">
        <ul class="swiper-wrapper visualList">
            <li class="visual01 swiper-slide">
                <div class="img"></div>
                <div class="slogan">
                    <p><span>PRUGIO ART HALL</span></p>
                    <p><span>TO NEW MISSION</span></p>
                </div>
            </li>
            <li class="visual02 swiper-slide">
                <div class="img"></div>
                <div class="slogan">
                    <p><span>PRUGIO ART HALL</span></p>
                    <p><span>TO NEW MISSION</span></p>
                </div>
            </li>
        </ul>
        <button class="btn prev"><img src="images/prev_bx.png" alt=""></button>
        <button class="btn next"><img src="images/next_bx.png" alt=""></button>
        <div class="pagination"></div>
    </div>
    <!--mainVisual end-->
    <div id="motto" class="section">
        <div class="container">
            <div class="title">
                
            </div>
            <div class="contents">
                <p class="main">
                    SHARING PLACE TO SHARE JOY AND <br>
                    IMPRESSION THROUGH CULTURAL ART
                    <a href="">more view</a>
                </p>
                <p class="sub">
                    문화예술을 통한 즐거움과 감동을 공유하는 나눔터 <br>
                    푸르지오는 깨끗함, 싱그러움을 표현하는 "푸르다"라는 <br>
                    순우리말에 대지, 공간을 뜻하는 "GEO"를 결합하는 것으로 <br>
                    사람, 자연, 그리고 환경이 하나 된 차원 높은 생활 문화 공간을 의미한다.
                </p>
            </div>
        </div>
    </div>
    <div id="notice" class="section">
        <div class="container">
            <div class="title">
                <h2>
                    <span class="kor">공지사항</span>
                    <span class="eng">Notice</span>
                </h2>
                <p>푸르지오아트홀 소식입니다.</p>
            </div>
            <div class="contents">
                <ul>
                    <li>
                        <a href="">
                            <div class="dateBox">
                                <span class="date">05</span>
                                <span class="year">2021.03</span>
                            </div>
                            <div class="desc">
                                <p>"title")</p>
                            </div>
                        </a>
                        <div class="answer" style="whitespace"> 
                           "content"
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>

<%@ include file="./include/footer.jsp"  %>

