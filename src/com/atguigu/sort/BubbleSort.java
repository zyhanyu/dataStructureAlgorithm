package com.atguigu.sort;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3,9,-1,10,20};
		
		// 测试冒泡排序
		bulleSort(arr);
	}
	
	// 将前面冒泡排序算法，封装成一个方法
	public static void bulleSort(int[] arr){
		int temp = 0; // 临时变量
		boolean flag = false;// 标识变量，表示是否进行过交换
		for (int j = 0; j < arr.length-1; j++) {
			for (int i = 0; i < arr.length - 1-j; i++) {
				// 如果前面的数比后面的数大，则交换
				if (arr[i] > arr[i+1]) {
					flag = true;
					temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i+1] = temp;
				}
			}
			System.out.println("第"+(j+1)+"这排序后的数组");
			System.out.println(Arrays.toString(arr));
			if (!flag) { // 在一趟排序中，一次交换都没发生过
				break;
			}else{
				flag = false; // 重置flag，进行下次判断
			}
		}
	}

}











