<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./include/header.jsp"  %>
    <main>
      <div class="container">
	      <h2 class="subTitle">JOIN</h2>
		  <div id="contents">
		  	<!-- 데이터 받아서 처리하기....forward방식으로 데이터 보여주기....  -->
		  	<form method="POST" action="join_process.jsp" id="join" class="form">
		  		<table>
		  			<colgroup>
		  				<col style="width:20%">
		  				<col style="width:80%">
		  			</colgroup>
		  			<tbody>
		  				<tr>
		  					<th>아이디 <span class="required">*</span></th>
		  					<td><input type="text" name="user_id" id="user_id" placeholder="아이디를 입력하세요."></td>
		  				</tr>
		  				<tr>
		  					<th>패스워드 <span class="required">*</span></th>
		  					<td><input type="password" name="user_pw" id="user_pw" placeholder="비밀번호를 입력하세요."></td>
		  				</tr>
		  			</tbody>
		  		</table>
		  		<div class="btns">
		  			<a href="login_process.jsp" class="btn btnConfirm">로그인</a>
		  			<a href="/member_review" class="btn btnCancel">취소</a>
		  		</div>
		  	</form>
		  </div>      	
	  </div> 
    </main>
    <script>
    	$(".btnConfirm").on("click".function(){
    		if($("#user_id").val()=="") {
    			alert("아이디를 입력해주세요.")
    			$("#user_id").focus();
    			return false;
    		} else if ($("#user_pw").val()=="") {
    			alert("아이디를 입력해주세요.")
    			$("#user_pw").focus();
    			return false;
    		} 
    	});

	</script>
    
<%@ include file="./include/footer.jsp"  %>






