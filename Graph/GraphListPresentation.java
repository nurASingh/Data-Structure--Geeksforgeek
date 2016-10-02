package Graph;

import java.util.Scanner;

public class GraphListPresentation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();

		int[][] graph = new int[V][V];
		int[] childCount = new int[V];

		for (int i = 0; i < E; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int w = sc.nextInt();
			graph[start][childCount[start]] = w;
			childCount[start]++;
		}
		
		for (int i = 0; i < childCount.length; i++) {
			System.out.print(childCount[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph.length; j++) {
				System.out.print(graph[i][j]+" ");
			}
			System.out.println();
		}

	}

}
