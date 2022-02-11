<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="./include/header.jsp"%>
<main>
	<div class="inner">
		<h2 class="subTitle">BOARD LIST</h2>
		<div id="contents">
			<div class="tableBox">
				<table>
					<colgroup>
						<col style="width: 30px">
						<col style="width: 30px">
						<col style="width: 100px">
						<col>
						<col style="width: 200px">
						<col style="width: 200px">
						<col style="width: 50px">
					</colgroup>
					<thead>
						<tr>
							<th>in.NO</th>
							<th>re.NO</th>
							<th>NAME</th>
							<th>SUBJECT</th>
							<th>EMAIL</th>
							<th>DATE</th>
							<th>HIT</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${boardList }" var="boardDto" varStatus="loop" begin="1">
							<tr>
								<td>${loop.index }</td>
								<td>${boardDto.no }</td>
								<td>${boardDto.name }</td>
								<td class="space${boardDto.reStep }"><c:if
										test="${boardDto.reStep > 1 }">
										<span class="material-icons">subdirectory_arrow_right</span>
									</c:if> <a href="View.do?no=${boardDto.no }">${boardDto.subject }</a>
								</td>
								<td>${boardDto.email }</td>
								<td>${boardDto.regDate }</td>
								<td>${boardDto.hit }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<form action="BoardSearchList.do" class="from" method="get">  
					<div class="searchBox">
						<select name="search_select">	
							<option value="subject" ${param.search_select=="subject"?"selected":"" }>제목</option>
							<option value="name" ${param.search_select=="name"?"selected":"" }>작성자</option>
							<option value="contents" ${param.search_select=="contents"?"selected":"" }>내용</option>
						</select>
						<input type="text" placeholder="검색할 내용을 입력해주세요" name="search_word" value="${param.search_word }">
						<button class="btn btnBlack">검색</button>
					</div>
				</form>
				<div class="btns">
					<a href="Write.do" class="btn btnConfirm">글쓰기</a>
				</div>
			</div>
		</div>
	</div>
</main>

<%@ include file="./include/footer.jsp"%>

