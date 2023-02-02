package org.iclass.Controller.community;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iclass.Controller.Controller;
import org.iclass.dao.CommunityDao;

public class DeleteController implements Controller{
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String idx = request.getParameter("idx");
		
		CommunityDao dao = CommunityDao.getInstance();
		int result = dao.delete(Integer.parseInt(idx));
		if(result != 0) {
			response.sendRedirect("list");
		}else {
			response.sendRedirect(request.getContextPath());
		}
	}

}
