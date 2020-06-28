package com.neu.foodorder.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.neu.foodorder.entity.Collect;

/**
 * 收藏的mapper层接口
 * @author 
 *
 */
@Mapper
public interface CollectMapper {
	//添加收藏
	@Insert("insert into collection values(null,#{userid},#{foodid},now())")
	public int addCollect(Collect c);
	//删除收藏
	@Delete("delete from collection where cid=#{val}")
	public int del(int id);
	//查找收藏 万能查询+模糊查询
	public List<Collect> select(Collect collect);
}
