<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.semi.model.*" %>
<%@ page import="com.semi.writer.model.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image/x-icon" href="/static/icons/pets_black_24dp.svg">
<title>우리 멍냥 찾아주사이트</title>
<link href="<%=request.getContextPath()%>/static/css/style.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath()%>/static/css/writer/writer.css" rel="stylesheet" type="text/css"/>
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
					<%
					//HttpSession sessions = request.getSession();
					//SignDTO initData = (SignDTO) request.getAttribute("init");
						//boolean logined = (boolean) request.getAttribute("logined");
						//if(!logined){
					%>
						<hr>
						<li class="header-link_menu_content"><a href="./login">로그인</a></li>
						<hr>
						<li class="header-link_menu_content"><a href="./sign">회원가입</a></li>
					<% 
						//} else {					
					%>	
						<hr>	
						<li class="header-link_menu_content"><a href="./logout">로그아웃</a></li>
						<hr>
						<li class="header-link_menu_content"><a href="./info">내정보</a></li>
					<%
						//}
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
		<a href="./main" class="nav-menu_link">분실 동물 게시판</a>
	</nav>
	<form action="<%=request.getContextPath()%>/writer" class="writer_class" id="writer_form" method="post" enctype="multipart/form-data">
		<div class="writer_c">
			<label for="title_id" class="writer_title">분실동물 이름</label>
			<input type="text" id="title_id" name="title" class="writer_text" placeholder="분실동물 이름" required>
			<p class="mini_txt">동물의 이름을 입력하세요.</p>
		</div>
		
		<div class="writer_c">
			<label for="contents_id" class="writer_title">분실동물의 특징</label>
			<textarea id="contents_id" name="contents" class="writer_text" placeholder="분실동물의 특징: 품종, 나이, 털 색, 눈에 띄는 특징, 분실 당시 하고 있던 목줄 색 등" required></textarea>
			<p class="mini_txt">품종, 나이, 털 색, 눈에 띄는 특징, 분실 당시 하고 있던 목줄 색 등</p>
		</div>
		
		<div class="writer_c">
			<label for="place_id" class="writer_title">분실장소</label>
			<input type="text" id="place_id" name="place" class="writer_text" placeholder="분실장소: 최대한 자세히 적어주세요" required>
			<p class="mini_txt">최대한 자세히 적어주세요(예: 서울시 강남구 한티역 5번출구 근처 신한은행 앞)</p>
		</div>
		
		<div class="writer_c">
			<label for="phonenumber_id" class="writer_title">보호자 연락처</label>
			<input type="text" id="phonenumber_id" name="phonenumber" class="writer_text" placeholder="보호자 연락처" required>
			<p class="mini_txt">바로 연락받을 수 있는 핸드폰 번호를 입력하세요</p>
		</div>
		
		<div class="writer_c">
			<label for="photoPath_id" class="writer_title">사진</label>
			<input type="file" id="photoPath_id" name="photoPath" class="writer_text">
			<p class="mini_txt">동물의 특징이 잘 보이는 사진을 올려주세요</p>
		</div>
		
		
		
		<div class="writer_c">
			<button type="submit" class="writer_but_c">등록</button>
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