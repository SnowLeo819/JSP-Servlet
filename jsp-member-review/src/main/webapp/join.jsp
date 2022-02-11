<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./include/header.jsp"  %>
    <main>
      <div class="container">
	      <h2 class="subTitle">JOIN</h2>
		  <div id="contents">
		  	<!-- 데이터 받아서 처리하기....forward방식으로 데이터 보여주기....  -->
		  	<form method="POST" action="join_process02.jsp" id="join" class="form">
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
		  				<tr>
		  					<th>패스워드 확인 <span class="required">*</span></th>
		  					<td><input type="password" name="user_pw_confirm" id="user_pw_confirm" placeholder="비밀번호를 입력하세요."></td>
		  				</tr>
		  				<tr>
		  					<th>이름 <span class="required">*</span></th>
		  					<td><input type="text" name="user_name" id="user_name" placeholder="이름을 입력하세요."></td>
		  				</tr>
		  				<tr>
		  					<th>이메일 <span class="required">*</span></th>
		  					<td><input type="text" name="user_email" id="user_email" placeholder="메일을 입력하세요."></td>
		  				</tr>
		  				<tr>
		  					<th>전화번호 <span class="required">*</span></th>
		  					<td>
		  						<select name="user_phone_first" class="short">
		  							<option value="010" selected>010</option>
		  							<option value="011">011</option>
		  							<option value="017">017</option>
		  						</select>
		  						<input type="text" name="user_phone_middle" class="short" id="user_phone_middle" placeholder="전화번호를 입력하세요.">
		  						<input type="text" name="user_phone_last" class="short" id="user_phone_last" placeholder="전화번호를 입력하세요.">
		  					</td>
		  				</tr>
		  				<tr>
		  					<th>주소 <span class="required">*</span></th>
		  					<td>
		  						<div>
		  							<input type="number" name="zipcode" placeholder="우편번호" class="short" id="zipcode">
		  							<button class="btn btnZipcode">우편번호</button>
		  						</div>
		  						<div class="addrBox">
		  							<input type="text" name="address01" placeholder="기본주소" id="address01">
		  							<span class="sticker">기본 주소</span>
		  						</div>
		  						<div class="addrBox">
		  							<input type="text" name="address02" placeholder="나머지 주소" id="address02">
		  							<span class="sticker">나머지 주소</span>
		  						</div>
		  					</td>
		  				</tr>
		  			</tbody>
		  		</table>
		  		<div class="btns">
		  			<button type="submit" class="btn btnConfirm">회원가입</button>
		  			<button type="reset" class="btn btnCancel">취소</button>
		  		</div>
		  	</form>
		  </div>      	
	  </div>
    </main>
    <script>
    	$(".btnConfirm").on("click",function(){
    		if($("#user_id").val()=="") {
    			alert("ID를 입렫해 주세요");
    			$("#user_id").focus();
    			return false;
    		} else if($("#user_pw").val()=="") {
    			alert("password를 입렫해 주세요");
    			$("#user_pw").focus();
    			return false;
    		} else if($("#user_pw_confirm").val()=="") {
    			alert("password 확인을 입렫해 주세요");
    			$("#user_pw_confirm").focus();
    			return false;
    		} else if($("#user_pw").val()!==$("#user_pw_confirm").val()) {
    			alert("패스워드가 맞지 않습니다.");
    			$("#user_pw_confirm").focus();
    			$("#user_pw_confirm").val("");
    			return false;
    		} else if($("#user_name").val()=="") {
    			alert("name을 입렫해 주세요");
    			$("#user_name").focus();
    			return false;
    		} else if($("#user_email").val()=="") {
    			alert("email을 입렫해 주세요");
    			$("#user_email").focus();
    			return false;
    		} else if($("#user_zipcode").val()=="") {
    			alert("우편번호를 입렫해 주세요");
    			$("#user_zipcode").focus();
    			return false;
    		} else if($("#user_address01").val()=="") {
    			alert("주소를 입렫해 주세요");
    			$("#user_address01").focus();
    			return false;
    		} 
    	});
    </script>
<%@ include file="./include/footer.jsp"  %>






