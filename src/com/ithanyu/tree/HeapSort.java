package com.ithanyu.tree;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class HeapSort {

	public static void main(String[] args) {
		// Ҫ�����������������
		
		

		int[] arr = new int[80000];
		for (int i = 0; i < 80000; i++) {
			arr[i] = (int)(Math.random() * 8000000);//����һ��[0, 8000000] ��
		}
		
		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(data1);
		System.out.println("����ǰ��ʱ��ʱ=" + date1Str);
		
		
		// ���Զ�����
		heapSort(arr);
		
		Date data2 = new Date();
		String date2Str = simpleDateFormat.format(data2);
		System.out.println("������ʱ��ʱ=" + date2Str);
		
		
	}
	
	// ��дһ��������ķ���
	public static void heapSort(int arr[]){
		int temp = 0;
		// System.out.println("�����򣡣�");
		// �ֲ����
		// adjustHeap(arr,1,arr.length);
		// System.out.println("��һ��"+Arrays.toString(arr)); // [4, 9, 8, 5, 6]

		// adjustHeap(arr,0,arr.length);
		// System.out.println("��һ��"+Arrays.toString(arr)); // [9, 6, 8, 5, 4]
	    // 1.���������й�����һ���ѣ���������������ѡ��󶥶ѻ�С����
		for(int i = arr.length / 2 -1 ;i>=0;i--){
			adjustHeap(arr, i, arr.length);
			
		}
		// 2. ���Ѷ�Ԫ����ĩβԪ�ؽ����������Ԫ��"��"������ĩ�ˣ�
		// 3. ���µ����ṹ��ʹ������Ѷ��壬Ȼ����������Ѷ�Ԫ���뵱ǰĩβԪ�أ�����ָ�����+���沽�裬ֱ�������������
		for(int j = arr.length-1;j>0;j--){
			// ����
			temp = arr[j];
			arr[j] = arr[0];
			arr[0] = temp;
			adjustHeap(arr, 0, j);
		}
		// System.out.println("����="+Arrays.toString(arr)); // [9, 6, 8, 5, 4]
	}
	
	// ��һ�����飨����������������һ���󶥶�
	/**
	 * ���ܣ���� �� �� i ��Ӧ�ķ�Ҷ�ӽڵ���������ɴ󶥶�
	 * @param arr ������������
	 * @param i ��ʾ��Ҷ�ӽڵ�������������
	 * @param length ��ʾ�Զ��ٸ�Ԫ�ؽ��е�����length ���𽥵ļ���
	 */
	public static void  adjustHeap(int arr[],int i,int length){
		int temp = arr[i]; // ��ȡ����ǰԪ�ص�ֵ����������ʱ����
		// ��ʼ����
		// ˵��
		// 1. k = i * 2 + 1 k ��i�ڵ�����ӽڵ�
		for(int k = i * 2+1;k<length;k = k*2+1){
			if(k+1 < length && arr[k] < arr[k+1]){ // ˵�����ӽڵ��ֵС�����ӽڵ��ֵ
				k++; // k ָ�����ӽڵ�
			}
			if (arr[k] > temp) { // ����ӽڵ���ڸ��ڵ�
				arr[i] = arr[k]; // �ѽϴ��ֵ������ǰ�ڵ�
				i = k; // i ָ�� k������ѭ���Ƚ�
			} else {
				break;
			}
		}
		// �� for ѭ�������������Ѿ�����i Ϊ���ڵ���������ֵ�������� ����ֲ���
		arr[i] = temp;// ��tempֵ�ŵ��������λ��
	} 

}









