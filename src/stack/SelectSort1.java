package stack;

import java.util.Arrays;

public class SelectSort1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {101, 34, 119, 1,-1,90,123};
		System.out.println("排序前");
		System.out.println(Arrays.toString(arr));
		
		selectSort(arr);

		System.out.println("排序后");
		System.out.println(Arrays.toString(arr));
		

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
