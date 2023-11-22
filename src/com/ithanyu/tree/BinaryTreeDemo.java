package com.ithanyu.tree;

public class BinaryTreeDemo {

	public static void main(String[] args) {
		// ����Ҫ����һ�������
		BinaryTree binaryTree = new BinaryTree();
		// ������Ҫ�Ľڵ�
		HeroNode root = new HeroNode(1, "�ν�");
		HeroNode node2 = new HeroNode(2, "����");
		HeroNode node3 = new HeroNode(3, "¬����");
		HeroNode node4 = new HeroNode(4, "�ֳ�");
		HeroNode node5 = new HeroNode(5, "��ʤ");
		
		// ˵�������ֶ�����������������ݹ�ķ�ʽ����������
		root.setLeft(node2);
		root.setRight(node3);
		node3.setRight(node4);
		node3.setLeft(node5);
		binaryTree.setRoot(root);
		
		// ����
		System.out.println("ǰ�����"); // 1,2,3,4
		binaryTree.preOrder();
		
		// ����
		System.out.println("�������"); // 2,1,3,4
		binaryTree.infixOrder();

		// ����
		System.out.println("�������"); // 2,1,3,4
		binaryTree.postOrder();
		
		// ǰ�����
//		System.out.println("ǰ����ҷ�ʽ~~~");
//		HeroNode resNode = binaryTree.preOrderSearch(5);
//		if (resNode != null) {
//			System.out.printf("�ҵ���,��ϢΪno=%d name=%s",resNode.getNo(),resNode.getName());
//		}else{
//			System.out.printf("û���ҵ� no = %d ��Ӣ��",5);
//		}
		
		// �������
//		System.out.println("������ҷ�ʽ~~~");
//		HeroNode resNode = binaryTree.infixOrderSearch(5);
//		if (resNode != null) {
//			System.out.printf("�ҵ���,��ϢΪno=%d name=%s",resNode.getNo(),resNode.getName());
//		}else{
//			System.out.printf("û���ҵ� no = %d ��Ӣ��",5);
//		}
		
		// �������
		System.out.println("������ҷ�ʽ~~~");
		HeroNode resNode = binaryTree.postOrderSearch(5);
		if (resNode != null) {
			System.out.printf("�ҵ���,��ϢΪno=%d name=%s",resNode.getNo(),resNode.getName());
		}else{
			System.out.printf("û���ҵ� no = %d ��Ӣ��",5);
		}
		
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















