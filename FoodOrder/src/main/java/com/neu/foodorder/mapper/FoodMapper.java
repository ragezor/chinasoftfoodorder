package com.neu.foodorder.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.neu.foodorder.entity.Food;
import com.neu.foodorder.entity.FoodType;
/**
 * 食品的Mapper层接口
 * @author 
 *
 */
@Mapper
public interface FoodMapper {

	//查找所有食品
	@Select("select * from food")
	public List<Food> getAll();
	//查找所有食品种类
	@Select("select * from foodtype")
	public List<FoodType> typesAll();
	//添加食品种类
	@Insert("insert into foodtype values(null,#{ftname},#{ftpic},#{ftdesc})")
	public int addFoodType(FoodType ft);
	//添加食品
	public int add(Food food);
	//根据食品名查找食品
	@Select("select * from food where foodname=#{foodname}")
	public Food findFoodByName(String foodname);
	//根据食品种类名称查找种类信息
	@Select("select * from foodtype where ftname=#{name}")
	public FoodType selectTypeByName(String name);
	//修改食品种类信息
	public int updateFoodType(FoodType ft);
	//根据食品种类id查找种类信息
	@Select("select * from foodtype where ftid=#{id}")
	public FoodType selectTypeById(int id);
	//修改食品信息
	public int updateFood(Food food);
	//根据食品id查找食品信息
	@Select("select * from food where foodid=#{val}")
	public Food selectFoodById(int id);
	//根据对象进行查询 只查找对象中含有的属性
	public List<Food> selectFoodVar(Food food);
}
