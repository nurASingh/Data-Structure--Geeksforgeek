package Graph;

import java.util.Arrays;
import java.util.Scanner;

public class Topological {

	public static int[] stack;
	public static int[] visited;
	public static int[] parentCount;
	public static int front = 0;

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
			for (int i = 0; i < E; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				parentCount[end]++;
				graph[start][end] = 1;
			}
			Arrays.fill(stack, -1);
			for (int i = 0; i < V; i++) {
				if (parentCount[i] == 0 && visited[i]==0){
					DFS(graph, i);
					break;
				}
					
			}
		}

	}

	public static void DFS(int[][] graph, int src) {

		visited[src] = 1;
		stack[front++] = src;
		if(front == graph.length){
			for (int i = 0; i < front; i++) {
				System.out.println(stack[i]);
			}
			front=0;
			Arrays.fill(stack,-1);
			Arrays.fill(visited,0);
			return;
		}
		for (int i = 0; i < graph.length; i++) {
			int next = graph[src][i];
			if(next ==1)
				parentCount[i]--;
			if (next == 1 && visited[i] == 0 && parentCount[i] ==0) {
				DFS(graph,i);
			}else if(i == graph.length-1 && (next == 0 || visited[i]==1)){
				// look for another zero
				for (int k = 0; k < graph.length; k++) {
					if (parentCount[k] == 0 && visited[k]==0){
						DFS(graph, k);
						break;
					}
						
				}
			}
		}
	}
}
