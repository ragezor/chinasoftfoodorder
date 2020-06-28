package com.neu.foodorder.service;

import java.util.List;

import com.neu.foodorder.entity.Collect;

/**
 * 收藏的业务层接口
 * @author
 *
 */
public interface CollectService {
	public int add(Collect c);//添加收藏
	public int del(int id);//删除收藏
	public List<Collect> select(Collect c);//查询收藏
}
