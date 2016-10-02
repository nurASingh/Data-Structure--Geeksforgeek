package Graph;

import java.util.Scanner;

public class BiPitrate {

	public static int[] stack;
	public static int[] visited;
	public static int[] parentCount;
	public static int front = 0;
	public static int startnode;
	public static int[] dist;
	public static int rear = 0;
	public static int[] queue ;
	public static int[] color;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int T = 0; T < tc; T++) {
			int V = sc.nextInt();
			int E = sc.nextInt();
			int[][] graph = new int[V][V];
			parentCount = new int[V];
			stack = new int[V];
			visited = new int[V];
			dist = new int[V];
			queue = new int[V];
			color = new int[V];
			for (int i = 0; i < E; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				graph[start][end] = 1;
			}
			BFS(graph, 0);
		}

	}

	public static void BFS(int[][] graph, int src) {
		visited[src] = 1;
		queue[rear++] = src;
		color[src] = 1;
		boolean status = false;
		while(front != rear){
			int node = queue[front++];
			for (int i = 0; i < graph.length; i++) {
				int nextNode = graph[node][i];
				if(nextNode ==1){
					if(color[node] == color[i]){
						System.out.println("YES");
						status = true;
						break;
					}else{
						if(color[node] ==1){
							color[i] =2;
						}else{
							color[i] =1;
						}
						queue[rear++] = i;
					}
				}
			}
			if(status == true)
				break;
		}
		

	}

}
