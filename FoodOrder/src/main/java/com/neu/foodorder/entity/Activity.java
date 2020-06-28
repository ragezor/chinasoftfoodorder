package com.neu.foodorder.entity;

public class Activity {
	
	private Integer acid;
	private String acname;
	private String acdesc;//活动描述
	private int aclev;//参加活动的用户vip等级
	private String acstart;//活动开始时间
	private String acend;//活动结束时间
	public Activity(Integer acid, String acname, String acdesc, int aclev, String acstart, String acend) {
		super();
		this.acid = acid;
		this.acname = acname;
		this.acdesc = acdesc;
		this.aclev = aclev;
		this.acstart = acstart;
		this.acend = acend;
	}
	public Activity() {
		super();
	}
	@Override
	public String toString() {
		return "Activity [acid=" + acid + ", acname=" + acname + ", acdesc=" + acdesc + ", aclev=" + aclev
				+ ", acstart=" + acstart + ", acend=" + acend + "]";
	}
	public Integer getAcid() {
		return acid;
	}
	public void setAcid(Integer acid) {
		this.acid = acid;
	}
	public String getAcname() {
		return acname;
	}
	public void setAcname(String acname) {
		this.acname = acname;
	}
	public String getAcdesc() {
		return acdesc;
	}
	public void setAcdesc(String acdesc) {
		this.acdesc = acdesc;
	}
	public int getAclev() {
		return aclev;
	}
	public void setAclev(int aclev) {
		this.aclev = aclev;
	}
	public String getAcstart() {
		return acstart;
	}
	public void setAcstart(String acstart) {
		this.acstart = acstart;
	}
	public String getAcend() {
		return acend;
	}
	public void setAcend(String acend) {
		this.acend = acend;
	}
	

}
