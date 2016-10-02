package Graph;

import java.util.Scanner;

public class PathBetweeenTwoNode {

	public static int[] path;
	public static int front = 0;
	public static int dest = -1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int T = 0; T < tc; T++) {
			int V = sc.nextInt();
			int E = sc.nextInt();
			int[][] graph = new int[V][V];
			path = new int[V];

			int[] visited = new int[V];

			for (int i = 0; i < E; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				graph[start-1][end-1] = 1;
				graph[end-1][start-1] = 1;
			}
			int startNode = sc.nextInt()-1;
			int endNode = sc.nextInt();

			path[front++] = startNode;
			dest = endNode-1;
			DFSPath(graph,startNode,visited);

		}
	}

	public static boolean found = false;
	public static void DFSPath(int[][] graph, int src, int[] visited) {

		if(src== dest){
			for (int i = 0; i < front; i++) {
				System.out.println(path[i]+1);
			}
			return;
		}
			
			
		visited[src] = 1;
		//System.out.println(src);
		for (int i = 0; i < graph.length; i++) {
			int node = graph[src][i];
			if(node==1 && visited[i] ==0){
				path[front++] = i;
				DFSPath(graph,i,visited);
			}else if(i== graph.length-1 && (node==0 || visited[i] ==1)){
				path[--front]=-1;
			}

		}

	}

}
