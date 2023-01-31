package org.iclass.dao;

import org.apache.ibatis.session.SqlSession;
import org.iclass.vo.CommunityComments;

import mybatis.SqlSessionBean;

public class CommunityCommentsDao {
	private static final CommunityCommentsDao dao = new CommunityCommentsDao();
	private CommunityCommentsDao() {	};
	public static CommunityCommentsDao getInstance() {
		return dao;
	}
	
	public int insert(CommunityComments vo) {
		SqlSession mapper = SqlSessionBean.getSession();
		int result = mapper.insert("insert",vo);
		mapper.commit();
		mapper.close();
		return result;
	}
	
	public int delete(CommunityComments vo) {
		SqlSession mapper = SqlSessionBean.getSession();
		int result = mapper.delete("delete",vo);
		mapper.commit();
		mapper.close();
		return result;
	}
	
	public int update(CommunityComments vo) {
		SqlSession mapper = SqlSessionBean.getSession();
		int result = mapper.update("update",vo);
		mapper.commit();
		mapper.close();
		return result;
	}
	
}
