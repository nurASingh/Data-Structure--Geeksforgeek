package Graph;

import java.util.Scanner;

public class DFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		int[][] graph = new int[V][V];
		int[]  visited = new int[V];
		for (int i = 0; i < E; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			graph[start][end] = 1;
		}
		DFSAlgo(graph,2,visited);
	}
	
	public static void DFSAlgo(int[][] graph, int src , int[] visited){
		
		System.out.print(src);
		visited[src] = 1;
		for (int i = 0; i < graph.length; i++) {
			int vertex = graph[src][i];
			if(vertex == 1 && visited[i] ==0){
				DFSAlgo(graph,i,visited);
			}else if(i== graph.length-1 && (vertex==0 || visited[i] ==1)){
				return;
			}
		}
		
	}

}
