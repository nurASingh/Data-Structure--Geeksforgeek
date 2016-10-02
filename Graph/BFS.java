package Graph;

import java.util.Scanner;

public class BFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		int[][] graph = new int[V][V];
		for (int i = 0; i < E; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			graph[start][end] = 1;
		}
		BFSAlgo(graph,V,2);
	}

	public static void BFSAlgo(int[][] graph, int N, int src) {
		int[] bfsQueue = new int[N];
		int front = 0;
		int rear = 0;
		int[] visited = new int[N];
		bfsQueue[front++] = src;
		visited[src] =1;

		while (front != rear) {
			// pop the first item
			int frontVertex = bfsQueue[rear++];
			
			System.out.println(frontVertex);
			for (int i = 0; i < N; i++) {
				int next = graph[frontVertex][i];

				if (next == 1 && visited[i] == 0) {
					bfsQueue[front++] = i;
					visited[i] =1;
				}
			}

		}

	}

}
