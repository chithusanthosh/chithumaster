package com.chithu.app.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.chithu.app.entity.User;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		
		user.setUserid(rs.getInt("userid"));
		user.setUsername(rs.getString("username"));
		user.setFirstname(rs.getString("firstname"));
		user.setLastname(rs.getString("lastname"));
		user.setMailid(rs.getString("mailid"));
		user.setAlternatemail(rs.getString("alternatemail"));
		user.setMobilenumber(rs.getBigDecimal("mobilenumber"));
		user.setAlternatenumber(rs.getBigDecimal("alternatenumber"));
		user.setDob(rs.getString("dob"));
		user.setPassword(rs.getString("password"));
		return user;
	}

}
