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
* @date:           2019��3��22��--����2:22:44
* @version:        v1.0
* @description:    ����ʵ�ֻ��ֶһ�
*
* *********************************************
*/
public class ChangeImpl implements Change {
	@Override
	public void show() {
		list();//�б���ʾ
	}
//	�б���ʾ
	@Override
	public void list() {
		List<Integration> list=new ArrayList<Integration>();
		list.add(new Integration(1, "ˮ��", 100));
		list.add(new Integration(2, "ֽ��", 50));
		list.add(new Integration(3, "ˮ��", 1000));
		System.out.println("��Ʒ���\t����\t\t���������\t");
		list.forEach(System.out::println);
		change(list);
	}
//	��������
	@Override
	public void change(List<Integration> list) {
//		�һ�
		Scanner input=new Scanner(System.in);
		int no;//��Ա����
		int gid;//��Ʒ���
		String contin;//�Ƿ�����һ�
		boolean flag=false;//�Ƿ������Ʒ���
		boolean flag2=true;//�Ƿ����
		boolean flag3=true;//�Ƿ��ǻ�Ա
		
//		�Ƿ��ǻ�Ա
		System.out.println("�������Ա���ţ�");
		no=input.nextInt();
		VipImpl vipImpl=new VipImpl();
		List<VIPcard> list2 = vipImpl.list();
		l:while (true) {
			for (VIPcard viPcard : list2) {
				if (no==viPcard.getVid()) {
					while (flag2) {
						System.out.println("������һ�����Ʒ��ţ�");
						gid=input.nextInt();
						
						for (Integration integration : list) {
							if(viPcard.getIntegral()<integration.getGnum()) {
								System.out.println("���ֲ���,�һ�ʧ��");
							}
							if (gid==integration.getGid()&&(viPcard.getIntegral()>=integration.getGnum())) {
								System.out.println("�һ��ɹ�");
								viPcard.setIntegral(viPcard.getIntegral()-integration.getGnum());
								flag=true;
							}
						}
						System.out.println("�Ƿ�����һ���y-�����������ַ�-����");
						contin=input.next();
						switch (contin) {
						case "y":
							break ;
						default:
							flag2=false;
							break l;
						}
						if (!flag) {
							System.out.println("��Ʒ��Ų�����");
						}
					}
					flag3=true;
				}
			}
			if (!flag3) {
				System.out.println("��Ա������");
				break;
			}
		}	
	}
		
		
}

