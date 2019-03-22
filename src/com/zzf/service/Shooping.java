package com.zzf.service;

import java.util.Map;

import com.zzf.pojo.Product;

/**
***********************************************
*
* @className:      Shooping.java
* @author:         M10F
* @date:           2019年3月22日--下午2:19:16
* @version:        v1.0
* @description:    购物操作
*
* *********************************************
*/
public interface Shooping {
	public void show();//功能显示
	public void list();//	列表显示
	public void opera(Map<Product, Integer> map);//	数据操作
}
