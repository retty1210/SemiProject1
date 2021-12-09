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
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">
      <script type="text/javascript" src="<%=request.getContextPath()%>/static/js/mainJS.js"></script>
</head>
<body>
	<header class="main-header">
		<nav class="header-link_box">
			<ul class="header-link_writer_ul">
				<li class="header-link_writer_li">
				<%
					boolean logined = (boolean) request.getAttribute("logined");
					if(!logined){ 
				%>
					<a href="./login" class="header-link_writer">
						<span class="material-icons">
							create
						</span>&nbsp;로그인
					</a>
				<%
					}else{
						
				%>
					<a href="./writer" class="header-link_writer">
						<span class="material-icons">
							create
						</span>&nbsp;글쓰기
					</a>
				<%
					}
				%>				
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
		<a href="/main" class="nav-menu_link">분실 동물 게시판</a>
	</nav>
	<%
		List<WriterDTO> datas;
		if(request.getAttribute("datas") != null){
			datas = (List<WriterDTO>) request.getAttribute("datas");
	%>	
	<div class="content-box">
	<%
			
			for(WriterDTO data: datas){
			
	%>	
		<div class="contenet-1">
			<table class="content-area">
				<tr class="content-imgtr">
					<td class="content-imgtd">
						<img class="content-img" alt="동물사진" src="/upload/pet00<%=data.getId() %>.jpg" name="img<%=data.getId() %>" height=500 width=500> 
					</td>
				<!-- 테스트하느라 src값 수정중! 반드시 테스트 끝난 후 < % = data.getPhotopath() %>로 돌려놓기 -->
				</tr>
				<tr class="content-body">
					<td>
						<a class="content-link" href="/contents?id=<%=data.getId() %>"><%=data.getTitle() %> <%=data.getContents() %></a>
					</td>
				</tr>
			</table>
			
			
		</div>
		
	<%
				}
			}
	%>
	</div>
	

	
	<footer>
		<hr>
		<p class="footer-txt">팀원 :이종훈 | 곽서희 | 장재완 | 정현실 | 신재민 | 조정현</p>
		<a href="#"></a>
		<p class="footer-txt">ⓒ 여기가 동물신고 사이트다!</p>
	</footer>
</body>
</html>