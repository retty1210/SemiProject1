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
		String view = "/WEB-INF/jsp/writer/delete.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			// 게시글 번호
			String id = request.getParameter("id");
			int intID = Integer.parseInt(id);
			
		
			WriterDTO dto = new WriterDTO();
			dto.setId(intID);
			
			
			WriterService service = new WriterService();

			if(service.delete(dto)) {
				// 삭제 완료
					request.setAttribute("success", "삭제가 완료되었습니다.");
					String view ="/WEB-INF/jsp/writer/delete.jsp";
					RequestDispatcher rd = request.getRequestDispatcher(view);
					rd.forward(request, response);
				} 
			 else {
				// 삭제 실패	
				System.out.println("오류4");
				request.setAttribute("fail", "삭제가 실패했습니다.");
				String view ="/WEB-INF/jsp/writer/delete.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(view);
				rd.forward(request, response);
			}
		}
	}

