package com.zzf.pojo;
/**
***********************************************
*
* @className:      Product.java
* @author:         M10F
* @date:           2019年3月22日--下午1:54:27
* @version:        v1.0
* @description:     产品：产品编号、名称、价格、剩余量
*
* *********************************************
*/
public class Product {
	@Override
	public String toString() {
		return pid+"\t"+pname+"\t"+price+"\t";
	}
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	private int pid;//产品编号
	private String pname;//名称
	private double price;//价格
	public Product(int pid, String pname, double price) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
	}
}
