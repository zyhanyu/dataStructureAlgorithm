package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SelectSort1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = new int[80000];
		for (int i = 0; i < 80000; i++) {
			arr[i] = (int)(Math.random() * 8000000);//����һ��[0, 8000000] ��
		}
		
		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(data1);
		System.out.println("����ǰ��ʱ��ʱ=" + date1Str);
		
		
		// ����ð������
		selectSort(arr);
		
		Date data2 = new Date();
		String date2Str = simpleDateFormat.format(data2);
		System.out.println("������ʱ��ʱ=" + date2Str);
		
		

	}
	// ѡ������
		public static void selectSort(int[] arr){
			// �����ʱ�临�ӵ�ʱO��n^2��
			for (int i = 0; i < arr.length - 1; i++) {
				int minIndex = i;
				int min = arr[i];
				for (int j = i + 1; j < arr.length; j++) {
					if (min > arr[j]) { // ˵���ٶ�����Сֵ����������С
						min = arr[j]; // ����min
						minIndex = j; // ����minIndex
					}
				}
				
				// ����Сֵ������arr[0],������
				if (minIndex != i) {
					arr[minIndex] = arr[i];
					arr[i] = min;
				}
				
				// System.out.println("��"+(i+1)+"һ�ֺ�~");
				// System.out.println(Arrays.toString(arr));
				
			}
		}
}
