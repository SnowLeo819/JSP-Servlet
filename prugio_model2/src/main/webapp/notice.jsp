<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./include/header02.jsp"%>

<main class="formBox">
	<div class="container">
		<h2 class="subTitle">NOTICE</h2>
		  <div id="contents">
			<form action="notice_process.jsp" method="POST">
				<table>
					<colgroup>
						<col style="width: 20%">
						<col style="width: 80%">
					</colgroup>
					<tbody>
						<tr>
							<th>제목</th>
							<td><input type="text" name="user_title" id="user_title"
								placeholder="제목을 입력하세요."></td>
						</tr>
						<tr>
							<th>내용</th>
							<td>
							<textarea name="user_contents" id="user_contents"
									placeholder="내용을 입력하세요." rows="" cols=""></textarea>
							</td>
						</tr>
					</tbody>
				</table>
				<div class="btns">
					<button type="submit" class="btn btnConfirm">저장</button>
					<button type="reset" class="btn btnCancel">취소</button>
				</div>
			</form>
		</div>
	</div>
</main>

<%@ include file="./include/footer.jsp"%>

