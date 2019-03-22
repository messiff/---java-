package com.zzf.pojo;
/**
***********************************************
*
* @className:      Integration.java
* @author:         M10F
* @date:           2019年3月22日--下午1:54:58
* @version:        v1.0
* @description:     积分小礼品：礼品编号、名称、所需积分数
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
	private int gid;//礼品编号
	private String gname;//名称
	private int gnum;//所需积分数
	public Integration(int gid, String gname, int gnum) {
		super();
		this.gid = gid;
		this.gname = gname;
		this.gnum = gnum;
	}
	
	
}
