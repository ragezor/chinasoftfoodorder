package com.neu.foodorder.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neu.foodorder.entity.Order;
import com.neu.foodorder.service.OrderService;
import com.neu.foodorder.utils.FileLoadUtils;

/**
 * 订单的Controller层
 * @author 
 *
 */
@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService os;
	
	//添加订单
	@RequestMapping("/add")
	public Object addOrder(@RequestBody Order order) {
		Map<String,Object> map=new HashMap<>(); 
		Map<String,Object> result=new HashMap<>(); 
		Order target=os.addOrder(order);
		if(target!=null) {
			result.put("addlMsg", "添加成功"); 
			result.put("item",target);
			map.put("success", true);
			map.put("code",1);
			map.put("failMsg","");
		}else {
			result.put("addMsg", "添加失败"); 
			result.put("item","");
			map.put("success", false);
			map.put("code",0);
			map.put("failMsg","订单生成失败");
		}
		map.put("result",result);
		return map;
	}
	
	//修改订单
	@RequestMapping("/update")
	public Object updateOrder(@RequestBody Order order) {
		Map<String,Object> map=new HashMap<>(); 
		Map<String,Object> result=new HashMap<>(); 
		Order target=os.updateOrder(order);
		if(target!=null) {
			result.put("udMsg", "修改成功"); 
			result.put("target",target);
			map.put("success", true);
			map.put("code",1);
			map.put("failMsg","");
		}else {
			result.put("udMsg", "修改失败"); 
			result.put("target","");
			map.put("success", false);
			map.put("code",0);
			map.put("failMsg","订单号不存在");
		}
		map.put("result",result);
		return map;
	}
	
	//查询用户所有订单
	@RequestMapping("/getallpersonal")
	public Object getAll(@RequestParam("userid")Integer userid,
			@RequestParam(value = "ordertime",required = false)String time,
			@RequestParam(value ="ordereval" ,required = false)Integer eval) {
		Map<String,Object> map=new HashMap<>(); 
		Map<String,Object> result=new HashMap<>(); 
		Order order=new Order();
		order.setUserid(userid);order.setOrdereval(eval);order.setOrdertime(time);
		List<Order> items= os.selectByVar(order);
		if(items!=null) {
			result.put("Msg", "共查询到"+items.size()+"条记录"); 
			result.put("list",items);
			map.put("success", true);
			map.put("code",1);
			map.put("failMsg","");
		}else {
			result.put("Msg", "没有查询到相关的数据"); 
			result.put("list","");
			map.put("success", false);
			map.put("code",0);
			map.put("failMsg","没有符合要求的数据");
		}
		map.put("result",result);
		return map;
	}
	
	//查询所有订单
	@RequestMapping("/getall")
	public Object getAll(@RequestParam(value = "orderid",required = false)Integer orderid,
			@RequestParam(value = "userid",required = false)Integer userid,
			@RequestParam(value = "ordertime",required = false)String ordertime,
			@RequestParam(value = "orderstate",required = false)Integer orderstate,
			@RequestParam(value = "ordereval",required = false)Integer ordereval) {
		Map<String,Object> map=new HashMap<>(); 
		Map<String,Object> result=new HashMap<>(); 
		Order order=new Order(orderid, userid, ordertime, orderstate, ordereval);
		List<Order> items= os.selectByVar(order);
		if(items!=null) {
			result.put("Msg", "共查询到"+items.size()+"条记录"); 
			result.put("list",items);
			map.put("success", true);
			map.put("code",1);
			map.put("failMsg","");
		}else {
			result.put("Msg", "没有查询到相关的数据"); 
			result.put("list","");
			map.put("success", false);
			map.put("code",0);
			map.put("failMsg","没有符合要求的数据");
		}
		map.put("result",result);
		return map;
	}
	
}
