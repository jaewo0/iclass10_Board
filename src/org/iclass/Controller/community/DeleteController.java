package org.iclass.Controller.community;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iclass.Controller.Controller;
import org.iclass.dao.CommunityDao;
import org.iclass.vo.Community;
import org.iclass.vo.NewMember;

public class DeleteController implements Controller {
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 글 삭제 구현해 보세요.
		CommunityDao dao = CommunityDao.getInstance();
		HttpSession session = request.getSession();
		NewMember user = (NewMember) session.getAttribute("user");
		
		long idx = Long.parseLong(request.getParameter("idx"));
		//NumberFormatException은 web.xml 설정으로 처리(UpdateViewController와 비교하는 코드)
		Community vo = dao.selectByIdx(idx);
		if (vo == null || !vo.getWriter().equals(user.getId())) throw new RuntimeException();
		
		int result = dao.delete(idx);
		if (result == 1) {
			response.sendRedirect("list?page="+request.getParameter("page"));
		} else {
			response.sendRedirect(request.getContextPath());
		}

	}

}
