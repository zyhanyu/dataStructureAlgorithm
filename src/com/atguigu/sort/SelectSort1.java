package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SelectSort1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = new int[80000];
		for (int i = 0; i < 80000; i++) {
			arr[i] = (int)(Math.random() * 8000000);//生成一个[0, 8000000] 数
		}
		
		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(data1);
		System.out.println("排序前的时间时=" + date1Str);
		
		
		// 测试冒泡排序
		selectSort(arr);
		
		Date data2 = new Date();
		String date2Str = simpleDateFormat.format(data2);
		System.out.println("排序后的时间时=" + date2Str);
		
		

	}
	// 选择排序
		public static void selectSort(int[] arr){
			// 排序的时间复杂的时O（n^2）
			for (int i = 0; i < arr.length - 1; i++) {
				int minIndex = i;
				int min = arr[i];
				for (int j = i + 1; j < arr.length; j++) {
					if (min > arr[j]) { // 说明假定的最小值，并不是最小
						min = arr[j]; // 重置min
						minIndex = j; // 重置minIndex
					}
				}
				
				// 将最小值，放在arr[0],即交换
				if (minIndex != i) {
					arr[minIndex] = arr[i];
					arr[i] = min;
				}
				
				// System.out.println("第"+(i+1)+"一轮后~");
				// System.out.println(Arrays.toString(arr));
				
			}
		}
}
