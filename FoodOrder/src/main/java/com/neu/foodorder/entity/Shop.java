 package com.neu.foodorder.entity;

/**
 * 店铺实体类
 * @author
 *
 */
public class Shop {
	private Integer shopid;
	private String shopname;
	private String regtime;//店铺注册时间
	private String starttime;//店铺开始营业时间
	private String endtime;//店铺打烊时间
	private String address;
	private String phonenumber;
	private String shopdesc;//店铺信息描述
	private String logo;//店铺Logo图片地址
	public Shop(Integer shopid, String shopname, String regtime, String starttime, String endtime, String address,
			String phonenumber, String shopdesc, String logo) {
		super();
		this.shopid = shopid;
		this.shopname = shopname;
		this.regtime = regtime;
		this.starttime = starttime;
		this.endtime = endtime;
		this.address = address;
		this.phonenumber = phonenumber;
		this.shopdesc = shopdesc;
		this.logo = logo;
	}
	public Shop() {
		super();
	}
	public Integer getShopid() {
		return shopid;
	}
	public void setShopid(Integer shopid) {
		this.shopid = shopid;
	}
	public String getShopname() {
		return shopname;
	}
	public void setShopname(String shopname) {
		this.shopname = shopname;
	}
	public String getRegtime() {
		return regtime;
	}
	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getShopdesc() {
		return shopdesc;
	}
	public void setShopdesc(String shopdesc) {
		this.shopdesc = shopdesc;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	@Override
	public String toString() {
		return "Shop [shopid=" + shopid + ", shopname=" + shopname + ", regtime=" + regtime + ", starttime=" + starttime
				+ ", endtime=" + endtime + ", address=" + address + ", phonenumber=" + phonenumber + ", shopdesc="
				+ shopdesc + ", logo=" + logo + "]";
	}
	
	
}
