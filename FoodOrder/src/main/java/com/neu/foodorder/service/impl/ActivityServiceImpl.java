package com.neu.foodorder.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neu.foodorder.entity.Activity;

import com.neu.foodorder.mapper.ActivityMapper;
import com.neu.foodorder.service.ActivityService;

/**
 * 活动的业务层实现类
 * @author 
 *
 */
@Service
public class ActivityServiceImpl implements ActivityService{
	@Autowired
	private ActivityMapper mapper;

	@Override
	public Activity update(Activity activity) {//修改食品种类信息
		int i=mapper.update(activity);
		return i==1?mapper.selectActivityById(activity.getAcid()):null;
	}

}
