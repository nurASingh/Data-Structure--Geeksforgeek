package Graph;

import java.util.Scanner;

public class Dijkstra {
	public static int[] mset;
	public static int[] dist;
	public static int[] visited;
	public static int count;
	public static int ans;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		int[][] graph = new int[V][V];
		visited = new int[V];
		for (int i = 0; i < E; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int weight = sc.nextInt();
			graph[start - 1][end - 1] = weight;
			graph[end - 1][start - 1] = weight;
		}

		int src = sc.nextInt();
		dist = new int[V];
		mset = new int[V];

		for (int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
			mset[i] = -1;
			visited[i] = 0;

		}
		dist[0] = 0;
		ans = 0;
		count = 0;
		prims(graph, src - 1);
		//System.out.println(ans);
	}

	public static void prims(int[][] graph, int src) {

		if(count == graph.length){
for (int i = 0; i < graph.length; i++) {
	System.out.println(dist[i]);
}
			return;
		}
		for (int i = 0; i < graph.length; i++) {
			int currentWeight = graph[src][i];

			if (currentWeight > 0) {

				if (visited[i] == 0 && (dist[src] + currentWeight) < dist[i]) {

					dist[i] = dist[src] + currentWeight;
				}
			}
		}
		mset[count++] = src;
		visited[src] =1;
		
		prims(graph,minNode());

	}
	
	public static int minNode(){
		int  min = Integer.MAX_VALUE;
		int node= -1;
		for (int i = 0; i < visited.length; i++) {
			if(visited[i] ==0 && dist[i] < min ){
				node = i;
				min = dist[i];
			}
				
		}
		//System.out.println(min + "????");
		//ans = ans + min;
		return node;
	}

}
