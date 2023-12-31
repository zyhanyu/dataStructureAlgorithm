package com.ithanyu.sparsearray;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.security.acl.Owner;

public class SparseArray {

	public static void main(String[] args) {
		// 创建一个原始的二维数组 11 * 11
		// 0：表示没有棋子，1：表示黑子，2：表示篮子
		int chessArr1[][] = new int[11][11];
		chessArr1[1][2] = 1;
		chessArr1[2][3] = 2;
		chessArr1[4][5] = 2;
		System.out.println("原始的二维数组~~");
		// 输出原始的二维数组
		for(int[] row : chessArr1){
			for(int data: row){
				System.out.printf("%d\t",data);
			}
			System.out.println();
		}
		
		// 将二维数组 转 希蔬数组的思想
		// 1.先遍历二维数组 得到非零的数组的个数
		int sum = 0;
		for(int i = 0;i < 11;i++){
			for (int j = 0; j < 11; j++) {
				if (chessArr1[i][j] != 0) {
					sum++;
				}
			}
		}
		System.out.println("sum:" + sum);
		// 2. 创建对应的稀疏数组
		int sparseArr[][] = new int[sum +1][3];
		// 给稀疏数组赋值
		sparseArr[0][0] = 11;
		sparseArr[0][1] = 11;
		sparseArr[0][2] = sum;
		// 遍历二维数组，将非0的值存放到 sparseArr 中
		int count = 0 ;
		for(int i = 0;i < 11;i++){
			for (int j = 0; j < 11; j++) {
				if (chessArr1[i][j] != 0) {
					count++;
					sparseArr[count][0] = i;
					sparseArr[count][1] = j;
					sparseArr[count][2] = chessArr1[i][j];
				}
			}
		}
		
		// 写入磁盘中
		try {
			OutputStreamWriter ow = new OutputStreamWriter(new FileOutputStream("./map.data"));
//			ow.write(sparseArr);
//			ow.flush();
			ow.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		// 从磁盘读出
		try {
			InputStreamReader ir = new InputStreamReader(new FileInputStream("./map.data"));


			ir.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

		
		// 输出稀疏数组的形式
		System.out.println();
		System.out.println("得到稀疏数组为~~~");
		for (int i = 0; i < sparseArr.length; i++) {
			System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
		}
		System.out.println();
		
		
		
		//将稀疏数组 --》恢复成 原始的二维数组
		// 1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组，比如上面的 chessArr2 = int[11][11]
		// 2. 在读取稀疏数组后几行的数据，并赋给 原始的二维数组 即可
		
		// 1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
		
		int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
		
		// 2. 在读取稀疏数组后几行的数据(第二行开始)，并赋给 原始的二维数组 即可

		for (int i = 1; i < sparseArr.length; i++) {
			chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
		}
		;
		// 输入恢复后的二维数组
		System.out.println();
		System.out.println("恢复后的二维数组");
		for(int[] row:chessArr2){
			for (int data:row) {
				System.out.printf("%d\t",data);
			}
			System.out.println();
		}
		//四、将稀疏数组保存到磁盘上，如map.data
				try {
					System.out.println("将稀疏数组保存到磁盘并命名为map.data");
					File f = new File("E:/java/DataStructures/src/com/ithanyu/sparsearray/map.txt");
					FileOutputStream fos = new FileOutputStream(f);
					OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
					System.out.println("写入中----------");
					for(int i = 0; i < sparseArr.length; i++) {
						osw.write(sparseArr[i][0] + "," + sparseArr[i][1] + "," + sparseArr[i][2] + ",");
					}
					osw.flush();
					osw.close();//关闭输出流
					fos.close();//关闭输出流
					System.out.println("写入磁盘成功");
					//读取磁盘中的map.data文件
					System.out.println("读取中----------");
					FileInputStream fis = new FileInputStream(f);
					InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
					StringBuffer sb = new StringBuffer();
					while(isr.ready()) {
						sb.append((char)isr.read());
					}
					isr.close();//关闭输入流
					fis.close();//关闭输入流
					System.out.println("读取成功");
					String ss = sb.toString();
					String[] sb1 = sb.toString().split(",");
					System.out.printf("从磁盘读取的字符串为：\n%s\n", ss);//格式化输出
					//恢复稀疏数组
					int sum1 = 0;
					int[][] sparseArr1 = new int[sb1.length/3][3];
					sparseArr1[0][0] = Integer.parseInt(sb1[0]);
					sparseArr1[0][1] = Integer.parseInt(sb1[1]);
					sparseArr1[0][2] = Integer.parseInt(sb1[2]);
					for(int i = 3; i < sb1.length; i += 3) {
						sum1++;
						sparseArr1[sum1][0] = Integer.parseInt(sb1[i]);
						sparseArr1[sum1][1] = Integer.parseInt(sb1[i+1]);
						sparseArr1[sum1][2] = Integer.parseInt(sb1[i+2]);
					}
					System.out.println("还原后的稀疏数组为：");
					for(int i = 0; i < sparseArr1.length; i++) {
						System.out.printf("%d\t%d\t%d\n", sparseArr1[i][0], sparseArr1[i][1], sparseArr1[i][2]);
					}
					//恢复原始二维数组
					int[][] chessArr3 = new int[sparseArr1[0][0]][sparseArr1[0][1]];
					for(int i = 1; i < sparseArr1.length; i++) {
						chessArr3[sparseArr1[i][0]][sparseArr1[i][1]] = sparseArr1[i][2];
					}
					System.out.println("还原后的二维数组为:");
					for(int[] a : chessArr3) {
						for(int b : a) {
							System.out.printf("%d\t", b);
						}
						System.out.println();
					}
				}catch(IOException e) {
					e.printStackTrace();
				}
		
	}
	
	
	

}
