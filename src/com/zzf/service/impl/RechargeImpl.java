package com.zzf.service.impl;

import java.util.List;
import java.util.Scanner;

import com.zzf.pojo.VIPcard;
import com.zzf.service.Recharge;
import com.zzf.test.Menu;

/**
***********************************************
*
* @className:      RechargeImpl.java
* @author:         M10F
* @date:           2019��3��22��--����2:22:15
* @version:        v1.0
* @description:    ����ʵ�ֳ�ֵ
*
* *********************************************
*/
public class RechargeImpl implements Recharge {
	@Override
	public void show() {
		insert();
	}
//	��ֵ����
	@Override
	public void insert() {
		VipImpl vipImpl=new VipImpl();
		List<VIPcard> list = vipImpl.list();
		boolean flag=false;//�Ƿ��ǻ�Ա
		
		Scanner input=new Scanner(System.in);
		System.out.println("�������Ա���ţ�");
		int vid=input.nextInt();//��Ա����
		
		for (VIPcard viPcard : list) {
			if (vid==viPcard.getVid()) {
				System.out.println("�������ֵ��Ϣ��");
				double money=input.nextDouble();
				viPcard.setBalance(viPcard.getBalance()+money);
				System.out.println("��ֵ�ɹ�");
				flag=true;
			}
		}
		if (!flag) {
			System.out.println("���ǻ�Ա");
		}
		
	}
}
