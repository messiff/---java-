package com.zzf.service;

import java.util.List;

import com.zzf.pojo.Integration;

/**
***********************************************
*
* @className:      Change.java
* @author:         M10F
* @date:           2019年3月22日--下午2:19:35
* @version:        v1.0
* @description:    积分兑换操作
*
* *********************************************
*/
public interface Change {
	public void show();//功能实现
	public void list();//列表显示
	public void change(List<Integration> list);//数据处理
}
