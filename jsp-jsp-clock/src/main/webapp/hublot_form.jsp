<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HUBLOT</title>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
<link rel="stylesheet" href="css/layout.css">
<link rel="stylesheet" href="css/form.css">
</head>
<body>
	<div class="formBox">
		<h2>HUBLOT UPLOAD</h2>
		<!-- .do 라는 확장자는 그냥 임의로 만드는거...  -->
		<form action="ClockUploadController.do" id="joinForm" method="POST" enctype="multipart/form-data">
			<table>
				<colgroup>
					<col style="width:150px">
					<col style="width:850px">
				</colgroup>
				<tbody>
					<tr>
						<th>CATEGORY</th>
						<td>
							<select name="category">
								<option value="CLASSIC FUSION">CLASSIC FUSION</option>
								<option value="BIG BANG">BIG BANG</option>
								<option value="DEEP SEE">DEEP SEE</option>
							</select>
						</td>
					</tr>
					<tr>
						<th>TITLE</th>
						<td>
							<input type="text" name="title" id="title">
						</td>
					</tr>
					<tr>
						<th>DEPTH</th>
						<td>
							<input type="text" name="depth" id="depth">
						</td>
					</tr>
					<tr>
						<th>PRICE</th>
						<td>
							<input type="text" name="price" id="price">
						</td>
					</tr>
					<tr>
						<th>LINK</th>
						<td>
							<input type="text" name="link" id="link">
						</td>
					</tr>
					<tr>
						<th>FILE</th>
						<td>
							<input type="file" name="hublotFile" id="hublotFile">
						</td>
					</tr>
				</tbody>
			</table>
			<div class="btns">
				<input type="submit" value="확인" id="join">
				<input type="reset" value="취소" id="cancel">
			</div>
		</form>
	</div>
</body>
</html>