package com.neu.foodorder.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neu.foodorder.entity.Evaluate;
import com.neu.foodorder.mapper.EvaluateMapper;
import com.neu.foodorder.service.EvaluateService;
/**
 * 评价的业务层实现类
 * @author 
 *
 */
@Service
public class EvaluateServiceImpl implements EvaluateService {
	@Autowired
	private EvaluateMapper mapper;

	@Override
	public Evaluate addEvaluate(Evaluate evaluate) {//添加评价信息
		int i=mapper.addEvaluate(evaluate);
		return i!=0?mapper.getEvaluateById(evaluate.getEid()):null;
	}

	@Override
	public Evaluate updateEva(Evaluate evaluate) {//修改评价信息
		return mapper.updateEva(evaluate)==1?mapper.getEvaluateById(evaluate.getEid()):null;
	}

	@Override
	public boolean delEva(int id) {//删除评价信息
		return mapper.delEva(id)==1;
	}

	@Override
	public List<Evaluate> selectByVar(Evaluate e) {//万能查询
		return mapper.selectByVar(e);
	}
	
	
	
	
	
}
