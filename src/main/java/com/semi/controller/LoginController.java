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
		/*
		String id = request.getParameter("userId"); // 이건 임시입니다.
		String password = request.getParameter("userPw"); // 로그인 화면을 못 봐서 해당 name 알면 붙여넣을게요.
		
		JoinDTO dto = new JoinDTO(id, password);
		JoinService service = new JoinService();
		
		if(service.login(dto)) {
			HttpSession session = request.getSession();
			session.setAttribute("s_login_user", dto.getId());
			
			Cookie cookie = new Cookie("login_user", dto.getId());
			cookie.setMaxAge(60*30);
			response.addCookie(cookie);
			response.sendRedirect("/");
		} else {
			System.out.println("로그인 실패");
		}
		 */	
	}
}
