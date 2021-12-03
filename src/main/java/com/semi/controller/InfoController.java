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

@WebServlet("/info")
public class InfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//쿠키 말고 세션으로 받게 수정해주세요~
		String login_user = "";
		HttpSession session = request.getSession();
		session.getAttribute("login_user");
		
		if(session.getAttribute(login_user) != null) {
			login_user = (String) session.getAttribute(login_user);		
		}
		
		if(login_user.equals("")) {
			request.setAttribute("logined",false);
		}else {
			request.setAttribute("logined", true);					
		
		}
		String view = "/WEB-INF/jsp/info/info.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
