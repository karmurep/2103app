package in.yash.dailystatusupdateapp.serviceimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.yash.dailystatusupdateapp.dao.TaskDAO;
import in.yash.dailystatusupdateapp.daoimpl.TaskDAOImpl;
import in.yash.dailystatusupdateapp.modal.Task;
import in.yash.dailystatusupdateapp.service.TaskService;
import in.yash.dailystatusupdateapp.util.DBUtil;

public class TaskServiceImpl extends DBUtil implements TaskService {
	
	private TaskDAO taskDAO;
	
	public TaskServiceImpl() {
		taskDAO =  new TaskDAOImpl();
	}

	@Override
	public void createTask(Task task) {
		taskDAO.save(task);

	}

	@Override
	public List<Task> showAll() {
		
		return taskDAO.findAll();
	}

	@Override
	public void removeTask(int id) {
		taskDAO.delete(id);

	}

	@Override
	public List<Task> showAllTasksByLoggedInUserId(int loggedInUserId) {
		String sql = "select * from tasks where userid="+loggedInUserId;
		PreparedStatement pstmt = prepareStatement(sql);

		List<Task> tasks = new ArrayList<>();
		Task task = null;

		try {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				task = new Task();
				task.setId(rs.getInt("id"));
				task.setStatus(rs.getString("status"));
				task.setTask(rs.getString("task"));
				task.setDuedate(rs.getString("duedate"));
				task.setUserid(rs.getInt("userid"));				
				tasks.add(task);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			closePrepareStatement();
		}
		return tasks;
	}

}
