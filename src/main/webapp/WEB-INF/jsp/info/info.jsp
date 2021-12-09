<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.semi.model.*" %>
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
						HttpSession sessions = request.getSession();
						SignDTO initData = new SignDTO();
						
						boolean logined = (boolean) request.getAttribute("logined");
						if(logined){
					%>
						<hr>	
						<li class="header-link_menu_content"><a href="./logout">로그아웃</a></li>
						<hr>
						<li class="header-link_menu_content"><a href="./info">내정보</a></li>
					<% 
						} else {					
					%>	
						<hr>
						<li class="header-link_menu_content"><a href="./login">로그인</a></li>
						<hr>
						<li class="header-link_menu_content"><a href="./sign">회원가입</a></li>
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
		<div class="info-inner_box">
			<div class="info-input_box">
				<h3 class="info-user_h3"><%=sessions.getAttribute("login_user") %> 님의 개인정보 입니다.</h3>
				<%
					if(request.getAttribute("init") != null){ 
						initData = (SignDTO) request.getAttribute("init");
					}

				%>
				<div class="info-input_input">
					<input type="text" name="username" value="<%=initData.getUsername() %>">
				</div>
				<div class="info-input_input">
					<input type="text" name="useremail" value="<%=initData.getEmail() %>">
				</div>
				<div class="info-input_input">
					<input type="text" name="userphone" value="<%=initData.getPhoneNumber() %>">
				</div>
				<div class="info-input_input">
					<input type="text" name="signdate" value="<%=initData.getSignDate() %>">
				</div>
			</div>
			<div class="info-writer_box">
				<table class="info-writer_tb">
					<tr class="info-writer_head">
						<th>번호</th>
						<th>제목</th>
						<th>날짜</th>
						<th>조회수</th>
					</tr>
					<%
						List<WriterDTO> datas;
						if(request.getAttribute("wdatas") != null){
							datas = (List<WriterDTO>) request.getAttribute("wdatas");
							for(WriterDTO data: datas){
					%>
					<tr>
						<td><%=data.getId() %></td>
						<td><a href="#"><%=data.getTitle() %></a></td>
						<td><%=data.getWriterDate() %></td>
						<td>1</td>
					</tr>
					<%
							}
						}
					%>
					<%
						WriterDTO dto = new WriterDTO();
						String tempPage = request.getParameter("page");
						int cPage = 0;
						int pageLength = 6;
						int startPage;
						int endPage;
						int totalRows = dto.getTotalRows();
						
					if(tempPage == null || tempPage.length() == 0){
						cPage = 1;
					}
					try{
						cPage = Integer.parseInt(tempPage);
					}catch(NumberFormatException e){
						cPage = 1;
					}
					int currentBlock = cPage % pageLength == 0 ? cPage / pageLength:(cPage/pageLength)+1;
					startPage = (currentBlock - 1) * pageLength + 1;
					endPage = startPage + pageLength - 1;
					int totalPages = totalRows % pageLength == 0? totalRows / pageLength:(totalRows/pageLength) + 1;
					if(totalPages == 0){
						totalPages = 1;
					}
					if(endPage > totalPages){
						endPage = totalPages;
					}
					int start = (cPage - 1) * pageLength;
					
					%>
					<tr>
						<th><a href="/info?page=1">1</a></th>
					</tr>
				</table>
			</div>
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