package com.ithanyu.linkedlist;

import java.util.zip.CRC32;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Josepfu {

	public static void main(String[] args) {
		// ����һ�ѿ����������������ͱ���Ƿ�ok
		CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
		circleSingleLinkedList.addBoy(25);
		circleSingleLinkedList.showBoy();
		System.out.println("==================");
		// ����С����Ȧ�Ƿ���ȷ
		circleSingleLinkedList.countBoy(1, 2, 25);
	}

}

// ����һ�����εĵ�������
class CircleSingleLinkedList{
	// ����һ��first�ڵ㣬��ǰû�б��
	private Boy first = null;
	// ���С���ڵ㣬������һ����������
	public void addBoy(int nums){
		// nums ��һ������У��
		if (nums < 1) {
			System.out.println("nums��ֵ����ȷ");
			return;
		}
		Boy curBoy = null; // ����ָ�룬����������������
		// ʹ��for���������ǵĻ�������
		for(int i = 1;i <= nums; i++){
			// ���ݱ�ţ�����С���ڵ�
			Boy boy = new Boy(i);
			// ����ǵ�һ��С��
			if (i == 1) {
				first = boy;
				first.setNext(first);// ����һ����
				curBoy = first; // ��curBoyָ���һ��С��
			}else{
				curBoy.setNext(boy);
				boy.setNext(first);
				curBoy = boy;
			}
		}
		
		
	}
	public void showBoy(){
		// �ж������Ƿ�Ϊ��
		if (first == null) {
			System.out.println("û���κ�С��~~");
			return;
		}else{
			// ��Ϊ first ���ܶ������������Ȼʹ��һ������ָ����ɱ���
			Boy curBoy = first;
			while(true){
				System.out.printf("С���ı��Ϊ %d \n",curBoy.getNo());
				if (curBoy.getNext() == first) {// ˵���Ѿ��������
					break;
				}
				curBoy=curBoy.getNext(); // curBoy����
			}
		}

	}

	// �����û������룬�����С����Ȧ��˳��
	/**
	 * 
	 * @param startNo ��ʾ�ӵڼ���С����ʼ����
	 * @param countNum ��ʾ������
	 * @param sums ��ʾ����ж���С����Ȧ��
	 */
	public void countBoy(int startNo,int countNum,int nums){
		// �ȶ����ݽ���У��
		if (first == null || startNo < 1 || startNo > nums) {
			System.out.println("����������������������");
			return;
		}
		// ����һ������ָ�룬�������С����Ȧ
		Boy helper = first;
		// ���󴴽�һ������ָ�루������helper,ʵ��Ӧ��ָ����������������ڵ�
		while(true){
			if (helper.getNext() == first) { // ˵��helperָ�����С���ڵ�
				break;
			}
			helper = helper.getNext();
		}
			// С������ǰ������ first �� helper һ�� k -1��
			for(int j = 0;j<startNo - 1;j++){
				first = first.getNext();
				helper = helper.getNext();
			}
			// ��С������ʱ����first �� helper ָ��ͬʱ �ƶ� m - 1�Σ�Ȼ���Ȧ
			// ������һ��ѭ��������֪��Ȧ��ֻ��һ���ڵ�
			while(true){
				if (helper == first) { // ˵��Ȧ��ֻ��һ���ڵ�
					break;
				}
				// �� first �� helper ָ��ͬʱ ���ƶ� countNum -1
				for (int j = 0; j < countNum - 1; j++) {
					first = first.getNext();
					helper = helper.getNext();
				}
				// ��ʱfirst ָ��Ľڵ㣬Ҫ�ǳ�Ȧ��С���ڵ�
				System.out.printf("С�� %d ��Ȧ\n",first.getNo());
				// ���ǽ�firstָ���С���ڵ��Ȧ
				first = first.getNext();
				helper.setNext(first);
			}
			System.out.printf("�������԰��С�����%d \n",first.getNo());
		}
}

// ����һ��Boy�࣬��ʾһ���ڵ�
class Boy{
	private int no;
	private Boy next; // ָ����һ���ڵ㣬Ĭ��null
	public Boy(int no){
		this.no = no;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public Boy getNext() {
		return next;
	}
	public void setNext(Boy next) {
		this.next = next;
	}
	
}











