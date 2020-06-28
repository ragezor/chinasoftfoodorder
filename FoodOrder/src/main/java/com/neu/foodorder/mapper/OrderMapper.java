package com.neu.foodorder.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.neu.foodorder.entity.Order;
import com.neu.foodorder.entity.OrderItem;

/**
 * 订单的Mapper层接口
 * @author 
 *
 */
@Mapper
public interface OrderMapper {
	//添加订单信息
	//@Insert("insert into order values(null,#{userid},now(),#{orderaddress},#{phone},#{orderprice},#{remark,0,0})")
	public int addOrder(Order order);
	//添加订单明细信息
	public int addOrderItem(OrderItem oi);
	//根据订单号查找订单
	@Select("select * from `order` where orderid=#{id}")
	public Order selectOrderById(int id);
	//根据订单号查找所有订单明细
	@Select("select * from orderitem where orderid=#{id}")
	public List<OrderItem> selectItemsByOrderId(int id);
	//根据订单号修改订单信息 不含订单明细
	public int updateOrder(Order order);
	//查询所有订单 万能查询+模糊查询
	public List<Order> selectAll(Order order);
}
