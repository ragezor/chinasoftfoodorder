package com.neu.foodorder.entity;

import java.util.List;

/**
 * 订单实体类
 * @author 
 *
 */
public class Order {
	private Integer orderid;
	private Integer userid;
	private String ordertime;
	private String orderaddress;
	private String phone;
	private double orderprice;
	private String remark;//备注
	private Integer orderstate;//订单状态 0-已下单 1-已接单 2-已完成 3-已取消
	private Integer ordereval;//订单评价 评价等级为1-5星
	private List<OrderItem> items;//订单明细
	public List<OrderItem> getItems() {
		return items;
	}
	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
	public Order(Integer orderid, Integer userid, String ordertime, Integer orderstate, Integer ordereval) {
		super();
		this.orderid = orderid;
		this.userid = userid;
		this.ordertime = ordertime;
		this.orderstate = orderstate;
		this.ordereval = ordereval;
	}
	public Order(Integer orderid, Integer userid, String ordertime, String orderaddress, String phone,
			double orderprice, String remark, Integer orderstate, Integer ordereval) {
		super();
		this.orderid = orderid;
		this.userid = userid;
		this.ordertime = ordertime;
		this.orderaddress = orderaddress;
		this.phone = phone;
		this.orderprice = orderprice;
		this.remark = remark;
		this.orderstate = orderstate;
		this.ordereval = ordereval;
	}
	public Order() {
		super();
	}
	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", userid=" + userid + ", ordertime=" + ordertime + ", orderaddress="
				+ orderaddress + ", phone=" + phone + ", orderprice=" + orderprice + ", remark=" + remark
				+ ", orderstate=" + orderstate + ", ordereval=" + ordereval + ", items=" + items + "]";
	}
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}
	public String getOrderaddress() {
		return orderaddress;
	}
	public void setOrderaddress(String orderaddress) {
		this.orderaddress = orderaddress;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public double getOrderprice() {
		return orderprice;
	}
	public void setOrderprice(double orderprice) {
		this.orderprice = orderprice;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getOrderstate() {
		return orderstate;
	}
	public void setOrderstate(Integer orderstate) {
		this.orderstate = orderstate;
	}
	public Integer getOrdereval() {
		return ordereval;
	}
	public void setOrdereval(Integer ordereval) {
		this.ordereval = ordereval;
	}
	
	

}
