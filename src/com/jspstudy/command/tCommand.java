package com.jspstudy.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface tCommand {
	
	void execute(HttpServletRequest request, HttpServletResponse response);

}
