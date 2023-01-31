package org.iclass;

import static org.junit.jupiter.api.Assertions.*;

import org.iclass.dao.CommunityCommentsDao;
import org.iclass.dao.CommunityDao;
import org.iclass.vo.Community;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BoardTest {
	CommunityDao communityDao = CommunityDao.getInstance();
	CommunityCommentsDao commentsDao = CommunityCommentsDao.getInstance();
	
//	@DisplayName("메인 글쓰기 insert")
//	@Test
//	void insertMain() {
//		Community vo = Community.builder()
//				.writer("트트트")
//				.title("자바정석 후기")
//				.content("자바 공부하기 자바 정석으로")
//				.build();
//		communityDao.insert(vo);
//		assertEquals(vo.getIdx(), 11);    //기대값 : 생성된 시퀀스값
//		
//	}
//	@DisplayName("delete 테스트")
//	@Test
//	void delete() {
//		Community vo = new Community();
//		communityDao.delete(14);
//		assertEquals(vo.getIdx(), 10);
//	}
//
	@DisplayName("update 테스트")
	@Test
	void update() {
		Community vo = Community.builder()
				.writer("크크크")
				.title("수정 테스트")
				.content("대충콘텐트")
				.idx(20)
				.build();
		communityDao.update(vo);
		
	}



}

