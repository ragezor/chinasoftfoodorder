package com.neu.foodorder.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neu.foodorder.entity.Collect;
import com.neu.foodorder.mapper.CollectMapper;
import com.neu.foodorder.service.CollectService;

/**
 * 收藏的业务层实现类
 * @author 
 *
 */
@Service
public class CollectServiceImpl implements CollectService{
	@Autowired
	private CollectMapper mapper;

	@Override
	public int add(Collect c) {//添加收藏
		return mapper.addCollect(c);
	}

	@Override
	public int del(int id) {//删除收藏
		return mapper.del(id);
	}

	@Override
	public List<Collect> select(Collect c) {//查询用户收藏列表
		return mapper.select(c);
	}
	
	
	

}
