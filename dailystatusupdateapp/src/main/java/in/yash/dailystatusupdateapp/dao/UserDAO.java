package in.yash.dailystatusupdateapp.dao;

import java.util.List;

import in.yash.dailystatusupdateapp.modal.User;

public interface UserDAO {
	
	void save(User user);
	
	List<User> findAll();
	
	void update(User user);
	
	void delete(int id);

}
