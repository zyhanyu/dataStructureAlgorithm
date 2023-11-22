package com.ithanyu.tree;

public class BinaryTreeDemo {

	public static void main(String[] args) {
		// ����Ҫ����һ�������
		BinaryTree binaryTree = new BinaryTree();
		// ������Ҫ�Ľڵ�
		HeroNode node1 = new HeroNode(1, "�ν�");
		HeroNode node2 = new HeroNode(2, "����");
		HeroNode node3 = new HeroNode(3, "¬����");
		HeroNode node4 = new HeroNode(4, "�ֳ�");
	}

}

// ���� BinaryTree ������
class BinaryTree{
	private HeroNode root;

	public void setRoot(HeroNode root) {
		this.root = root;
	}
	
	// ǰ�����
	public void preOrder(){
		if (this.root != null) {
			this.root.postOrder();
		}else{
			System.out.println("������Ϊ�գ��޷�����");
		}
	}
	
	// �������
	public void infixOrder(){
		if (this.root != null) {
			this.root.infixOrder();
		}else{
			System.out.println("������Ϊ�գ��޷�����");
		}
	}
	// �������
	public void postOrder(){
		if (this.root != null) {
			this.root.postOrder();
		}else{
			System.out.println("������Ϊ�գ��޷�����");
		}
	}
	
}

// �ȴ��� HeroNode �ڵ�
class HeroNode{
	private int no;
	private String name;
	private HeroNode left; // Ĭ��null
	private HeroNode right; // Ĭ��null
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
	// ��дǰ������ķ���
	public void preOrder(){
		System.out.println(this);// ��������ڵ�
		// �ݹ���������ǰ�����
		if (this.left != null) {
			this.left.preOrder();
		}
		// �ݹ���������ǰ�����
		if (this.right != null) {
			this.right.preOrder();
		}
	}
	// �������
	public void infixOrder(){
		// �ݹ�������������
		if (this.left != null) {
			this.left.infixOrder();
		}
		// �����ǰ�ڵ�
		System.out.println(this);
		if (this.right != null) {
			this.right.infixOrder();
		}
	}
	// ��������
	public void postOrder(){
		// �ݹ�������������
		if (this.left != null) {
			this.left.postOrder();
		}
		if (this.right != null) {
			this.right.postOrder();
		}
		// �����ǰ�ڵ�
		System.out.println(this);
	}
	
}















