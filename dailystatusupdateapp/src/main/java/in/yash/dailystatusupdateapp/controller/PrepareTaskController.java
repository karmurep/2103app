package in.yash.dailystatusupdateapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.yash.dailystatusupdateapp.modal.Task;
import in.yash.dailystatusupdateapp.service.TaskService;
import in.yash.dailystatusupdateapp.serviceimpl.TaskServiceImpl;

/**
 * Servlet implementation class PrepareTaskController
 */
@WebServlet("/PrepareTaskController")
public class PrepareTaskController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TaskService taskService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrepareTaskController() {
    	taskService = new TaskServiceImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int loggedInUserId = (int) session.getAttribute("aUserId");
	
		List<Task> tasks =  taskService.showAllTasksByLoggedInUserId(loggedInUserId);
		request.setAttribute("taskList", tasks);
		getServletContext().getRequestDispatcher("/listTasks.jsp").forward(request, response);
	}

}
