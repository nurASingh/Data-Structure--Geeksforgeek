package Graph;

import java.util.Scanner;

public class DetectCycleInGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		int[][] graph = new int[V][V];
		int[] visited = new int[V];
		for (int i = 0; i < E; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			graph[start][end] = 1;
		}

	}

	public static void DFSAlgo(int[][] graph, int[] visited, int[] stack,int src, int front) {

		visited[src] = 1;
		stack[front++] = src;
		for (int i = 0; i < graph.length; i++) {
			int next = graph[src][i];
			if (next == 1 && visited[i] == 0) {

			}
		}

	}

}
