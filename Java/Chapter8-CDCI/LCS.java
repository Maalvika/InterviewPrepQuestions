import java.util.*;

public class LCS {
	
	public static int[][]memo;
	
	public static void main(String args[]){
		
		String s1 = "abc";
		String s2 = "bcd";
		char[] s1_chars = s1.toCharArray();
		char[] s2_chars = s2.toCharArray();
		memo = new int[s1_chars.length+1][s2_chars.length+1];
		for(int i=0; i<=s1_chars.length; i++) {
			for(int j=0; j<=s2_chars.length; j++) {
				memo[i][j]=-1;
			}
		}
		int len = lcs_length(s1.toCharArray(), s2.toCharArray(), 0,0);
		System.out.println("Length of longest common subsequence recursion:"+len);
		
		for(int i=0; i<=s1_chars.length; i++) {
			for(int j=0; j<=s2_chars.length; j++) {
				memo[i][j]=-1;
			}
		}
		
		len = lcs_length_memo(s1.toCharArray(), s2.toCharArray(), 0,0);
		System.out.println("Length of longest common subsequence dp:"+len);
		String s3 = "aabebcdd";
		char[] s3_char = s3.toCharArray();
		memo = new int[s3_char.length+1][s3_char.length+1];
		for(int i=0; i<=s1_chars.length; i++) {
			for(int j=0; j<=s2_chars.length; j++) {
				memo[i][j]=0;
			}
		}
		
		int len_lrs = lrs_length_memo(s3_char);
		System.out.println("Length of longest repeating subsequence:"+len_lrs);
		
	}
	
	// simple recursion                              
	public static int lcs_length(char[] a, char[] b, int ai, int bi){
		
		if(ai>=a.length || bi>=b.length) {
			return 0;
		}
		
		if(a[ai] == b[bi]) {
				return 1+ lcs_length(a, b, ai+1, bi+1);
		} else {
			return Math.max(lcs_length(a,b, ai+1, bi), lcs_length(a,b,ai, bi+1));
		}
	}
	
	public static int lcs_length_memo(char[] a, char[] b, int ai, int bi){
		
		if(ai>=a.length || bi>=b.length) {
			return 0;
		}
		
		if(a[ai] == b[bi]) {
			if(memo[ai+1][bi+1] == -1) {
				memo[ai+1][bi+1] = lcs_length_memo(a, b, ai+1, bi+1);
				
			}
			memo[ai][bi] = 1 + memo[ai+1][bi+1];
			return memo[ai][bi];
		} else {
			if(memo[ai][bi+1] == -1) {
				memo[ai][bi+1] =lcs_length_memo(a, b, ai, bi+1);	
			}
			
			if(memo[ai+1][bi] == -1) {
				memo[ai+1][bi] =lcs_length_memo(a, b, ai+1, bi);
			}
			memo[ai][bi] = Math.max(memo[ai+1][bi], memo[ai][bi+1]);
			return memo[ai][bi];
		}
	}
	
	public static int lrs_length_memo(char[] a){
		int n = a.length;
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(a[i-1] == a[j-1] && i!=j) {
					memo[i][j] = 1 + memo[i-1][j-1];
				} else {
					memo[i][j] = Math.max(memo[i-1][j], memo[i][j-1]); 
				}
			}
		}
		return memo[n][n];
	}
}