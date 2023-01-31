package org.iclass.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.iclass.vo.Community;

import mybatis.SqlSessionBean;

public class CommunityDao {
	private static final CommunityDao dao = new CommunityDao();
	private CommunityDao() {	};
	public static CommunityDao getInstance() {
		return dao;
	}
	
	public Community select(int idx){
		SqlSession mapper = SqlSessionBean.getSession();
		Community vo = mapper.selectOne("community.select",idx);
		mapper.close();
		return vo;
	}
	
	public long insert(Community vo) {
		SqlSession mapper = SqlSessionBean.getSession();
		mapper.insert("community.insert",vo);
		mapper.commit();
		mapper.close();
		return vo.getIdx();
	}

	public int update(Community vo) {
		SqlSession mapper = SqlSessionBean.getSession();
		int result = mapper.update("community.update",vo);
		mapper.commit();
		mapper.close();
		return result;
	}

	public int delete(int idx) {
		SqlSession mapper = SqlSessionBean.getSession();
		int result = mapper.delete("community.delete",idx);
		mapper.commit();
		mapper.close();
		return result;
	}
}
