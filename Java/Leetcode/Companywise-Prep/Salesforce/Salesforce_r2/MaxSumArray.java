import java.util.*;

public class MaxSumArray{
	
	public static int max_sum(int[] arr, int i){
		if(i<0) {
			return 0;
		}
		
		return Math.max(arr[i] + max_sum(arr, i-2), max_sum(arr, i-1));
	}
	
	public static void main(String[] args){
		int[] arr = {5, 5, 10, 100, 10, 5};
		System.out.println("Max sum value:"+max_sum(arr, arr.length-1));
	}
}