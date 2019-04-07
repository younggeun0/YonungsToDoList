package dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

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
	
	public void insertToDo(String content) {
		
		
	}
	
	public boolean updateToDo(String td_num) {
		boolean flag = false;
		
		return flag;
	}
	
	public boolean deleteToDo(String td_num) {
		boolean flag = false;
		
		return flag;
	}
}
