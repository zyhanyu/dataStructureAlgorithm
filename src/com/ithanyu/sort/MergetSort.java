package com.ithanyu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MergetSort {

	public static void main(String[] args) {int[] arr = new int[80000];
		for (int i = 0; i < 80000; i++) {
			arr[i] = (int)(Math.random() * 8000000);//����һ��[0, 8000000] ��
		}
		
		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(data1);
		System.out.println("����ǰ��ʱ��ʱ=" + date1Str);
	
		int temp[] = new int[arr.length]; // �鲢����С��һ�����⿿��Ͻ�
		mergeSort(arr, 0, arr.length - 1, temp);
		
		Date data2 = new Date();
		String date2Str = simpleDateFormat.format(data2);
		System.out.println("������ʱ��ʱ=" + date2Str);	
		
	}
	
	// ��+�Ϸ���
	public static void mergeSort(int[] arr,int left,int right,int[] temp){
		if (left < right) {
			int mid = (left + right) / 2;//�м�����
			// ����ݹ���зֽ�
			mergeSort(arr, left, mid, temp);
			// ���ҵݹ���зֽ�
			mergeSort(arr, mid + 1, right, temp);
			// ���ϲ�
			 merge(arr, left, mid, right, temp);
		}
	}
	
	/**
	 * �ϲ�����
	 * @param arr �����ԭʼ����
	 * @param left ����������еĳ�ʼ����
	 * @param mid �м�����
	 * @param right �ұ�����
	 * @param temp ����ת������
	 */
	public static void merge(int[] arr,int left,int mid,int right,int[] temp){
		int i = left; // ��ʼ��i������������еĳ�ʼ����
		int j = mid + 1; // ��ʼ��j���ұ��������еĳ�ʼ����
		int t = 0; // ָ��temp����ĵ�ǰ����
		
		// (һ)
		// �Ȱ���������(����)�����ݰ��չ�����䵽temp����
		// ֱ���������ߵ��������У���һ�ߴ������Ϊֹ
		while(i <= mid && j <= right){// ����
			// �����ߵ��������еĵ�ǰԪ�أ�С�ڵ����ұ��������еĵ�ǰԪ��
			// ������ߵĵ�ǰԪ�أ�������temp����
			// Ȼ�� t++,i++
			if (arr[i] <= arr[j]) {
				temp[t] = arr[i];
				t += 1;
				i += 1;
			}else{ // ��֮,���ұߵ��������еĵ�ǰԪ�أ���䵽temp����
				temp[t] = arr[j];
				t += 1;
				j += 1;
			}
			
		}
		
		// (��)
		// ����ʣ�����ݵ�һ�ߵ���������ȫ����䵽temp
		while( i <= mid){ // ��ߵ��������л���ʣ���Ԫ�أ���ȫ����䵽temp
			temp[t] = arr[i];
			t += 1;
			i += 1;
		}
		while( j <= right){ // �ұߵ��������л���ʣ���Ԫ�أ���ȫ����䵽temp
			temp[t] = arr[j];
			t += 1;
			j += 1;
		}
		
		// (��)
		// ��temp�����ԭʼ������arr
		// ע�⣬������ÿ�ζ���������
		t = 0;
		int tempLeft = left; // 
		// ��һ�κϲ� tl = 0,ri = 1// �ڶ��κϲ� tl = 2,ri = 3// �����κϲ� tl = 0,ri = 3
		// ���һ�� tempLeft  = 0 right = 7
		while(tempLeft <= right){
			arr[tempLeft] = temp[t];
			t += 1;
			tempLeft += 1; 
		}
	}

}




















