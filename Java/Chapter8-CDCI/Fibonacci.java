import java.util.*;

public class Fibonacci {
	
	public static int[] memo;
	
	public static int fibo(int n){
		if(n == 1) {
			return 1;
		} else if(n==2) {
			return 1;
		} else {
			if(memo[n-1] == -1) {
				memo[n-1] = fibo(n-1);
			} 
			if(memo[n-2] == -1) {
				memo[n-2] = fibo(n-2);
			}
			memo[n] = memo[n-1] + memo[n-2];
			return memo[n];
		}
	}
	
	public static int fibo2(int n){
		int[] memo2 = new int[n+1];
		memo2[1] = 1;
		memo2[2] = 1;
		for(int i=3;i<=n;i++) {
			memo2[i] = memo2[i-1]+memo2[i-2];
		}
		return memo2[n];
	}
	
	public static void main(String[] args) {
		
		int n = 25;
		memo = new int[n+1];
		for(int i=1; i<=n; i++) {
			memo[i] = -1;
		}
		System.out.println("Fibonacci Number for n:"+n+" is:"+fibo2(n));
	}
}