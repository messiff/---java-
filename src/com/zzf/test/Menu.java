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
* @date:           2019��3��22��--����2:03:58
* @version:        v1.0
* @description:    �˵�����
*
* *********************************************
*/
public class Menu {
	//�˵�����
	public void menu() {
		System.out.println("*****************��ӭ����xx����****************");
		System.out.println("��ѡ����:1������\t2�����ֶһ�\t 3����ֵ\t4���˳�ϵͳ");
	}
	public void mainMenu() {
		menu();
		boolean flag=true;//�Ƿ��˳�
		while (flag) {
			Scanner input=new Scanner(System.in);
			int no;//ѡ����
			no=input.nextInt();
			switch (no) {
			case 1:
	//			����
				ShoopingImpl shopping=new ShoopingImpl();
				shopping.show();
				menu();
				break;
			case 2:
	//			���ֶһ�
				ChangeImpl changeImpl=new ChangeImpl();
				changeImpl.show();
				menu();
				break;
			case 3:
	//			��ֵ
				RechargeImpl rechargeImpl=new RechargeImpl();
				rechargeImpl.show();
				menu();
				break;
			case 4:
	//			�˳�
				System.out.println("exit");
				flag=false;
				break;
			default:
				System.out.println("����������½���ѡ��");
				break;
			}
		}
		
	}
}
