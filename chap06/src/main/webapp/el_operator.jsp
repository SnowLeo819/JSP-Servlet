<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    int num01 = 3;
    pageContext.setAttribute("num02", 4);
    pageContext.setAttribute("num03", "5");
    pageContext.setAttribute("num04", "6");
    
    pageContext.setAttribute("nullString", null);
    pageContext.setAttribute("emptyString", "");
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>el operator</h1>
	<ul>
		<li>${num01 }</li>
		<li>${num01 = 7;''}==>${num01 }</li>
		<li>${num02 }</li>
		<li>${num03 }</li>
		<li>${num04 }</li>
		
		<br>
		
		<li>${num03 + num04 }</li>
		<li>${num03 * num04 }</li>
		<li>${num03 / num04 } ==> ${num03 div num04 }</li>
		<li>${num03 % num04 } ==> ${num03 mod num04 } </li>
		<li>${num03 > num04 } ==> ${num03 gt num04 } == gt : > </li>
		<li>${num03 < num04 } ==> ${num03 lt num04 } == lt : < </li>
		<li>${num03 >= num04 } ==> ${num03 ge num04 } == ge : >= </li>
		<li>${num03 <= num04 } ==> ${num03 le num04 } == le : <= </li>
		<li>${num03 == num04 } ==> ${num03 eq num04 } == eq : == </li>
		
		<br>
		
		<!-- null 이나 공백의 경우 empty를 활용해서 처리 -->
		<li>${empty nullString}</li>
		<li>${empty emptyString}</li>
		
		
		<!-- null 값은 원래 연산이 안되는게 맞지만 el 에서는 0으로 처리되어 연산 -->
		<li>${nullString + 10}</li>
		<li>${nullString > 10}</li>
		
		
	</ul>
</body>
</html>