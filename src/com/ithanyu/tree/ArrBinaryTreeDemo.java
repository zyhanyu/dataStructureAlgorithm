package com.ithanyu.tree;

public class ArrBinaryTreeDemo {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7};
		ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
		arrBinaryTree.perOrder();
	}

}

// 编写一个ArrayByTree，实现顺序存储二叉树遍历
class ArrBinaryTree{
	private int[] arr;// 存储数据节点的数据

	public ArrBinaryTree(int[] arr) {
		this.arr = arr;
		// 创建一个ArrBinaryTree
		
	}

	// 重载preOrder
	public void perOrder(){
		this.perOrder(0);
	}
	
	
	// 编写一个方法，完成顺序存储二叉树的前序遍历
	/**
	 * 
	 * @param index 数组的下标
	 */
	public void perOrder(int index){
		// 如果数组为空，或者 arr.length = 0;
		if (arr == null || arr.length == 0) {
			System.out.println("数组为空不能按照二叉树的前序前序遍历");
		}
		// 输出当前这个元素
		System.out.println(arr[index]);
		// 向左递归遍历
		if ((2 * index +1) < arr.length) {
			perOrder( 2 * index +1);
		}
		// 向右递归遍历
		if ((2 * index + 2) < arr.length) {
			perOrder( 2 * index + 2);
		}
	}
	
}












