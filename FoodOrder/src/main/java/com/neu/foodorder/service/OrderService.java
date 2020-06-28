package com.neu.foodorder.service;

import java.util.List;

import com.neu.foodorder.entity.Order;

/**
 * 订单的业务层接口
 * @author 
 *
 */
public interface OrderService {
	public Order addOrder(Order order);//添加订单
	public Order updateOrder(Order order);//修改订单
	public List<Order> selectByVar(Order order);//万能查询 
}
