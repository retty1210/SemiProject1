package com.semi.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.model.*;
import com.semi.writer.model.*;

@WebServlet("/contents")
public class ContentsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String view = "";
       
    public ContentsController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String login_user = "";
		if(session.getAttribute("login_user") != null) {
			login_user = (String) session.getAttribute("login_user");
		}
		
		if(login_user.equals("")) {
			// 로그인 안한 상태
			request.setAttribute("logined", false);
		} else {
			// 로그인 한 상태
			request.setAttribute("logined", true);
		}
		String id = request.getParameter("id");
		
		WriterService wService= new WriterService();
		SignService sService = new SignService();
		
		List<WriterDTO> datas = wService.select(id);
		int userPkid = sService.select_pkid(login_user);
		request.setAttribute("pkid", userPkid);
		for(WriterDTO data: datas){
			request.setAttribute("datas", data);
		}

		//request.setAttribute("id_Num", id);

		
		view = "/WEB-INF/jsp/contents/contents.jsp";
		RequestDispatcher rd1 = request.getRequestDispatcher(view);
		rd1.forward(request, response);
		
		//삭제 기능 만든 다음에 써야 할 것(if문 등 조건문으로 묶어주세요)
		//String view2 = "/WEB_INF/jsp/welcome/main.jsp";
		//RequestDispatcher rd2 = request.getRequestDispatcher(view2);
		//rd2.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	}

}
