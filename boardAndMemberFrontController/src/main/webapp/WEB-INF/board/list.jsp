<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../include/header.jsp"%>
<main>
	<div class="inner">
		<h2 class="subTitle">BOARD LIST</h2>
		<div id="contents">
			<div class="tableBox">
				<form action="AllDelete.do" method="POST">
					<div class="btns right" style="margin-bottom: 10px">
							<c:if test="${!empty loggedId }">
								<a href="Write.do" class="btn btnConfirm" style="height: 40px">글쓰기</a>
							</c:if>
							<c:if test="${isManager == true}">
								<button id="btnAllDelete" class="btn right btnDelete"
									style="height: 40px">일괄삭제 ${isManager }</button>
							</c:if>
					</div>
					<table>
						<colgroup>
							<col style="width: 30px">
							<col style="width: 30px">
							<col style="width: 100px">
							<col>
							<col style="width: 200px">
							<col style="width: 200px">
							<col style="width: 50px">
							<c:choose>
								<c:when test="${isManager == true}">
									<col style="width: 50px">
								</c:when>
							</c:choose>
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
								<c:choose>
									<c:when test="${isManager == true}">
										<th><input type="checkbox" id="allCheck" name="allCheck">
										</th>
									</c:when>
								</c:choose>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${boardList }" var="boardDto" varStatus="loop">
								<tr>
									<td></td>
									<td>${boardDto.no }</td>
									<td>${boardDto.name }</td>
									<td class="space${boardDto.reStep } left"
										style="padding: 0 20px"><c:if
											test="${boardDto.reStep > 1 }">
											<span class="material-icons">subdirectory_arrow_right</span>
										</c:if> <a href="View.do?no=${boardDto.no }">${boardDto.subject }</a>
									</td>
									<td>${boardDto.email }</td>
									<td>${boardDto.regDate }</td>
									<td>${boardDto.hit }</td>
									<c:choose>
										<c:when test="${isManager == true}">
											<td><input type="checkbox" class="deleteCheck"
												name="delete_check" value="${boardDto.no }"></td>
										</c:when>
									</c:choose>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</form>
				<form action="BoardSearchList.do" class="from" method="get">
					<div class="searchBox">
						<select name="search_select">
							<option value="subject" selected>제목</option>
							<option value="name">작성자</option>
							<option value="contents">내용</option>
						</select> <input type="text" placeholder="검색할 내용을 입력해주세요"
							name="search_word">
						<button class="btn btnBlack">검색</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</main>
<script>
	$("#allCheck").on("click", function() {
		const isChecked = $(this).prop("checked");
		$(".deleteCheck").prop("checked", isChecked);
		console.log(isChecked);
	})
</script>


<%@ include file="../include/footer.jsp"%>

