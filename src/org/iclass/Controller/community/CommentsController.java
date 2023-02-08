package org.iclass.Controller.community;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iclass.Controller.Controller;
import org.iclass.dao.CommunityCommentsDao;
import org.iclass.vo.CommunityComments;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommentsController implements Controller {
	private static final Logger logger = LoggerFactory.getLogger(CommentsController.class);
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	//	request.setCharacterEncoding("UTF-8");
		CommunityCommentsDao dao = CommunityCommentsDao.getInstance();
		String f = request.getParameter("f");
		String url = null;
		long mref = Long.parseLong(request.getParameter("mref"));
		logger.info(":::::CommentsController  f={} :::::",f);
		
		// 댓글 작성 추가
		if(f.equals("1")) {
			CommunityComments vo = CommunityComments.builder()
													.mref(mref)
													.writer(request.getParameter("writer"))
													.content(request.getParameter("content"))
													.ip(request.getRemoteAddr())
													.build();
			
			if(dao.insert(vo)==1) url = "read?idx="+mref;
			else url = "list";
		}else if(f.equals("2")) {
			//댓글 삭제
			String idx = request.getParameter("idx");
			int result = dao.delete(Integer.parseInt(idx));
			if(result != 0) {
				url="read?idx="+mref;
			}
		}
		//댓글 갯수 변경
		dao.setCommentCount(mref);
		response.sendRedirect(url);
		
		String page = request.getParameter("page");
		//댓글 작성 추가
		if(f.equals("1")) {
			CommunityComments vo = CommunityComments.builder()
									.mref(mref)
									.writer(request.getParameter("writer"))
									.content(request.getParameter("contetnt"))
									.ip(request.getRemoteAddr())
									.build();
			if(dao.insert(vo)==1) url = "read?idx="+mref+"&page="+page;
			else url = "list";
		}else if(f.equals("2")) {
			//댓글 작성
			int idx = Integer.parseInt(request.getParameter("idx"));
			if(dao.delete(idx)==1) url="read?idx="+mref+"&page="+page;
			else url = "list";
		}
	}
	
}
