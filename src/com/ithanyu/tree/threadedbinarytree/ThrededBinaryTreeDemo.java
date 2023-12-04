package com.ithanyu.tree.threadedbinarytree;

import com.atguigu.sort.test;

public class ThrededBinaryTreeDemo {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// ����һ�����������������Ĺ���
		HeroNode root = new HeroNode(1, "tom");
		HeroNode node2 = new HeroNode(3, "jack");
		HeroNode node3 = new HeroNode(6, "smith");
		HeroNode node4 = new HeroNode(8, "mary");
		HeroNode node5 = new HeroNode(10, "king");
		HeroNode node6 = new HeroNode(14, "dim");
		
		// ����������
		root.setLeft(node2);
		root.setRight(node3);
		node2.setLeft(node4);
		node2.setRight(node5);
		node3.setLeft(node6);
		
		ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
		threadedBinaryTree.setRoot(root);
		threadedBinaryTree.threadedNodes();
		
		// ���ԣ���10�Žڵ����
		HeroNode leftNode = node5.getLeft();
		HeroNode rightNode = node5.getRight();
		System.out.println("10�Žڵ��ǰ���ڵ��� = "+leftNode); // 3
		System.out.println("10�Žڵ�ĺ�̽ڵ��� = "+rightNode); // 1
		
		
	}

}


//���� ThreadedBinaryTree ʵ�������������ܵĶ�����
class ThreadedBinaryTree{
	private HeroNode root;
	
	// Ϊ��ʵ������������Ҫ����Ҫ��ָ��ǰ����ǰ���ڵ��ָ��
	// �ڵݹ����������ʱ��pre ���Ǳ���ǰһ���ڵ�
	private HeroNode pre = null;

	public void setRoot(HeroNode root) {
		this.root = root;
	}
	
	// ����threadedNodes����
	public void threadedNodes(){
		this.threadedNodes(root);
	}
	
	// ��д�Զ��������������������ķ���
	/**
	 * 
	 * @param node ���ǵ�ǰ��Ҫ�������Ľڵ�
	 */
	public void threadedNodes(HeroNode node){
		// ���node==null,����������
		if (node == null) {
			return;
		}
		
		// 1.��������������
		threadedNodes(node.getLeft());
		// 2.��������ǰ�ڵ�
		
		// ����ǰ����ǰ���ڵ�
		if (node.getLeft() == null) {
			// �õ�ǰ�ڵ����ָ��ָ��ǰ���ڵ�
			node.setLeft(pre);
			// �޸ĵ�ǰ�ڵ����ָ������ͣ�ָ��ǰ���ڵ�
			node.setLeftType(1);
		}
		
		// �����̽ڵ�
		if (pre != null && pre.getRight() == null) {
			// ��ǰ���ڵ����ָ����ǰ�ڵ�
			pre.setRight(node);
			// �޸�ǰ���ڵ����ָ������
			pre.setRightType(1);
		}
		
		// !!! ÿ����һ���ڵ���õ�ǰ�ڵ�����һ���ڵ��ǰ���ڵ�
		pre = node;
		
		
		// 3.��������������
		threadedNodes(node.getRight());
		
	}
	
	// ɾ���ڵ�
	public void delNode(int no){
		if (root != null) {
			// �������root һ���ڵ㣬�ж�root�ǲ���Ҫɾ���Ľڵ�
			if (root.getNo() == no) {
				root = null;
			}else{
				root.delNode(no);
			}
		}else{
			System.out.println("����һ����������ɾ��");
		}
	}
	
