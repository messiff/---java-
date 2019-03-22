package com.zzf.pojo;
/**
***********************************************
*
* @className:      VIPcard.java
* @author:         M10F
* @date:           2019年3月22日--下午1:54:18
* @version:        v1.0
* @description:    会员卡：卡号、余额、积分、折扣百分比
*
* *********************************************
*/
public class VIPcard {
	@Override
	public String toString() {
		return "VIPcard [vid=" + vid + ", balance=" + balance + ", integral=" + integral + ", percent=" + percent + "]";
	}
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getIntegral() {
		return integral;
	}
	public void setIntegral(int integral) {
		this.integral = integral;
	}
	public double getPercent() {
		return percent;
	}
	public void setPercent(double percent) {
		this.percent = percent;
	}
	private int vid;//卡号
	private double balance;//余额
	private int  integral;// 积分
	private double percent;// 折扣百分比
	public VIPcard(int vid, double balance, int integral, double percent) {
		super();
		this.vid = vid;
		this.balance = balance;
		this.integral = integral;
		this.percent = percent;
	}
	
}
