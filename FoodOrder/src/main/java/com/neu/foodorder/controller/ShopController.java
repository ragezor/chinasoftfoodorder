package com.neu.foodorder.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.neu.foodorder.entity.FoodType;
import com.neu.foodorder.entity.Shop;
import com.neu.foodorder.service.ShopService;
import com.neu.foodorder.utils.FileLoadUtils;

/**
 * 店铺的控制层
 * @author 
 *
 */
@RequestMapping("/shop")
@RestController
public class ShopController {
	
	@Autowired
	private ShopService ss;
	
	//修改店铺信息 不含图片
	@RequestMapping("/update")
	public Object update(@RequestBody Shop shop) {
		Map<String,Object> map=new HashMap<>();
		Map<String,Object> result=new HashMap<>();
		Shop target=ss.update(shop);
		//System.out.println(shop);
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
			map.put("failMsg","修改店铺信息失败");
		}
		map.put("result",result);
		return map;
	}
	
	//修改店铺logo
	@RequestMapping("/logo")
	public Object logo(@RequestParam("mf")MultipartFile mf) {
		String newPath=FileLoadUtils.upload(mf, "/shop");
		Map<String,Object> map=new HashMap<>(); 
		Map<String,Object> result=new HashMap<>(); 
		if(newPath==null) { 
			result.put("ulMsg", "上传失败"); 
			result.put("path","");
			map.put("success", false);
			map.put("code",0);
			map.put("failMsg","文件格式不正确");
		}else {
			Shop shop=new Shop();
			shop.setLogo(newPath);
			Shop target=ss.upload(shop);
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
				map.put("failMsg","上传Logo失败");
			}
			
		}
		map.put("result",result);
		return map;
	}
	
	//查询店铺信息
	@RequestMapping("/select")
	public Object select() {
		Map<String,Object> map=new HashMap<>(); 
		Map<String,Object> result=new HashMap<>(); 
		Shop target=ss.select();
		if(target!=null) {
			result.put("Msg", "查询成功"); 
			result.put("target",target);
			map.put("success", true);
			map.put("code",1);
			map.put("failMsg","");
		}else {
			result.put("Msg", "查询失败"); 
			result.put("target","");
			map.put("success", false);
			map.put("code",0);
			map.put("failMsg","店铺不存在");
		}
		map.put("result",result);
		return map;
	}
}
