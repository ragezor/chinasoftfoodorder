package com.neu.foodorder.service;
/**
 * 店铺的业务层接口
 * @author 
 *
 */

import com.neu.foodorder.entity.Shop;

public interface ShopService {
	public Shop update(Shop shop);//修改店铺信息
	public Shop upload(Shop shop);//上传店铺logo
	public Shop select();//查询店铺信息
}
