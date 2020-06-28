package com.neu.foodorder.controller;
/**
 * 会员的控制器类
 * @author 
 *
 */

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neu.foodorder.entity.Member;
import com.neu.foodorder.entity.User;
import com.neu.foodorder.entity.VIPType;
import com.neu.foodorder.service.MemberService;

@RestController
@RequestMapping("/vip")
public class MemberController {
	@Autowired
	private MemberService ms;
	
	
	//获取vip列表	
		@RequestMapping("/getall")
		public Object getAll() {
			Map<String, Object> map=new HashMap<>();
			List<Member> ml=ms.getAll();
			map.put("success", true);
			map.put("code", 1);		//成功码
			map.put("failMsg", "");
			map.put("result", ml);
			if(ml==null||ml.size()==0) { 	//空
				map.put("success", false);
				map.put("code", 0);		//失败码
				map.put("failMsg", "没有查询到相关内容");
			}
			return map;
		}
	
	//注册会员
	@RequestMapping("/reg")
	public Object regMember(@RequestParam("userid")int uid,@RequestParam("viplev")int lev
			,@RequestParam("months")int months) {
		Map<String, Object> map=new HashMap<>();
		String now=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		Calendar calendar=Calendar.getInstance();
		int year=calendar.get(calendar.YEAR);
		int month=calendar.get(calendar.MONTH);
		int day=calendar.get(calendar.DATE);
		String endtime=new StringBuilder().append(year+(month+months)/12)
				.append("-").append((month+months+1)%12).append("-").append(day).toString();
		Member member=new Member(uid,lev,now,endtime);
		int status=ms.regMember(member);
		map.put("result", "会员注册失败!");
		map.put("success",false);
		map.put("code",0);
		if(status==-1) {
			map.put("failMsg","请先填写手机号");
		}else if(status!=1){
			map.put("failMsg","会员注册失败");
		}else {
			map.put("result","会员注册成功");
			map.put("success",true);
			map.put("code",1);
		}
		return map;
	}
	
	//获取会员种类列表
	@RequestMapping("/typesall")
	public Object typesAll() {
		Map<String, Object> map=new HashMap<>();
		List<VIPType> list=ms.typesAll();
		map.put("success", true);
		map.put("code", 1);
		map.put("failMsg", "");
		map.put("result", list);
		if(list==null||list.size()==0) {
			map.put("success", false);
			map.put("code", 0);
			map.put("failMsg", "没有查询到相关内容");
		}
		return map;
	}
	
	//续费会员
	@RequestMapping("/renew")
	public Object renew(@RequestParam("userid")int id,@RequestParam("months")int months) {
		Map<String,Object> map=new HashMap<>();
		Member member=ms.renew(id, months);
		Map<String,Object> result=new HashMap<>();
		if(member!=null) {
			result.put("Msg","续费成功");
			result.put("information",member);
			map.put("code", 1);
			map.put("success", true);
			map.put("failMsg","");
		}else {
			result.put("Msg", "续费失败");
			result.put("information", "");
			map.put("code", 0);
			map.put("success", false);
			map.put("failMsg","用户id不存在");
		}
		map.put("result",result);
		return map;
	}
	
	//修改会员种类信息
	@RequestMapping("/updatetype")
	public Object updateType(@RequestBody VIPType type) {
		Map<String,Object> map=new HashMap<>();
		int i=ms.updateVipType(type);
		Map<String,Object> result=new HashMap<>();
		if(i==1) {
			result.put("udMsg","修改成功");
		//	result.put("list", ms.typesAll());
			map.put("code", 1);
			map.put("success", true);
			map.put("failMsg","");
		}else {
			result.put("udMsg", "修改失败");
			map.put("code", 0);
			map.put("success", false);
			map.put("failMsg","修改会员种类信息失败");
		}
		map.put("result",result);
		return map;
	}
	
	//添加会员种类信息
	@RequestMapping("addtype")
	public Object addType(@RequestBody VIPType type) {
		Map<String,Object> map=new HashMap<>();
		VIPType res=ms.addType(type);
		Map<String,Object> result=new HashMap<>();
		if(res!=null) {
			result.put("addMsg","添加成功");
			result.put("type", res);
			map.put("code", 1);
			map.put("success", true);
			map.put("failMsg","");
		}else {
			result.put("addMsg", "添加失败");
			result.put("type", "");
			map.put("code", 0);
			map.put("success", false);
			map.put("failMsg","会员种类名称已存在！");
		}
		map.put("result",result);
		return map;
	}

}
