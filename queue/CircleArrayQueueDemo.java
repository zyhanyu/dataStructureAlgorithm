package com.ithanyu.queue;

import java.awt.Font;
import java.util.Scanner;

public class CircleArrayQueueDemo {

	public static void main(String[] args) {
		// ����
				// ����һ������
				CircleArray queue = new CircleArray(4);// ˵������4������е���Ч���������3
				char key = ' '; // �����û�����
				Scanner scanner = new Scanner(System.in);
				boolean loop = true;
				// ���һ���˵�
				while(loop) {
					System.out.println("s(show): ��ʾ����");
					System.out.println("e(exit): �˳�����");
					System.out.println("a(add): ������ݵ�����");
					System.out.println("g(get): �Ӷ���ȡ������");
					System.out.println("h(head): �鿴����ͷ������");
					key = scanner.next().charAt(0);//����һ���ַ�
					switch(key){
						case 's':
							queue.showQueue();
							break;
						case 'a':
							System.out.println("����һ����");
							int value = scanner.nextInt();
							queue.addQueue(value);
							break;
						case 'g':
							try {
								int res = queue.getQueue();
								System.out.printf("ȡ����������%d\n",res);
							} catch (Exception e) {
								// TODO: handle exception
								System.out.println(e.getMessage());
							}
							break;
						case 'h': // �鿴����ͷ������
							try {
								int res = queue.headQueue();
								System.out.printf("����ͷ��������%d\n",res);
							} catch (Exception e) {
								// TODO: handle exception
								System.out.println(e.getMessage());
							}
							break;
						case 'e':// �˳�
							scanner.close();
							loop = false;
							break;
					}
				}
				System.out.println("�����˳���~");

	}

}

class CircleArray{

	private int maxSize; // ��ʾ������������
	// front �����ĺ�����һ��������front ��ָ����еĵ�һ��Ԫ�أ�Ҳ����˵ arr[front]
	// front �ĳ�ʼֵΪ0
	private int front; // ����ͷ
	private int rear; // ����β
	private int[] arr; // ���������ڴ�����ݣ�ģ�����
	
	// �������еĹ�����
	public CircleArray(int arrMaxSize){
		maxSize = arrMaxSize;
		arr = new int[maxSize];
		
		
	}
	
	// �ж϶����Ƿ���
	public boolean isFull(){
		return (rear + 1) % maxSize == front;
	}
	
	// �ж϶����Ƿ�Ϊ��
	public boolean isEmpty(){
		return rear == front;
	}
	
	// ������ݵ�����
	public void addQueue(int n){
		// �ж϶����Ƿ���
		if (isFull()) {
			System.out.println("�����������ܼ�������~");
			return;
		}
		// ֱ�ӽ����ݼ���
		arr[rear] = n;
		// ��rear����,������뿼��ȡģ
		rear = (rear + 1) % maxSize;
	}
	
	// ��ȡ���е����ݣ�������
	public int getQueue(){
		// �ж϶����Ƿ�Ϊ��
		if(isEmpty()){
			// ͨ���׳��쳣
			throw new RuntimeException("���пգ�����ȡ����");
		}
		// ������Ҫ������ front��ָ����еĵ�һ��Ԫ��
		// 1. �Ȱ� front ��Ӧ��ֵ���浽һ����ʱ�ı���
		// 2. �� front ���� ����ȡģ
		// 3. ����ʱ����ı�������
		int value = arr[front];
		front = (front + 1) % maxSize;
		return value;
	}
	// ��ʾ���е���������
	public void showQueue() {
		// ����
		if (isEmpty()) {
			System.out.println("���пյģ�û������~~");
			return;
		}
		// ˼·����front��ʼ�������������ٸ�Ԫ��
		for (int i = front; i < front + size(); i++) {
			System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
		}
		
	}
	// �����ǰ������Ч���ݵĸ���
	public int size(){
		// read = 1
		// front = 0
		// maxSize = 3
		return (rear + maxSize - front) % maxSize;
	}
	// ��ʾ���е�ͷ���ݣ�ע�ⲻ��ȡ������
	public int headQueue (){
		// �ж�
		if (isEmpty()) {
			System.out.println("���пյģ�û������~~");
			throw new RuntimeException("����Ϊ�յģ�û������");
		}
		return arr[front];
	}
	
}
