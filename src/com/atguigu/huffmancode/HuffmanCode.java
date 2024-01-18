package com.atguigu.huffmancode;

import java.util.List;
import java.util.Map;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class HuffmanCode {

	public static void main(String[] args) {
		
		// ����ѹ���ļ�
//		String srcFile = "E://java//src.jpg";
//		String dstFile = "E://java//src.zip";
//		
//		zipFile(srcFile, dstFile);
//		System.out.println("ѹ���ļ�~OK");
		
		// ���Խ�ѹ�ļ�
		String zipFile = "E://java//src.zip";
		String dstFile = "E://java//src2.jpg";
		
		unZipFile(zipFile, dstFile);
		System.out.println("��ѹ�ļ�~OK");
		
		/*
		// TODO Auto-generated method stub
		String content = "i like like like java do you like a java";
		byte[] contentBytes = content.getBytes();
		// System.out.println(Arrays.toString(contentBytes));
		// System.out.println(contentBytes.length); // 40
		
		byte[] huffmanCodesBytes = huffmanZip(contentBytes);
		System.out.println("ѹ����Ľ���ǣ�" + Arrays.toString(huffmanCodesBytes) + " ����= " + huffmanCodesBytes.length);
		
		// ���� byteToBitString
		// System.out.println(byteToBitString((byte)1));
		byte[] soutceBytes = decode(huffmanCodes, huffmanCodesBytes);
		System.out.println("ԭ�����ַ��� = " + new String(soutceBytes));
		*/
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
	
	// ��дһ����������ɶ�ѹ���ļ��Ľ�ѹ
	/**
	 * 
	 * @param zipFile ׼����ѹ�����꼶
	 * @param dstFile ���ļ���ѹ���ĸ�·��
	 */
	public static void unZipFile(String zipFile,String dstFile){
		// �����ļ�������
		InputStream is= null;
		// ����һ������������
		ObjectInputStream ois = null;
		// �����ļ��������
		OutputStream os = null;
		try {
			// �����ļ�������
			is = new FileInputStream(zipFile);
			// ����һ�� �� is �����Ķ���������
			ois = new ObjectInputStream(is);
			// ��ȡbyte���� huffmanBytes
			byte[] huffmanBytes = (byte[])ois.readObject();
			// ��ȡ�����������
			Map<Byte, String> huffmanCodes = (Map<Byte, String>)ois.readObject();
			
			// ����
			byte[] bytes = decode(huffmanCodes, huffmanBytes);
			// ��bytes ����д�뵽Ŀ���ļ�
			os = new FileOutputStream(dstFile);
			// д���ݵ� dstFile �ļ�
			os.write(bytes);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				os.close();
				ois.close();
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
	}
	
	// ��д��������һ���ļ�����ѹ��
	/**
	 * 
	 * @param srcFile �㴫���ϣ��ѹ�����ļ���ȫ·��
	 * @param dstFile ����ѹ����ѹ���ļ��ŵ��ĸ�Ŀ¼
	 */
	public static void zipFile(String srcFile,String dstFile){
		OutputStream os = null;
		ObjectOutputStream oos = null;
		// ���������
		FileInputStream is = null;
		try {
			is = new FileInputStream(srcFile);
			// ����һ����Դ�ļ���Сһ����byte[]
			byte[] b = new byte[is.available()];
			// ��ȡ�ļ�
			is.read(b);
			// ֱ�Ӷ�Դ�ļ�ѹ��
			byte[] huffmanBytes = huffmanZip(b);
			// �����ļ�����������ѹ���ļ�
			os = new FileOutputStream(dstFile);
			// ����һ�����ļ������������ObjecatOutputStremam
			oos = new ObjectOutputStream(os);
			// �� �������������ֽ�����д��ѹ���ļ�
			oos.writeObject(huffmanBytes);// �����ǰ�
			
			// ���������Զ������ķ�ʽд�� ���������룬��Ϊ���Ժ����ǻָ�Դ�ļ�ʱʹ��
			// ע��һ��Ҫ�ѹ���������д�� ѹ���ļ�
			oos.writeObject(huffmanCodes);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				is.close();
				oos.close();
				os.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	
	// ������ݵĽ�ѹ
	// ˼·
	// 1. ��huffmanCodeBytes [-88, -65, -56, -65, -56, -65, -55, 77, -57, 6, -24, -14, -117, -4, -60, -90, 28] ����= 17
	//    ��д��ת�� �����������Ӧ�Ķ����Ƶ��ַ��� "1010100010111..."
	// 2. �����������Ӧ�Ķ����Ƶ��ַ��� "1010100010111..." => ���� ���������� => "i like like like java do you like a java"
	
	// ��дһ����������ɶ�ѹ�����ݵĽ���
	/**
	 * 
	 * @param huffmanCodes ����������� map
	 * @param huffmanBytes ����������õ����ֽ�����
	 * @return ����ԭ�����ַ�����Ӧ������
	 */
	private static byte[] decode(Map<Byte, String> huffmanCodes,byte[] huffmanBytes){
		
		// 1. �ȵõ� hufmanBytes ��Ӧ�Ķ����Ƶ��ַ�������ʽ 1010100010111...
		StringBuffer stringBuilder = new StringBuffer();
		// ��byte����ת�ɶ����Ƶ��ַ���
		for (int i = 0; i < huffmanBytes.length; i++) {
			byte b =huffmanBytes[i];
			// �ж��ǲ������һ���ַ���
			boolean flag = (i == huffmanBytes.length - 1);
			stringBuilder.append(byteToBitString(!flag, b));
		}
		// System.out.println("�������ֽ������Ӧ�Ķ������ַ���="+ stringBuilder.toString());
		// return null;
		// ���ַ�������ָ���Ĺ��������н���
		// �ѹ������������е�������Ϊ�����ѯ a->100 100->a
		Map<String, Byte> map = new HashMap<String,Byte>();
		for(Map.Entry<Byte, String> entry:huffmanCodes.entrySet()){
			map.put(entry.getValue(), entry.getKey());
		}
		System.out.println("map"+map);
		
		// ����Ҫ�����ϣ����byte
		List<Byte> list = new ArrayList<>();
		// i ��������������ɨ�� stringBuilder	
		for (int i = 0; i < stringBuilder.length(); ) {
			int count = 1; // С�ļ�����
			boolean flag = true;
			Byte b = null;
			
			while(flag){
				// 1010100010111...
				// ������ȡ��key
				String key = stringBuilder.substring(i,i+count);// i ��������count�ƶ���ָ��ƥ�䵽һ���ַ�
				b = map.get(key);
				if (b == null) {//˵��û��ƥ�䵽
					count++;
				}else{
					// ƥ�䵽
					flag = false;
				}
				
			}
			list.add(b);
			i += count;// i ֱ���ƶ��� count
		}
		// ��forѭ������������list�оʹ�������е��ַ�
		// ��list �е����ݷ��뵽byte[], ������
		byte b[] = new byte[list.size()];
		for (int i = 0; i < b.length; i++) {
			b[i] = list.get(i);
		}
		return b;
		
	}
	
	/**
	 * ��һ��byte ת��һ�������Ƶ��ַ���
	 * @param flag ��־�Ƿ���Ҫ����λ�����true����ʾ��Ҫ����λ�������false��ʾ��������������һ���ֽڣ����貹��λ
	 * @param b  �����byte
	 * @return �Ǹ�b ��Ӧ�Ķ����Ƶ��ַ�����(ע���ǰ����뷵��)
	 */
	private static String byteToBitString(boolean flag,byte b) {
		// ʹ�ñ������� b
		int temp = b; // ��bת��int
		// ������������ǻ����ڲ���λ
		if (flag) {
			temp |= 256; // ��λ��256 1 0000 0000 | 0000 0001 => 1 0000 0001

		}
		
		String str = Integer.toBinaryString(temp); // ���ص���temp��Ӧ�Ķ����ƵĲ���
		// System.out.println("str="+str);

		if (flag) {
			return str.substring(str.length() - 8);
		}else{
			return str;
		}
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





