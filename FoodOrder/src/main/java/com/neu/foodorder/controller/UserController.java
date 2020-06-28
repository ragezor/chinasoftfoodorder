package com.neu.foodorder.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.neu.foodorder.entity.User;
import com.neu.foodorder.service.UserService;
import com.neu.foodorder.utils.FileLoadUtils;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService us;
	
	//获取所有用户信息
	@RequestMapping("/getall")
	public Object getAll() {
		Map<String, Object> map=new HashMap<>();
		List<User> list=us.getAll();
		map.put("success", true);
		map.put("code", 1);
		map.put("failMsg", "");
		map.put("result", list);
		if(list==null||list.size()==0) {
			map.put("success", false);
			map.put("code", 0);
			map.put("failMsg", "没有查询到相关内容");
			map.put("result","");
		}
		return map;
		
	}
	
		//登录
		@RequestMapping("/login")
		public Object login(@RequestBody User user,HttpSession session) { 
			Map<String,Object> map = new HashMap<String,Object>();
			Map<String,Object> result=new HashMap<>();
			User u = us.login(user);
			result.put("isLogin",false);
			if(u!=null) {
				//session.setMaxInactiveInterval(120*60);
				result.put("isLogin",true);
				result.put("userid",u.getUserid());
				map.put("sucess", true);
				map.put("code", 1);
				map.put("failMsg", "");
				session.setAttribute("loginUser", u);
				//System.out.println("-p---"+session.getId());
			}
			else {
				map.put("sucess", false);
				map.put("code", 0);
				map.put("failMsg", "用户名或密码错误");
			}
			map.put("result", result);
			return map;
			
		}
		
		//获取个人信息
		@RequestMapping("getloginuser")
		public Object getLoginUseer(@RequestParam("userid")int id,HttpSession session) {
			User user=(User)session.getAttribute("loginUser");
			Map<String,Object> map=new HashMap<>();
			if(user==null||id!=user.getUserid()) {
				map.put("result","");
				map.put("success",false);
				map.put("code",0);
				map.put("failMsg","用户未登录");
			}else {
				map.put("result",user);
				map.put("code",1);
				map.put("success",true);
				map.put("failMsg","");
			}
			return map;
		}
		
		//注册
		@RequestMapping("/register")
		public Object register(@RequestBody User user) { 
			Map<String,Object> map = new HashMap<String,Object>();
			
			//注册的系统时间
			Date date = new Date();
			SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :HH:mm:ss");
			String s = dateFormat.format(date);
			//User user=new User(username, password);
			user.setRegtime(s);
			int i = us.register(user);
			Map<String,Object> result=new HashMap<>();
			if(i==1 ) {
				result.put("regist","注册成功！");
				map.put("sucess", true);
				map.put("code", 1);
				map.put("failMsg", "");
				
			}
			else {
				result.put("regist","注册失败");
				map.put("sucess", false);
				map.put("code", 0);
				map.put("failMsg", "用户名已存在");
			}
			map.put("result", result);
			return map;
		}
		
		//修改用户个人信息
		@RequestMapping("/updateuser")
		public Object updateUser(@RequestBody User user) {
			Map<String,Object> map=new HashMap<>();
			int i=us.updateUser(user);
			Map<String,Object> result=new HashMap<>();
			if(i==1) {
				result.put("udMsg", "修改成功");
				map.put("success",true);
				map.put("code",1);
				map.put("failMsg","");
			}
			else {
				result.put("udMsg", "修改失败");
				map.put("success",false);
				map.put("code",0);
				map.put("failMsg","用户不存在或参数为空");
			}
			map.put("result", result);
			return map;
		}
		
		//上传用户头像
		@RequestMapping("/upload")
		public Object upload(@RequestParam("mf")MultipartFile mf,@RequestParam("userid")int id){
			String newPath=FileLoadUtils.upload(mf, "user");
			Map<String,Object> map=new HashMap<>(); 
			Map<String,Object> result=new HashMap<>(); 
			if(newPath==null) { 
				result.put("ulMsg", "上传失败"); 
				result.put("path","");
				map.put("success", false);
				map.put("code",0);
				map.put("failMsg","文件格式不正确");
			}else {
				User user=new User();
				user.setUserid(id);
				user.setPic(newPath);
				boolean delMsg=us.upload(user);
				if(delMsg) {
					result.put("ulMsg", "上传成功"); 
					result.put("path",newPath);
					map.put("success", true);
					map.put("code",1);
					map.put("failMsg","");
				}else {
					result.put("ulMsg", "上传失败"); 
					result.put("path","");
					map.put("success", false);
					map.put("code",0);
					map.put("failMsg","用户id不存在");
				}
				
			}
			map.put("result",result);
			return map;
		}
			
		
}
