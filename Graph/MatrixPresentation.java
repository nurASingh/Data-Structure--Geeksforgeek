package Graph;

import java.util.Scanner;

public class MatrixPresentation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new  Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		int[][] graph = new int[V][V];
		
		for (int i = 0; i < graph.length; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			graph[start][end] = 1;
		}
		
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph.length; j++) {
				System.out.print(graph[i][j]+" ");
			}
			System.out.println();
		}
 	}

}
