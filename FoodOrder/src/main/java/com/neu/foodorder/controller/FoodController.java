package com.neu.foodorder.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.neu.foodorder.entity.Food;
import com.neu.foodorder.entity.FoodType;
import com.neu.foodorder.entity.User;
import com.neu.foodorder.service.FoodService;
import com.neu.foodorder.utils.FileLoadUtils;

@RestController
@RequestMapping("/food")
public class FoodController {

	@Autowired
	private FoodService fs;
	//获取食品列表
	@RequestMapping("/getall")
	public Object getAll() {
		Map<String, Object> map=new HashMap<>();
		List<Food> list=fs.getAll();
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
	//获取食品种类列表
	@RequestMapping("/typesall")
	public Object typesAll() {
		Map<String, Object> map=new HashMap<>();
		List<FoodType> list=fs.typesAll();
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
	
	
	//添加食品种类
	@RequestMapping("/addtype")
	public Object addFoodType(@RequestParam("mf")MultipartFile mf,@RequestParam("ftname")String name,@RequestParam("ftdesc")String desc) {
		Map<String, Object> map=new HashMap<>();
		Map<String,Object> result=new HashMap<>();
		String newPath=FileLoadUtils.upload(mf, "foodtype");
		if(newPath==null) { 
			result.put("ulMsg", "添加失败"); 
			result.put("path","");
			map.put("success", false);
			map.put("code",0);
			map.put("failMsg","文件格式不正确");
		}else {
			FoodType ft=new FoodType(name, newPath, desc);
			FoodType target=fs.addFoodType(ft);
			if(target!=null) {
				result.put("ulMsg", "添加成功"); 
				result.put("item",target);
				map.put("success", true);
				map.put("code",1);
				map.put("failMsg","");
			}else {
				FileLoadUtils.removePic(newPath);
				result.put("ulMsg", "添加失败"); 
				result.put("item","");
				map.put("success", false);
				map.put("code",0);
				map.put("failMsg","食品种类名称已存在");
			}
		}
		map.put("result",result);
		return map;
		
	} 
	
	//修改食品种类信息（不含图片）
	@RequestMapping("/updatetype")
	public Object updateFoodType(@RequestBody FoodType ft) {
		Map<String,Object> map=new HashMap<>();
		Map<String,Object> result=new HashMap<>();
		FoodType target=fs.updateFoodType(ft);
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
			map.put("failMsg","食品种类id不存在");
		}
		map.put("result",result);
		return map;
	}
	
	//修改食品种类图片
	@RequestMapping("/modifytypepic")
	public Object modifyTypePic(@RequestParam("mf")MultipartFile mf,@RequestParam("ftid")int id) {
		String newPath=FileLoadUtils.upload(mf, "/foodtype");
		Map<String,Object> map=new HashMap<>(); 
		Map<String,Object> result=new HashMap<>(); 
		if(newPath==null) { 
			result.put("ulMsg", "上传失败"); 
			result.put("path","");
			map.put("success", false);
			map.put("code",0);
			map.put("failMsg","文件格式不正确");
		}else {
			FoodType ft=new FoodType();
			ft.setFtid(id);
			ft.setFtpic(newPath);
			FoodType target=fs.uploadFoodType(ft);
			if(target!=null) {
				result.put("ulMsg", "上传成功"); 
				result.put("path",newPath);
				map.put("success", true);
				map.put("code",1);
				map.put("failMsg","");
			}else {
				FileLoadUtils.removePic(newPath);
				result.put("ulMsg", "上传失败"); 
				result.put("path","");
				map.put("success", false);
				map.put("code",0);
				map.put("failMsg","食品种类id不存在");
			}
			
		}
		map.put("result",result);
		return map;
	}
	
	//添加食品
	@RequestMapping("/addfood")
	public Object addFood(@RequestParam("mf")MultipartFile mf,@RequestParam("foodname")String name,
			@RequestParam("price")double price,@RequestParam("ftid")int ftid,
			@RequestParam("desc")String desc) {
		Map<String, Object> map=new HashMap<>();
		Map<String,Object> result=new HashMap<>();
		String newPath=FileLoadUtils.upload(mf, "food");
		if(newPath==null) { 
			result.put("ulMsg", "添加失败"); 
			result.put("path","");
			map.put("success", false);
			map.put("code",0);
			map.put("failMsg","文件格式不正确");
		}else {
			Food food=new Food(name, ftid, newPath, price, desc);
			Food target=fs.add(food);
			if(target!=null) {
				result.put("ulMsg", "添加成功"); 
				result.put("item",target);
				map.put("success", true);
				map.put("code",1);
				map.put("failMsg","");
			}else {
				FileLoadUtils.removePic(newPath);
				result.put("ulMsg", "添加失败"); 
				result.put("item","");
				map.put("success", false);
				map.put("code",0);
				map.put("failMsg","食品名重复");
			}
		}
		map.put("result",result);
		return map;
	}
	
	//修改食品信息 不含图片
	@RequestMapping("/updatefood")
	public Object updateFood(@RequestBody Food food) {
		Map<String,Object> map=new HashMap<>();
		Map<String,Object> result=new HashMap<>();
		Food target=fs.updateFood(food);
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
			map.put("failMsg","食品id不存在");
		}
		map.put("result",result);
		return map;
	}
	
	//修改食品图片
	@RequestMapping("/modifyfoodpic")
	public Object modifyFoodPic(@RequestParam("mf")MultipartFile mf,@RequestParam("foodid")int id) {
		String newPath=FileLoadUtils.upload(mf, "/food");
		Map<String,Object> map=new HashMap<>(); 
		Map<String,Object> result=new HashMap<>(); 
		if(newPath==null) { 
			result.put("ulMsg", "上传失败"); 
			result.put("path","");
			map.put("success", false);
			map.put("code",0);
			map.put("failMsg","文件格式不正确");
		}else {
			Food food=new Food();
			food.setFoodid(id);
			food.setPic(newPath);
			Food target=fs.uploadFood(food);
			if(target!=null) {
				result.put("ulMsg", "上传成功"); 
				result.put("path",newPath);
				map.put("success", true);
				map.put("code",1);
				map.put("failMsg","");
			}else {
				FileLoadUtils.removePic(newPath);
				result.put("ulMsg", "上传失败"); 
				result.put("path","");
				map.put("success", false);
				map.put("code",0);
				map.put("failMsg","食品id不存在");
			}
			
		}
		map.put("result",result);
		return map;
	}
	
	//获取所有上架食品
	@RequestMapping("/getallonsale")
	public Object getAllOnSale() {
		Map<String, Object> map=new HashMap<>();
		Food food=new Food();
		food.setFoodstate(1);
		List<Food> list=fs.selectFoodByVar(food);
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
	
	//万能查询
	@RequestMapping("/varselect")
	public Object selectByVar(@RequestParam(value = "foodid" ,required=false)Integer id,
			@RequestParam(value = "foodname",required = false)String name,
			@RequestParam(value = "ftid",required = false)Integer ftid) {
		Map<String, Object> map=new HashMap<>();
		Food food=new Food();
		food.setFoodid(id);
		food.setFoodname(name);
		food.setFtid(ftid);
		List<Food> list=fs.selectFoodByVar(food);
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
	
}
