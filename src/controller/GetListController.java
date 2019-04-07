package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.ToDo;
import service.ToDoService;

public class GetListController implements Controller {

	private String url;
	private boolean forwardFlag;
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		// 다른 서비스 사용
		ToDoService tdService = new ToDoService();
		
		List<ToDo> finishedList = tdService.getToDo("Y");
		List<ToDo> toDoList = tdService.getToDo("N");
		
		url = "main.jsp";
		if (finishedList != null && toDoList != null) {
			forwardFlag = true;
			request.setAttribute("finishedList", finishedList);
			request.setAttribute("toDoList", toDoList);
		}
	}

	@Override
	public String moveUrl() {
		return url;
	}

	@Override
	public boolean isFoward() {
		return forwardFlag;
	}
}
