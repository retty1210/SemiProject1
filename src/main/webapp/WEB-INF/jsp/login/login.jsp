<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image/x-icon" href="/static/icons/pets_black_24dp.svg">
<title>우리 멍냥 찾아주사이트</title>
<link href="<%=request.getContextPath()%>/static/css/style.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath()%>/static/css/login/login.css" rel="stylesheet" type="text/css"/>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">
</head>
<body>
	<header class="main-header">
		<nav class="header-link_box">
			<ul class="header-link_ul">
				
			</ul>
		</nav>
	</header>
	<main class="login-main">
		<div class="main-logo-box">
			<a class="main-logo-link" href="/main">
				<img name ="hmain-logo"class="main-logo" src="/static/icons/pets_black_24dp.svg">
	   		</a>
		</div>
		<div class="form-login">
			<input type="text" class="login-input" id="login-id" name="userId" placeholder="아이디">
			<label for="login-id">아이디</label>
		</div>
		<div class="form-login">
			<input type="password" class="login-input" id="login-pw" name="userPw" placeholder="비밀번호">
			<label for="login-pw">비밀번호</label>
		</div>
		<div class="button_area">
			<button class="button-main" type="submit">로그인</button>
		</div>
		<div class="sub_txt">
			<a class="sub_txt_sign" href="./sign">회원가입</a>
		</div>
	</main>
	<footer>
		<hr>
		<p class="footer-txt">팀원 :이종훈 | 곽서희 | 장재완 | 정현실 | 신재민 | 조정현</p>
		<a href="#"></a>
		<p class="footer-txt">ⓒ 여기가 동물신고 사이트다!</p>
	</footer>
</body>
</html>