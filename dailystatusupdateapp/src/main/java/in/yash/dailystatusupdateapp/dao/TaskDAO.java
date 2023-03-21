package in.yash.dailystatusupdateapp.dao;

import java.util.List;

import in.yash.dailystatusupdateapp.modal.Task;

public interface TaskDAO {
	void save(Task task);
	
	List<Task> findAll();
	
	void update(Task task);
	
	void delete(int id);


}
