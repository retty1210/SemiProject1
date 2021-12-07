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

import com.semi.writer.model.*;

@WebServlet("/contents")
public class ContentsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		List<WriterDTO> datas = wService.select(id);
		
		for(WriterDTO data: datas){
			request.setAttribute("datas", data);
		}
		System.out.println(id);
		request.setAttribute("id_Num", id);
		String view = "/WEB-INF/jsp/contents/contents.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	}

}
