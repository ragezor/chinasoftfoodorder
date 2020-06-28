package com.neu.foodorder.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.neu.foodorder.entity.Shop;

/**
 * 店铺的Mapper层接口
 * @author 
 *
 */
@Mapper
public interface ShopMapper {
	//修改店铺信息 不含图标
	public int update(Shop shop);
	//查询店铺信息
	@Select("select * from shop where shopid=1")
	public Shop select();
}
