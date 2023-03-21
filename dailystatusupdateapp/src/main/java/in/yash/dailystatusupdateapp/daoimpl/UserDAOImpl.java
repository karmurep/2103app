package in.yash.dailystatusupdateapp.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.yash.dailystatusupdateapp.dao.UserDAO;
import in.yash.dailystatusupdateapp.modal.User;
import in.yash.dailystatusupdateapp.util.DBUtil;

public class UserDAOImpl extends DBUtil implements UserDAO {

	@Override
	public void save(User user) {
		String sql = "insert into users (loginname, password, status, role) values(?,?,?,?)";
		PreparedStatement pstmt = prepareStatement(sql);

		try {
			pstmt.setString(1, user.getLoginname());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getStatus());
			pstmt.setString(4, user.getRole());
			pstmt.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			closePrepareStatement();
		}

	}

	@Override
	public List<User> findAll() {
		String sql = "select * from users";
		PreparedStatement pstmt = prepareStatement(sql);

		List<User> users = new ArrayList<>();
		User user = null;

		try {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setContact(rs.getString("contact"));
				user.setLoginname(rs.getString("loginname"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));
				user.setStatus(rs.getString("status"));
				users.add(user);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			closePrepareStatement();
		}
		return users;
	}

	@Override
	public void update(User user) {
		String sql = "update users set name=?,contact=? where id=?";
		PreparedStatement pstmt = prepareStatement(sql);
		try {

			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getContact());
			pstmt.setInt(3, user.getId());

			pstmt.execute();

		} catch (Exception ex) {
			System.out.println("Problem : " + ex.getMessage());
		} finally {
			closePrepareStatement();
		}
	}

	@Override
	public void delete(int id) {
		String sql = "delete from users where id="+id;
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
