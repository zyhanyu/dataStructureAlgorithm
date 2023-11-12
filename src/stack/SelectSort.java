package stack;

import java.util.Arrays;

public class SelectSort {
	public static void mian(String[] args){
		// TODO Auto-generated method stub
		int[] arr = {101, 34, 119, 1};
		selectSort(arr);
	}
	
	// 选择排序
	public static void selectSort(int[] arr){
		int minIndex = 0;
		int min = arr[0];
		for (int j = 0; j < arr.length; j++) {
			if (min > arr[j]) { // 说明假定的最小值，并不是最小
				min = arr[j]; // 重置min
				minIndex = j; // 重置minIndex
			}
		}
		
		// 将最小值，放在arr[0],即交换
		arr[minIndex] = arr[0];
		arr[0] = min;
		
		System.out.println("第一轮后~");
		System.out.println(Arrays.toString(arr));
	}
}


















