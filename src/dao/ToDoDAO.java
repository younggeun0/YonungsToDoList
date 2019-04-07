package dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.ToDo;

public class ToDoDAO {
	
	private static ToDoDAO td_dao;
	
	public static ToDoDAO getInstance() {
		if(td_dao == null) {
			td_dao = new ToDoDAO();
		}
		
		return td_dao;
	}
	
	public synchronized SqlSessionFactory getSessionFactory() throws IOException {
		SqlSessionFactory ssf = null;
	
		Reader r = Resources.getResourceAsReader("dao/mybatis_config.xml");
		
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		ssf = ssfb.build(r);
		
		return ssf;
	}
	
	public void insertToDo(String content) throws IOException, SQLException {
		SqlSession ss = getSessionFactory().openSession();
		ss.insert("insertToDo", content);
		ss.commit();
		ss.close();
	}
	
	public boolean updateToDo(String td_num) throws IOException, SQLException {
		boolean flag = false;
		
		SqlSession ss = getSessionFactory().openSession();
		ss.update("updateToDo",td_num);
		ss.commit();
		ss.close();
		return flag;
	}
	
	public boolean deleteToDo(String td_num) throws IOException, SQLException {
		boolean flag = false;
		
		SqlSession ss = getSessionFactory().openSession();
		ss.update("deleteToDo", td_num);
		ss.commit();
		ss.close();
		return flag;
	}
	
	public List<ToDo> selectToDo(String finish_flag) throws IOException, SQLException {
		List<ToDo> list = null;
		
		SqlSession ss = getSessionFactory().openSession();
		list = ss.selectList("selectToDo", finish_flag);
		ss.close();
		
		return list;
	}
}
