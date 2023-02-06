package org.iclass.Controller.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iclass.Controller.Controller;

public class LogoutController implements Controller {
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.invalidate();		//세션 무효화 : 기존 세션ID 삭제
		response.sendRedirect(request.getContextPath());//메인페이지에 요청

	}
}
