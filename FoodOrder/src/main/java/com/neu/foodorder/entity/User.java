package com.neu.foodorder.entity;

public class User {
	private Integer userid;
	private String username;
	private String password;
	private String nickname;
	private String phonenum;
	private String address;
	private Integer usertype;
	private Integer vipid;
	private String regtime;
	private String pic;
	private Member member;
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getUsertype() {
		return usertype;
	}
	public void setUsertype(Integer usertype) {
		this.usertype = usertype;
	}
	public Integer getVipid() {
		return vipid;
	}
	public void setVipid(Integer vipid) {
		this.vipid = vipid;
	}
	public String getRegtime() {
		return regtime;
	}
	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", password=" + password + ", nickname=" + nickname
				+ ", phonenum=" + phonenum + ", address=" + address + ", usertype=" + usertype + ", vipid=" + vipid
				+ ", regtime=" + regtime + ", pic=" + pic + ", member=" + member + "]";
	}
	public User(Integer userid, String username, String password, String nickname, String phonenum, String address,
			Integer usertype, Integer vipid, String regtime, String pic, Member member) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.phonenum = phonenum;
		this.address = address;
		this.usertype = usertype;
		this.vipid = vipid;
		this.regtime = regtime;
		this.pic = pic;
		this.member = member;
	}
	public User() {
		super();
	}
	
	
}
	
