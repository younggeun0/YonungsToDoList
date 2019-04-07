package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ToDoService;

public class RemoveController implements Controller {

	private String url;
	private boolean forwardFlag;
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		ToDoService tdService = new ToDoService();
		String td_num = request.getParameter("td_num");
		
		url = "main.do";
		if(tdService.removeToDo(td_num)) {
			forwardFlag = true;
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
