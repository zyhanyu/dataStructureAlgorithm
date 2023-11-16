package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class RadixSort {

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
		radixSort(arr);
		
		Date data2 = new Date();
		String date2Str = simpleDateFormat.format(data2);
		System.out.println("������ʱ��ʱ=" + date2Str);
	}
	
	// �������򷽷�
	public static void radixSort(int[] arr){
		// 1. �õ���������������λ��
		int max = arr[0]; // �����һ����������
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
			
		}
		// �õ�������Ǽ�λ��
		int maxLength = (max + "").length();
		
		// ��һ��(���ÿ��Ԫ�صĸ�λ����������)
		
		// ����һ����ά���飬��ʾ10��Ͱ��ÿ��Ͱ����һ��һά����
		// ˵��
		// 1. ��ά�������10��һλ����
		// 2. Ϊ�˷�ֹ�ڷ�������ʱ�������������ÿ��һά���飨Ͱ������С����λarr.length
		// 3. ��ȷ����������
		int[][] bucket = new int[10][arr.length];
		
		// Ϊ�˼�¼ÿ��Ͱ�У�ʵ�ʴ���˶��ٸ����ݣ����Ƕ���һ��һά�����ڼ�¼����Ͱÿ�η�������ݸ���
		// bucketElementCounts[0],��¼�ľ��� bucket[0] Ͱ�ķ������ݸ���
		int[] bucketElementCounts = new int[10];
		
		// ��������ʹ��ѭ�������봦��
		for (int i = 0,n = 1; i < maxLength; i++,n *= 10) {
			// ���ÿ��Ԫ�صĶ�Ӧλ��������������һλ�Ǹ�λ,�ڶ�λʮλ����λ��λ
			for(int j = 0; j < arr.length; j++){
				// ȡ��ÿ��Ԫ�صĸ���
				int digitOfElement = arr [j] / n % 10;
				// �ŵ���Ӧ��Ͱ��
				bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
				bucketElementCounts[digitOfElement]++;
			}
			// �������Ͱ��˳��(һά������±�����ȡ�����ݣ�����ԭ������)
			int index = 0;
			// ����ÿһͰ������Ͱ�е����ݣ����뵽ԭ����
			for(int k = 0;k < bucketElementCounts.length;k++){
				// ���Ͱ�У������ݣ����ǲŷ��뵽ԭ����
				if (bucketElementCounts[k] != 0) {
					// ѭ����Ͱ����k��Ͱ������k��һά���飩,����
					for(int l = 0; l< bucketElementCounts[k];l++){
						// ȡ��Ԫ�ط��뵽arr
						arr[index++] = bucket[k][l];
					}
					
				}
				// ��һ�ִ������Ҫ��ÿ��bucketElementCounts[k] = 0 !!!
				bucketElementCounts[k] = 0;
			}
			// System.out.println("��"+(i+1)+"�ۣ��Ը�λ������ arr = "+Arrays.toString(arr));
		}
//		
//		for(int j = 0; j < arr.length; j++){
//			// ȡ��ÿ��Ԫ�صĸ���
//			int digitOfElement = arr[j] / 10 % 10;
//			// �ŵ���Ӧ��Ͱ��
//			bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
//			bucketElementCounts[digitOfElement]++;
//		}
//		// �������Ͱ��˳��(һά������±�����ȡ�����ݣ�����ԭ������)
//		 index = 0;
//		// ����ÿһͰ������Ͱ�е����ݣ����뵽ԭ����
//		for(int k = 0;k < bucketElementCounts.length;k++){
//			// ���Ͱ�У������ݣ����ǲŷ��뵽ԭ����
//			if (bucketElementCounts[k] != 0) {
//				// ѭ����Ͱ����k��Ͱ������k��һά���飩,����
//				for(int l = 0; l< bucketElementCounts[k];l++){
//					// ȡ��Ԫ�ط��뵽arr
//					arr[index++] = bucket[k][l];
//				}
//				
//			}
//			// ��һ�ִ������Ҫ��ÿ��bucketElementCounts[k] = 0 !!!
//			// bucketElementCounts[k] = 0;
//		}
//		System.out.println("��2�ۣ��Ը�λ������ arr = "+Arrays.toString(arr));
//		
//		
	}

}














