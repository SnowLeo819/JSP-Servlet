<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="./include/header.jsp"  %>
    <div id="mainVisual">
        <ul class="swiper-wrapper visualList">
        	<c:forEach items="${visualList }" var="visualDto" varStatus="loop">
	            <li class="visual${loop.index } swiper-slide">
	                <div class="img" style="background-image:url('upload_visual/${visualDto.visualRealImg}')"></div>
	                <div class="slogan">
	                    <p><span>${visualDto.slogan }</span></p>
	                </div>
	            </li>
            </c:forEach>
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
                                <span class="date"></span>
                                <span class="year">2021.03</span>
                            </div>
                            <div class="desc">
                                <p></p>
                            </div>
                        </a>
                        <div class="answer" style="">
                            
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
<%@ include file="./include/footer.jsp"  %>