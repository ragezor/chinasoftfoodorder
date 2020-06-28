package com.neu.foodorder.entity;

/**
 * vip类别实体类
 * @author 
 *
 */
public class VIPType {
	private Integer vipid;
	private Integer viplev;//会员级别
	private String vipname;//会员名称
	private String vipdesc;//会员信息描述
	private Double vipprice;
	public Integer getVipid() {
		return vipid;
	}
	public void setVipid(Integer vipid) {
		this.vipid = vipid;
	}
	public Integer getViplev() {
		return viplev;
	}
	public void setViplev(Integer viplev) {
		this.viplev = viplev;
	}
	public String getVipname() {
		return vipname;
	}
	public void setVipname(String vipname) {
		this.vipname = vipname;
	}
	public String getVipdesc() {
		return vipdesc;
	}
	public void setVipdesc(String vipdesc) {
		this.vipdesc = vipdesc;
	}
	public Double getVipprice() {
		return vipprice;
	}
	public void setVipprice(Double vipprice) {
		this.vipprice = vipprice;
	}
	@Override
	public String toString() {
		return "VIPType [vipid=" + vipid + ", viplev=" + viplev + ", vipname=" + vipname + ", vipdesc=" + vipdesc
				+ ", vipprice=" + vipprice + "]";
	}
	public VIPType(Integer vipid, Integer viplev, String vipname, String vipdesc, Double vipprice) {
		super();
		this.vipid = vipid;
		this.viplev = viplev;
		this.vipname = vipname;
		this.vipdesc = vipdesc;
		this.vipprice = vipprice;
	}
	public VIPType() {
		super();
	}//会员价格
}
