import java.util.*;

class Solution_DFS{
	
	public static ArrayList<ArrayList<Integer>> graph;
	public static int visited[];
	public static int memo[][];
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		int m = scan.nextInt();
		graph = new ArrayList<>();
		for(int i=0; i<n+1; i++) {
			graph.add(new ArrayList<>());
		}
		for(int i=0; i<k; i++) {
			int s = scan.nextInt();
			int d = scan.nextInt();
			graph.get(s).add(d);
			graph.get(d).add(s);
		}
		int [] s = new int[m];
		for(int i=0;i<m;i++) {
			s[i]=scan.nextInt();
		}
		visited = new int[n+1];
		for(int i=1; i<=n; i++) {
			visited[i] = 0;
		}
		int mark = 1;
		for(int i=1;i<=n;i++) {
			if(visited[i] == 0 ) {
				dfs(i,mark);
				mark++;
			}
		}
		
		memo = new int[m][];
        for (int i = 0; i < m; ++i) {
            memo[i] = new int[m];
            for (int j = 0; j < m; ++j) {
                memo[i][j] = 0;
            }
        }
		int res = longestPalindrome(s, 0, m-1);
		System.out.println(res);
		
		
		
	}
	
	public static void dfs(int u, int mark) {
		visited[u] = mark;
		for(int i: graph.get(u)) {
			if(visited[i] == 0) {
				dfs(i,mark);
			}
		}
		
	}
	
	public static int longestPalindrome(int[] s, int i, int j){
		
		if(visited[s[i]] == visited[s[j]]) {
			if(i == j) {
				return 1;
				
			} else if(i + 1 == j) {
				return 2;
			} else {
				if (memo[i+1][j-1] == 0) {
                    memo[i+1][j-1] = longestPalindrome(s, i+1, j-1);
                }
				
				return 2 + memo[i+1][j-1];
			}
			
		} else {
			if (memo[i+1][j] == 0) {
                memo[i+1][j] = longestPalindrome(s, i+1, j);
            }
            if (memo[i][j-1] == 0) {
                memo[i][j-1] = longestPalindrome (s, i, j-1);
            }
			return Math.max(memo[i+1][j], memo[i][j-1]);
		}
		
	}
}