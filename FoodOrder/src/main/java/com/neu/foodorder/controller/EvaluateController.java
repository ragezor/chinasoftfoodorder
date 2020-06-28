package com.neu.foodorder.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neu.foodorder.entity.Evaluate;
import com.neu.foodorder.service.EvaluateService;
import com.neu.foodorder.utils.FileLoadUtils;

/**
 * 评价的控制层
 * @author 
 *
 */
@RestController
@RequestMapping("/evaluate")
public class EvaluateController {
	@Autowired
	private EvaluateService es;
	//添加评价信息
	@RequestMapping("/add")
	public Object add(@RequestBody Evaluate e) {
		Map<String, Object> map=new HashMap<>();
		Map<String,Object> result=new HashMap<>();
		Evaluate target=es.addEvaluate(e);
		if(target!=null) {
			result.put("addMsg", "添加成功"); 
			result.put("item",target);
			map.put("success", true);
			map.put("code",1);
			map.put("failMsg","");
		}else {
			result.put("addMsg", "添加失败"); 
			result.put("item","");
			map.put("success", false);
			map.put("code",0);
			map.put("failMsg","评价信息添加失败");
		}
		map.put("result",result);
		return map;
	}
	
	//修改评价
	@RequestMapping("/update")
	public Object update(@RequestBody Evaluate e) {
		Map<String, Object> map=new HashMap<>();
		Map<String,Object> result=new HashMap<>();
		Evaluate target=es.updateEva(e);
		if(target!=null) {
			result.put("udMsg", "修改成功"); 
			result.put("item",target);
			map.put("success", true);
			map.put("code",1);
			map.put("failMsg","");
		}else {
			result.put("udMsg", "修改失败"); 
			result.put("item","");
			map.put("success", false);
			map.put("code",0);
			map.put("failMsg","评价信息不存在");
		}
		map.put("result",result);
		return map;
	}
	
	//根据id删除评价信息
	@RequestMapping("/del")
	public Object delEva(@RequestBody Evaluate e) {
		Map<String, Object> map=new HashMap<>();
		Map<String,Object> result=new HashMap<>();
		boolean target=es.delEva(e.getEid());
		if(target) {
			result.put("delMsg", "删除成功"); 
			map.put("success", true);
			map.put("code",1);
			map.put("failMsg","");
		}else {
			result.put("delMsg", "删除失败"); 
			map.put("success", false);
			map.put("code",0);
			map.put("failMsg","评价信息不存在");
		}
		map.put("result",result);
		return map;
	}
	
	//万能查询 根据对象查询信息
	@RequestMapping("/varselect")
	public Object selectByVar(@RequestParam(value = "eid",required = false)Integer eid,
			@RequestParam(value = "userid",required = false) Integer userid,
			@RequestParam(value = "foodid",required = false)Integer foodid,
			@RequestParam(value = "elev",required = false)Integer elev,
			@RequestParam(value = "etime",required = false)String etime) {
		Map<String, Object> map=new HashMap<>();
		Map<String,Object> result=new HashMap<>();
		Evaluate evaluate=new Evaluate(eid, foodid, userid, null, elev, etime);
		List<Evaluate> list=es.selectByVar(evaluate);
		if(list!=null&&list.size()!=0) {
			result.put("Msg", "共查询到"+list.size()+"条记录");
			result.put("list", list);
			map.put("success", true);
			map.put("code",1);
			map.put("failMsg","");
		}else {
			result.put("Msg", "查询失败");
			result.put("list", "");
			map.put("success", false);
			map.put("code",0);
			map.put("failMsg","没有查询到符合的评价");
		}
		map.put("result",result);
		return map;
	}

}
