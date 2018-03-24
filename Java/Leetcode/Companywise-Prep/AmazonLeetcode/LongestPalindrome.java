import java.util.*;

public class LongestPalindrome{
	
	public static String longestPalindrome(String s) {
		int n = s.length();
		boolean[][] memo = new boolean[n][n];
		int startId = 0;
		int len=1;
		
		//equivalent to the base case of 1
		for(int i=0; i<n; i++) {
			memo[i][i] = true;
		}
		
		//equivalent to the base case of 2
		for(int i=0; i<n-1; i++) {
			if(s.charAt(i)==s.charAt(i+1)) {
				memo[i][i+1] = true;
				startId = i;
				len = 2;
			}
		}
		
		for(int cur_len=3; cur_len<=n; cur_len++) {
			for(int i=0; i<n-cur_len+1; i++) {
				int j = i + cur_len-1;
				if(s.charAt(i)==s.charAt(j) && memo[i+1][j-1]) {
					memo[i][j] = true;
					startId = i;
					len = cur_len;
				}
			}
		}
		return s.substring(startId, startId+len);
		
    }
	
	public static void main(String[] args) {
		String s = "abbacd";
		System.out.println("longest palindrome substring is:"+longestPalindrome(s));
	}
}