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
						<hr>
						<li class="header-link_menu_content"><a href="./sign">회원가입</a></li>
					<% 
						} else {					
					%>	
						<hr>	
						<li class="header-link_menu_content"><a href="./logout">로그아웃</a></li>
						<hr>
						<li class="header-link_menu_content"><a href="./info">내정보</a></li>
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
		<a href="#" class="nav-menu_link">분실 동물 게시판</a>
	</nav>
	<div class="content-box">
		<div class="contenet-1">
			<!-- 
			<img class="content-img" alt="이미지 설명" src="이미지 주소"> 
			이미지 주소는 DB에서 가져오게 할 것. alt는 시각장애인용 script가 읽거나 이미지 로딩에 실패했을 때 뜨는 문구입니다.
			 -->
			<div class="content-body">
				<a class="content-link" href="/contents">게시글 제목, 간략한 설명</a>
				<!-- 특정 게시글로 들어가게 하는거 어떻게해요..? -->
			</div>
		</div>
		<div class="contenet-1"></div>
		<!-- 위의 코드가 완전히 완성된 다음 복사붙여넣기 할것(안 그러면 코드가 꼬일수도?) -->
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