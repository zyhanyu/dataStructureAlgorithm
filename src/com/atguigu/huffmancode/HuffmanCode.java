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
		System.out.println("ѹ����Ľ���ǣ�" + Arrays.toString(huffmanCodesBytes) + " ����= " + huffmanCodesBytes.length);
		
		// �ֲ�����
		/*
		List<Node> nodes = getNodes(contentBytes);
		System.out.println("nodes=" + nodes);
		
		// ����һ�ѣ������Ĺ�������
		System.out.println("��������");
		Node huffmanTreeRoot = createHuffmanTree(nodes);
		System.out.println("ǰ�����");
		huffmanTreeRoot.preOrder();
		
		// ����һ���Ƿ������˶�Ӧ�Ĺ���������
		// getCodes(huffmanTreeRoot, "", stringBuffer);
		Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot);
		System.out.println("���ɵĹ����������"+huffmanCodes);
		
		// ����
		byte[] huffmanCodeBytes = zip(contentBytes, huffmanCodes);
		System.out.println("huffmanCodeBytes=" + Arrays.toString(huffmanCodeBytes));//17
		
		// ����huffmanCodeBytes ����
		 */
		
		
	}
	
	// ʹ��һ����������ǰ��ķ�����װ�������������ǵĵ��á�
	/**
	 * 
	 * @param bytes ԭʼ���ַ�����Ӧ���ֽ�����
	 * @return ������������Ŵ������ֽ����飨ѹ��������飩
	 */
	private static byte[] huffmanZip(byte[] bytes){
		List<Node> nodes = getNodes(bytes);
		// ���� nodes �����Ĺ�������
		Node huffmanTreeRoot = createHuffmanTree(nodes);
		// �����˶�Ӧ�Ĺ���������(���� ��������)
		Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot);
		// �������ɵĹ��������룬ѹ���õ�ѹ����Ĺ����������ֽ�����
		byte[] huffmanCodeBytes = zip(bytes, huffmanCodes);
		
		return huffmanCodeBytes;
	}
	
	// ��дһ�����������ַ�����Ӧ��byte[] ���飬ͨ�����ɵĹ��������������һ������������ ѹ�����byte[]
	/**
	 * 
	 * @param bytes ��ʱԭʼ���ַ�����Ӧ�� byte[]
	 * @param huffmanCodes ���ɵĹ���������map
	 * @return ���ع��������봦���� byte[]
	 * ������String content = "i like like like java do you like a java"; => byte[] contentBytes = content.getBytes();
	 * ���ص�ʱ �ַ��� "101010001011111111100100010111111110010001011111111001001010011011100011100000110111010001111"
	 * => ��Ӧ�� byte[] hufffmanCodeBytes ,��8λ��Ӧһ��byte�����뵽huffmanCodeBytes
	 * huffmanCodeBytes[0] = 10101000(����) => byte [�Ƶ� 10101000=> 10101000 - 1 => 10100111(����) => 11011000 = -88]
	 * huffmanCodeBytes[1] = -88
	 * 
	 */
	private static byte[] zip(byte[] bytes,Map<Byte, String> huffmanCodes){
		// 1. ����huffmanCodes �� bytes ת�� �����������Ӧ���ַ���
		StringBuffer stringBuffer = new StringBuffer();
		// ���� bytes����
		for(byte b:bytes){
			stringBuffer.append(huffmanCodes.get(b));
		}
		// System.out.println("���� stringBuilder="+stringBuffer.toString());
		// 1010100010111111110010001011111111001000101111111100100101001101110001110000011011101000111100101000101111111100110001001010011011100
		// �� "1010100010111111110010..."ת��byte[]
		// ͳ�Ʒ��� byte[] huffmanCodeBytes ����
		// һ�仰int len = (stringBuilder.length() + 7) / 8;
		int len;
		if (stringBuffer.length() % 8 == 0) {
			len = stringBuffer.length() / 8;
		}else{
			len = stringBuffer.length() /8+1;
		}
		// ���� �洢ѹ����� byte����
		byte[] huffmanCodeBytes = new byte[len];
		int index = 0; // ��¼�Ǽ���byte
		for(int i = 0;i < stringBuffer.length();i+=8){// ��Ϊ��ÿ8λ��Ӧһ��byte,���Բ��� +8
			String strByte;
			if (i+8 > stringBuffer.length()) { // ����8λ
				strByte = stringBuffer.substring(i);
			}else{
				strByte = stringBuffer.substring(i,i+8);
			}
			
			// ��strByte ת��һ��byte,���뵽 huffmanCodeBytes
			huffmanCodeBytes[index] = (byte)Integer.parseInt(strByte,2);
			index++;
		}
		
		return huffmanCodeBytes;
	}
	
	// ���ɹ���������Ӧ�Ĺ���������
	// ˼·��
	// 1. �����������������Map<Byte,String> ��ʽ
	//    32->01 97->100 100->11000 ����ʽ
	static Map<Byte, String> huffmanCodes = new HashMap<Byte,String>();
	// 2. �����ɹ����������ʾ����Ҫȡƴ��·��������һ��StringBuilder �洢ĳ��Ҷ�ӽ���·��
	static StringBuffer stringBuffer = new StringBuffer();
	
	// Ϊ�˵��÷��㣬�������� getCodes
	private static Map<Byte, String> getCodes(Node root){
		if (root == null) {
			return null;
		}
		// ����root��������
		getCodes(root.left,"0",stringBuffer);
		// ����root��������
		getCodes(root.right,"1",stringBuffer);
		return huffmanCodes;
	}
	
	/**
	 * ���ܣ��������node��������Ҷ�ӽ��Ĺ���������õ��������뵽huffmanCodes����
	 * @param node ������
	 * @param code ·���� ���ӽڵ��� 0�����ӽ�� 1
	 * @param stringBuffer ����ƴ��·��
	 */
	private static void getCodes(Node node,String code,StringBuffer stringBuffer){
		StringBuffer stringBuffer2 = new StringBuffer(stringBuffer);
		// �� code ���뵽 stringbuilder2
		stringBuffer2.append(code);
		if (node != null) { // ���node == null ������
			// �жϵ�ǰnode ��Ҷ�ӽ�㻹�Ƿ�Ҷ�ӽ��
			if (node.data == null) { // ��Ҷ�ӽ��
				// �ݹ鴦��
				// ����ݹ�
				getCodes(node.left, "0", stringBuffer2);
				// ����ݹ�
				getCodes(node.right, "1", stringBuffer2);

			}else{ // ˵����һ��Ҷ�ӽ��
				// �ͱ�ʾ�ҵ�ĳ��Ҷ�ӽ������
				huffmanCodes.put(node.data, stringBuffer2.toString());
			}
		}
	}
	
	// ǰ������ķ���
	private static void preOrder(Node root){
		if (root != null) {
			root.preOrder();
		}else{
			System.out.println("��������Ϊ��");
		}
	}
	
	/**
	 * 
	 * @param bytes �����ֽ�����
	 * @return ���ؾ��� List ��ʽ [Node[date=97,weight=5],Node[date=85,weight=9]]
	 */
	private static List<Node> getNodes(byte[] bytes){
		// 1.����һ��ArrayList
		 ArrayList<Node> nodes = new ArrayList<Node>();
		 
		 // ���� bytes,ͳ�� �洢ÿһ��byte���ֵĴ���->map[key,value]
		 Map<Byte, Integer> counts = new HashMap<>();
		 for (byte b : bytes) {
			Integer count = counts.get(b);
			if (count == null) { // Map ��û������ַ����ݣ���һ��
				counts.put(b, 1);
				
			}else{
				counts.put(b, count +1);
			}
		}
		 
		 // ��ÿ����ֵ��ת��һ��Node ���󣬲����뵽nodes����
		 for(Map.Entry<Byte, Integer> entry:counts.entrySet()){
			 nodes.add(new Node(entry.getKey(), entry.getValue()));
		 }
		 return nodes;
	}
	
	// ����ͨ��List ������Ӧ�Ĺ�������
	private static Node createHuffmanTree(List<Node> nodes){
		while(nodes.size() > 1){
			// ���򣬴�С����
			Collections.sort(nodes);
			// ȡ����һ����С�Ķ�����
			Node leftNode = nodes.get(0);
			// ȡ���ڶ�����С�Ķ�����
			Node rightNode = nodes.get(1);
			// ����һ���µĶ����������ĸ��ڵ� û��data��ֻ��Ȩֵ
			Node parent = new Node(null, leftNode.weight + rightNode.weight);
			parent.left = leftNode;
			parent.right = rightNode;
			
			// ���Ѿ���������Ŷ�������nodes�Ƴ�
			nodes.remove(leftNode);
			nodes.remove(rightNode);
			// ���µĶ����������뵽nodes
			nodes.add(parent);
		}
		// nodes ���Ľ�㣬���ǹ��������ĸ��ڵ�
		return nodes.get(0);
		
	}

}

// ����Node�������ݺ�Ȩֵ
class Node implements Comparable<Node>{
	Byte data; // ������ݱ�������'a' => 97 ' ' => 32
	int weight; // Ȩֵ������ʾ�ַ����ֵĴ���
	Node left;
	Node right;
	public Node(Byte data, int weight) {
		this.data = data;
		this.weight = weight;
	}
	@Override
	public int compareTo(Node o) {
		// ��С��������
		return this.weight - o.weight;
	}
	@Override
	public String toString() {
		return "Node [data=" + data + ", weight=" + weight + "]";
	}
	
	// ǰ�����
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





