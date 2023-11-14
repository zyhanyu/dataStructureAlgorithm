package com.atguigu.sort;

import java.util.Arrays;

public class ShellSort {

	public static void main(String[] args) {
		int[] arr = {8,9,1,7,2,3,5,4,6,0};
		shellSort(arr);
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
			System.out.println("ϣ������"+(++count)+"�۽��="+Arrays.toString(arr));
		}	
	}
}




















