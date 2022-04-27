<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<main>
	<div class="inner">
		<h2 class="subTitle">UPDATE</h2>
		<div id="contents">
			<!-- 데이터 받아서 처리하기....forward방식으로 데이터 보여주기....  -->
			<form method="POST" action="../board/UpdateBoardProcess.do" id="join" class="form">
				<table>
					<colgroup>
						<col style="width: 20%">
						<col style="width: 80%">
					</colgroup>
					<tbody>
						<tr>
							<th>name <span class="required">*</span></th>
							<td><input type="text" name="user_name" id="user_name"
								value="${boardDto.name }" disabled></td>
						</tr>
						<tr>
							<th>subject <span class="required">*</span></th>
							<td><input type="text" name="user_subject" id="user_subject"
								value="${boardDto.subject }"></td>
						</tr>

						<tr>
							<th>email <span class="required">*</span></th>
							<td><input type="text" name="user_email" id="user_email"
								value="${boardDto.email }"></td>
						</tr>
						<tr>
							<th>password <span class="required">*</span></th>
							<td><input type="password" name="user_pw" id="user_pw"
								placeholder="비밀번호를 입력하세요"></td>
						</tr>
						<tr>
							<th>contents<span class="required">*</span></th>
							<td><textarea id="summernote" name="user_contents" placeholder="내용을 입력하세요.">${boardDto.contents }</textarea></td>
						</tr>
					</tbody>
				</table>
				<input type="hidden" name="no" value="${boardDto.no }">
				<div class="btns">
					<button type="submit" class="btn btnConfirm">수정</button>
					<a href="../board/List.do" class="btn btnCancel">취소</a>
				</div>
			</form>
		</div>
	</div>
</main>
<script>

	//summernote 적용
	$('#summernote').summernote({
		height : 200,
		callbacks : {
			onImageUpload : function(files) {  // 드래그-드롭 업로드 가능하게 하는 구문
				for(let i=0;i<files.length;i++) {  // 한번에 여러 파일 업로드 하기
					uploadImage(files[i],this);    
				}
			}
		}
	});
	
	// 데이터 전달 방법..
	// queryString → view.do?img=aaa?text=bbb ;
	// from 태그 이용 → <form method="get 또는 post" action="넘길 페이지"></form>
	// FormData		
	
	function uploadImage(file, editor){
		const sendData = new FormData();
		sendData.append("uploadFile", file);   // <input type="file" name="uploadFile">
		$.ajax({
			url : "../SummerNoteFileUpload.do",
			type : "POST", 
			data : sendData,
			contentType : false,  // 기본값은 application/x-www-form-urlencode 임..  false 처리해야 multipart/form-data 로 처리
			processData : false,  // QueryString 형태로 전달되는 것을 막음..  default 값은 true    false 처리해야 url?name=AAA?pass=111  등으로 표현 가능
			dataType : "json",
			success : function(data){
				console.log(data);
				$(editor).summernote("editor.insertImage", data.url);  // fileURLMap 에서 입력한 값에 대응하는 내용을 가져옴
			},
			error : function(){
				alert("업로드에 실패하였습니다.");
			}
		})
	}
</script>
<%@ include file="../include/footer.jsp"%>






