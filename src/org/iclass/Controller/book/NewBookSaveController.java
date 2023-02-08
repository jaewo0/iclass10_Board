package org.iclass.Controller.book;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iclass.Controller.Controller;
import org.iclass.dao.NewBooksDao;
import org.iclass.vo.NewBooks;
import org.slf4j.LoggerFactory;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class NewBookSaveController implements Controller {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(NewBookSaveController.class);

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// 서버에 전송될 위치(파일시스템 경로)
		String path = "D:\\Iclips1020\\se";

		// 업로드 파일의 최대 크기(바이트)
		int maxSize = 10 * 1024 * 1024; // 10메가바이트

		// request를 파일을 받을 수 있는 request로 사용 : cos 라이브러리 추가
		MultipartRequest multiRequest = new MultipartRequest(request, path, maxSize, "UTF-8",
				new DefaultFileRenamePolicy());
		// DefaultFileRenamePolicy는 중복된 파일명에 대해서 새로 파일명을 부여하는 규칙

		// 기존 방식처럼 text 타입등 파라미터 받아오기
		String title = multiRequest.getParameter("title");
		String summary = multiRequest.getParameter("summary");

		// 서버로 업로드된 파일의 파일명
		String cover = multiRequest.getFilesystemName("coverfile");
		logger.info("::: 파일명-{}, 책제목-{}, 내용-{} :::", cover, title, summary);
		// 서버 파일시스템 경로에서 파일이 생겼는지 확인하기

		// dao의 insert 실행시키기기기ㄹ기기긱가리깃깃
		NewBooksDao dao = NewBooksDao.getInstabce();
		String url = null;
		NewBooks book = new NewBooks(0, title, summary, null, cover, "admin");
		if (dao.insert(book) == 1) {
			url = "list";
		} else {
			url = "new";
		}

		response.sendRedirect(url);
	}

}
