package com.semi.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		view = "/WEB-INF/jsp/contents/contents.jsp";
		String id = request.getParameter("id");
		RequestDispatcher rd1 = request.getRequestDispatcher(view);
		rd1.forward(request, response);
		
		view="/WEB_INF/jsp/welcome/main.jsp";
		RequestDispatcher rd2 = request.getRequestDispatcher(view);
		rd2.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		doGet(request, response);
	}

}
