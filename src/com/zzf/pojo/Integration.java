package com.zzf.pojo;
/**
***********************************************
*
* @className:      Integration.java
* @author:         M10F
* @date:           2019��3��22��--����1:54:58
* @version:        v1.0
* @description:     ����С��Ʒ����Ʒ��š����ơ����������
*
* *********************************************
*/
public class Integration {
	@Override
	public String toString() {
		
		return gid+"\t"+gname+"\t"+gnum;
	}
	
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public int getGnum() {
		return gnum;
	}
	public void setGnum(int gnum) {
		this.gnum = gnum;
	}
	private int gid;//��Ʒ���
	private String gname;//����
	private int gnum;//���������
	public Integration(int gid, String gname, int gnum) {
		super();
		this.gid = gid;
		this.gname = gname;
		this.gnum = gnum;
	}
	
	
}
