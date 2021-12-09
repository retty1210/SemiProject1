<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image/x-icon" href="/static/icons/pets_black_24dp.svg">
<title>우리 멍냥 찾아주사이트</title>
<link href="<%=request.getContextPath()%>/static/css/style.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath()%>/static/css/writer/delete.css" rel="stylesheet" type="text/css"/>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">
</head>
<body>	
	<form method="post">
		<div class="header-logo-box">
			<a class="header-logo-link" href="/">
			<img name ="header-logo"class="header-logo" src="/static/icons/pets_black_24dp.svg">
	   		</a>
	   	</div>
	<nav class="success">
		<%
			if(request.getAttribute("success") != null) {
		%>
		<span class="delete_success">
		<%= request.getAttribute("success") %>
		</span>
		<%
			}else {
		%>
		
		<span class="delete_success">
		<%=
			request.getAttribute("fail")
		%>
		</span>
		<% } %>
	</nav>
		<div class="button_area">
		<input class="return_main" type="button" value="게시판으로 돌아가기" onclick="location.href='/main'"/>
		</div>
	</form>
	 <footer>
		<hr>
		<p class="footer-txt">팀원 :이종훈 | 곽서희 | 장재완 | 정현실 | 신재민 | 조정현</p>
		<a href="#"></a>
		<p class="footer-txt">ⓒ 여기가 동물신고 사이트다!</p>
	</footer>
</body>
</html>