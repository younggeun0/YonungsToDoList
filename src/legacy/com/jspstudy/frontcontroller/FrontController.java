package legacy.com.jspstudy.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import legacy.com.jspstudy.command.tAddCommand;
import legacy.com.jspstudy.command.tCommand;
import legacy.com.jspstudy.command.tCompleteCommand;
import legacy.com.jspstudy.command.tDeleteCommand;
import legacy.com.jspstudy.command.tListCommand;

/*@WebServlet("*.do")*/
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FrontController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionDo");
		
		request.setCharacterEncoding("EUC-KR");
		
		String viewPage = null;
		tCommand command = null;
		
		String uri = request.getRequestURI();
		String contextpath = request.getContextPath();
		String com = uri.substring(contextpath.length());
		
		if (com.equals("/add.do")) {
			command = new tAddCommand();
			command.execute(request, response);
			viewPage = "/list.do";
		} else if (com.equals("/list.do")) {
			command = new tListCommand();
			command.execute(request, response);
			viewPage = "/main.jsp";
		} else if (com.equals("/delete.do")) {
			command = new tDeleteCommand();
			command.execute(request, response);
			viewPage = "/list.do";
		} else if (com.equals("/modify.do")) {
			
		} else if (com.equals("/complete.do")) {
			command = new tCompleteCommand();
			command.execute(request, response);
			viewPage = "/list.do";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
