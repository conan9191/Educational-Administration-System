package com.service;

import com.pojo.User;

public interface IUserService {
	public User getUserById(int userId);
	public int register(User record);
	public int login(User record);
	public User getUserCondition(String username);
}
