package com.semi.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.writer.model.*;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/update")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		WriterService service = new WriterService();
		String id = request.getParameter("id");
		List<WriterDTO> datas = service.select(id);
		
		for(WriterDTO data: datas) {
			request.setAttribute("datas", data);
		}
		
		String view = "/WEB-INF/jsp/contents/update.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
