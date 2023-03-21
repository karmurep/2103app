package in.yash.dailystatusupdateapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.yash.dailystatusupdateapp.modal.User;
import in.yash.dailystatusupdateapp.service.UserService;
import in.yash.dailystatusupdateapp.serviceimpl.UserServiceImpl;

/**
 * Servlet implementation class HandleUserAuthenticationController
 */
@WebServlet("/HandleUserAuthenticationController")
public class HandleUserAuthenticationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService;

	public HandleUserAuthenticationController() {
		userService = new UserServiceImpl(); // DI : tight coupling
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// receive form data
		String loginname = request.getParameter("loginname");
		String password = request.getParameter("password");
		//Autheticate user via userService
		User loggedInUser = userService.authenticate(loginname,password);
		
		//session creation : Role management, Status management
		HttpSession session = request.getSession();
		session.setAttribute("aUserId", loggedInUser.getId());
		session.setAttribute("user_role", loggedInUser.getRole());
		session.setAttribute("user_status", loggedInUser.getStatus());
		session.setAttribute("userName", loggedInUser.getName());
		session.setAttribute("loggedInUser", loggedInUser);
		// redirection
		getServletContext().getRequestDispatcher("/dashboard.jsp").forward(request, response);
	}

}
