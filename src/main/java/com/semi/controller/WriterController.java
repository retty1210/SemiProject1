package com.semi.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.semi.model.SignDTO;
import com.semi.model.SignService;
import com.semi.writer.model.*;

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

		HttpSession session = request.getSession();
		String login_user = (String) session.getAttribute("login_user");	
		SignService sv = new SignService();
		int pkid = sv.select_pkid(login_user);
		
//		enctype="multipart/form-data" -> 이거 쓸 때는 request.getParameter 사용 불가능하며 
//		library의 cos의 MultipartRequest를 사용해야 함!
		
		//request.setAttribute("datas",datas); 내정보에 글목록 불러오는데 사용합니다.글쓴거 리스트컬렉션으로 받는 셀렉문 로직에 넣어주세요.
//		enctype="multipart/form-data" -> 이거 쓸 때는 request.getParameter 사용 불가능하며 
//		library의 cos의 MultipartRequest를 사용해야 함!
		System.out.println("WriterController, 진입"); //테스트용 println
		
		
		MultipartRequest multi = new MultipartRequest(
				
				request, 
				request.getServletContext().getRealPath("/upload"),//업로드 파일의 저장 위치 지정
				1024 * 1024 * 10, //업로드 파일의 크기 제한(Byte단위)(10MB)
				"utf-8", //업로드 파일의 인코딩 형식
				new DefaultFileRenamePolicy() //중복되는 이름의 파일이 업로드 될 경우 이름을 바꾸는 것(뒤에 숫자 붙임)
				);
		String title = multi.getParameter("title");
		String contents = multi.getParameter("contents");
		String place = multi.getParameter("place");
		String phonenumber = multi.getParameter("phonenumber");
		String photoPath = "/upload/" + multi.getFilesystemName("photoPath");
		
		//int pkid = Integer.parseInt(multi.getParameter("pkid"));
//		System.out.println(multi.getFile("photoPath").getName());//아래 꺼랑 기능 동일
//		System.out.println(multi.getFilesystemName("photoPath"));//둘 중에 하나 편한거 쓰면 됨
		WriterDTO dto = new WriterDTO();
		WriterService service = new WriterService();
		
		System.out.println("writercon getpkid : " +pkid);
		//int pkid = Integer.parseInt(multi.getParameter("pkid"));
		//dto.setPkid(pkid);
		dto.setPkid(pkid); // 임시로			
		dto.setTitle(title);
		dto.setContents(contents);
		dto.setPlace(place);
		dto.setPhonenumber(phonenumber);
		dto.setPhotopath(photoPath);
		String view = "/WEB-INF/jsp/writer/writer.jsp";
		
		if(service.insert(dto) ) {
			response.sendRedirect("/main");
		} else {
			System.out.println("저장 실패");
		}
		
//		WriterService service = new WriterService();
	}

}
