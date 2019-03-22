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
* @date:           2019��3��22��--����2:24:36
* @version:        v1.0
* @description:    ����ʵ�ֹ����嵥 ��Ʒ
*
* *********************************************
*/
public class ShoopingImpl implements Shooping {
	Scanner input=new Scanner(System.in);
	@Override
	public void show() {
		list();//�б���ʾ
	}
//	�б���ʾ
	@Override
	public void list() {
		Map<Product, Integer> map=new LinkedHashMap<Product, Integer>();
		map.put(new Product(1, "�ɿڿ���500ml", 3), 78);
		map.put(new Product(2, "���������ζ", 3), 195);
		map.put(new Product(3, "�ֱ�", 50), 0);
		System.out.println("��Ʒ���\t����\t\t�۸�\tʣ����\t");
		Set<Entry<Product, Integer>> entrySet = map.entrySet();
		for (Entry<Product, Integer> entry : entrySet) {
			System.out.println(entry.getKey()+"\t"+entry.getValue());
		}
		opera(map);
	}
//	���ݲ���
	@Override
	public void opera(Map<Product,Integer> map) {
		
		Set<Entry<Product, Integer>> entrySet = map.entrySet();
		int no;//��Ʒ���
		Integer num;//��������
		String contin;//�Ƿ����
		boolean flag=true;//��������  true ������
		boolean falg2=false;//�Ƿ������Ʒ��true����
		String vip;//�Ƿ���vip
		double bumoney=0;//����ÿ����Ʒ���
		
		
		Map<Product, Integer> map2=new LinkedHashMap<Product, Integer>();//�����嵥
		while (flag) {
			System.out.println("�������Ʒ��ţ�");
			no=input.nextInt();
			for (Entry<Product, Integer> entry : entrySet) {
				if (no==entry.getKey().getPid()) {
					System.out.println("�����빺��������");
					num=input.nextInt();
					if (num<=entry.getValue()) {
						entry.setValue(entry.getValue()-num);
						bumoney=num*entry.getKey().getPrice();
						map2.put(new Product(entry.getKey().getPid(),entry.getKey().getPname(),bumoney),num);
					}else {
						System.out.println("��������");
					}
					falg2=true;
				}
			}
			if (!falg2) {
				System.out.println("��Ʒ������");
			}
			System.out.println("�Ƿ�Ҫ�������y-�ǣ������ַ�-��");
			contin=input.next();
			switch (contin) {
			case "y":
				break;
			default:
				System.out.println("��������");
				flag=false;
				break;
			}
		}
//		�����嵥
		System.out.println("�����嵥��");
		double money=0;
		Set<Entry<Product, Integer>> entrySet2 = map2.entrySet();
		for (Entry<Product, Integer> entry : entrySet2) {
			money+=entry.getKey().getPrice();
			System.out.println(entry.getKey()+"\t"+entry.getValue());
		}
//		�Ƿ��л�Ա
		VipImpl vipImpl=new VipImpl();
		List<VIPcard> list = vipImpl.list();
		System.out.println("�Ƿ��л�Ա����y-�У������ַ�-��");
		vip=input.next();
		switch (vip) {
		case "y":
//			vip֧�����
			vip(list,money);
			break;
		default:
//			��vip֧�����
			novip(money);
			break;
		}
	}
//	vip֧����ʽ
	public void vip(List<VIPcard> list,double money) {
		double pay;//֧��
		double remoney;//����
		int vipno;//��Ա����
		System.out.println("�������Ա�ţ�");
		vipno=input.nextInt();
		System.out.println("---");
		for (VIPcard viPcard : list) {
			if (viPcard.getVid()==vipno) {
				if (viPcard.getBalance()>money*viPcard.getPercent()) {
					System.out.println("��Ҫ֧����"+money*viPcard.getPercent());
					viPcard.setBalance(viPcard.getBalance()-money*viPcard.getPercent());
					System.out.println("�ѿ۳�"+money*viPcard.getPercent()+",���"+viPcard.getBalance());
				}
				else {
					System.out.println("��Ա�����㣬�ѿ۳�"+viPcard.getBalance()*viPcard.getPercent());
					
//					�������ֽ�֧��
					System.out.println("��Ա�����㣬������֧����"+(money-viPcard.getBalance()));
					
					System.out.println("������֧����");
					pay=input.nextDouble();
					if (pay>money-viPcard.getBalance()) {
						remoney=pay-money-viPcard.getBalance();
					}
					else {
						remoney=0;
					}
					viPcard.setBalance(0);
					System.out.println("֧���ɹ�,���㣺"+remoney);
				}
				
			}
		}
	}
//	��vip֧����ʽ
	public void novip(double money) {
		double pay;//֧��
		double remoney;//����
		System.out.println("����֧����"+money);
		System.out.println("������֧����");
		pay=input.nextDouble();
		if (pay>money) {
			remoney=pay-money;
		}
		else {
			remoney=0;
		}
		System.out.println("֧���ɹ�,���㣺"+remoney);
	}
}
