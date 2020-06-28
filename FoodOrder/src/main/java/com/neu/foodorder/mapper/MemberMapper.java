package com.neu.foodorder.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.neu.foodorder.entity.Member;
import com.neu.foodorder.entity.VIPType;
/**
 * 会员的mapper层接口
 * @author 
 *
 */
@Mapper
public interface MemberMapper {
	//注册会员
	public int regMember(Member member);
	//查找所有会员
	@Select(" SELECT * FROM vip ")
	public List<Member> getAll();
	//查找所有会员种类
	@Select("select * from viptype")
	public List<VIPType> typesAll();
	//根据用户id查找会员
	@Select("select * from vip where userid=#{val}")
	public Member getMemberByUserId(int userid);
	//续费会员
	public int renew(@Param("id")int id,@Param("months")int months);
	//根据vipid查找会员信息
	@Select("select * from vip where vipid=#{id}")
	public Member selectByVid(int id);
	//修改会员种类
	public int updateType(VIPType type);
	//添加会员种类
	@Insert("insert into viptype values(null,#{viplev},#{vipname},#{vipdesc},#{vipprice})")
	public int addType(VIPType type);
	//根据会员种类名称查找会员种类
	@Select("select * from viptype where vipname=#{name}")
	public VIPType findTypeByName(String name);
}
