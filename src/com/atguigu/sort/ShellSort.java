package com.atguigu.sort;

import java.util.Arrays;

public class ShellSort {

	public static void main(String[] args) {
		int[] arr = {8,9,1,7,2,3,5,4,6,0};
		shellSort(arr);
	}
	
	public static void shellSort(int[] arr){
		// 希尔排序的第一轮排序
		// 因为第1论排序，是将10个数据分成了5组
		int temp = 0;
		int count = 0;
		for(int gap = arr.length / 2; gap > 0;gap /= 2){
			for (int i = gap; i < arr.length; i++) {
				// 遍历各组中所有的元素(共gap组，每组有2个元素)，步长5
				for (int j = i - gap; j >= 0; j -= gap) {
					// 如果当前元素大于加上步长后的那个元素，说明交换
					if (arr[j] > arr[j + gap]) {
						temp = arr[j];
						arr[j] = arr[j+gap];
						arr[j+gap] = temp;
					}
				}
			}
			System.out.println("希尔排序"+(++count)+"论结果="+Arrays.toString(arr));
		}	
	}
}




















