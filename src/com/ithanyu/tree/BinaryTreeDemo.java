package com.ithanyu.tree;

public class BinaryTreeDemo {

	public static void main(String[] args) {
		// 先需要创建一块二叉树
		BinaryTree binaryTree = new BinaryTree();
		// 创建需要的节点
		HeroNode node1 = new HeroNode(1, "宋江");
		HeroNode node2 = new HeroNode(2, "吴用");
		HeroNode node3 = new HeroNode(3, "卢俊义");
		HeroNode node4 = new HeroNode(4, "林冲");
	}

}

// 定义 BinaryTree 二叉树
class BinaryTree{
	private HeroNode root;

	public void setRoot(HeroNode root) {
		this.root = root;
	}
	
	// 前序遍历
	public void preOrder(){
		if (this.root != null) {
			this.root.postOrder();
		}else{
			System.out.println("二叉树为空，无法遍历");
		}
	}
	
	// 中序遍历
	public void infixOrder(){
		if (this.root != null) {
			this.root.infixOrder();
		}else{
			System.out.println("二叉树为空，无法遍历");
		}
	}
	// 后序遍历
	public void postOrder(){
		if (this.root != null) {
			this.root.postOrder();
		}else{
			System.out.println("二叉树为空，无法遍历");
		}
	}
	
}

// 先创建 HeroNode 节点
class HeroNode{
	private int no;
	private String name;
	private HeroNode left; // 默认null
	private HeroNode right; // 默认null
	public HeroNode(int no, String name) {
		this.no = no;
		this.name = name;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public HeroNode getLeft() {
		return left;
	}
	public void setLeft(HeroNode left) {
		this.left = left;
	}
	public HeroNode getRight() {
		return right;
	}
	public void setRight(HeroNode right) {
		this.right = right;
	}
	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + "]";
	}
	// 编写前序遍历的方法
	public void preOrder(){
		System.out.println(this);// 先输出父节点
		// 递归向左子树前序遍历
		if (this.left != null) {
			this.left.preOrder();
		}
		// 递归向右子树前序遍历
		if (this.right != null) {
			this.right.preOrder();
		}
	}
	// 中序遍历
	public void infixOrder(){
		// 递归向左子树遍历
		if (this.left != null) {
			this.left.infixOrder();
		}
		// 输出当前节点
		System.out.println(this);
		if (this.right != null) {
			this.right.infixOrder();
		}
	}
	// 后续遍历
	public void postOrder(){
		// 递归向左子树遍历
		if (this.left != null) {
			this.left.postOrder();
		}
		if (this.right != null) {
			this.right.postOrder();
		}
		// 输出当前节点
		System.out.println(this);
	}
	
}















