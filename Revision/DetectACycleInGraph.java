package Revision;

import java.util.Scanner;

public class DetectACycleInGraph {
	public static int[] stack;
	public static int front = 0;
	public static boolean found = false;
	public static int[] visited;

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
				// graph[end][start] = 1;
			}

			front = 0;
			stack = new int[V];
			java.util.Arrays.fill(stack, -1);
			visited = new int[V];
			found = false;
			int src = 0;
			
			
			
			for (int i = 0; i < V; i++) {
				
				if(found == false && visited[i] ==0){
					stack[front++] = i;
					DFS(graph,i);
				}
				if(found == true)
					break;
				
			}
			
			
			
			if(found == true){
				System.out.println("Found");
				for (int j = 0; j < front; j++) {
					System.out.println(stack[j]);
				}
			}else{
				System.out.println("Not Found");
			}
		}
	}

	public static void DFS(int[][] graph, int src) {
		visited[src] = 1;
		for (int i = 0; i < visited.length; i++) {
			if(found == false){
				int node = graph[src][i];
				if (node == 1 && visited[i] == 0) {
					stack[front++] = i;
					DFS(graph, i);
				}else if(node == 1 && visited[i] == 1) {
					if(checkStack(i) == true)
					found = true;
				}
				else if (i == visited.length - 1
						&& (node == 0 || visited[i] == 1)) {
					stack[--front] = -1;
				}
			}


		}
	}
	
	public static boolean checkStack(int src){
		boolean status = false;
		for (int i = 0; i < front; i++) {
			if(stack[i] == src)
				status = true;
		}
		return status;
	}

}
