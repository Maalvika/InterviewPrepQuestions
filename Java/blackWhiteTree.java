import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	
	class Graph{
		public ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
		boolean[] colored;
		
		public Graph(int n){
			colored = new boolean[n+1];
			for(int i=0; i<n+1; i++) {
				tree.add(new ArrayList<>());
				colored[i] = false;
			}
		}
		
		public void addEdge(int x, int y){
			tree.get(x).add(y);
			tree.get(y).add(x);
		}
		
		public void root(){
			
		}
		
	}
	
	class Edge{
		int x;
		int y;
	}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] c = new int[n];
        for(int c_i = 0; c_i < n; c_i++){
			int val = in.nextInt();
			if (val == 0){
				val = -1;
			}
            c[c_i] = val;
        }
		ArrayList<Edge> edges = new ArrayList<>();
        for(int a0 = 0; a0 < n-1; a0++){
            int x = in.nextInt();
            int y = in.nextInt();
            // Write Your Code Here
        }
        in.close();
    }
}
