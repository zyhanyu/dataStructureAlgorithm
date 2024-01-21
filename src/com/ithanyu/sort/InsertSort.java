package com.ithanyu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertSort {

	public static void main(String[] args) {
		// 测试一下冒泡排序的速度O(n^2),给80000个数据，测试
		// 创建要给80000个的随机的数组
		int[] arr = new int[80000];
		for (int i = 0; i < 80000; i++) {
			arr[i] = (int)(Math.random() * 8000000);//生成一个[0, 8000000] 数
		}
		
		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(data1);
		System.out.println("排序前的时间时=" + date1Str);
		
		
		// 测试冒泡排序
		insertSort(arr);
		
		Date data2 = new Date();
		String date2Str = simpleDateFormat.format(data2);
		System.out.println("排序后的时间时=" + date2Str);
	}

	// 插入排序
	public static void insertSort(int[] arr){
		// 定义待插入的数
		int insertVal = 0;
		int insertIndex = 0; // 即arr[1]的前面这个数的下标
		// 第1论 {101,34,119,1} => {34,101,119,1}
		for (int i = 1; i < arr.length; i++) {
			
			// 定义待插入的数
			insertVal = arr[i];
			insertIndex = i -1; // 即arr[1]的前面这个数的下标
			
			// 给insertVal 找到插入的位置
			// 说明
			// 1. insertIndex >= 0 保证在给insertVal 找插入位置，不越界
			// 2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
			// 3. 就需要将 arr[insertIndex] 后移
			while(insertIndex >= 0 && insertVal < arr[insertIndex]){
				arr[insertIndex + 1] = arr[insertIndex]; 
				insertIndex--;
			}
			// 当退出while循环时，说明插入的位置找到，insertIndex + 1
			arr[insertIndex + 1] = insertVal;
			
			// System.out.println("第"+i+"轮插入后");
			// System.out.println(Arrays.toString(arr));

		
		}
	}
}

















