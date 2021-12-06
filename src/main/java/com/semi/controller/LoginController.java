package com.semi.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.model.JoinDTO;
import com.semi.model.JoinService;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String view = "/WEB-INF/jsp/login/login.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String id = request.getParameter("userId"); // 이건 임시입니다.
		String password = request.getParameter("userPw"); // 로그인 화면을 못 봐서 해당 name 알면 붙여넣을게요.
		
		JoinDTO dto = new JoinDTO(id, password);
		JoinService service = new JoinService();
		//request.setAttribute("init", dto); 로그인 했을때 사용자의 정보 가져오는 로직 회원가입시 입력한 정보들 셀렉하는 로직 안에다 넣어주세요
		
		if(service.login(dto)) {
			HttpSession session = request.getSession();
			session.setAttribute("login_user", dto.getId());
			
			
//			Cookie cookie = new Cookie("login_user", dto.getId());
//			cookie.setMaxAge(60*30);
//			response.addCookie(cookie);
			response.sendRedirect("/");
		} else {
			
			//여기 따로 실패 페이지나 아니면 getAttribute? 맞나 여튼 그걸로 실패했다고 유저한테 창 띄우게 만들것
			request.setAttribute("errMsg", "로그인 정보가 올바르지 않습니다.");
			response.sendRedirect("/login");
		}
	}
}
