package Graph;

import java.util.Scanner;

public class Krushkal {

	public static Path[] obj;
	public static Path[] objAns;
	public static int[] parent;
	public static int Ans = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int T = 0; T < tc; T++) {

			int V = sc.nextInt();
			int E = sc.nextInt();
			obj = new Path[E];
			objAns = new Path[V-1];
			parent = new int[V];
			java.util.Arrays.fill(parent, -1);
			for (int i = 0; i < E; i++) {
				obj[i] = new Path(sc.nextInt(), sc.nextInt(), sc.nextInt());
			}
			Ans = 0;
			sort(0, E - 1);
			krushkalAlgo(V,E);
			System.out.println(Ans);
			
		}

	}

	public static int find(int src) {
		if (parent[src] == -1)
			return src;
		return find(parent[src]);
	}

	public static boolean union(int v1, int v2) {
		boolean isCycle = false;

		int xset = find(v1);
		int yset = find(v2);

		if (xset == yset)
			isCycle = true;
		else
			parent[xset] = yset;
		return isCycle;
	}

	public static void krushkalAlgo(int V,int E) {
		int index = 0;
		int ansIndex = 0;
		int includedPath = 0;
		while (index < E && includedPath < V) {
			Path next = obj[index];
			if (union(next.start, next.end) == false) {
				Ans = Ans + next.weight;
				objAns[ansIndex] = next;
				ansIndex ++;
				System.out.print( next.start + ">" + next.end + ">" + next.weight);
				includedPath++;
			}
			System.out.println();
			index++;
		}
	}

	public static void sort(int src, int end) {

		if (src <= end) {
			int Pindex = partitionIndex(src, end);
			sort(src, Pindex - 1);
			sort(Pindex + 1, end);

		}
	}

	public static int partitionIndex(int src, int end) {
		int Pindex = src;
		int pivot = obj[end].weight;

		for (int i = src; i < end; i++) {
			if (pivot >= obj[i].weight) {
				Path temp = obj[i];
				obj[i] = obj[Pindex];
				obj[Pindex] = temp;
				Pindex++;
			}
		}
		Path temp = obj[end];
		obj[end] = obj[Pindex];
		obj[Pindex] = temp;
		return Pindex;
	}

}

class Path {
	int start = -1;
	int end = -1;
	int weight = -1;

	public Path(int s, int e, int w) {
		start = s;
		end = e;
		weight = w;
	}

}
