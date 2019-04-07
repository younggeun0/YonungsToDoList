package dist;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.ToDoController;


@SuppressWarnings("serial")
public class MainController extends HttpServlet {
	
	private static Map<String, Controller> cmdMap;

	static {
		cmdMap = new HashMap<String, Controller>();
		cmdMap.put("insert", new ToDoController("insert"));
		cmdMap.put("update", new ToDoController("update"));
		cmdMap.put("delete", new ToDoController("delete"));
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cmd = request.getParameter("cmd");
		
		if (cmd == null || "".equals(cmd)) {
			movePage(request, response, "main.jsp", false);
		} else if (cmdMap.containsKey(cmd)) {
			
			Controller controller = cmdMap.get(cmd);
			
			controller.execute();
			
			String url = controller.moveUrl();
			boolean forwardFlag = controller.isFoward();
			
			movePage(request, response, url, forwardFlag);
		} else {
			movePage(request, response, "main.jsp", false);
		}
	}
	
	private void movePage(HttpServletRequest request, HttpServletResponse response, String url, boolean forwardFlag) throws ServletException, IOException {
		
		if (forwardFlag) {
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
		} else {
			response.sendRedirect(url);
		}
	}
}
