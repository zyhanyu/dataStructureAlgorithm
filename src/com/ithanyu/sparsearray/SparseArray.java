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
		// ����һ��ԭʼ�Ķ�ά���� 11 * 11
		// 0����ʾû�����ӣ�1����ʾ���ӣ�2����ʾ����
		int chessArr1[][] = new int[11][11];
		chessArr1[1][2] = 1;
		chessArr1[2][3] = 2;
		chessArr1[4][5] = 2;
		System.out.println("ԭʼ�Ķ�ά����~~");
		// ���ԭʼ�Ķ�ά����
		for(int[] row : chessArr1){
			for(int data: row){
				System.out.printf("%d\t",data);
			}
			System.out.println();
		}
		
		// ����ά���� ת ϣ�������˼��
		// 1.�ȱ�����ά���� �õ����������ĸ���
		int sum = 0;
		for(int i = 0;i < 11;i++){
			for (int j = 0; j < 11; j++) {
				if (chessArr1[i][j] != 0) {
					sum++;
				}
			}
		}
		System.out.println("sum:" + sum);
		// 2. ������Ӧ��ϡ������
		int sparseArr[][] = new int[sum +1][3];
		// ��ϡ�����鸳ֵ
		sparseArr[0][0] = 11;
		sparseArr[0][1] = 11;
		sparseArr[0][2] = sum;
		// ������ά���飬����0��ֵ��ŵ� sparseArr ��
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
		
		// д�������
		try {
			OutputStreamWriter ow = new OutputStreamWriter(new FileOutputStream("./map.data"));
//			ow.write(sparseArr);
//			ow.flush();
			ow.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		// �Ӵ��̶���
		try {
			InputStreamReader ir = new InputStreamReader(new FileInputStream("./map.data"));


			ir.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

		
		// ���ϡ���������ʽ
		System.out.println();
		System.out.println("�õ�ϡ������Ϊ~~~");
		for (int i = 0; i < sparseArr.length; i++) {
			System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
		}
		System.out.println();
		
		
		
		//��ϡ������ --���ָ��� ԭʼ�Ķ�ά����
		// 1. �ȶ�ȡϡ������ĵ�һ�У����ݵ�һ�е����ݣ�����ԭʼ�Ķ�ά���飬��������� chessArr2 = int[11][11]
		// 2. �ڶ�ȡϡ��������е����ݣ������� ԭʼ�Ķ�ά���� ����
		
		// 1. �ȶ�ȡϡ������ĵ�һ�У����ݵ�һ�е����ݣ�����ԭʼ�Ķ�ά����
		
		int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
		
		// 2. �ڶ�ȡϡ��������е�����(�ڶ��п�ʼ)�������� ԭʼ�Ķ�ά���� ����

		for (int i = 1; i < sparseArr.length; i++) {
			chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
		}
		;
		// ����ָ���Ķ�ά����
		System.out.println();
		System.out.println("�ָ���Ķ�ά����");
		for(int[] row:chessArr2){
			for (int data:row) {
				System.out.printf("%d\t",data);
			}
			System.out.println();
		}
		//�ġ���ϡ�����鱣�浽�����ϣ���map.data
				try {
					System.out.println("��ϡ�����鱣�浽���̲�����Ϊmap.data");
					File f = new File("E:/java/DataStructures/src/com/ithanyu/sparsearray/map.txt");
					FileOutputStream fos = new FileOutputStream(f);
					OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
					System.out.println("д����----------");
					for(int i = 0; i < sparseArr.length; i++) {
						osw.write(sparseArr[i][0] + "," + sparseArr[i][1] + "," + sparseArr[i][2] + ",");
					}
					osw.flush();
					osw.close();//�ر������
					fos.close();//�ر������
					System.out.println("д����̳ɹ�");
					//��ȡ�����е�map.data�ļ�
					System.out.println("��ȡ��----------");
					FileInputStream fis = new FileInputStream(f);
					InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
					StringBuffer sb = new StringBuffer();
					while(isr.ready()) {
						sb.append((char)isr.read());
					}
					isr.close();//�ر�������
					fis.close();//�ر�������
					System.out.println("��ȡ�ɹ�");
					String ss = sb.toString();
					String[] sb1 = sb.toString().split(",");
					System.out.printf("�Ӵ��̶�ȡ���ַ���Ϊ��\n%s\n", ss);//��ʽ�����
					//�ָ�ϡ������
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
					System.out.println("��ԭ���ϡ������Ϊ��");
					for(int i = 0; i < sparseArr1.length; i++) {
						System.out.printf("%d\t%d\t%d\n", sparseArr1[i][0], sparseArr1[i][1], sparseArr1[i][2]);
					}
					//�ָ�ԭʼ��ά����
					int[][] chessArr3 = new int[sparseArr1[0][0]][sparseArr1[0][1]];
					for(int i = 1; i < sparseArr1.length; i++) {
						chessArr3[sparseArr1[i][0]][sparseArr1[i][1]] = sparseArr1[i][2];
					}
					System.out.println("��ԭ��Ķ�ά����Ϊ:");
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
