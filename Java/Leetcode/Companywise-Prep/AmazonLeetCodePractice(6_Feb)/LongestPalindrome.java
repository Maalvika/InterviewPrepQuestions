import java.util.*;

public class LongestPalindrome{
	
	public String longestPalindrome(String s) {
		
		int n = s.length();
		int len = 1;
		int startIdx = 0;
		boolean[][] memo = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			memo[i][i] = true;
		}
		
		for(int i=0; i<n-1; i++) {
			if(s.charAt(i)==s.charAt(i+1)) {
				memo[i][i+1] = true;
				len = 2;
				startIdx = i;
			}
			
		}
		
		for(int cur_len=3; cur_len<=n; cur_len++) {
			for(int i=0; i<n-cur_len+1; i++) {
				int j = i+cur_len-1;
				if(s.charAt(i) == s.charAt(j) && memo[i+1][j-1]) {
					memo[i][j] = true;
					len = cur_len;
					startIdx = i;
				}
			}
		}
		
		return s.substring(startIdx, startIdx+len);
	}
}