package com.zzf.pojo;
/**
***********************************************
*
* @className:      VIPcard.java
* @author:         M10F
* @date:           2019��3��22��--����1:54:18
* @version:        v1.0
* @description:    ��Ա�������š������֡��ۿ۰ٷֱ�
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
	private int vid;//����
	private double balance;//���
	private int  integral;// ����
	private double percent;// �ۿ۰ٷֱ�
	public VIPcard(int vid, double balance, int integral, double percent) {
		super();
		this.vid = vid;
		this.balance = balance;
		this.integral = integral;
		this.percent = percent;
	}
	
}
