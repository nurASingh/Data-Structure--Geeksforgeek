package Graph;

import java.util.Scanner;

public class PT07Z {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] graph = new int[N][N];
		for (int i = 0; i < N - 1; i++) {
			int start = sc.nextInt();

			int end = sc.nextInt();
			graph[start - 1][end - 1] = 1;
			graph[end - 1][start - 1] = 1;
		}
		int ans = 0;
		for (int i = 0; i < graph.length; i++) {
			if(graph[0][i] == 1){
				graph[0][i] =0;
				ans = ans + BFS(graph,i,N) +1;
			}
		}
		System.out.println(ans);
	}

	public static int BFS(int[][] graph, int src, int N) {

		int height = 0;
		int[] Q = new int[N];
		int[] W = new int[N];
		int[] visited = new int[N];
		int front = 0;
		int rear = 0;
		
		Q[front++] = src;
		int max = 0;
		
		while(front != rear){
			
			int v = Q[rear++];
			for (int i = 0; i < N; i++) {
				int node = graph[v][i];
				if(node ==1 && visited[i] ==0){
					Q[front++] = i;
					W[i] = W[v] + 1;
					if(max < W[i])
						max = W[i];
				}
			}
			visited[v] = 1;
			height = max;
		}

		return height;
	}

}
