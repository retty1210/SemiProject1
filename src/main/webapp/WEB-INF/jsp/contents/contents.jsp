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
		<a href="./main" class="nav-menu_link">분실 동물 게시판</a>
	</nav>
			<%
				WriterDTO datas;
				int content_pkid = 0;
				if(request.getAttribute("datas") != null){
						datas = (WriterDTO) request.getAttribute("datas");
						content_pkid = datas.getPkid();
			%>
	
	<div class="contents-main">
	
		<div class="contents-imgarea">
			<img class="contents-img" alt="동물 사진" src="<%=datas.getPhotopath() %>" name="img">
		</div>
		<script>imgSize("img");</script>
		
		<div class="list-btn_box">
			<a href="/main"><button class="list-btn">목 록</button></a>
		</div>
		
		<div class="contents-inner">
			<table class="contents-table">
				<tr class="table-row">
					<td class="table-titletxt">분실동물 이름</td>
					<td class="table-contxt"><%=datas.getTitle() %></td>
				</tr>
				<tr class="table-row" rowspan="5" align="center">
					<td class="table-titletxt">분실동물의 특징</td>
					<td class="table-contxt"><%=datas.getContents() %></td>
				</tr>
				<tr class="table-row">
					<td class="table-titletxt">분실장소</td>
					<td class="table-contxt"><%=datas.getPlace() %></td>
				</tr>
				<tr class="table-row">
					<td class="table-titletxt">보호자 연락처</td>
					<td class="table-contxt"><%=datas.getPhonenumber() %></td>
				</tr>
			</table>
		</div>
	</div>
	
			<%	
				}
			%>
				<div class="buttonarea">
			<%	
				int pkid = 0;
				System.out.println(content_pkid);
				if((int)request.getAttribute("pkid") != 0){
					pkid = (int)request.getAttribute("pkid");
				}
				System.out.println(pkid);
				if(content_pkid == pkid) {
	
			%>
					<div class="button-writer"><!-- hidden으로 놓고 작성자 본인에게만 보이게 -->
						<a href="/update?id=<%=request.getParameter("id") %>"><button type="submit" class="mini-btn">수정</button></a>
						<form action="/delete?id=<%=request.getParameter("id") %>" method="post">	
						<button type="submit" class="mini-btn" id="delete-btn">삭제</button>
						</form>
					</div>
			
			<%
				}else if(session.getAttribute("login_user").equals("ADMIN")){
			%>
					<div class="button-admin">
						<button type="button" class="mini-btn">삭제</button>
					</div>
			<%
				}
			%>
				
				</div>	
	<footer>
		<hr>
		<p class="footer-txt">팀원 :이종훈 | 곽서희 | 장재완 | 정현실 | 신재민 | 조정현</p>
		<a href="#"></a>
		<p class="footer-txt">ⓒ 여기가 동물신고 사이트다!</p>
	</footer>
<script type="text/javascript" src="static/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="static/js/delete.js"></script>
</body>
</html>