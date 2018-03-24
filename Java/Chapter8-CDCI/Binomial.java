import java.util.*;

public class Binomial{
	
	public static int[][] memo;
	
	// Recursion for binomial coefficient is: C(n,k) = C(n-1, k-1) + C(n-1,k)
	public static int binom(int n, int k){
		
		if(k == 0) {
			return 1;
		} else if(n==k) {
			return 1;
		} else {
			if(memo[n-1][k-1] == -1) {
				memo[n-1][k-1] = binom(n-1,k-1);
			}
			if(memo[n-1][k] == -1) {
				memo[n-1][k] = binom(n-1, k);
			}
			memo[n][k] = memo[n-1][k-1] + memo[n-1][k];
			return memo[n][k];
			
		}
		
	}
	
	public static void main(String[] args) {
		int n = 5;
		int k = 3;
		
		memo = new int[n+1][k+1];
		for(int i = 0; i<=n; i++) {
			for(int j=0; j<=k; j++) {
				memo[i][j] = -1;
			}
		}
		
		System.out.println("coeficient to binomial is:"+binom(n,k));
	}
}