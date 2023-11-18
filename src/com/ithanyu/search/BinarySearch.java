package com.ithanyu.search;

// ע�⣺ʹ�ö��ֲ��ҵ�ǰ���� ������������ġ�
public class BinarySearch {

	public static void main(String[] args) {
		int arr[] = {1,8,10,89,1000,1234};
		int resIndex =  binarySearch(arr, 0, arr.length - 1, 88);
		System.out.println("resIndex="+resIndex);
	}
	
	/**
	 * ���ֲ����㷨
	 * @param arr ����
	 * @param left ��ߵ�����
	 * @param right �ұߵ�����
	 * @param findVal Ҫ���ҵ�ֵ
	 * @return �ҵ��ͷ����±꣬���û���ҵ����ͷ���-1
	 */
	public static int binarySearch(int[] arr,int left,int right,int findVal){
		// �� left > right �ǣ�����ݹ��������飬����û���ҵ�
		if (left > right) {
			return -1;
		}
		int mid = (left + right) / 2;
		int midVal = arr[mid];
		if (findVal > midVal) { // ���ҵݹ�
			return binarySearch(arr,mid+1,right,findVal);
		} else if (findVal < midVal) { // ����ݹ�
			return binarySearch(arr,left,mid-1,findVal);
		}else{
			return mid;
		}
	}

}

























