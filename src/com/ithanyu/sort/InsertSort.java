package com.ithanyu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertSort {

	public static void main(String[] args) {
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
		insertSort(arr);
		
		Date data2 = new Date();
		String date2Str = simpleDateFormat.format(data2);
		System.out.println("������ʱ��ʱ=" + date2Str);
	}

	// ��������
	public static void insertSort(int[] arr){
		// ������������
		int insertVal = 0;
		int insertIndex = 0; // ��arr[1]��ǰ����������±�
		// ��1�� {101,34,119,1} => {34,101,119,1}
		for (int i = 1; i < arr.length; i++) {
			
			// ������������
			insertVal = arr[i];
			insertIndex = i -1; // ��arr[1]��ǰ����������±�
			
			// ��insertVal �ҵ������λ��
			// ˵��
			// 1. insertIndex >= 0 ��֤�ڸ�insertVal �Ҳ���λ�ã���Խ��
			// 2. insertVal < arr[insertIndex] �������������û���ҵ�����λ��
			// 3. ����Ҫ�� arr[insertIndex] ����
			while(insertIndex >= 0 && insertVal < arr[insertIndex]){
				arr[insertIndex + 1] = arr[insertIndex]; 
				insertIndex--;
			}
			// ���˳�whileѭ��ʱ��˵�������λ���ҵ���insertIndex + 1
			arr[insertIndex + 1] = insertVal;
			
			// System.out.println("��"+i+"�ֲ����");
			// System.out.println(Arrays.toString(arr));

		
		}
	}
}

















