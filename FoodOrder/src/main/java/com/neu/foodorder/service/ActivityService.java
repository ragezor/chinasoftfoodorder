package com.neu.foodorder.service;

import com.neu.foodorder.entity.Activity;
import org.springframework.stereotype.Service;

/**
 * 活动的业务层接口
 * @author 
 *
 */
@Service
public interface ActivityService {
	public Activity update(Activity activity);//修改食品种类
}
