package com.zzf.service;

import java.util.List;

import com.zzf.pojo.Integration;

/**
***********************************************
*
* @className:      Change.java
* @author:         M10F
* @date:           2019��3��22��--����2:19:35
* @version:        v1.0
* @description:    ���ֶһ�����
*
* *********************************************
*/
public interface Change {
	public void show();//����ʵ��
	public void list();//�б���ʾ
	public void change(List<Integration> list);//���ݴ���
}
