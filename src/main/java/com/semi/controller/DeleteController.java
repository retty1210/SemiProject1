package com.semi.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.model.*;
import com.semi.writer.model.*;

@WebServlet("/delete")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String view = "WEB-INF/jsp/delete/delete.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
				
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			// 게시글 번호
			String id = request.getParameter("id");
		
			WriterDTO dto = new WriterDTO();
			WriterService service = new WriterService();
			List<WriterDTO> deleteWriter = service.select(id);
			
				if(service.delete(dto)) {
					// 삭제 완료 페이지 띄움
					String view = "/WEB-INF/jsp/delete/delete.jsp";
					RequestDispatcher rd = request.getRequestDispatcher(view);
					rd.forward(request, response);
				} else {
					// 삭제 실패
					System.out.println("오류");
				}
			}
	}

