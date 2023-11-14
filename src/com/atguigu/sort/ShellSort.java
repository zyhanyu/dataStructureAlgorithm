package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.omg.CORBA.PUBLIC_MEMBER;

public class ShellSort {

	public static void main(String[] args) {
		int[] arr = new int[80000];
		for (int i = 0; i < 80000; i++) {
			arr[i] = (int)(Math.random() * 8000000);//����һ��[0, 8000000] ��
		}
		
		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(data1);
		System.out.println("����ǰ��ʱ��ʱ=" + date1Str);
		
//		shellSort(arr); // ����ʽ
		shellSort2(arr); // ��λʽ
		
		Date data2 = new Date();
		String date2Str = simpleDateFormat.format(data2);
		System.out.println("������ʱ��ʱ=" + date2Str);
	}
	
	public static void shellSort(int[] arr){
		// ϣ������ĵ�һ������
		// ��Ϊ��1�������ǽ�10�����ݷֳ���5��
		int temp = 0;
		int count = 0;
		for(int gap = arr.length / 2; gap > 0;gap /= 2){
			for (int i = gap; i < arr.length; i++) {
				// �������������е�Ԫ��(��gap�飬ÿ����2��Ԫ��)������5
				for (int j = i - gap; j >= 0; j -= gap) {
					// �����ǰԪ�ش��ڼ��ϲ�������Ǹ�Ԫ�أ�˵������
					if (arr[j] > arr[j + gap]) {
						temp = arr[j];
						arr[j] = arr[j+gap];
						arr[j+gap] = temp;
					}
				}
			}
			// System.out.println("ϣ������"+(++count)+"�۽��="+Arrays.toString(arr));
		}	
		
		
	}
	
	// �Խ���ʽ��ϣ����������Ż�->��λ��
	public static void shellSort2(int[] arr){
		
		// ����gap�����𲽵���С����
		for(int gap = arr.length / 2; gap > 0;gap /= 2){
			// �ӵ�gap��Ԫ�أ���ʼ��������ڵ�����в�������
			for (int i = gap; i < arr.length; i++) {
				int j = i;
				int temp = arr[j];
				if (arr[j] < arr[j - gap]) {
					while(j - gap >= 0 && temp < arr[j - gap]){
						// �ƶ�
						arr[j] = arr[j-gap];
						j -= gap;
					}
					// ���˳�while�󣬾͸�temp�ҵ������λ��
					arr[j] = temp;
				}
			}
		}
	}
}




















