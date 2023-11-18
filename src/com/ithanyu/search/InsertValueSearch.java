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
	 * ��д��ֵ�����㷨,ҲҪ�������������
	 * @param arr ����
	 * @param left �������
	 * @param right �ұ�����
	 * @param findVal ����ֵ
	 * @return ����ҵ������ض�Ӧ�±꣬û���ҵ�������-1
	 */
	public static int insertValueSearch(int[] arr,int left,int right,int findVal){
		System.out.println("HelloWorld");
		// ע�⣺findVal < arr[0] || findVal > arr[arr.length - 1] 
		// ������Ҫ ����mid ����Խ��
		if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
			return -1;
		}
		// ���mid
		int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
		int midVal = arr[mid];
		if (findVal > midVal) { // ˵��Ӧ�����ұߵݹ�
			return insertValueSearch(arr, mid + 1, right, findVal);
		} else if (findVal < midVal) { // ˵��Ӧ�����ұߵݹ�
			return insertValueSearch(arr, left, mid - 1, findVal);
		}else{
			return mid;
		}
	}

}



















