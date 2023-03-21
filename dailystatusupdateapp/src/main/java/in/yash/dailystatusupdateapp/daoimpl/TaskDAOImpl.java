package in.yash.dailystatusupdateapp.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.yash.dailystatusupdateapp.dao.TaskDAO;
import in.yash.dailystatusupdateapp.modal.Task;
import in.yash.dailystatusupdateapp.modal.Task;
import in.yash.dailystatusupdateapp.util.DBUtil;

public class TaskDAOImpl extends DBUtil implements TaskDAO {

	@Override
	public void save(Task task) {
		String sql = "insert into tasks (task, duedate, status, userid) values(?,?,?,?)";
		PreparedStatement pstmt = prepareStatement(sql);

		try {
			pstmt.setString(1, task.getTask());
			pstmt.setString(2, task.getDuedate());
			pstmt.setString(3, task.getStatus());
			pstmt.setInt(4, task.getUserid());
			pstmt.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			closePrepareStatement();
		}

	}

	@Override
	public List<Task> findAll() {
		String sql = "select * from tasks";
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

	@Override
	public void update(Task task) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		String sql = "delete from tasks where id="+id;
		PreparedStatement pstmt = prepareStatement(sql);
		try {
			pstmt.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			closePrepareStatement();
		}

	}

}
