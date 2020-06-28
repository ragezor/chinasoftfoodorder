package com.neu.foodorder.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neu.foodorder.entity.Food;
import com.neu.foodorder.entity.FoodType;
import com.neu.foodorder.mapper.FoodMapper;
import com.neu.foodorder.service.FoodService;
import com.neu.foodorder.utils.FileLoadUtils;

@Service
public class FoodServiceImpl implements FoodService{
	

	@Autowired
	private FoodMapper mapper;
	

	@Override
	public FoodType addFoodType(FoodType ft) {//添加食品种类
		if(mapper.selectTypeByName(ft.getFtname())!=null)return null;//已存在同名食品种类
		int i=mapper.addFoodType(ft);
		return i==1?mapper.selectTypeByName(ft.getFtname()):null;
	}

	@Override
	public FoodType updateFoodType(FoodType ft) {//修改食品种类信息
		int i=mapper.updateFoodType(ft);
		return i==1?mapper.selectTypeById(ft.getFtid()):null;
	}

	@Override
	public FoodType uploadFoodType(FoodType ft) {//上传食品种类图片
		String oldPath=mapper.selectTypeById(ft.getFtid()).getFtpic();
		int i=mapper.updateFoodType(ft);
		if(i>0) {
			FileLoadUtils.removePic(oldPath);
			return mapper.selectTypeById(ft.getFtid());
		}else {
			return null;
		}
		
	}

	@Override
	public Food uploadFood(Food food) {//上传食品图片
		String oldPath=mapper.selectFoodById(food.getFoodid()).getPic();
		int i=mapper.updateFood(food);
		if(i>0) {
			FileLoadUtils.removePic(oldPath);
			return mapper.selectFoodById(food.getFoodid());
		}
		return null;
	}

	@Override
	public List<Food> selectFoodByVar(Food food) {//万能查询+模糊查询 查询食品列表
		return mapper.selectFoodVar(food);
	}

	@Override
	public List<Food> getAll() {
		return mapper.getAll();
	}
	
	@Override
	public List<FoodType> typesAll() {
		return mapper.typesAll();
	}
	
	@Override
	public Food add(Food food) {//添加食品
		Food foodWithName=mapper.findFoodByName(food.getFoodname());
		if(foodWithName!=null)return null;
		return mapper.add(food)==1?mapper.findFoodByName(food.getFoodname()):null;
	}

	@Override
	public Food updateFood(Food food) {//修改食品信息
		return mapper.updateFood(food)==1?mapper.selectFoodById(food.getFoodid()):null;
	}
}
