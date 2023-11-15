package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = new int[80000];
		for (int i = 0; i < 80000; i++) {
			arr[i] = (int)(Math.random() * 8000000);//����һ��[0, 8000000] ��
		}
		
		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(data1);
		System.out.println("����ǰ��ʱ��ʱ=" + date1Str);
		quickSort(arr,0,arr.length-1);
		Date data2 = new Date();
		String date2Str = simpleDateFormat.format(data2);
		System.out.println("������ʱ��ʱ=" + date2Str);

	}
	public static void quickSort(int[] arr,int left,int right){
		int l = left;// ���±�
		int r = right;// ���±�
		// pivot ����ֵ
		int pivot = arr[(left + right) / 2];
		int temp = 0; // ��ʱ��������ʱʹ��
		// whileѭ����Ŀ��ʽ�ñ�pivot ֵС�ŵ����
		// ��pivot ֵ��ķŵ��ұ�
		while( l < r){
			// ��pivot�����һֱ�ң��ҵ����ڵ���pivotֵ�����˳�
			while( arr[l] < pivot){
				l += 1;
			}
			// ��pivot���ұ�һֱ�ң��ҵ�С�ڵ���pivotֵ�����˳�
			while(arr[r] > pivot){
				r -= 1;
			}
			// ���l >= r ˵��pivot ����������ֵ���Ѿ��������ȫ����
			// С�ڵ���pivotֵ���ұ�ȫ�����ڵ���pivotֵ
			if (l >= r) {
				break;
			}
			
			// ����
			temp = arr[l];
			arr[l] = arr[r];
			arr[r] =temp;
			// ��������󣬷������arr[l] == pivotֵ ��� r--��ǰ��
			if (arr[l] == pivot) {
				r -= 1;
			}			
			// ��������󣬷������arr[r] == pivotֵ ��� l--��ǰ��
			if (arr[r] == pivot) {
				l += 1;
			}
		}
		
		// ��� l == r������l++��l--������ջ���
		if (l==r) {
			l += 1;
			r -= 1;
		}
		// ����ݹ�
		if (left < r) {
			quickSort(arr, left, r);
		}
		// ���ҵݹ�
		if (right > l) {
			quickSort(arr, l, right);
		}
	}

}


















