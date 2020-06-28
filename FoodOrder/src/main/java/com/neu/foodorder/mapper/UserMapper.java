package com.neu.foodorder.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.neu.foodorder.entity.User;

@Mapper
public interface UserMapper {
	//查找所有用户
	@Select("select * from user")
	public List<User>getAll();
	//用户登录
	public User login(User user);
	//用户注册
	public int register(User user);
	//根据用户名查找用户
	@Select("select * from user where username=#{name}")
	public User findUserByName(String name);
	//更新用户信息
	public int updateUser(User user);
	//修改头像
	@Update("update user set pic=#{pic} where userid=#{id}")
	public int upload(User user);
	//根据用户id查找用户
	public User getUserById(int id);
	//修改用户的会员信息
	@Update("update user set vipid=#{vipid} where userid=#{id}")
	public int modifyVlev(int id,int vipid);
	//查找所有用户 带会员信息
	public List<User> getAllUserWithMem();
}
