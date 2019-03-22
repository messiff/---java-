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
* @date:           2019年3月22日--下午2:22:15
* @version:        v1.0
* @description:    具体实现充值
*
* *********************************************
*/
public class RechargeImpl implements Recharge {
	@Override
	public void show() {
		insert();
	}
//	充值功能
	@Override
	public void insert() {
		VipImpl vipImpl=new VipImpl();
		List<VIPcard> list = vipImpl.list();
		boolean flag=false;//是否是会员
		
		Scanner input=new Scanner(System.in);
		System.out.println("请输入会员卡号：");
		int vid=input.nextInt();//会员卡号
		
		for (VIPcard viPcard : list) {
			if (vid==viPcard.getVid()) {
				System.out.println("请输入充值信息：");
				double money=input.nextDouble();
				viPcard.setBalance(viPcard.getBalance()+money);
				System.out.println("充值成功");
				flag=true;
			}
		}
		if (!flag) {
			System.out.println("不是会员");
		}
		
	}
}
