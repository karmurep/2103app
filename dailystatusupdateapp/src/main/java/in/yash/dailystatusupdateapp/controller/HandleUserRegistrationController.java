package in.yash.dailystatusupdateapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.yash.dailystatusupdateapp.modal.User;
import in.yash.dailystatusupdateapp.service.UserService;
import in.yash.dailystatusupdateapp.serviceimpl.UserServiceImpl;

/**
 * Servlet implementation class HandleUserRegistrationController
 */
@WebServlet("/HandleUserRegistrationController")
public class HandleUserRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserService userService=null;
	
	public HandleUserRegistrationController() {
		userService=new UserServiceImpl();
	}
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// receive form data
		String loginname = request.getParameter("loginname");
		String password=request.getParameter("password");
		// modal preparation
		User user=new User();
		user.setLoginname(loginname);
		user.setPassword(password);
		// share modal with service
		userService.registerUser(user);
		// redirection
		getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
	}
}
