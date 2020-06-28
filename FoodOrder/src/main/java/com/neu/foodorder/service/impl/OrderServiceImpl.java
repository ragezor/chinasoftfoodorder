package com.neu.foodorder.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neu.foodorder.entity.Order;
import com.neu.foodorder.entity.OrderItem;
import com.neu.foodorder.mapper.OrderMapper;
import com.neu.foodorder.service.OrderService;

/**
 * 订单的业务层实现类
 * @author 
 *
 */
@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderMapper mapper;

	@Override
	public Order addOrder(Order order) {//添加订单
		int i=mapper.addOrder(order);
		if(i!=1)return null;//添加失败
		List<OrderItem> items=order.getItems();
		for(OrderItem item:items) {
			item.setOrderid(order.getOrderid());//加入订单号
			mapper.addOrderItem(item);//添加订单明细
		}
		Order target=mapper.selectOrderById(order.getOrderid());
		target.setItems(mapper.selectItemsByOrderId(order.getOrderid()));
		return target;
	}

	@Override
	public Order updateOrder(Order order) {//修改订单
		return mapper.updateOrder(order)>0?mapper.selectOrderById(order.getOrderid()):null;
	}

	@Override
	public List<Order> selectByVar(Order order) {//查询订单 万能查询+模糊查询
		return mapper.selectAll(order);
	}
	
	
	

}
