import java.util.*;

public class TravellingSalesman{
	int[][] memo;
	int V;
	public int find_min_path(int[][]graph) {
		V = graph.length;
		memo = new int[V][V];
		int start = 0;
		for(int i=0; i<V; i++){
			memo[i][i] = 0;
			memo[i][start] = graph[i][start];
		} 
		
		for(int i=2; )
	}
	
	public static void main(String[] args) {
		
	}
}