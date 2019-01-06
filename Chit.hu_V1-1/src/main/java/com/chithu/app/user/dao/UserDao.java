package com.chithu.app.user.dao;

import org.springframework.stereotype.Component;

import com.chithu.app.entity.User;

@Component
public interface UserDao {

	public String getUser(String userid, String password);
	public int saveUser(User user);
	public boolean deleteUser(User user);
}
