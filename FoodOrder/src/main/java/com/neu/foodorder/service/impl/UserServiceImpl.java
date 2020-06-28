package com.neu.foodorder.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neu.foodorder.entity.User;
import com.neu.foodorder.mapper.UserMapper;
import com.neu.foodorder.service.UserService;
import com.neu.foodorder.utils.FileLoadUtils;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper mapper;
	
	@Override
	public List<User> getAll() {//获取用户列表 带会员信息
		return mapper.getAllUserWithMem();
	}
	
	@Override
	public User login(User user) {//登录
		//验证用户名密码
		User u=mapper.login(user);
		System.out.println(u);
		//return u;
		return u==null?null:mapper.getUserById(u.getUserid());
	}
	@Override
	public int register(User user) {//注册
		User userWithName=mapper.findUserByName(user.getUsername());
		//System.err.println(123);
		if(userWithName!=null)return -1;
		return mapper.register(user);
		
	}

	@Override
	public int updateUser(User user) {//修改用户信息
		System.out.println(user+"---");
		return mapper.updateUser(user);
	}

	@Override
	public boolean upload(User user) {//上传用户头像
		String oldPath=mapper.getUserById(user.getUserid()).getPic();
		FileLoadUtils.removePic(oldPath);
		return mapper.updateUser(user)==1?true:false;
	}

}
