import java.util.*;

/**
*This solution doesnt work as expected. 
*It Simply return the base case rather than accumulating the string
*Sample Input: 12231
*Expected Output: 1221
*Actual Output: 22
*/
public class Solution {
	
	public static int memo[][];
	
	public static void main(String args[]) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the size");
		int m = scan.nextInt();
		int [] a=new int[m];
		System.out.println("Enter the elements");
		for(int i=0; i<m; i++) {
			a[i] = scan.nextInt();
		}
		memo = new int[m][];
        for (int i = 0; i < m; ++i) {
            memo[i] = new int[m];
            for (int j = 0; j < m; ++j) {
                memo[i][j] = 0;
            }
        }
		lcs_length(a, 0, m-1);
		for (int i=0; i<m; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(memo[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	
	public static int lcs_length(int[] s, int i, int j){
		
		if(s[i] == s[j]) {
			if(i == j) {
				return 1;
				
			} else if(i + 1 == j) {
				return 2;
			} else {
				if (memo[i+1][j-1] == 0) {
                    memo[i+1][j-1] = lcs_length(s, i+1, j-1);
                }
				memo[i][j] = 2 + memo[i+1][j-1];
				return memo[i][j];
			}
			
		} else {
			if (memo[i+1][j] == 0) {
                memo[i+1][j] = lcs_length(s, i+1, j);
            }
            if (memo[i][j-1] == 0) {
                memo[i][j-1] = lcs_length(s, i, j-1);
            }
			memo[i][j] = Math.max(memo[i+1][j], memo[i][j-1]);
			return memo[i][j];
		}
		
	}
	
	
}