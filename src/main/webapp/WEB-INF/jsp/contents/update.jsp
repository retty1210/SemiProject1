<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.semi.writer.model.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image/x-icon" href="/static/icons/pets_black_24dp.svg">
<title>우리 멍냥 찾아주사이트</title>
<link href="<%=request.getContextPath()%>/static/css/style.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath()%>/static/css/contents/contents.css" rel="stylesheet" type="text/css"/>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/contents.js"></script>
</head>
<body>
	<header class="contents-header">
		<div class="header-logo-box">
		<a class="header-logo-link" href="/">
			<img name ="header-logo"class="header-logo" src="/static/icons/pets_black_24dp.svg">
	   	</a>
		</div>
	</header>
	<nav class="nav-menu">
		<a href="./main" class="nav-menu_link">게시글 수정 페이지</a>
	</nav>
	
			<%
				WriterDTO datas;
				if(request.getAttribute("datas") != null){
					datas = (WriterDTO) request.getAttribute("datas");
			%>
			
	<form action="/update" method="post">
		<div class="contents-main">
		
			<div class="contents-imgarea">
				<img class="contents-img" alt="동물 사진" src="<%=datas.getPhotopath() %>" name="img">
			</div>
			<script>imgSize("img");</script>
			
			<div class="contents-inner">
				<table class="contents-table">
					<tr class="table-row">
						<td class="table-titletxt">글 번호</td>
						<td class="table-contxt"><input type="text" name="num" class="input-contxt" value="<%=datas.getId() %>" readonly></td>
					</tr>						
					<tr class="table-row">
						<td class="table-titletxt">분실동물 이름</td>
						<td class="table-contxt"><input type="text" name="title" class="input-contxt" value="<%=datas.getTitle() %>" maxlength="16"></td>
					</tr>
					<tr class="table-row" rowspan="5" align="center">
						<td class="table-titletxt">분실동물의 특징</td>
						<td class="table-contxt"><textarea name="contents" class="input-contxt"><%=datas.getContents() %></textarea></td>
					</tr>
					<tr class="table-row">
						<td class="table-titletxt">분실장소</td>
						<td class="table-contxt"><input type="text" name="place" class="input-contxt" value="<%=datas.getPlace() %>"></td>
					</tr>
					<tr class="table-row">
						<td class="table-titletxt">보호자 연락처</td>
						<td class="table-contxt"><input type="text"name="phoneNumber" class="input-contxt" value="<%=datas.getPhonenumber() %>"></td>
					</tr>
				</table>
			</div>
		</div>
		
	<%
				}
	%>
	
		<div class="update-button_box"><!-- hidden으로 해 놓고 작성자 본인에게만 보이게 -->
			<button type="submit" class="main-btn">수정</button>
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