package com.atguigu.huffmancode;

import java.util.List;
import java.util.Map;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class HuffmanCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String content = "i like like like java do you like a java";
		byte[] contentBytes = content.getBytes();
		// System.out.println(Arrays.toString(contentBytes));
		// System.out.println(contentBytes.length); // 40
		
		byte[] huffmanCodesBytes = huffmanZip(contentBytes);
		System.out.println("压缩后的结果是：" + Arrays.toString(huffmanCodesBytes) + " 长度= " + huffmanCodesBytes.length);
		
		// 分布过程
		/*
		List<Node> nodes = getNodes(contentBytes);
		System.out.println("nodes=" + nodes);
		
		// 测试一把，创建的哈夫曼树
		System.out.println("哈夫曼树");
		Node huffmanTreeRoot = createHuffmanTree(nodes);
		System.out.println("前序遍历");
		huffmanTreeRoot.preOrder();
		
		// 测试一把是否生成了对应的哈夫曼编码
		// getCodes(huffmanTreeRoot, "", stringBuffer);
		Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot);
		System.out.println("生成的哈夫曼编码表"+huffmanCodes);
		
		// 测试
		byte[] huffmanCodeBytes = zip(contentBytes, huffmanCodes);
		System.out.println("huffmanCodeBytes=" + Arrays.toString(huffmanCodeBytes));//17
		
		// 发送huffmanCodeBytes 数组
		 */
		
		
	}
	
	// 使用一个方法，将前面的方法封装起来，便于我们的调用。
	/**
	 * 
	 * @param bytes 原始的字符串对应的字节数组
	 * @return 经过哈夫曼编号处理后的字节数组（压缩后的数组）
	 */
	private static byte[] huffmanZip(byte[] bytes){
		List<Node> nodes = getNodes(bytes);
		// 根据 nodes 创建的哈夫曼树
		Node huffmanTreeRoot = createHuffmanTree(nodes);
		// 生成了对应的哈夫曼编码(根据 哈夫曼树)
		Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot);
		// 根据生成的哈夫曼编码，压缩得到压缩后的哈夫曼编码字节数组
		byte[] huffmanCodeBytes = zip(bytes, huffmanCodes);
		
		return huffmanCodeBytes;
	}
	
	// 编写一个方法，将字符串对应的byte[] 数组，通过生成的哈夫曼编码表，返回一个哈夫曼编码 压缩后的byte[]
	/**
	 * 
	 * @param bytes 这时原始的字符串对应的 byte[]
	 * @param huffmanCodes 生成的哈夫曼编码map
	 * @return 返回哈夫曼编码处理后的 byte[]
	 * 举例：String content = "i like like like java do you like a java"; => byte[] contentBytes = content.getBytes();
	 * 返回的时 字符串 "101010001011111111100100010111111110010001011111111001001010011011100011100000110111010001111"
	 * => 对应的 byte[] hufffmanCodeBytes ,即8位对应一个byte，放入到huffmanCodeBytes
	 * huffmanCodeBytes[0] = 10101000(补码) => byte [推到 10101000=> 10101000 - 1 => 10100111(反码) => 11011000 = -88]
	 * huffmanCodeBytes[1] = -88
	 * 
	 */
	private static byte[] zip(byte[] bytes,Map<Byte, String> huffmanCodes){
		// 1. 利用huffmanCodes 将 bytes 转成 哈夫曼编码对应的字符串
		StringBuffer stringBuffer = new StringBuffer();
		// 遍历 bytes数组
		for(byte b:bytes){
			stringBuffer.append(huffmanCodes.get(b));
		}
		// System.out.println("测试 stringBuilder="+stringBuffer.toString());
		// 1010100010111111110010001011111111001000101111111100100101001101110001110000011011101000111100101000101111111100110001001010011011100
		// 将 "1010100010111111110010..."转成byte[]
		// 统计返回 byte[] huffmanCodeBytes 长度
		// 一句话int len = (stringBuilder.length() + 7) / 8;
		int len;
		if (stringBuffer.length() % 8 == 0) {
			len = stringBuffer.length() / 8;
		}else{
			len = stringBuffer.length() /8+1;
		}
		// 创建 存储压缩后的 byte数组
		byte[] huffmanCodeBytes = new byte[len];
		int index = 0; // 记录是几个byte
		for(int i = 0;i < stringBuffer.length();i+=8){// 因为是每8位对应一个byte,所以步长 +8
			String strByte;
			if (i+8 > stringBuffer.length()) { // 不够8位
				strByte = stringBuffer.substring(i);
			}else{
				strByte = stringBuffer.substring(i,i+8);
			}
			
			// 将strByte 转成一个byte,放入到 huffmanCodeBytes
			huffmanCodeBytes[index] = (byte)Integer.parseInt(strByte,2);
			index++;
		}
		
		return huffmanCodeBytes;
	}
	
	// 生成哈夫曼树对应的哈夫曼编码
	// 思路：
	// 1. 将哈夫曼编码表存放在Map<Byte,String> 形式
	//    32->01 97->100 100->11000 等形式
	static Map<Byte, String> huffmanCodes = new HashMap<Byte,String>();
	// 2. 在生成哈夫曼编码表示，需要取拼接路径，定义一个StringBuilder 存储某个叶子结点的路径
	static StringBuffer stringBuffer = new StringBuffer();
	
	// 为了调用方便，我们重载 getCodes
	private static Map<Byte, String> getCodes(Node root){
		if (root == null) {
			return null;
		}
		// 处理root的左子树
		getCodes(root.left,"0",stringBuffer);
		// 处理root的右子树
		getCodes(root.right,"1",stringBuffer);
		return huffmanCodes;
	}
	
	/**
	 * 功能：将传入的node结点的索引叶子结点的哈夫曼编码得到，并放入到huffmanCodes集合
	 * @param node 传入结点
	 * @param code 路径： 左子节点是 0，右子结点 1
	 * @param stringBuffer 用于拼接路径
	 */
	private static void getCodes(Node node,String code,StringBuffer stringBuffer){
		StringBuffer stringBuffer2 = new StringBuffer(stringBuffer);
		// 将 code 加入到 stringbuilder2
		stringBuffer2.append(code);
		if (node != null) { // 如果node == null 不处理
			// 判断当前node 是叶子结点还是非叶子结点
			if (node.data == null) { // 非叶子结点
				// 递归处理
				// 向左递归
				getCodes(node.left, "0", stringBuffer2);
				// 向左递归
				getCodes(node.right, "1", stringBuffer2);

			}else{ // 说明是一个叶子结点
				// 就表示找到某个叶子结点的最后
				huffmanCodes.put(node.data, stringBuffer2.toString());
			}
		}
	}
	
	// 前序遍历的方法
	private static void preOrder(Node root){
		if (root != null) {
			root.preOrder();
		}else{
			System.out.println("哈夫曼树为空");
		}
	}
	
	/**
	 * 
	 * @param bytes 接收字节数组
	 * @return 返回就是 List 形式 [Node[date=97,weight=5],Node[date=85,weight=9]]
	 */
	private static List<Node> getNodes(byte[] bytes){
		// 1.创建一个ArrayList
		 ArrayList<Node> nodes = new ArrayList<Node>();
		 
		 // 遍历 bytes,统计 存储每一个byte出现的次数->map[key,value]
		 Map<Byte, Integer> counts = new HashMap<>();
		 for (byte b : bytes) {
			Integer count = counts.get(b);
			if (count == null) { // Map 还没有这个字符数据，第一次
				counts.put(b, 1);
				
			}else{
				counts.put(b, count +1);
			}
		}
		 
		 // 把每个键值对转成一个Node 对象，并加入到nodes集合
		 for(Map.Entry<Byte, Integer> entry:counts.entrySet()){
			 nodes.add(new Node(entry.getKey(), entry.getValue()));
		 }
		 return nodes;
	}
	
	// 可以通过List 创建对应的哈夫曼树
	private static Node createHuffmanTree(List<Node> nodes){
		while(nodes.size() > 1){
			// 排序，从小到大
			Collections.sort(nodes);
			// 取出第一颗最小的二叉树
			Node leftNode = nodes.get(0);
			// 取出第二颗最小的二叉树
			Node rightNode = nodes.get(1);
			// 创建一颗新的二叉树，它的根节点 没有data，只有权值
			Node parent = new Node(null, leftNode.weight + rightNode.weight);
			parent.left = leftNode;
			parent.right = rightNode;
			
			// 将已经处理的两颗二叉树从nodes移除
			nodes.remove(leftNode);
			nodes.remove(rightNode);
			// 将新的二叉树，加入到nodes
			nodes.add(parent);
		}
		// nodes 最后的结点，就是哈夫曼树的根节点
		return nodes.get(0);
		
	}

}

// 创建Node，待数据和权值
class Node implements Comparable<Node>{
	Byte data; // 存放数据本身，比如'a' => 97 ' ' => 32
	int weight; // 权值，；表示字符出现的次数
	Node left;
	Node right;
	public Node(Byte data, int weight) {
		this.data = data;
		this.weight = weight;
	}
	@Override
	public int compareTo(Node o) {
		// 从小到大排序
		return this.weight - o.weight;
	}
	@Override
	public String toString() {
		return "Node [data=" + data + ", weight=" + weight + "]";
	}
	
	// 前序遍历
	public void preOrder(){
		System.out.println(this);
		if (this.left != null) {
			this.left.preOrder();
		}
		if (this.right != null) {
			this.right.preOrder();
		}
	}
}





