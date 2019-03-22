package com.zzf.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import com.zzf.pojo.Product;
import com.zzf.pojo.VIPcard;
import com.zzf.service.Shooping;
import com.zzf.test.Menu;

/**
***********************************************
*
* @className:      ShoopingImpl.java
* @author:         M10F
* @date:           2019年3月22日--下午2:24:36
* @version:        v1.0
* @description:    具体实现购物清单 产品
*
* *********************************************
*/
public class ShoopingImpl implements Shooping {
	Scanner input=new Scanner(System.in);
	@Override
	public void show() {
		list();//列表显示
	}
//	列表显示
	@Override
	public void list() {
		Map<Product, Integer> map=new LinkedHashMap<Product, Integer>();
		map.put(new Product(1, "可口可乐500ml", 3), 78);
		map.put(new Product(2, "美年达葡萄味", 3), 195);
		map.put(new Product(3, "钢笔", 50), 0);
		System.out.println("产品编号\t名称\t\t价格\t剩余量\t");
		Set<Entry<Product, Integer>> entrySet = map.entrySet();
		for (Entry<Product, Integer> entry : entrySet) {
			System.out.println(entry.getKey()+"\t"+entry.getValue());
		}
		opera(map);
	}
//	数据操作
	@Override
	public void opera(Map<Product,Integer> map) {
		
		Set<Entry<Product, Integer>> entrySet = map.entrySet();
		int no;//产品编号
		Integer num;//购买数量
		String contin;//是否继续
		boolean flag=true;//结束购物  true 不结束
		boolean falg2=false;//是否存在商品，true存在
		String vip;//是否是vip
		double bumoney=0;//购物每件商品金额
		
		
		Map<Product, Integer> map2=new LinkedHashMap<Product, Integer>();//购物清单
		while (flag) {
			System.out.println("请输入产品编号：");
			no=input.nextInt();
			for (Entry<Product, Integer> entry : entrySet) {
				if (no==entry.getKey().getPid()) {
					System.out.println("请输入购买数量：");
					num=input.nextInt();
					if (num<=entry.getValue()) {
						entry.setValue(entry.getValue()-num);
						bumoney=num*entry.getKey().getPrice();
						map2.put(new Product(entry.getKey().getPid(),entry.getKey().getPname(),bumoney),num);
					}else {
						System.out.println("数量不足");
					}
					falg2=true;
				}
			}
			if (!falg2) {
				System.out.println("产品不存在");
			}
			System.out.println("是否要继续购物：y-是，其他字符-否");
			contin=input.next();
			switch (contin) {
			case "y":
				break;
			default:
				System.out.println("结束购物");
				flag=false;
				break;
			}
		}
//		购物清单
		System.out.println("购物清单：");
		double money=0;
		Set<Entry<Product, Integer>> entrySet2 = map2.entrySet();
		for (Entry<Product, Integer> entry : entrySet2) {
			money+=entry.getKey().getPrice();
			System.out.println(entry.getKey()+"\t"+entry.getValue());
		}
//		是否有会员
		VipImpl vipImpl=new VipImpl();
		List<VIPcard> list = vipImpl.list();
		System.out.println("是否有会员卡：y-有，其他字符-无");
		vip=input.next();
		switch (vip) {
		case "y":
//			vip支付金额
			vip(list,money);
			break;
		default:
//			非vip支付金额
			novip(money);
			break;
		}
	}
//	vip支付方式
	public void vip(List<VIPcard> list,double money) {
		double pay;//支付
		double remoney;//找零
		int vipno;//会员卡号
		System.out.println("请输入会员号：");
		vipno=input.nextInt();
		System.out.println("---");
		for (VIPcard viPcard : list) {
			if (viPcard.getVid()==vipno) {
				if (viPcard.getBalance()>money*viPcard.getPercent()) {
					System.out.println("需要支付："+money*viPcard.getPercent());
					viPcard.setBalance(viPcard.getBalance()-money*viPcard.getPercent());
					System.out.println("已扣除"+money*viPcard.getPercent()+",余额"+viPcard.getBalance());
				}
				else {
					System.out.println("会员卡余额不足，已扣除"+viPcard.getBalance()*viPcard.getPercent());
					
//					余额不足用现金支付
					System.out.println("会员卡余额不足，仍需需支付金额："+(money-viPcard.getBalance()));
					
					System.out.println("请输入支付金额：");
					pay=input.nextDouble();
					if (pay>money-viPcard.getBalance()) {
						remoney=pay-money-viPcard.getBalance();
					}
					else {
						remoney=0;
					}
					viPcard.setBalance(0);
					System.out.println("支付成功,找零："+remoney);
				}
				
			}
		}
	}
//	非vip支付方式
	public void novip(double money) {
		double pay;//支付
		double remoney;//找零
		System.out.println("所需支付金额："+money);
		System.out.println("请输入支付金额：");
		pay=input.nextDouble();
		if (pay>money) {
			remoney=pay-money;
		}
		else {
			remoney=0;
		}
		System.out.println("支付成功,找零："+remoney);
	}
}
