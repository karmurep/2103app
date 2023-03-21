package in.yash.dailystatusupdateapp.serviceimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.yash.dailystatusupdateapp.dao.UserDAO;
import in.yash.dailystatusupdateapp.daoimpl.UserDAOImpl;
import in.yash.dailystatusupdateapp.modal.User;
import in.yash.dailystatusupdateapp.service.UserService;
import in.yash.dailystatusupdateapp.util.DBUtil;

public class UserServiceImpl extends DBUtil implements UserService{
	
	private UserDAO userDAO=null;
	
	
	public UserServiceImpl() {
		userDAO=new UserDAOImpl();
	}

	@Override
	public void registerUser(User user) {
		user.setRole(ROLE_TRAINEE);
		user.setStatus(STATUS_ACTIVE);
		userDAO.save(user);
	}



	@Override
	public List<User> showAllRegisteredUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeUser(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User authenticate(String loginname, String password) {
		String sql = "select * from users where loginname='"+loginname+"' and password='"+password+"'";
		PreparedStatement pstmt = prepareStatement(sql);
		User user = null;

		try {
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setContact(rs.getString("contact"));
				user.setLoginname(rs.getString("loginname"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));
				user.setStatus(rs.getString("status"));
				
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			closePrepareStatement();
		}
		
		return user;
	}

}
