package com.ithanyu.graph;
import java.util.*;
public class Graph {
	
	private ArrayList<String> vertexList;  // �洢���㼯��
	private int[][] edges; // �洢ͼ��Ӧ���ڽӾ���
	private int numOfEdges; // ��ʾ�ߵ���Ŀ
	// ���������boolean[],��¼ĳ������Ƿ񱻷���
	private boolean[] isVisited;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ����һ��ͼ�Ƿ񴴽�ok
		int n = 8; // ���ĸ���
//		String Vertexs[] = {"A","B","C","D","E"};
		String Vertexs[] = {"1","2","3","4","5","6","7","8"};
		// ����ͼ����
		Graph graph = new Graph(n);
		// ѭ������Ӷ���
		for(String vertex:Vertexs){
			graph.insertVertex(vertex);
		}
		// ��ӱ�
		// A-B A-C B-C B-D B-E
//		graph.insertEdge(0, 1, 1);// A-B
//		graph.insertEdge(0, 2, 1);// A-C
//		graph.insertEdge(1, 2, 1);// B-C
//		graph.insertEdge(1, 3, 1);// B-D
//		graph.insertEdge(1, 4, 1);// B-E
		graph.insertEdge(0, 1, 1);
		graph.insertEdge(0, 2, 1);
		graph.insertEdge(1, 3, 1);
		graph.insertEdge(1, 4, 1);
		graph.insertEdge(3, 7, 1);
		graph.insertEdge(4, 7, 1);
		graph.insertEdge(2, 5, 1);
		graph.insertEdge(2, 6, 1);
		graph.insertEdge(5, 6, 1);
		
		// ��ʾһ���ڽӾ���
		graph.showGraph();
		
		// ����һ�ѣ����ǵ�dfs�����Ƿ�ok
		System.out.println("��ȱ���");
		graph.dfs(); // A->B->C->D->E->
		

		System.out.println("��ȱ���");
		graph.bfs();
	}
	
	// ������
	public Graph(int n){
		// ��ʼ�������vertexList
		edges = new int[n][n];
		vertexList = new ArrayList<String>(n);
		numOfEdges = 0;
	}
	// �õ���һ���ڽӽ����±� w
	/**
	 * 
	 * @param index
	 * @return ������ھͷ��ض�Ӧ���±꣬���򷵻�-1
	 */
	public int getFirstNeighbor(int index){
		for(int j=0;j<vertexList.size();j++){
			if(edges[index][j]>0){
				return j;
			}
		}
		return -1;
	}
	// ����ǰһ���ڽӽ����±�����ȡ��һ���ڽӽ��
	public int getNextNeighbor(int v1,int v2){
		for(int j = v2 + 1 ;j<vertexList.size();j++){
			if(edges[v1][j] > 0){
				return j;
			}
		}
		return -1;
	}
	
	// ������ȱ����㷨
	// i ��һ�ξ��� 0
	public void dfs(boolean[] isVisited,int i){
		// �������Ƿ��ʸýڵ㣬���
		System.out.print(getValueByIndex(i) + "->");
		// ���������Ϊ�Ѿ�����
		isVisited[i] = true;
		// ���ҽ��i�ĵ�һ���ڽӽ��w
		int w = getFirstNeighbor(i);
		while(w != -1){ // ˵����
			if(!isVisited[w]){
				dfs(isVisited,w);
			}
			// ���w����Ѿ������ʹ�
			w = getNextNeighbor(i,w);
		}
	}
	
	// ��dfs ����һ������,�����������еĽ�㣬������ dfs
	private void dfs(){
		isVisited = new boolean[vertexList.size()];
		// �������еĽ�㣬����dfs[����]
		for(int i=0;i<getNumOfVertex();i++){
			if(!isVisited[i]){
				dfs(isVisited,i);
			}
		}
	}
	
	// ��һ�������й�����ȱ����ķ���
	private void bfs(boolean[] isVisited, int i){
		int u; // ��ʾ���е�ͷ�ڵ��Ӧ�±�
		int w; // �ڽӽ��w
		// ���У���¼�����ʵ�˳��
		LinkedList queue = new LinkedList();
		// ���ʽ�㣬��������Ϣ
		System.out.println(getValueByIndex(i) + "=>");
		// ���Ϊ�ѷ���
		isVisited[i] = true;
		// �����������
		queue.addLast(i);
		
		while( !queue.isEmpty()){
			// ȡ�����е�ͷ����±�
			u = (Integer)queue.removeFirst();
			// �õ���һ���ڽӽ����±�w
			w = getFirstNeighbor(u);
			while(w != -1){ // �ҵ�
				// �Ƿ���ʹ�
				if(!isVisited[w]){
					System.out.println(getValueByIndex(w) + "=>");
					// ����Ѿ�����
					isVisited[w] = true;
					// ���
					queue.addLast(w);
				}
				// ��u Ϊǰ���㣬��w�������һ���ڽӵ�
				w = getNextNeighbor(u,w); // ���ֳ��������
			}
		}
	}
	
	// �������еĽ�㣬�����й����������
	public void bfs(){
		isVisited = new boolean[vertexList.size()];
		for(int i=0;i<getNumOfVertex();i++){
			if(!isVisited[i]){
				bfs(isVisited,i);
			}
		}
	}
	
	// ͼ�г��õķ���
	// ���ؽ��ĸ���
	public int getNumOfVertex(){
		return vertexList.size();
	}
	// �õ��ߵ���Ŀ
	public int getNumOfEdges(){
		return numOfEdges;
	}
	// ���ؽ��i(�±�)��Ӧ������ 0->"A" 1->"B" 2->"C"
	public String getValueByIndex(int i){
		return vertexList.get(i);
	}
	// ����v1��v2��Ȩֵ
	public int getWeight(int v1,int v2){
		return edges[v1][v2];
	}
	
	// ��ʾͼ��Ӧ�ľ���
	public void showGraph(){
		for(int[] link : edges) {
			System.err.println(Arrays.toString(link));
		}
	}
	
	// ������
	public void insertVertex(String vertex){
		vertexList.add(vertex);
	}
	// ��ӱ�
	/**
	 * 
	 * @param v1 ��ʾ����±� ��ʹ�ǵڼ������� "A"-"B" "A"->0 "B"->1
	 * @param v2 �ڶ��������Ӧ���±�
	 * @param weight ��ʾ
	 */
	public void insertEdge(int v1,int v2,int weight){
		edges[v1][v2] = weight;
		edges[v2][v1] = weight;
		numOfEdges++;
	}

}















