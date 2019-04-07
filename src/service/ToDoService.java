package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dao.ToDoDAO;
import domain.ToDo;

public class ToDoService {
	
	public List<ToDo> getToDo(String finish_flag) {
		List<ToDo> list = null;
		
		ToDoDAO td_dao = ToDoDAO.getInstance();
		
		try {
			list = td_dao.selectToDo(finish_flag);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public boolean addToDo(String content) { 
		boolean flag = false;
		
		ToDoDAO td_dao = ToDoDAO.getInstance();
		try {
			td_dao.insertToDo(content);
			flag = true;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return flag;
	}

	public boolean finishToDo(String td_num) {
		boolean flag = false;
		
		ToDoDAO td_dao = ToDoDAO.getInstance();
		try {
			if(td_dao.updateToDo(td_num)) {
				flag = true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public boolean removeToDo(String td_num) {
		boolean flag = false;
		
		ToDoDAO td_dao = ToDoDAO.getInstance();
		try {
			if(td_dao.deleteToDo(td_num)) {
				flag = true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return flag;
	}
}
