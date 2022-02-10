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
						<col style="width: 100px">
						<col>
						<col style="width: 200px">
						<col style="width: 200px">
						<col style="width: 50px">
					</colgroup>
					<thead>
						<tr>
							<th>NO</th>
							<th>NAME</th>
							<th>SUBJECT</th>
							<th>EMAIL</th>
							<th>DATE</th>
							<th>HIT</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${boardList }" var="boardDto" varStatus="loop">
							<tr>
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
				<div class="btns">
					<a href="Write.do" class="btn btnConfirm">글쓰기</a>
				</div>
			</div>
		</div>
	</div>
</main>

<%@ include file="./include/footer.jsp"%>

