package stack;

import java.util.Arrays;

public class SelectSort {
	public static void mian(String[] args){
		// TODO Auto-generated method stub
		int[] arr = {101, 34, 119, 1};
		selectSort(arr);
	}
	
	// ѡ������
	public static void selectSort(int[] arr){
		int minIndex = 0;
		int min = arr[0];
		for (int j = 0; j < arr.length; j++) {
			if (min > arr[j]) { // ˵���ٶ�����Сֵ����������С
				min = arr[j]; // ����min
				minIndex = j; // ����minIndex
			}
		}
		
		// ����Сֵ������arr[0],������
		arr[minIndex] = arr[0];
		arr[0] = min;
		
		System.out.println("��һ�ֺ�~");
		System.out.println(Arrays.toString(arr));
	}
}


















