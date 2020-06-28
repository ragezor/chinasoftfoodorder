package com.neu.foodorder.entity;
/**
 * 订单明细实体类
 * @author
 *
 */
public class OrderItem {
	private Integer itemid;
	private Integer orderid;
	private Integer foodid;
	private Integer foodnum;
	public OrderItem(Integer itemid, Integer orderid, Integer foodid, Integer foodnum) {
		super();
		this.itemid = itemid;
		this.orderid = orderid;
		this.foodid = foodid;
		this.foodnum = foodnum;
	}
	public OrderItem() {
		super();
	}
	public Integer getItemid() {
		return itemid;
	}
	public void setItemid(Integer itemid) {
		this.itemid = itemid;
	}
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public Integer getFoodid() {
		return foodid;
	}
	public void setFoodid(Integer foodid) {
		this.foodid = foodid;
	}
	public Integer getFoodnum() {
		return foodnum;
	}
	public void setFoodnum(Integer foodnum) {
		this.foodnum = foodnum;
	}
	@Override
	public String toString() {
		return "OrderItem [itemid=" + itemid + ", orderid=" + orderid + ", foodid=" + foodid + ", foodnum=" + foodnum
				+ "]";
	}
	

}
