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
					<hr>
					<li class="header-link_menu_content"><a href="./login">로그인</a></li>
					<!-- 로그인: 임시로 적은 경로입니다! 파일 완성되면 수정해주세요 -->
					<hr>
					<li class="header-link_menu_content"><a href="./sign">회원가입</a></li>
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
				<a class="content-link" href="#">게시글 제목, 간략한 설명</a>
				<div class="button-admin"><!-- hidden으로 해 놓고 admin 계정으로 로그인하면 hidden이 없어지게 -->
					<button type="button" class="mini-btn">삭제</button>
				</div>
				<div class="button-writer"><!-- hidden으로 해 놓고 작성자 본인에게만 보이게 -->
					<button type="button" class="mini-btn">수정</button>
					<button type="button" class="mini-btn">삭제</button>
				</div>
			</div>
			<%--버튼 위치, 이미지 사이즈나 위치 등은 하나도 안 건드렸어요 이건 css로 조정해야 함--%>
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
<script type="text/javascript" src="<%=request.getContextPath()%>/static/js/mainJS.js"></script>
</html>