package com.neu.foodorder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neu.foodorder.entity.Member;
import com.neu.foodorder.entity.VIPType;
import com.neu.foodorder.mapper.MemberMapper;
/**
 * 会员的业务层接口
 * @author 
 *
 */
public interface MemberService {
	
	public int regMember(Member member);//注册会员
	public List<Member> getAll();//获取会员列表
	public List<VIPType> typesAll();//获取会员种类用户列表
	public Member renew(int id,int months);//续费会员
	public int updateVipType(VIPType type);//修改会员种类
	public VIPType addType(VIPType type);//添加会员种类
	

}
