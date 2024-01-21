package com.ithanyu.sort;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.xml.crypto.Data;

public class BubbleSort {

	public static void main(String[] args) {
		
		
		// int arr[] = {3,9,-1,10,20};
		
		
		
		// 测试一下冒泡排序的速度O(n^2),给80000个数据，测试
		// 创建要给80000个的随机的数组
		int[] arr = new int[80000];
		for (int i = 0; i < 80000; i++) {
			arr[i] = (int)(Math.random() * 8000000);//生成一个[0, 8000000] 数
		}
		
		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(data1);
		System.out.println("排序前的时间时=" + date1Str);
		
		
		// 测试冒泡排序
		bulleSort(arr);
		
		Date data2 = new Date();
		String date2Str = simpleDateFormat.format(data2);
		System.out.println("排序后的时间时=" + date2Str);
		
		// System.out.println("排序后");
		// System.out.println(Arrays.toString(arr));
	}
	
	// 将前面冒泡排序算法，封装成一个方法
	public static void bulleSort(int[] arr){
		int temp = 0; // 临时变量
		boolean flag = false;// 标识变量，表示是否进行过交换
		for (int j = 0; j < arr.length-1; j++) {
			for (int i = 0; i < arr.length - 1-j; i++) {
				// 如果前面的数比后面的数大，则交换
				if (arr[i] > arr[i+1]) {
					flag = true;
					temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i+1] = temp;
				}
			}
			// System.out.println("第"+(j+1)+"这排序后的数组");
			// System.out.println(Arrays.toString(arr));
			if (!flag) { // 在一趟排序中，一次交换都没发生过
				break;
			}else{
				flag = false; // 重置flag，进行下次判断
			}
		}
	}

}











