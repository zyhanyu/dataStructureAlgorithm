package com.ithanyu.sort;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.xml.crypto.Data;

public class BubbleSort {

	public static void main(String[] args) {
		
		
		// int arr[] = {3,9,-1,10,20};
		
		
		
		// ����һ��ð��������ٶ�O(n^2),��80000�����ݣ�����
		// ����Ҫ��80000�������������
		int[] arr = new int[80000];
		for (int i = 0; i < 80000; i++) {
			arr[i] = (int)(Math.random() * 8000000);//����һ��[0, 8000000] ��
		}
		
		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(data1);
		System.out.println("����ǰ��ʱ��ʱ=" + date1Str);
		
		
		// ����ð������
		bulleSort(arr);
		
		Date data2 = new Date();
		String date2Str = simpleDateFormat.format(data2);
		System.out.println("������ʱ��ʱ=" + date2Str);
		
		// System.out.println("�����");
		// System.out.println(Arrays.toString(arr));
	}
	
	// ��ǰ��ð�������㷨����װ��һ������
	public static void bulleSort(int[] arr){
		int temp = 0; // ��ʱ����
		boolean flag = false;// ��ʶ��������ʾ�Ƿ���й�����
		for (int j = 0; j < arr.length-1; j++) {
			for (int i = 0; i < arr.length - 1-j; i++) {
				// ���ǰ������Ⱥ���������򽻻�
				if (arr[i] > arr[i+1]) {
					flag = true;
					temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i+1] = temp;
				}
			}
			// System.out.println("��"+(j+1)+"������������");
			// System.out.println(Arrays.toString(arr));
			if (!flag) { // ��һ�������У�һ�ν�����û������
				break;
			}else{
				flag = false; // ����flag�������´��ж�
			}
		}
	}

}











