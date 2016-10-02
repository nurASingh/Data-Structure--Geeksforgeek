package Graph;

import java.util.Scanner;

public class CrabGraphs {

	public static int[] connectedCounts ;
	public static int[] visited;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int T = 0; T < tc; T++) {
			int V = sc.nextInt();
			int K = sc.nextInt();
			int E = sc.nextInt();
			connectedCounts = new int[V];
			visited = new int[V];
			int ans = 0;

			int[][] graph = new int[V][V];
			for (int i = 0; i < E; i++) {
				int V1 = sc.nextInt();
				int V2 = sc.nextInt();
				graph[V1-1][V2-1] =1;
				graph[V2-1][V1-1] =1;
				connectedCounts[V1-1]++;
				connectedCounts[V2-1]++;
			}
			
			for (int i = 0; i < V; i++) {
				if(connectedCounts[i] >= K){
					ans = ans + solveMe(graph,i,K);
				}
			}
			System.out.println(ans);
		}
	}
	
	public static int solveMe(int[][] graph, int src,int K){
		int Ecount = 0;
		for (int i = 0; i < graph.length; i++) {
			int connect = graph[src][i];
			if(connect ==1 && visited[i]==0 && connectedCounts[i] <K){
				Ecount++;
				connectedCounts[i]--;
			}
		}
		visited[src] =1;
		System.out.println(Ecount+">>");
		return Ecount>=K? Ecount : 0;
	}

}
