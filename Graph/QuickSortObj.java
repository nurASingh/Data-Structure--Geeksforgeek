package Graph;

import java.util.Scanner;

public class QuickSortObj {

	public static Edge[] arObj;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		
		int V = sc.nextInt();
		int E = sc.nextInt();
		arObj = new Edge[E];
		//arObj = new Path[V-1];
		//parent = new int[V];
		//java.util.Arrays.fill(parent, -1);
		for (int i = 0; i < E; i++) {
			arObj[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		
	/*	for (int i = 0; i < N; i++) {
			arObj[i] = new Edge((int) Math.floor(Math.random()*N) ,(int) Math.floor(Math.random()*N), (int) Math.floor(Math.random()*N));
		}*/
		
		for (int i = 0; i < arObj.length; i++) {
			System.out.println(arObj[i].src + " >" +arObj[i].end + " >" +arObj[i].weight);
		}
		qSort(0,V-1);
		System.out.println("_____________________________________________");
		for (int i = 0; i < arObj.length; i++) {
			System.out.println(arObj[i].src + " >" +arObj[i].end + " >" +arObj[i].weight);
		}
	}
	
	
	public static int partitionIndex(int src, int end) {
		int PIndex = src;
		Edge pivot = arObj[end];

		for (int i = src; i < end; i++) {

			if (arObj[i].weight <= pivot.weight) {
				Edge temp = arObj[i];
				arObj[i] = arObj[PIndex];
				arObj[PIndex] = temp;
				PIndex++;
				//System.out.println(ar[i] +" >" + ar[PIndex] + "> " +PIndex);
			}
		}
		Edge temp = arObj[end];
		arObj[end] = arObj[PIndex];
		arObj[PIndex] = temp;
		return PIndex;

	}

	public static void qSort(int src , int end){
	
		if(src <= end){
			int index = partitionIndex(src,end);
			qSort(src,index-1);
			qSort(index+1,end);
		}
	}

}

class Edge {
	
	int src ;
	int end;
	int weight;
	
	public Edge(int src , int end , int weight){
		this.src = src;
		this.end = end;
		this.weight = weight;
	}	
}
