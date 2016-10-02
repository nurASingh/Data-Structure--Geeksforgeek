package Graph;

import java.util.Scanner;

public class MSTPrims {

	public static int[] mset;
	public static int[] dist ;
	public static int[] visited;
	public static int count;
	public static int ans ;
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
			graph[start-1][end-1] = weight;
			graph[end-1][start-1] = weight;
		}
		
		
		int src = sc.nextInt();
		dist = new int[V];
		mset = new int[V];
		
		for (int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
			mset[i] = -1;
			visited[i] = 0;
			
		}
		ans = 0;
		count =0;
		prims(graph,src-1);
		System.out.println(ans);

	}
	
	public static void prims(int[][] graph, int src){
		
		mset[count++] = src;
		
		if(count == graph.length){
			System.out.println();
			for (int i = 0; i < graph.length; i++) {
				System.out.print((mset[i]+1) + " ");
			}
			return;
		}
		
		for (int i = 0; i < graph.length; i++) {
			int next = graph[src][i];
			if(next != 0 && visited[i] == 0 && dist[i] > next){
				dist[i] = next;
			}
		}
		
		// get minimum node now
		visited[src] =1;
		src = minNode();
		System.out.println(src);
		prims(graph,src);
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
		System.out.println(min + "????");
		ans = ans + min;
		return node;
	}

}
