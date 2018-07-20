package com.jspstudy.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspstudy.dao.tDao;

public class tAddCommand implements tCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String tContent = request.getParameter("todo");
		
		tDao dao = new tDao();
		
		dao.add(tContent);
	}

}
