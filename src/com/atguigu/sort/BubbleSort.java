package com.atguigu.sort;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3,9,-1,10,20};
		
		// ����ð������
		bulleSort(arr);
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
			System.out.println("��"+(j+1)+"������������");
			System.out.println(Arrays.toString(arr));
			if (!flag) { // ��һ�������У�һ�ν�����û������
				break;
			}else{
				flag = false; // ����flag�������´��ж�
			}
		}
	}

}











