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
			
			WriterDAO dao = new WriterDAO();
			WriterService service = new WriterService();

			if(dao.delete(dto)) {
				// 삭제 완료
				System.out.println("굿");
				if(service.delete(dto)) {
					// 삭제 완료 후 커밋까지 완료
					System.out.println("완굿");
					String view ="/WEB-INF/jsp/writer/delete.jsp";
					RequestDispatcher rd = request.getRequestDispatcher(view);
					rd.forward(request, response);
				} else {
					// 삭제 완료 뒤 커밋에서 문제
					System.out.println("오오류3");
					request.setAttribute("error", "해당 게시글 삭제 여부를 확인하세요.");
					String view ="/WEB-INF/jsp/writer/delete.jsp";
					RequestDispatcher rd = request.getRequestDispatcher(view);
					rd.forward(request, response);
				}
			} else {
				// 삭제 실패	
				System.out.println("오류4");
				request.setAttribute("fail", "게시글 삭제가 실패했습니다.");
				String view ="/WEB-INF/jsp/writer/delete.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(view);
				rd.forward(request, response);
			}
		}
	}

