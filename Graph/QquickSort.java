package Graph;

public class QquickSort {

	public static int[] ar;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ar = new int[]{2 ,5 ,6 ,8,1,3,4,7,0,9};
		qSort(0,ar.length-1);
		for (int i = 0; i < ar.length; i++) {
			System.out.print(ar[i] + " ");
		}
	}

	public static int partitionIndex(int src, int end) {
		int PIndex = src;
		int pivot = ar[end];

		for (int i = src; i < end; i++) {

			if (ar[i] <= pivot) {
				int temp = ar[i];
				ar[i] = ar[PIndex];
				ar[PIndex] = temp;
				PIndex++;
				//System.out.println(ar[i] +" >" + ar[PIndex] + "> " +PIndex);
			}
		}
		int temp = ar[end];
		ar[end] = ar[PIndex];
		ar[PIndex] = temp;
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
