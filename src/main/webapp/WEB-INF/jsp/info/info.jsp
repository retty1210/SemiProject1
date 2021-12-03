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
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/mainJS.js"></script>
</head>
<body>
	<header class="main-header">
		<nav class="header-link_box">
			<ul class="header-link_writer_ul">
				<li class="header-link_writer_li">
					<a href="./writer" class="header-link_writer">
						<span class="material-icons">
							create
						</span>&nbsp;글쓰기
					</a>		
				</li>
			</ul>
			<ul class="header-link_ul">
				<li class="header-link_li"><a href="#" class="header-link_a">
					<span class="material-icons">
						menu
					</span>
				</a>
				<ul class="header-link_menu">
					<%
						boolean logined = (boolean) request.getAttribute("logined");
						if(!logined){
					%>
						<hr>
						<li class="header-link_menu_content"><a href="./login">로그인</a></li>
						<!-- 로그인: 임시로 적은 경로입니다! 파일 완성되면 수정해주세요 -->
						<hr>
						<li class="header-link_menu_content"><a href="./sign">회원가입</a></li>
					<% 
						} else {					
					%>	
						<hr>	
						<li class="header-link_menu_content"><a href="./loginout">로그아웃</a></li>
						<!-- 로그아웃: 임시로 적은 경로입니다! 파일 완성되면 수정해주세요 -->
						<hr>
						<li class="header-link_menu_content"><a href="./info">내정보</a></li>
						<!-- 내정보: 임시로 적은 경로입니다! 파일 완성되면 수정해주세요 -->
					<%
						}
					%>
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
		<a href="#" class="nav-menu_link">My Page</a>
	</nav>
	<div class="info-main_box">
		<div class="info-input_box">
			<h3 class="info-user_h3">0000 님의 개인정보 입니다.</h3>
			<div class="info-input_username">
				<input type="text" name="username" value="로그인정보 가져와서 넣기">
			</div>
			<div class="info-input_useremail">
				<input type="text" name="useremail" value="로그인정보 가져와서 넣기">
			</div>
			<div class="info-input_usephone">
				<input type="text" name="userphone" value="로그인정보 가져와서 넣기">
			</div>
		</div>
		<div class="info-input_box">
		
		</div>
	</div>
	

	
	<footer>
		<hr>
		<p class="footer-txt">팀원 :이종훈 | 곽서희 | 장재완 | 정현실 | 신재민 | 조정현</p>
		<a href="#"></a>
		<p class="footer-txt">ⓒ 여기가 동물신고 사이트다!</p>
	</footer>
</body>
</html>