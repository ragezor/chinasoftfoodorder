package com.neu.foodorder.entity;
/**
 * 食品实体类
 * @author 
 *
 */
public class Food {
		private Integer foodid;
		private String foodname;
		private Integer ftid;//食品种类id
		private String pic;
		private double price;
		private String desc;
		private String regtime;//食品注册时间
		private Integer foodstate;//食品状态 0-已注册 1-已上架 2-已下架
		public Food(String foodname, Integer ftid, String pic, double price, String desc) {
			super();
			this.foodname = foodname;
			this.ftid = ftid;
			this.pic = pic;
			this.price = price;
			this.desc = desc;
		}
		public Food(String foodname, Integer ftid, double price, String desc) {
			super();
			this.foodname = foodname;
			this.ftid = ftid;
			this.price = price;
			this.desc = desc;

		}
		public Food(Integer foodid, String foodname, Integer ftid, String pic, double price, String desc,
				String regtime, Integer foodstate) {
			super();
			this.foodid = foodid;
			this.foodname = foodname;
			this.ftid = ftid;
			this.pic = pic;
			this.price = price;
			this.desc = desc;
			this.regtime = regtime;
			this.foodstate = foodstate;
		}
		public Food() {
			super();
		}
		public Integer getFoodid() {
			return foodid;
		}
		public void setFoodid(Integer foodid) {
			this.foodid = foodid;
		}
		public String getFoodname() {
			return foodname;
		}
		public void setFoodname(String foodname) {
			this.foodname = foodname;
		}
		public Integer getFtid() {
			return ftid;
		}
		public void setFtid(Integer ftid) {
			this.ftid = ftid;
		}
		public String getPic() {
			return pic;
		}
		public void setPic(String pic) {
			this.pic = pic;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
		public String getRegtime() {
			return regtime;
		}
		public void setRegtime(String regtime) {
			this.regtime = regtime;
		}
		public Integer getFoodstate() {
			return foodstate;
		}
		public void setFoodstate(Integer foodstate) {
			this.foodstate = foodstate;
		}
		@Override
		public String toString() {
			return "Food [foodid=" + foodid + ", foodname=" + foodname + ", ftid=" + ftid + ", pic=" + pic + ", price="
					+ price + ", desc=" + desc + ", regtime=" + regtime + ", foodstate=" + foodstate + "]";
		}


}
