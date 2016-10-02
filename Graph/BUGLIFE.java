package Graph;

import java.util.Scanner;

public class BUGLIFE {

	//public static boolean ans = false;

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
				graph[start - 1][end - 1] = 1;
				graph[end - 1][start - 1] = 1;
			}
			int[] color = new int[V];
			for (int i = 0; i < color.length; i++) {
				color[i] = -1;
			}
			int src = 0;
			color[src] = 0;
			
			System.out.println("Scenario #" + (T + 1) + ":");
			BFS(graph,V);
		}
	}

	public static void BFS(int[][] graph, int N) {

		int[] color = new int[N];
		for (int i = 0; i < N; i++) {
			color[i] = -1;
		}
		color[0] = 0;

		int[] Q = new int[N];
		int front = 0;
		int rear = 0;

		Q[front++] = 0;
		boolean ans = false;

		int[] visited = new int[N];
		while (front != rear) {
			int node = Q[rear++];
			
			for (int i = 0; i < N; i++) {
				int connect = graph[node][i];
				if(connect ==1){
					 if(color[node] == color[i]){
						ans = true;
						break;
					}else if(color[i] ==-1){
						color[i] = 1- color[node];
						Q[front++] = i;
					}
					
				}
			}
			if(ans == true)
				break;

		}
		
		if (ans == true) {
			System.out.println("Suspicious bugs found!");
		} else {
			System.out.println("No suspicious bugs found!");
		}
	}

}
