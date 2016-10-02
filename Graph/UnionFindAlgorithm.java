package Graph;

import java.util.Scanner;

public class UnionFindAlgorithm {

	public static int[] parent;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		for (int T = 0; T < tc; T++) {
			int V = sc.nextInt();
			int E = sc.nextInt();
			int[][] graph = new int[V][V];
			parent = new int[V];
			for (int i = 0; i < V; i++) {
				parent[i] = -1;
			}
			boolean flag = false;
			for (int i = 0; i < E; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				if (isCycle(start,end) == true){
					flag = true;
				}
					
			}
			if(flag == true)
				System.out.println("Cycle");
			else
				System.out.println("No Cycle");
		}
		



	}

	public static int findParent(int vertex) {
		if (parent[vertex] == -1)
			return vertex;
		return findParent(parent[vertex]);
	}

	public static void union(int vertex1, int vertex2) {

		int xset = findParent(vertex1);
		int yset = findParent(vertex2);
		parent[xset] = yset;
	}

	public static boolean isCycle(int vertex1, int vertex2) {

		boolean cycle = false;
		int xset = findParent(vertex1);
		int yset = findParent(vertex2);
		if(xset== yset)
			cycle = true;
		else{
			union(vertex1,vertex2);
		}
		return cycle;

	}

}
