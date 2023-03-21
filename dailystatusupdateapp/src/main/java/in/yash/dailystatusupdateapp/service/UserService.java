package in.yash.dailystatusupdateapp.service;

import java.util.List;

import in.yash.dailystatusupdateapp.modal.User;

public interface UserService {

	String ROLE_ADMIN = "Admin";
	String ROLE_TRAINER = "Trainer";
	String ROLE_TRAINEE = "Trainee";

	String STATUS_ACTIVE = "Active";
	String STATUS_BLOCKED = "Blocked";

	void registerUser(User user);

	List<User> showAllRegisteredUsers();

	void removeUser(int id);

	User authenticate(String loginname, String password);

}
