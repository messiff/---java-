package com.zzf.pojo;
/**
***********************************************
*
* @className:      Product.java
* @author:         M10F
* @date:           2019��3��22��--����1:54:27
* @version:        v1.0
* @description:     ��Ʒ����Ʒ��š����ơ��۸�ʣ����
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

	private int pid;//��Ʒ���
	private String pname;//����
	private double price;//�۸�
	public Product(int pid, String pname, double price) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
	}
}
