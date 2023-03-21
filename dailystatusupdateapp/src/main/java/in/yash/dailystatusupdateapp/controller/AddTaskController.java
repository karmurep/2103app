package in.yash.dailystatusupdateapp.controller;

import java.io.IOException;
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
 * Servlet implementation class AddTaskController
 */
@WebServlet("/AddTaskController")
public class AddTaskController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private TaskService taskService;
    public AddTaskController() {
       taskService =  new TaskServiceImpl();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =  request.getSession();
		
		Task task =  new Task();
		task.setDuedate(request.getParameter("duedate"));
		task.setTask(request.getParameter("task"));
		task.setStatus(request.getParameter("status"));
		task.setUserid((int) session.getAttribute("aUserId"));
		taskService.createTask(task);
		//redirection :  task list. 
		getServletContext().getRequestDispatcher("/PrepareTaskController").forward(request, response);
		
		
		
	}

}
