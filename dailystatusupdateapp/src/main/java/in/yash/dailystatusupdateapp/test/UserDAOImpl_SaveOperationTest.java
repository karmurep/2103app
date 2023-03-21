package in.yash.dailystatusupdateapp.test;

import in.yash.dailystatusupdateapp.dao.UserDAO;
import in.yash.dailystatusupdateapp.daoimpl.UserDAOImpl;
import in.yash.dailystatusupdateapp.modal.User;

public class UserDAOImpl_SaveOperationTest {

	public static void main(String[] args) {
		UserDAO userDAO =  new UserDAOImpl();
		
		User user = new User();
		user.setLoginname("Amit");
		user.setPassword("amit123");
		user.setRole("trainee");
		user.setStatus("active");
		
		userDAO.save(user);
		
		System.out.println("Success! user is saved");

	}

}
