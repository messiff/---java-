package com.zzf.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.zzf.pojo.VIPcard;

/**
***********************************************
*
* @className:      VipImpl.java
* @author:         M10F
* @date:           2019��3��22��--����4:36:43
* @version:        v1.0
* @description:    VIP�б�  ��Ա�������š������֡��ۿ۰ٷֱ�
*
* *********************************************
*/
public class VipImpl {
	public void show() {
		list();
	}
	public List<VIPcard> list() {
		List<VIPcard> list=new ArrayList<VIPcard>();
		list.add(new VIPcard(1, 2467, 2383, 0.8));
		list.add(new VIPcard(2, 3254, 1000, 0.95));
		list.add(new VIPcard(3, 3213, 3453, 0.85));
		list.add(new VIPcard(4, 1321, 4324, 0.7));
		return list;
	}
}
