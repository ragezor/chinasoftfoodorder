package com.neu.foodorder.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.neu.foodorder.entity.Activity;



/**
 * 活动的Mapper层接口
 * @author 
 *
 */
@Mapper
public interface ActivityMapper {
	//根据活动id查找活动信息
	@Select("select * from activity where acid=#{acid}")
	public Activity selectActivityById(int acid);
	//修改活动信息
		public int update(Activity activity);
}
