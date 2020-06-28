package com.neu.foodorder.service;
/**
 * Mapper的Service层接口
 * @author 
 *
 */

import java.util.List;

import com.neu.foodorder.entity.Evaluate;

public interface EvaluateService {
	public Evaluate addEvaluate(Evaluate evaluate);//添加评价信息
	public Evaluate updateEva(Evaluate evaluate);//修改评价信息
	public boolean delEva(int id);//删除评价信息
	public List<Evaluate> selectByVar(Evaluate e);//万能查询
}
