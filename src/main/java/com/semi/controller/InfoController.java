package com.semi.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.model.*;
import com.semi.writer.model.*;

@WebServlet("/info")
public class InfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login_user = "";
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("login_user") != null) {
			login_user = (String) session.getAttribute("login_user");		
		}
		
		if(login_user.equals("")) {
			request.setAttribute("logined",false);
		}else {
			request.setAttribute("logined", true);					
		
		}
		
		SignService service = new SignService();
		List<SignDTO> datas = service.select((String)session.getAttribute("login_user"));
		
		for(SignDTO sdto: datas) {
			request.setAttribute("init", sdto);			
		}
		WriterService wService = new WriterService();
		List<WriterDTO> wDatas = wService.select(login_user);
		
		
		request.setAttribute("wdatas", wDatas);
		
		String view = "/WEB-INF/jsp/info/info.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
