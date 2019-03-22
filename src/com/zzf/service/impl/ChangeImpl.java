package com.zzf.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.zzf.pojo.Integration;
import com.zzf.pojo.Product;
import com.zzf.pojo.VIPcard;
import com.zzf.service.Change;
import com.zzf.test.Menu;

/**
***********************************************
*
* @className:      ChangeImpl.java
* @author:         M10F
* @date:           2019年3月22日--下午2:22:44
* @version:        v1.0
* @description:    具体实现积分兑换
*
* *********************************************
*/
public class ChangeImpl implements Change {
	@Override
	public void show() {
		list();//列表显示
	}
//	列表显示
	@Override
	public void list() {
		List<Integration> list=new ArrayList<Integration>();
		list.add(new Integration(1, "水杯", 100));
		list.add(new Integration(2, "纸巾", 50));
		list.add(new Integration(3, "水壶", 1000));
		System.out.println("礼品编号\t名称\t\t所需积分数\t");
		list.forEach(System.out::println);
		change(list);
	}
//	处理数据
	@Override
	public void change(List<Integration> list) {
//		兑换
		Scanner input=new Scanner(System.in);
		int no;//会员卡号
		int gid;//礼品编号
		String contin;//是否继续兑换
		boolean flag=false;//是否存在礼品编号
		boolean flag2=true;//是否继续
		boolean flag3=true;//是否是会员
		
//		是否是会员
		System.out.println("请输入会员卡号：");
		no=input.nextInt();
		VipImpl vipImpl=new VipImpl();
		List<VIPcard> list2 = vipImpl.list();
		l:while (true) {
			for (VIPcard viPcard : list2) {
				if (no==viPcard.getVid()) {
					while (flag2) {
						System.out.println("请输入兑换的礼品编号：");
						gid=input.nextInt();
						
						for (Integration integration : list) {
							if(viPcard.getIntegral()<integration.getGnum()) {
								System.out.println("积分不足,兑换失败");
							}
							if (gid==integration.getGid()&&(viPcard.getIntegral()>=integration.getGnum())) {
								System.out.println("兑换成功");
								viPcard.setIntegral(viPcard.getIntegral()-integration.getGnum());
								flag=true;
							}
						}
						System.out.println("是否继续兑换：y-继续，其他字符-放弃");
						contin=input.next();
						switch (contin) {
						case "y":
							break ;
						default:
							flag2=false;
							break l;
						}
						if (!flag) {
							System.out.println("礼品编号不存在");
						}
					}
					flag3=true;
				}
			}
			if (!flag3) {
				System.out.println("会员不存在");
				break;
			}
		}	
	}
		
		
}

