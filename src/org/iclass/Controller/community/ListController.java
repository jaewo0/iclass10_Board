package org.iclass.Controller.community;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iclass.Controller.Controller;
import org.iclass.dao.CommunityDao;

public class ListController implements Controller {
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//db에서 글목록 가져오기
		CommunityDao dao = CommunityDao.getInstance();
		request.setAttribute("list", dao.list());
		
		//현재 날짜 시간 저장 - 출력 형식 2개 중 하나 고를때 비교값
		request.setAttribute("today", LocalDate.now());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/community/list.jsp");
		dispatcher.forward(request, response);
	}

}
