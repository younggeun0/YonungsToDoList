package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ToDoService;

public class AddController implements Controller {

	private String url;
	private boolean forwardFlag;
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String content = request.getParameter("todo");
		ToDoService tdService = new ToDoService();
		url = "main.do";
		
		tdService.addToDo(content);
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
