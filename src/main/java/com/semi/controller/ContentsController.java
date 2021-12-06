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
       
    public ContentsController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String view = "/WEB-INF/jsp/contents/contents.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		WriterDTO wdto = new WriterDTO();
		WriterService wService= new WriterService();
		List<WriterDTO> datas = wService.onePickSelect();
		request.setAttribute("datas", datas);
		
		
		request.getAttribute("datas");
		doGet(request, response);
	}

}
