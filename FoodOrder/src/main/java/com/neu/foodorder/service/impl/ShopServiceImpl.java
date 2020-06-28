package com.neu.foodorder.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neu.foodorder.entity.Shop;
import com.neu.foodorder.mapper.ShopMapper;
import com.neu.foodorder.service.ShopService;
import com.neu.foodorder.utils.FileLoadUtils;

/**
 * 店铺的业务层实现类
 * @author 
 *
 */
@Service
public class ShopServiceImpl implements ShopService{
	@Autowired
	private ShopMapper mapper;

	@Override
	public Shop update(Shop shop) {//更新店铺信息
		return mapper.update(shop)==1?mapper.select():null;
	}

	@Override
	public Shop upload(Shop shop) {//上传店铺logo
		String oldPath=mapper.select().getLogo();
		int i=mapper.update(shop);
		if(i>0) {
			FileLoadUtils.removePic(oldPath);
			return mapper.select();
		}else {
			return null;
		}
	}

	@Override
	public Shop select() {//查询店铺信息
		return mapper.select();
	}
	
	
	
	
	
}
