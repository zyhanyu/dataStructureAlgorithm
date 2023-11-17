package com.ithanyu.search;

public class SeqSarch {

	public static void main(String[] args) {
		int arr[] = {1,9,11,-1,34,89};
		int index = seqSearch(arr, 11);
		System.out.println(index);
	}
	
	/**
	 * 这里我们实现的线性查找是找到一个满足条件的值，就返回
	 * @param arr
	 * @param value
	 * @return
	 */
	public static int seqSearch(int[] arr,int value){
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == value) {
				return i ;
			}
		}
		return -1;
	}

}
