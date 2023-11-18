package com.ithanyu.search;

import java.util.Arrays;

public class InsertValueSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[100];
		for (int i = 0; i < 100; i++) {
			arr[i] = i + 1;
		}
		int index = insertValueSearch(arr, 0, arr.length - 1, 25);
		System.out.println("index="+index);
		// System.out.println(Arrays.toString(arr));
	}
	/**
	 * 编写插值查找算法,也要求数组是有序的
	 * @param arr 数组
	 * @param left 左边索引
	 * @param right 右边索引
	 * @param findVal 查找值
	 * @return 如果找到，返回对应下标，没有找到，返回-1
	 */
	public static int insertValueSearch(int[] arr,int left,int right,int findVal){
		System.out.println("HelloWorld");
		// 注意：findVal < arr[0] || findVal > arr[arr.length - 1] 
		// 必须需要 否则mid 可能越界
		if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
			return -1;
		}
		// 求出mid
		int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
		int midVal = arr[mid];
		if (findVal > midVal) { // 说明应该向右边递归
			return insertValueSearch(arr, mid + 1, right, findVal);
		} else if (findVal < midVal) { // 说明应该向右边递归
			return insertValueSearch(arr, left, mid - 1, findVal);
		}else{
			return mid;
		}
	}

}



















