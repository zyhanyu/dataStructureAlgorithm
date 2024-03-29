package com.ithanyu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class RadixSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[80000];
		for (int i = 0; i < 80000; i++) {
			arr[i] = (int)(Math.random() * 8000000);//生成一个[0, 8000000] 数
		}
		
		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(data1);
		System.out.println("排序前的时间时=" + date1Str);
		radixSort(arr);
		
		Date data2 = new Date();
		String date2Str = simpleDateFormat.format(data2);
		System.out.println("排序后的时间时=" + date2Str);
	}
	
	// 基数排序方法
	public static void radixSort(int[] arr){
		// 1. 得到数据中最大的数的位数
		int max = arr[0]; // 假设第一数就是最大的
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
			
		}
		// 得到最大数是几位数
		int maxLength = (max + "").length();
		
		// 第一轮(针对每个元素的个位进行排序处理)
		
		// 定义一个二维数组，表示10个桶，每个桶就是一个一维数组
		// 说明
		// 1. 二维数组包含10个一位数组
		// 2. 为了防止在放入数的时候，数据溢出，则每个一维数组（桶），大小定义位arr.length
		// 3. 明确，基数排序
		int[][] bucket = new int[10][arr.length];
		
		// 为了记录每个桶中，实际存放了多少个数据，我们定义一个一维数组在记录各个桶每次放入的数据个数
		// bucketElementCounts[0],记录的就是 bucket[0] 桶的放入数据个数
		int[] bucketElementCounts = new int[10];
		
		// 这里我们使用循环将代码处理
		for (int i = 0,n = 1; i < maxLength; i++,n *= 10) {
			// 针对每个元素的对应位进行排序处理），第一位是个位,第二位十位，三位百位
			for(int j = 0; j < arr.length; j++){
				// 取出每个元素的个数
				int digitOfElement = arr [j] / n % 10;
				// 放到对应的桶中
				bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
				bucketElementCounts[digitOfElement]++;
			}
			// 按照这个桶的顺序(一维数组的下标依次取出数据，让人原来数组)
			int index = 0;
			// 遍历每一桶，并将桶中的数据，放入到原数组
			for(int k = 0;k < bucketElementCounts.length;k++){
				// 如果桶中，有数据，我们才放入到原数组
				if (bucketElementCounts[k] != 0) {
					// 循环该桶即将k个桶（即第k个一维数组）,放入
					for(int l = 0; l< bucketElementCounts[k];l++){
						// 取出元素放入到arr
						arr[index++] = bucket[k][l];
					}
					
				}
				// 第一轮处理后，需要将每个bucketElementCounts[k] = 0 !!!
				bucketElementCounts[k] = 0;
			}
			// System.out.println("第"+(i+1)+"论，对个位的排序 arr = "+Arrays.toString(arr));
		}
//		
//		for(int j = 0; j < arr.length; j++){
//			// 取出每个元素的个数
//			int digitOfElement = arr[j] / 10 % 10;
//			// 放到对应的桶中
//			bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
//			bucketElementCounts[digitOfElement]++;
//		}
//		// 按照这个桶的顺序(一维数组的下标依次取出数据，让人原来数组)
//		 index = 0;
//		// 遍历每一桶，并将桶中的数据，放入到原数组
//		for(int k = 0;k < bucketElementCounts.length;k++){
//			// 如果桶中，有数据，我们才放入到原数组
//			if (bucketElementCounts[k] != 0) {
//				// 循环该桶即将k个桶（即第k个一维数组）,放入
//				for(int l = 0; l< bucketElementCounts[k];l++){
//					// 取出元素放入到arr
//					arr[index++] = bucket[k][l];
//				}
//				
//			}
//			// 第一轮处理后，需要将每个bucketElementCounts[k] = 0 !!!
//			// bucketElementCounts[k] = 0;
//		}
//		System.out.println("第2论，对个位的排序 arr = "+Arrays.toString(arr));
//		
//		
	}

}














