package org.iclass.Controller.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iclass.Controller.Controller;

public class LoginViewController implements Controller {
public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	//View
	String temp = request.getParameter("back");
	HttpSession session = request.getSession();
	if(temp != null && temp.equals("w"))
		session.setAttribute("back", "community/write");
	
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
	dispatcher.forward(request,response);

}
}
