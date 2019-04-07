package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	
	public void execute(HttpServletRequest request, HttpServletResponse response);
	
	public String moveUrl();
	
	public boolean isFoward();
}
