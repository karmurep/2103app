package in.yash.dailystatusupdateapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.yash.dailystatusupdateapp.service.TaskService;
import in.yash.dailystatusupdateapp.serviceimpl.TaskServiceImpl;

/**
 * Servlet implementation class DeleteTaskController
 */
@WebServlet("/DeleteTaskController")
public class DeleteTaskController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TaskService taskService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTaskController() {
    	taskService = new TaskServiceImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int taskId = Integer.parseInt(request.getParameter("taskId"));
		taskService.removeTask(taskId);
		getServletContext().getRequestDispatcher("/PrepareTaskController").forward(request, response);
	}

}
