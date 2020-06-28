package com.neu.foodorder.entity;

/**
 * 收藏实体类
 * @author 
 *
 */
public class Collect {
	
	private Integer cid;
	private Integer userid;
	private Integer foodid;
	private String ctime;//收藏时间
	public Collect(Integer cid, Integer userid, Integer foodid, String ctime) {
		super();
		this.cid = cid;
		this.userid = userid;
		this.foodid = foodid;
		this.ctime = ctime;
	}
	public Collect() {
		super();
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getFoodid() {
		return foodid;
	}
	public void setFoodid(Integer foodid) {
		this.foodid = foodid;
	}
	public String getCtime() {
		return ctime;
	}
	public void setCtime(String ctime) {
		this.ctime = ctime;
	}
	@Override
	public String toString() {
		return "Collect [cid=" + cid + ", userid=" + userid + ", foodid=" + foodid + ", ctime=" + ctime + "]";
	}
	
	

}
