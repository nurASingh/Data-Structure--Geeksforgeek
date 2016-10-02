package Revision;

import java.util.Scanner;

public class DFSAlgo {

	public static int dest = 0;
	public static boolean found = false;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int T = 0; T < tc; T++) {

			int V = sc.nextInt();
			int E = sc.nextInt();
			int[][] graph = new int[V][V];

			for (int i = 0; i < E; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				graph[start][end] = 1;
				graph[end][start] = 1;
			}
			dest = sc.nextInt();
			int[] visited = new int[V];
			found = false;
			System.out.println("Next Node >>" + 0);
			DFS(graph,0,visited);
		}
	}

	public static void DFS(int[][] graph, int src, int[] visited) {
		if(dest == src){
			found = true;
		}
			
		visited[src] = 1;
		for (int i = 0; i < visited.length; i++) {
			int node = graph[src][i];
			if (node == 1 && visited[i] == 0) {
				if(found == false){
					System.out.println("Next Node >>" + i);
					DFS(graph,i,visited);
				}

				
			}
		}
	}

}
