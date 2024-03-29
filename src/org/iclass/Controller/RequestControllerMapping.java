package org.iclass.Controller;

import java.util.HashMap;
import java.util.Map;

import org.iclass.Controller.community.CommentsController;
import org.iclass.Controller.community.DeleteController;
import org.iclass.Controller.community.ListController;
import org.iclass.Controller.community.ReadController;
import org.iclass.Controller.community.UpdateController;
import org.iclass.Controller.community.UpdateViewController;
import org.iclass.Controller.community.WriteController;
import org.iclass.Controller.community.WriteViewController;
import org.iclass.Controller.login.LoginActionController;
import org.iclass.Controller.login.LoginViewController;
import org.iclass.Controller.login.LogoutController;


public class RequestControllerMapping {
	private static final Map<RequestKeyValue, Controller> mapping = new HashMap<>();
	
	public static void init() {
		//설계된 url,method 에 따라 처리할 controller 구현체를 Key,Value 로 HashMap에 저장합니다.
		mapping.put(new RequestKeyValue("/community/list","GET"), new ListController());
		mapping.put(new RequestKeyValue("/community/write","GET"), new WriteViewController());
		mapping.put(new RequestKeyValue("/community/write","POST"), new WriteController());
		//게시판 글 상세보기 ,수정하기,삭제하기
		mapping.put(new RequestKeyValue("/community/read", "GET"), new ReadController());
		mapping.put(new RequestKeyValue("/community/update","GET"), new UpdateViewController() );
		mapping.put(new RequestKeyValue("/community/update","POST"), new UpdateController() );
		mapping.put(new RequestKeyValue("/community/delete","GET"), new DeleteController() );
		//댓글 작성과 삭제
		mapping.put(new RequestKeyValue("/community/comments", "POST"), new CommentsController());
		//회원가입
		mapping.put(new RequestKeyValue("/member/join","GET"), null);
		mapping.put(new RequestKeyValue("/member/join","POST"), null);
		//회원정보 수정
		mapping.put(new RequestKeyValue("/member/modify","GET"), null);
		mapping.put(new RequestKeyValue("/member/modify","POST"), null);
		//로그인
		//로그인 기능
		mapping.put(new RequestKeyValue("/login","GET"),new LoginViewController());
		mapping.put(new RequestKeyValue("/login","POST"),new LoginActionController());
		mapping.put(new RequestKeyValue("/logout","GET"),new LogoutController());
		
	
	}

	public static Controller getController(RequestKeyValue key) {
		return mapping.get(key);
	}
	
}
 