package com.zzf.service;

import java.util.Map;

import com.zzf.pojo.Product;

/**
***********************************************
*
* @className:      Shooping.java
* @author:         M10F
* @date:           2019��3��22��--����2:19:16
* @version:        v1.0
* @description:    �������
*
* *********************************************
*/
public interface Shooping {
	public void show();//������ʾ
	public void list();//	�б���ʾ
	public void opera(Map<Product, Integer> map);//	���ݲ���
}
