package org.iclass.Controller.community;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iclass.Controller.Controller;
import org.iclass.dao.CommunityDao;

public class DeleteController implements Controller {
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 글 삭제 구현해 보세요.
		CommunityDao dao = CommunityDao.getInstance();
		long idx = Long.parseLong(request.getParameter("idx"));
		int result = dao.delete(idx);
		if (result == 1) {
			response.sendRedirect("list");
		} else {
			response.sendRedirect(request.getContextPath());
		}

	}

}
