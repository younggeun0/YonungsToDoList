package legacy.com.jspstudy.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import legacy.com.jspstudy.dao.tDao;

public class tCompleteCommand implements tCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String tId = request.getParameter("tId");
		
		tDao dao = new tDao();
		
		dao.complete(tId);
	}

}
