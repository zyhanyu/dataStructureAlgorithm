package com.ithanyu.search;

import java.util.List;
import java.util.ArrayList;

// ע�⣺ʹ�ö��ֲ��ҵ�ǰ���� ������������ġ�
public class BinarySearch {

	public static void main(String[] args) {
		int arr[] = {1,8,10,89,1000,1000,1000,1234};
		// int resIndex =  binarySearch(arr, 0, arr.length - 1, 88);
		List<Integer> resIndexList =  binarySearch2(arr, 0, arr.length - 1, 1000);
		System.out.println("resIndexList="+resIndexList);
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

	
	/**
	 * ���ֲ����㷨���ض���±�
	 * ˼·����
	 * 1. ���ҵ� mid ����ֵ����Ҫ���Ϸ���
	 * 2. ��mid ����ֵ�����ɨ�裬���������� 1000����Ԫ�ص��±꣬���뵽ArrayList
	 * 3. ��mid ����ֵ���ұ�ɨ�裬���������� 1000����Ԫ�ص��±꣬���뵽ArrayList
	 * 4. ��ArrayList����
	 * @param arr ����
	 * @param left ��ߵ�����
	 * @param right �ұߵ�����
	 * @param findVal Ҫ���ҵ�ֵ
	 * @return �ҵ��ͷ����±꣬���û���ҵ����ͷ���-1
	 */
	public static ArrayList<Integer> binarySearch2(int[] arr,int left,int right,int findVal){
		// �� left > right �ǣ�����ݹ��������飬����û���ҵ�
		if (left > right) {
			return new ArrayList<Integer>();
		}
		int mid = (left + right) / 2;
		int midVal = arr[mid];
		if (findVal > midVal) { // ���ҵݹ�
			return binarySearch2(arr,mid+1,right,findVal);
		} else if (findVal < midVal) { // ����ݹ�
			return binarySearch2(arr,left,mid-1,findVal);
		}else{

			// ˼·����
			// 1. ���ҵ� mid ����ֵ����Ҫ���Ϸ���
			// 2. ��mid ����ֵ�����ɨ�裬���������� 1000����Ԫ�ص��±꣬���뵽ArrayList
			// 3. ��mid ����ֵ���ұ�ɨ�裬���������� 1000����Ԫ�ص��±꣬���뵽ArrayList
			// 4. ��ArrayList����
			ArrayList<Integer> resIndexList = new ArrayList<Integer>();
			// 2. ��mid ����ֵ�����ɨ�裬���������� 1000����Ԫ�ص��±꣬���뵽ArrayList
			int temp = mid - 1;
			while(true){
				if (temp < 0 || arr[temp] != findVal) {
					break;
				}
				resIndexList.add(temp);
				temp -= 1; // temp����
			}
			resIndexList.add(mid);
			// 3. ��mid ����ֵ���ұ�ɨ�裬���������� 1000����Ԫ�ص��±꣬���뵽ArrayList
			temp = mid + 1;
			while(true){
				if (temp > arr.length - 1 || arr[temp] != findVal) {
					break;
				}
				resIndexList.add(temp);
				temp += 1; // temp����
			}
			return resIndexList;
		}
	}

}

























