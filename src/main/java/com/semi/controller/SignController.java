package com.semi.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.semi.model.*;


@WebServlet("/sign")
public class SignController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SignController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String view = "/WEB-INF/jsp/sign/sign.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//doGet(request, response);
		String userid = request.getParameter("user_id");
		String password = request.getParameter("user_pw");
		String password_check = request.getParameter("password_check");
		String username = request.getParameter("user_name");
		String userphone = request.getParameter("user_phone");
		String useremail = request.getParameter("user_email");
		
		SignDTO dto = new SignDTO(userid, password, username, userphone, useremail);
		SignService service = new SignService();
		
		if(service.isValid(dto)) {
			// 유효성 검사에 이상이 없는 경우
			if(service.userAdd(dto)) {
				// 가입 완료
			} else {
				// 가입 중 문제가 발생 
			}
		} else {
			// 유효성 검사에 이상이 있는 경우
		}
	}
}
