package org.iclass.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.iclass.vo.NewBooks;

import mybatis.SqlSessionBean;

public class NewBooksDao {
	private static NewBooksDao dao = new NewBooksDao();
	private NewBooksDao() {}
	public static NewBooksDao getInstabce() {
		return dao;
	}
	
	public List<NewBooks> list(){
		SqlSession mapper = SqlSessionBean.getSession();
		List<NewBooks> list = mapper.selectList("books.listAll");
		mapper.close();
		return list;
	}
	
	public int insert(NewBooks book) {
		SqlSession mapper = SqlSessionBean.getSession();
		int result = mapper.insert("books.insert",book);
		mapper.commit();
		mapper.close();
		return result;
	}
}
