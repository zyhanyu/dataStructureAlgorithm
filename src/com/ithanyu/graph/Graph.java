package com.ithanyu.graph;
import java.util.*;
public class Graph {
	
	private ArrayList<String> vertexList;  // 存储顶点集合
	private int[][] edges; // 存储图对应的邻接矩阵
	private int numOfEdges; // 表示边的数目

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 测试一把图是否创建ok
		int n = 5; // 结点的个数
		String Vertexs[] = {"A","B","C","D","E"};
		// 创建图对象
		Graph graph = new Graph(n);
		// 循环的添加顶点
		for(String vertex:Vertexs){
			graph.insertVertex(vertex);
		}
		// 添加边
		// A-B A-C B-C B-D B-E
		graph.insertEdge(0, 1, 1);// A-B
		graph.insertEdge(0, 2, 1);// A-C
		graph.insertEdge(1, 2, 1);// B-C
		graph.insertEdge(1, 3, 1);// B-D
		graph.insertEdge(1, 4, 1);// B-E
		
		// 显示一把邻接矩阵
		graph.showGraph();
	}
	
	// 构造器
	public Graph(int n){
		// 初始化矩阵和vertexList
		edges = new int[n][n];
		vertexList = new ArrayList<String>(n);
		numOfEdges = 0;
	}
	
	// 图中常用的方法
	// 返回结点的个数
	public int getNumOfVertex(){
		return vertexList.size();
	}
	// 得到边的数目
	public int getNumOfEdges(){
		return numOfEdges;
	}
	// 返回结点i(下标)对应的数据 0->"A" 1->"B" 2->"C"
	public String getValueByIndex(int i){
		return vertexList.get(i);
	}
	// 返回v1和v2的权值
	public int getWeight(int v1,int v2){
		return edges[v1][v2];
	}
	
	// 显示图对应的矩阵
	public void showGraph(){
		for(int[] link : edges) {
			System.err.println(Arrays.toString(link));
		}
	}
	
	// 插入结点
	public void insertVertex(String vertex){
		vertexList.add(vertex);
	}
	// 添加边
	/**
	 * 
	 * @param v1 表示点的下标 即使是第几个顶点 "A"-"B" "A"->0 "B"->1
	 * @param v2 第二个顶点对应的下标
	 * @param weight 表示
	 */
	public void insertEdge(int v1,int v2,int weight){
		edges[v1][v2] = weight;
		edges[v2][v1] = weight;
		numOfEdges++;
	}

}















