import java.util.*;

public class MaxSumNoAdj {
	
	public static void main(String[] args) {
		
		int[] arr = {5,  5, 10, 40, 50, 35};
		System.out.println("max sum is:"+find_maxsum(arr, arr.length-1));
	
	}
	
	public static int find_maxsum(int[] arr, int i){
		
		if(i==0){
			return arr[i];
		} else if(i==1) {
			return Math.max(arr[0], arr[1]);
			
		} else {
			return Math.max(arr[i]+find_maxsum(arr, i-2), find_maxsum(arr, i-1));
		}
	}
}