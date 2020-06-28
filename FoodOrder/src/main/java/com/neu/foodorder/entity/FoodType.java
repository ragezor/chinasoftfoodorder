package com.neu.foodorder.entity;

/**
 * 食品类型实体类
 * @author 
 *
 */
public class FoodType {
	
	public FoodType(String ftname, String ftpic, String ftdesc) {
		super();
		this.ftname = ftname;
		this.ftpic = ftpic;
		this.ftdesc = ftdesc;
	}
	private Integer ftid;//食品种类id
	private String ftname;
	private String ftpic;//食品种类图片url
	private String ftdesc;//食品种类描述
	public FoodType(Integer ftid, String ftname, String ftpic, String ftdesc) {
		super();
		this.ftid = ftid;
		this.ftname = ftname;
		this.ftpic = ftpic;
		this.ftdesc = ftdesc;
	}
	public FoodType() {
		super();
	}
	@Override
	public String toString() {
		return "FoodType [ftid=" + ftid + ", ftname=" + ftname + ", ftpic=" + ftpic + ", ftdesc=" + ftdesc + "]";
	}
	public Integer getFtid() {
		return ftid;
	}
	public void setFtid(Integer ftid) {
		this.ftid = ftid;
	}
	public String getFtname() {
		return ftname;
	}
	public void setFtname(String ftname) {
		this.ftname = ftname;
	}
	public String getFtpic() {
		return ftpic;
	}
	public void setFtpic(String ftpic) {
		this.ftpic = ftpic;
	}
	public String getFtdesc() {
		return ftdesc;
	}
	public void setFtdesc(String ftdesc) {
		this.ftdesc = ftdesc;
	}
	
	

}
