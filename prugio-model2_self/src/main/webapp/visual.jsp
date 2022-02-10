<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./include/header02.jsp"%>
<main class="formBox">
	<div class="container">
		<div id="contents">
			<form method="POST" action="VisualUpload.do" id="join" class="form"  enctype="multipart/form-data">
		  		<table>
		  			<colgroup>
		  				<col style="width:20%">
		  				<col style="width:80%">
		  			</colgroup>
		  			<tbody>
		  				<tr>
		  					<th>slogan <span class="required">*</span></th>
		  					<td>
		  						<input type="text" name="user_slogan01" id="user_slogan01" placeholder="슬로건을 입력하세요.">
		  					</td>
		  				</tr>
		  				<tr>
		  					<th>visual <span class="required">*</span></th>
		  					<td>
		  						<input type="file" name="user_visual01" id="user_visual01" placeholder="배경으로 쓸 이미지를 입력하세요.">
		  					</td>
		  				</tr>
		  			</tbody>
		  		</table>
		  		<div class="btns" style="justify-content:flex-end">
		  			<button class="btn btnConfirm" id="btnPlus">추가하기</button>
		  			<button class="btn btnConfirm" id="btnMinus">삭제하기</button>
		  		</div>
		  		<div class="btns">
		  			<button type="submit" class="btn btnConfirm">확인</button>
		  			<button type="reset" class="btn btnCancel">취소</button>
		  		</div>
		  	</form>
		</div>
	</div>
</main>
<script>
	let count = 1;
	function addZero(num) {
		if(num<10) return "0"+num;
		else return ""+num;
	}
	$("#btnMinus").on("click",function(){
		if(count>1) {
			count--;
			$("#join tbody tr:last-child").remove();
			$("#join tbody tr:last-child").remove();
		}
		return false;
	});
	$("#btnPlus").on("click",function(){
		count++;
		$("#join tbody").append(`
				<tr>
					<th>slogan <span class="required">*</span></th>
					<td>
						<input type="text" name="user_slogan\${addZero(count)}" id="user_slogan\${addZero(count)}" placeholder="슬로건을 입력하세요.">
					</td>
				</tr>
				<tr>
					<th>visual <span class="required">*</span></th>
					<td>
						<input type="file" name="user_visual\${addZero(count)}" id="user_visual\${addZero(count)}" placeholder="배경으로 쓸 이미지를 입력하세요.">
					</td>
				</tr>`);
		return false;
	})

</script>
<%@ include file="./include/footer.jsp"%>