package com.neu.foodorder.entity;

/**
 * 会员实体类
 * @author 
 *
 */
public class Member {
	private Integer vipid;
	private Integer userid;//用户id
	private Integer viplev;
	private String regtime;//注册日期
	private String endtime;//到期日期
	public Integer getVipid() {
		return vipid;
	}
	public void setVipid(Integer vipid) {
		this.vipid = vipid;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getViplev() {
		return viplev;
	}
	public void setViplev(Integer viplev) {
		this.viplev = viplev;
	}
	public String getRegtime() {
		return regtime;
	}
	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	@Override
	public String toString() {
		return "Member [vipid=" + vipid + ", userid=" + userid + ", viplev=" + viplev + ", regtime=" + regtime
				+ ", endtime=" + endtime + "]";
	}
	public Member(Integer vipid, Integer userid, Integer viplev, String regtime, String endtime) {
		super();
		this.vipid = vipid;
		this.userid = userid;
		this.viplev = viplev;
		this.regtime = regtime;
		this.endtime = endtime;
	}
	public Member() {
		super();
	}
	public Member(Integer userid, Integer viplev, String regtime, String endtime) {
		super();
		this.userid = userid;
		this.viplev = viplev;
		this.regtime = regtime;
		this.endtime = endtime;
	}
	
}
