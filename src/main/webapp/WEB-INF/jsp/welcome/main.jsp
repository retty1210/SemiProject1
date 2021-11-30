<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image/x-icon" href="/static/icons/pets_black_24dp.svg">
<title>우리 멍냥 찾아주사이트</title>
<link href="<%=request.getContextPath()%>/static/css/style.css" rel="stylesheet" type="text/css"/>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">
</head>
<body>
	<header class="main-header">
		<nav class="header-link_box">
			<ul class="header-link_ul">
				<li class="header-link_li"><a href="#" class="header-link_a">
					<span class="material-icons">
						menu
					</span>
				</a>
				<ul class="header-link_menu">
				<hr>
					<li class="header-link_menu_content"><a href="#">로그인</a></li>
					<hr>
					<li class="header-link_menu_content"><a href="#">회원가입</a></li>
				</ul></li>
			</ul>
		</nav>
		<div class="header-logo-box">
		<a class="header-logo-link" href="/">
			<img name ="header-logo"class="header-logo" src="/static/icons/pets_black_24dp.svg">
	   	</a>
		</div>
	</header>
	<nav class="nav-menu">
		<a href="#" class="nav-menu_link">분실 동물 게시판</a>
	</nav>
	<div class="content-box">
		<div class="contenet-1">
			<%--이미지,제목,간단한내용--%>
		</div>
		<div class="contenet-1"></div>
		<div class="contenet-1"></div>
	</div>
	<div class="content-box">
		<div class="contenet-1"></div>
		<div class="contenet-1"></div>
		<div class="contenet-1"></div>
	</div>
	
	<footer>
		<hr>
		<p class="footer-txt">팀원 :이종훈 | 곽서희 | 장재완 | 정현실 | 신재민 | 조정현</p>
		<a href="#"></a>
		<p class="footer-txt">ⓒ 여기가 동물신고 사이트다!</p>
	</footer>
</body>
</html>