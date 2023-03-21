package in.yash.dailystatusupdateapp.service;

import java.util.List;

import in.yash.dailystatusupdateapp.modal.Task;

public interface TaskService {
	
	void createTask(Task task);
	List<Task> showAll();
	void removeTask(int id);
	List<Task> showAllTasksByLoggedInUserId(int loggedInUserId);

}
