package com.atguigu.sort;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3,9,-1,10,-2};
					int temp = 0; // ��ʱ����
		for (int j = 0; j < arr.length-1; j++) {

			for (int i = 0; i < arr.length - 1-j; i++) {
				// ���ǰ������Ⱥ���������򽻻�
				if (arr[i] > arr[i+1]) {
					temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i+1] = temp;
				}
			}
			System.out.println("��"+(j+1)+"������������");
			System.out.println(Arrays.toString(arr));
		}
	}

}











