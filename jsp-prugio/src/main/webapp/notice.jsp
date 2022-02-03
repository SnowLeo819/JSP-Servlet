<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./include/header02.jsp"%>
<main class="formBox">
	<div class="container">
		<div id="contents">
			<form method="POST" action="notice_process.jsp" id="join" class="form">
		  		<table>
		  			<colgroup>
		  				<col style="width:20%">
		  				<col style="width:80%">
		  			</colgroup>
		  			<tbody>
		  				<tr>
		  					<th>title <span class="required">*</span></th>
		  					<td>
		  						<input type="text" name="user_title" id="user_title" placeholder="제목을 입력하세요.">
		  					</td>
		  				</tr>
		  				<tr>
		  					<th>contents <span class="required">*</span></th>
		  					<td>
		  						<textarea name="user_contents" placeholder="공지사항을 쓰세요.">
		  						</textarea>
		  					</td>
		  				</tr>
		  			</tbody>
		  		</table>
		  		<div class="btns">
		  			<button type="submit" class="btn btnConfirm">공지사항</button>
		  			<button type="reset" class="btn btnCancel">취소</button>
		  		</div>
		  	</form>
		</div>
	</div>
</main>
<%@ include file="./include/footer.jsp"%>