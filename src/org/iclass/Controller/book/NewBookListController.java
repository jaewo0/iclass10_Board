package org.iclass.Controller.book;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iclass.Controller.Controller;
import org.iclass.dao.NewBooksDao;
import org.iclass.vo.NewBooks;

public class NewBookListController implements Controller {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		NewBooksDao dao = NewBooksDao.getInstabce();
		List<NewBooks> list = dao.list();
		
		request.setAttribute("books", list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("newbooks.jsp");
		dispatcher.forward(request, response);
	}

}
