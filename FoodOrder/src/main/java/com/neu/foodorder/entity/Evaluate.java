package com.neu.foodorder.entity;

/**
 * 评价实体类
 * @author 
 *
 */
public class Evaluate {
	
	private Integer eid;
	private Integer foodid;
	private Integer userid;
	private String edesc;//评价描述
	private Integer elev;//评价等级 1-5
	private String etime;//评价时间
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public Integer getFoodid() {
		return foodid;
	}
	public void setFoodid(Integer foodid) {
		this.foodid = foodid;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getEdesc() {
		return edesc;
	}
	public void setEdesc(String edesc) {
		this.edesc = edesc;
	}
	public Integer getElev() {
		return elev;
	}
	public void setElev(Integer elev) {
		this.elev = elev;
	}
	public String getEtime() {
		return etime;
	}
	public void setEtime(String etime) {
		this.etime = etime;
	}
	@Override
	public String toString() {
		return "Evaluate [eid=" + eid + ", foodid=" + foodid + ", userid=" + userid + ", edesc=" + edesc + ", elev="
				+ elev + ", etime=" + etime + "]";
	}
	public Evaluate() {
		super();
	}
	public Evaluate(Integer eid, Integer foodid, Integer userid, String edesc, Integer elev, String etime) {
		super();
		this.eid = eid;
		this.foodid = foodid;
		this.userid = userid;
		this.edesc = edesc;
		this.elev = elev;
		this.etime = etime;
	}
	

}
