package com.zzf.test;

import java.util.Scanner;

import com.zzf.service.impl.ChangeImpl;
import com.zzf.service.impl.RechargeImpl;
import com.zzf.service.impl.ShoopingImpl;

/**
***********************************************
*
* @className:      Menu.java
* @author:         M10F
* @date:           2019年3月22日--下午2:03:58
* @version:        v1.0
* @description:    菜单界面
*
* *********************************************
*/
public class Menu {
	//菜单界面
	public void menu() {
		System.out.println("*****************欢迎光临xx超市****************");
		System.out.println("请选择功能:1、购物\t2、积分兑换\t 3、充值\t4、退出系统");
	}
	public void mainMenu() {
		menu();
		boolean flag=true;//是否退出
		while (flag) {
			Scanner input=new Scanner(System.in);
			int no;//选择功能
			no=input.nextInt();
			switch (no) {
			case 1:
	//			购物
				ShoopingImpl shopping=new ShoopingImpl();
				shopping.show();
				menu();
				break;
			case 2:
	//			积分兑换
				ChangeImpl changeImpl=new ChangeImpl();
				changeImpl.show();
				menu();
				break;
			case 3:
	//			充值
				RechargeImpl rechargeImpl=new RechargeImpl();
				rechargeImpl.show();
				menu();
				break;
			case 4:
	//			退出
				System.out.println("exit");
				flag=false;
				break;
			default:
				System.out.println("输入错误，重新进行选择");
				break;
			}
		}
		
	}
}
