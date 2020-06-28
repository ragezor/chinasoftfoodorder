package com.neu.foodorder.service;

import java.util.List;

import com.neu.foodorder.entity.User;

public interface UserService {
	
	public List<User> getAll();//获取用户列表
	public User login(User user);//登录
	public int register(User user);//注册
	public int updateUser(User user);//修改个人信息
	public boolean upload(User user);//修改头像

}
