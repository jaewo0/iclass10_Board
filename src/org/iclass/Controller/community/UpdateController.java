package org.iclass.Controller.community;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iclass.Controller.Controller;
import org.iclass.dao.CommunityDao;
import org.iclass.vo.Community;

public class UpdateController implements Controller {
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String ip = request.getRemoteAddr();
		long idx = Long.parseLong(request.getParameter("idx")); 
				
		Community vo = Community.builder()
								.title(title)
								.content(content)
								.ip(ip)
								.idx(idx)
								.build();
		
		CommunityDao dao = CommunityDao.getInstance();
		long result = dao.update(vo);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
				
		
		if(result != 0) {
			response.sendRedirect("list");
		}else {
			//메인으로 이동
			response.sendRedirect(request.getContextPath());
		}
		
	}

}
