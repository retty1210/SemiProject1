package com.semi.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/writer")
public class WriterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public WriterController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String view = "/WEB-INF/jsp/writer/writer.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		String place = request.getParameter("place");
		String phonenumber = request.getParameter("phonenumber"); //이거 String으로 할지 int로 할지 고민중
		
		//request.setAttribute("datas",datas); 내정보에 글목록 불러오는데 사용합니다.글쓴거 리스트컬렉션으로 받는 셀렉문 로직에 넣어주세요.
		
		//import semi.writer? 여튼 model import해줄것
//		WriterDTO dto = new WriterDTO();
//		dto.setTitle(title);
//		dto.setContents(contents);
		
//		WriterService service = new WriterService();
	}

}
