package com.neu.foodorder.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.neu.foodorder.entity.Evaluate;
/**
 * 评价的mapper层接口
 * @author
 *
 */
@Mapper
public interface EvaluateMapper {
	//添加评价
	public int addEvaluate(Evaluate evaluate);
	//根据评价id查找评价信息
	@Select("select * from evaluate where eid=#{id}")
	public Evaluate getEvaluateById(int id);
	//修改评价信息
	public int updateEva(Evaluate e);
	//删除评价信息
	@Delete("delete from evaluate where eid=#{id}")
	public int delEva(int id);
	//查找评价信息 万能查询
	public List<Evaluate> selectByVar(Evaluate e);
}
