package com.neu.foodorder.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.neu.foodorder.entity.FoodType;
import com.neu.foodorder.entity.Food;

@Service
public interface FoodService {

	public List<Food> getAll();//获取食品列表
	public List<FoodType> typesAll();//获取食品种类列表
	public Food add(Food food);//添加食品列表
	public FoodType addFoodType(FoodType ft);//添加食品种类
	public FoodType updateFoodType(FoodType ft);//修改食品种类
	public FoodType uploadFoodType(FoodType ft);//上传食品类别图片
	public Food updateFood(Food food);//修改食品信息
	public Food uploadFood(Food food);//上传食品图片
	public List<Food> selectFoodByVar(Food food);//根据传递的food对象传递，万能查询
}
