import java.util.*;

public class RegularExpr{
	
	public static boolean isMatch(String s, String p){
		int m = s.length();
		int n = p.length();
		boolean[][] memo = new boolean[m+1][n+1];
		
		memo[0][0] = true;
		for(int i=1; i<=m; i++) {
			memo[i][0] = false;
		}
		
		for(int j=1; j<=n; j++) {
			if(p.charAt(j-1)=='*') {
				memo[0][j] = memo[0][j-2];
			}
		}
		
		for(int i=1; i<=m; i++) {
			for(int j=1; j<=n; j++) {
				if(s.charAt(i-1)== p.charAt(j-1) || p.charAt(j-1)=='.') {
					memo[i][j] = memo[i-1][j-1];
				} else if(p.charAt(j-1) == '*' ){
					memo[i][j] = memo[i][j-2];
					if(s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.') {
						memo[i][j] = memo[i][j]|| memo[i-1][j];
					}
				} else {
					memo[i][j] = false;
				}
			}
 		}
		for(int i=0; i<=m; i++) {
			for(int j=0; j<=n; j++) {
				System.out.print(memo[i][j]+" ");
				
			}
			System.out.println();
		}
		return memo[m][n];
	}
	
	public static void main(String[] args) {
		
		String s = "aab";
		String p = "c*a*b*";
		
		System.out.println("Match result:"+isMatch(s, p));
	}
}