	// ǰ�����
	public void preOrder(){
		if (this.root != null) {
			this.root.preOrder();
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
	
	// ǰ�����
	public HeroNode preOrderSearch(int no){
		if (root != null) {
			return root.preOrderSearch(no);
		} else{
			return null;
		}
	}
	// �������
	public HeroNode infixOrderSearch(int no){
		if (root != null) {
			return root.infixOrderSearch(no);
		} else{
			return null;
		}
	}
	// �������
	public HeroNode postOrderSearch(int no){
		if (root != null) {
			return root.postOrderSearch(no);
		} else{
			return null;
		}
	}
	
}

// ����HeroNode
class HeroNode{
	private int no;
	private String name;
	private HeroNode left; // Ĭ��null
	private HeroNode right; // Ĭ��null
	// ˵��
	// 1. ���leftType == 0 ��ʾָ���������������� 1 ���ʾָ��ǰ���ڵ�
	// 2. ���rightType == 0 ��ʾָ���������������� 1 ��ʾָ���̽ڵ�
	private int leftType ;
	private int rightType;
	
	public int getLeftType() {
		return leftType;
	}
	public void setLeftType(int leftType) {
		this.leftType = leftType;
	}
	public int getRightType() {
		return rightType;
	}
	public void setRightType(int rightType) {
		this.rightType = rightType;
	}
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
	
	// �ݹ�ɾ���ڵ�
	// 1. ���ɾ���Ľڵ���Ҷ�ӽڵ㣬��ɾ���ýڵ�
	// 2. ���ɾ���Ľڵ��Ƿ�Ҷ�ӽڵ㣬��ɾ��������
	public void delNode(int no){
		if (this.left != null && this.left.no == no) {
			this.left = null;
			return;
		}
		if (this.right != null && this.right.no == no) {
			this.right = null;
			return;
		}
		if (this.left != null) {
			this.left.delNode(no);
		}
		if (this.right != null) {
			this.right.delNode(no);
		}
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
	// ǰ���������
	/**
	 * 
	 * @param no ���ҵ�no
	 * @return ����ҵ��ͷ���node�����û���ҵ��ͷ���null
	 */
	public HeroNode preOrderSearch(int no){
		System.out.println("����ǰ�����~~~");
		// �Ƚϵ�ǰ�ڵ��ǲ���
		if (this.no == no) {
			return this;
		}
		// �жϵ�ǰ�ڵ����ӽڵ��Ƿ�Ϊ�գ������Ϊ�գ���ݹ�ǰ�����
		// �����ݹ�ǰ����ң��ҵ��ڵ㣬�򷵻�
		HeroNode resNode = null;
		if (this.left != null) {
			resNode = this.left.preOrderSearch(no);
		}
		if (resNode != null) { // ˵�������������ҵ�
			return resNode;
		}
		// 1.��ݹ�ǰ����ң��ҵ��ڵ㣬�򷵻أ�������жϣ�
		// 2.��ǰ�Ľڵ�����ӽ��Ƿ�Ϊ�գ�������գ���������ҵݹ�ǰ�����
		if (this.right != null) {
			resNode = this.right.preOrderSearch(no);
		}
		return resNode;
	}
	
	// �����������
	public HeroNode infixOrderSearch(int no){
		// �жϵ�ǰ�ڵ�����ӽڵ��Ƿ�Ϊ�գ������Ϊ�գ���ݹ��������
		HeroNode resNode = null;
		if (this.left != null) {
			resNode = this.left.infixOrderSearch(no);
		}
		if (resNode != null) {
			return resNode;
		}
		// ����ҵ����򷵻أ����û���ҵ����ͺ͵�ǰ�ڵ�Ƚϣ�����򷵻ص�ǰ�ڵ�
		if(this.no == no){
			return this;
		}
		// ������������ҵݹ��������
		if(this.right != null){
			resNode = this.right.infixOrderSearch(no);
		}
		return resNode;
	}
	
	// �����������
	public HeroNode postOrderSearch(int no){
		// �жϵ�ǰ�ڵ�����ӽڵ��Ƿ�Ϊ�գ������Ϊ�գ���ݹ�������
		HeroNode resNode = null;
		if (this.left != null) {
			resNode = this.left.postOrderSearch(no);
		}
		if (resNode != null) { // ˵�����������ҵ�
			return resNode;
		}
		// ���������û���ҵ��������������ݹ���к����������
		if (this.right != null) {
			resNode = this.right.postOrderSearch(no);
		}
		if (resNode != null) {
			return resNode;
		}
		// �����������û���ҵ����ͱȽϵ�ǰ�ڵ����ǲ���
		if (this.no == no) {
			return this;
		}
		return resNode;
	
	}
	
}
