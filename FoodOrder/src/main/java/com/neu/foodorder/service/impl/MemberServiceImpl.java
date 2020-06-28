package com.neu.foodorder.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neu.foodorder.entity.Member;
import com.neu.foodorder.entity.User;
import com.neu.foodorder.entity.VIPType;
import com.neu.foodorder.mapper.MemberMapper;
import com.neu.foodorder.mapper.UserMapper;
import com.neu.foodorder.service.MemberService;
/**
 * 会员的业务层实现类
 * @author 
 *
 */
@Service
public class MemberServiceImpl  implements MemberService {
	

	@Autowired
	private MemberMapper mapper;
	@Autowired
	private UserMapper umapper;
	
	@Override
	public int regMember(Member member) {//注册会员
		//User user=member.getUser();
		User qUser=umapper.getUserById(member.getUserid());
		if(qUser==null||qUser.getPhonenum()==null)return -1;
		umapper.modifyVlev(member.getUserid(), member.getVipid());//修改用户表
		return mapper.regMember(member);
	}

	@Override
	public int updateVipType(VIPType type) {//修改会员种类信息
		return mapper.updateType(type);
	}

	@Override
	public VIPType addType(VIPType type) {//添加会员种类
		if(mapper.findTypeByName(type.getVipname())!=null)return null;//已经存在同名的会员种类
		mapper.addType(type);
		return mapper.findTypeByName(type.getVipname());
	}

	@Override
	public List<Member> getAll() {
		return mapper.getAll();
	}

	@Override
	public Member renew(int id, int months) {//续费会员
		return mapper.renew(id, months)==1?mapper.getMemberByUserId(id):null;
	}

	@Override
	public List<VIPType> typesAll() {
		return mapper.typesAll();
	}
	
	
}
