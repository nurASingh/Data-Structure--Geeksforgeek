package Revision;

import java.util.Scanner;

public class TopologicalSort {

	public static int[] stack;
	public static int front;
	public static int[] parentCount;
	public static int[] visited;
	public static boolean done = false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int T = 0; T < tc; T++) {
			int V = sc.nextInt();
			int E = sc.nextInt();
			int[][] graph = new int[V][V];
			visited = new int[V];
			parentCount = new int[V];
			stack = new int[V];
			for (int i = 0; i < E; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				graph[start][end] = 1;
				parentCount[end]++;
				// graph[end][start] = 1;
			}
			done = false;
			front = 0;
			for (int i = 0; i < V; i++) {
				if (parentCount[i] == 0 && visited[i] == 0) {
					
					stack[front++] = i;
					DFS(graph, i);
				}
			}
			
			for (int i = 0; i < front; i++) {
				System.out.println(stack[i]);
			}
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>");

		}
	}

	public static void DFS(int[][] graph, int src) {
		if (front == visited.length)
			done = true;
		visited[src] = 1;
		for (int i = 0; i < visited.length; i++) {
			int node = graph[src][i];
			if (done == false) {
				if (node == 1 && visited[i] == 0) {
					parentCount[i]--;
					if (parentCount[i] == 0) {
						stack[front++] = i;
						DFS(graph, i);
					}
				}
			}

		}
	}

}
