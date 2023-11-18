package com.ithanyu.search;

import java.util.List;
import java.util.ArrayList;

// 注意：使用二分查找的前提是 该数组是有序的。
public class BinarySearch {

	public static void main(String[] args) {
		int arr[] = {1,8,10,89,1000,1000,1000,1234};
		// int resIndex =  binarySearch(arr, 0, arr.length - 1, 88);
		List<Integer> resIndexList =  binarySearch2(arr, 0, arr.length - 1, 1000);
		System.out.println("resIndexList="+resIndexList);
	}
	
	/**
	 * 二分查找算法
	 * @param arr 数组
	 * @param left 左边的索引
	 * @param right 右边的索引
	 * @param findVal 要查找的值
	 * @return 找到就返回下标，如果没有找到，就返回-1
	 */
	public static int binarySearch(int[] arr,int left,int right,int findVal){
		// 当 left > right 是，是吗递归整个数组，电视没有找到
		if (left > right) {
			return -1;
		}
		int mid = (left + right) / 2;
		int midVal = arr[mid];
		if (findVal > midVal) { // 向右递归
			return binarySearch(arr,mid+1,right,findVal);
		} else if (findVal < midVal) { // 向左递归
			return binarySearch(arr,left,mid-1,findVal);
		}else{
			return mid;
		}
	}

	
	/**
	 * 二分查找算法返回多个下标
	 * 思路分析
	 * 1. 在找到 mid 索引值，不要马上返回
	 * 2. 向mid 索引值的左边扫描，将索引满足 1000，的元素的下标，加入到ArrayList
	 * 3. 向mid 索引值的右边扫描，将索引满足 1000，的元素的下标，加入到ArrayList
	 * 4. 将ArrayList返回
	 * @param arr 数组
	 * @param left 左边的索引
	 * @param right 右边的索引
	 * @param findVal 要查找的值
	 * @return 找到就返回下标，如果没有找到，就返回-1
	 */
	public static ArrayList<Integer> binarySearch2(int[] arr,int left,int right,int findVal){
		// 当 left > right 是，是吗递归整个数组，电视没有找到
		if (left > right) {
			return new ArrayList<Integer>();
		}
		int mid = (left + right) / 2;
		int midVal = arr[mid];
		if (findVal > midVal) { // 向右递归
			return binarySearch2(arr,mid+1,right,findVal);
		} else if (findVal < midVal) { // 向左递归
			return binarySearch2(arr,left,mid-1,findVal);
		}else{

			// 思路分析
			// 1. 在找到 mid 索引值，不要马上返回
			// 2. 向mid 索引值的左边扫描，将索引满足 1000，的元素的下标，加入到ArrayList
			// 3. 向mid 索引值的右边扫描，将索引满足 1000，的元素的下标，加入到ArrayList
			// 4. 将ArrayList返回
			ArrayList<Integer> resIndexList = new ArrayList<Integer>();
			// 2. 向mid 索引值的左边扫描，将索引满足 1000，的元素的下标，加入到ArrayList
			int temp = mid - 1;
			while(true){
				if (temp < 0 || arr[temp] != findVal) {
					break;
				}
				resIndexList.add(temp);
				temp -= 1; // temp左移
			}
			resIndexList.add(mid);
			// 3. 向mid 索引值的右边扫描，将索引满足 1000，的元素的下标，加入到ArrayList
			temp = mid + 1;
			while(true){
				if (temp > arr.length - 1 || arr[temp] != findVal) {
					break;
				}
				resIndexList.add(temp);
				temp += 1; // temp左移
			}
			return resIndexList;
		}
	}

}

























