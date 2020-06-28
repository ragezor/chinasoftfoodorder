package com.neu.foodorder.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neu.foodorder.entity.Activity;
import com.neu.foodorder.service.ActivityService;
import com.neu.foodorder.service.FoodService;

/**
 * 活动的控制层
 * @author
 *
 */
@RestController
@RequestMapping("/activity")
public class ActivityController {
	@Autowired
	private ActivityService as;
	//修改活动种类信息
		@RequestMapping("/update")
		public Object update(@RequestBody Activity activity) {
			Map<String,Object> map=new HashMap<>();
			Map<String,Object> result=new HashMap<>();
			Activity target=as.update(activity);
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
				map.put("failMsg","活动id不存在");
			}
			map.put("result",result);
			return map;
		}
}
