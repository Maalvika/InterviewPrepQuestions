import java.util.*;

public class Solution{
	
	public static void main(String args[]){
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] a = new int[n];
		for(int i=0; i<n; i++) {
			a[i] = scan.nextInt();
		}
		int m = scan.nextInt();
		int[] b = new int[m];
		for(int i=0; i<m; i++) {
			b[i] = scan.nextInt();
		}
		int res = medianAux(a, 0, n, b, 0, m);
		System.out.println("result:"+res);
		
	}
	
	public static int medianAux(int a[], int a_i, int a_j, int b[], int b_i, int b_j){
		if(a.length + b.length <= 4) {
			int i =0, j = 0, k =0;
			int[] c = new int[a.length + b.length];
			while(i<a.length || j<b.length){
				if(a[i]<b[j]) {
					c[k] = a[i];
					i++;
					k++;
				} else if(a[i]>b[j]) {
					c[k] = b[j];
					j++;
					k++;
				} else if(a.length!=0 && b.length==0){
					c[k] = a[i];
					i++;
					k++;
				} else if(b.length!=0 && a.length==0){
					c[k] = b[j];
					j++;
					k++;
				}
			}
		} else {
			int a_mean = findMedian(a);
			int b_mean = findMedian(b);
			int len_a = a_j - a_i;
			int len_b = b_j - b_i;
			if(a_mean == b_mean) {
				return a_mean;
			} else if(a_mean > b_mean) {
				int[] temp_a = Arrays.copyOfRange(a, len_a/2 , a.length);
				int[] temp_b = Arrays.copyOfRange(a, 0 , len_b/2+1);
				
				return medianAux(temp_a, a_i+len_a/2, a_j, temp_b, b_i, b_j-len_b/2);
			} else {
				int[] temp_a = Arrays.copyOfRange(a, 0 , len_a/2+1);
				int[] temp_b = Arrays.copyOfRange(a, len_b/2 , b.length);
				
				return medianAux(temp_a, a_i, a_j-len_a/2, temp_b, b_i+len_b/2, b_j);
				
			}
		}
		return -1;
	}

	public static int findMedian(int []arr) {
		if(arr.length%2 == 0) {
			return (arr[(arr.length-1)/2]+arr[(arr.length)/2])/2;
		} else {
			return arr[(arr.length-1)/2];
		}
	}
}