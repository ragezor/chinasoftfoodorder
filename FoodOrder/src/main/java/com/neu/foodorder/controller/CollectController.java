package com.neu.foodorder.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neu.foodorder.entity.Collect;
import com.neu.foodorder.service.CollectService;

/**
 * 收藏的控制层
 * @author
 *
 */
@RestController
@RequestMapping("/collect")
public class CollectController {
	@Autowired
	private CollectService cs;
	
	//添加收藏
	@RequestMapping("/add")
	public Object add(@RequestBody Collect collect) {
		Map<String,Object> map=new HashMap<>(); 
		Map<String,Object> result=new HashMap<>(); 
		int i=cs.add(collect);
		if(i==1) {
			result.put("addMsg", "添加成功"); 
			map.put("success", true);
			map.put("code",1);
			map.put("failMsg","");
		}else {
			result.put("addMsg", "添加失败"); 
			map.put("success", false);
			map.put("code",0);
			map.put("failMsg","添加收藏失败");
		}
		map.put("result",result);
		return map;
	}
	
	//删除收藏
	@RequestMapping("/del")
	public Object del(@RequestBody Collect c) {
		Map<String,Object> map=new HashMap<>(); 
		Map<String,Object> result=new HashMap<>(); 
		int i=cs.del(c.getCid());
		if(i==1) {
			result.put("delMsg", "删除成功"); 
			map.put("success", true);
			map.put("code",1);
			map.put("failMsg","");
		}else {
			result.put("delMsg", "删除失败"); 
			map.put("success", false);
			map.put("code",0);
			map.put("failMsg","删除的内容不存在");
		}
		map.put("result",result);
		return map;
	}
	
	//查询收藏 条件组合查询+模糊查询
	@RequestMapping("/select")
	public Object getAll(@RequestParam(value = "cid",required = false)Integer cid,
			@RequestParam(value = "userid",required = false)Integer userid,
			@RequestParam(value = "ctime",required = false)String ctime,
			@RequestParam(value = "foodid",required = false)Integer foodid) {
		Map<String,Object> map=new HashMap<>(); 
		Map<String,Object> result=new HashMap<>(); 
		Collect c=new Collect(cid, userid, foodid, ctime);
		List<Collect> list=cs.select(c);
		if(list!=null&&list.size()!=0) {
			result.put("Msg", "共查询到"+list.size()+"条记录"); 
			result.put("list", list);
			map.put("success", true);
			map.put("code",1);
			map.put("failMsg","");
		}else {
			result.put("Msg", "没有查询到相关的内容"); 
			result.put("list", "");
			map.put("success", false);
			map.put("code",0);
			map.put("failMsg","没有查询到相关内容");
		}
		map.put("result",result);
		return map;
	}
	

}
