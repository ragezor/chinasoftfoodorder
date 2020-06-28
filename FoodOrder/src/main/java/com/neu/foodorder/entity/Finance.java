package com.neu.foodorder.entity;
/**
 * 财务信息实体类
 * @author 
 *
 */
public class Finance {
	private Integer finid;
	private String date;
	private Double totalprofit;//总收益
	private Integer newuser;//新用户数量
	private Integer newvip;//新会员数量
	private Integer ordernum;//订单数量
	private String dvalue;//差值
	public Finance(Integer finid, String date, Double totalprofit, Integer newuser, Integer newvip, Integer ordernum,
			String dvalue) {
		super();
		this.finid = finid;
		this.date = date;
		this.totalprofit = totalprofit;
		this.newuser = newuser;
		this.newvip = newvip;
		this.ordernum = ordernum;
		this.dvalue = dvalue;
	}
	public Finance() {
		super();
	}
	@Override
	public String toString() {
		return "Finance [finid=" + finid + ", date=" + date + ", totalprofit=" + totalprofit + ", newuser=" + newuser
				+ ", newvip=" + newvip + ", ordernum=" + ordernum + ", dvalue=" + dvalue + "]";
	}
	public Integer getFinid() {
		return finid;
	}
	public void setFinid(Integer finid) {
		this.finid = finid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Double getTotalprofit() {
		return totalprofit;
	}
	public void setTotalprofit(Double totalprofit) {
		this.totalprofit = totalprofit;
	}
	public Integer getNewuser() {
		return newuser;
	}
	public void setNewuser(Integer newuser) {
		this.newuser = newuser;
	}
	public Integer getNewvip() {
		return newvip;
	}
	public void setNewvip(Integer newvip) {
		this.newvip = newvip;
	}
	public Integer getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(Integer ordernum) {
		this.ordernum = ordernum;
	}
	public String getDvalue() {
		return dvalue;
	}
	public void setDvalue(String dvalue) {
		this.dvalue = dvalue;
	}
	
	
}
