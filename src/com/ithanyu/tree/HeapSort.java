package com.ithanyu.tree;

import java.lang.reflect.Array;
import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		// 要求将数组进行升序排序
		int arr[] = {4,6,8,5,9,1,90,89,56,-899};
		heapSort(arr);
	}
	
	// 编写一个堆排序的方法
	public static void heapSort(int arr[]){
		int temp = 0;
		System.out.println("堆排序！！");
		// 分步完成
		// adjustHeap(arr,1,arr.length);
		// System.out.println("第一次"+Arrays.toString(arr)); // [4, 9, 8, 5, 6]

		// adjustHeap(arr,0,arr.length);
		// System.out.println("第一次"+Arrays.toString(arr)); // [9, 6, 8, 5, 4]
	    // 1.将无序序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆
		for(int i = arr.length / 2 -1 ;i>=0;i--){
			adjustHeap(arr, i, arr.length);
			
		}
		// 2. 将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端；
		// 3. 重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复指向调整+交替步骤，直到真个序列有序。
		for(int j = arr.length-1;j>0;j--){
			// 交换
			temp = arr[j];
			arr[j] = arr[0];
			arr[0] = temp;
			adjustHeap(arr, 0, j);
		}
		System.out.println("数组="+Arrays.toString(arr)); // [9, 6, 8, 5, 4]
	}
	
	// 将一个数组（二叉树），调整成一个大顶堆
	/**
	 * 功能：完成 将 以 i 对应的非叶子节点的树调整成大顶堆
	 * @param arr 待调整的数组
	 * @param i 表示非叶子节点在数组中索引
	 * @param length 表示对多少个元素进行调整，length 在逐渐的减少
	 */
	public static void  adjustHeap(int arr[],int i,int length){
		int temp = arr[i]; // 先取出当前元素的值，保存在临时变量
		// 开始调整
		// 说明
		// 1. k = i * 2 + 1 k 是i节点的左子节点
		for(int k = i * 2+1;k<length;k = k*2+1){
			if(k+1 < length && arr[k] < arr[k+1]){ // 说明左子节点的值小于右子节点的值
				k++; // k 指向右子节点
			}
			if (arr[k] > temp) { // 如果子节点大于父节点
				arr[i] = arr[k]; // 把较大的值赋给当前节点
				i = k; // i 指向 k，继续循环比较
			} else {
				break;
			}
		}
		// 当 for 循环结束后，我们已经将以i 为父节点的树的最大值，放在了 最顶（局部）
		arr[i] = temp;// 将temp值放到调整后的位置
	} 

}









