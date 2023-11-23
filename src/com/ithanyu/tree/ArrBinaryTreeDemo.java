package com.ithanyu.tree;

public class ArrBinaryTreeDemo {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7};
		ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
		arrBinaryTree.perOrder();
	}

}

// ��дһ��ArrayByTree��ʵ��˳��洢����������
class ArrBinaryTree{
	private int[] arr;// �洢���ݽڵ������

	public ArrBinaryTree(int[] arr) {
		this.arr = arr;
		// ����һ��ArrBinaryTree
		
	}

	// ����preOrder
	public void perOrder(){
		this.perOrder(0);
	}
	
	
	// ��дһ�����������˳��洢��������ǰ�����
	/**
	 * 
	 * @param index ������±�
	 */
	public void perOrder(int index){
		// �������Ϊ�գ����� arr.length = 0;
		if (arr == null || arr.length == 0) {
			System.out.println("����Ϊ�ղ��ܰ��ն�������ǰ��ǰ�����");
		}
		// �����ǰ���Ԫ��
		System.out.println(arr[index]);
		// ����ݹ����
		if ((2 * index +1) < arr.length) {
			perOrder( 2 * index +1);
		}
		// ���ҵݹ����
		if ((2 * index + 2) < arr.length) {
			perOrder( 2 * index + 2);
		}
	}
	
}












