package com.neu.foodorder.entity;

public class Activity {
	
	private Integer acid;
	private String acname;
	private Integer actype;//活动类型  1-满减活动  2-折扣活动
	private String acdesc;//活动描述
	private Integer aclev;//参加活动的用户vip等级
	private Double count;//参加活动的消费金额
	private Double reduce;//减免金额
	private Double discount;//折扣  范围是0-1 作为系数
	private String acstart;//活动开始时间
	private String acend;//活动结束时间
	public Activity(Integer acid, String acname, Integer actype, String acdesc, Integer aclev, Double count,
			Double reduce, Double discount, String acstart, String acend) {
		super();
		this.acid = acid;
		this.acname = acname;
		this.actype = actype;
		this.acdesc = acdesc;
		this.aclev = aclev;
		this.count = count;
		this.reduce = reduce;
		this.discount = discount;
		this.acstart = acstart;
		this.acend = acend;
	}
	public Activity() {
		super();
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
	public Integer getActype() {
		return actype;
	}
	public void setActype(Integer actype) {
		this.actype = actype;
	}
	public String getAcdesc() {
		return acdesc;
	}
	public void setAcdesc(String acdesc) {
		this.acdesc = acdesc;
	}
	public Integer getAclev() {
		return aclev;
	}
	public void setAclev(Integer aclev) {
		this.aclev = aclev;
	}
	public Double getCount() {
		return count;
	}
	public void setCount(Double count) {
		this.count = count;
	}
	public Double getReduce() {
		return reduce;
	}
	public void setReduce(Double reduce) {
		this.reduce = reduce;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
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
	@Override
	public String toString() {
		return "Activity [acid=" + acid + ", acname=" + acname + ", actype=" + actype + ", acdesc=" + acdesc
				+ ", aclev=" + aclev + ", count=" + count + ", reduce=" + reduce + ", discount=" + discount
				+ ", acstart=" + acstart + ", acend=" + acend + "]";
	}
	
	
	
}
