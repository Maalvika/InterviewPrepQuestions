import java.util.*;

//Problem:200
public class Islands{
	
	int[] parent;
	int cc = 0;
	
	public void union_op(int x, int y){
		int parX = find_op(x);
		int parY = find_op(y);
		
		if(parX ==parY) {
			return;
		}
		parent[parX] = parY;
		// Number of times union_op is called implies we are merging 2 components i.e. we have one less component
		cc--;
	}
	
	public int find_op(int x){
		if(parent[x]!=x) {
			parent[x] = find_op(parent[x]);
		}
		return parent[x];
	}
	

	public int numIslands(char[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
		for(int i=0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				if(grid[i][j]=='1'){
					cc++;
				}
			}
		}
		parent = new int[rows*cols];
		
		for(int i=0; i<parent.length; i++) {
			parent[i] = i;
		}
	}
	
	public void merge(char[][] grid, int r, int c) {
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(grid[i][j] == '0') {
					//do nothing
					continue;
				}
 				int x = i*c+j;
				int y;
				// if the element above is a 1
				if(i>0 && grid[i-1][j] == '1') {
					y = x - c;
					union_op(x,y);
				}
				if(i<r-1 && grid[i+1][j] == '1') {
					y = x+c;
					union_op(x,y)
				}
				if(j>0 && grid[i][j-1] == '1') {
					y = x-1;
					union_op(x,y)
				}
				if(j<c-1 && grid[i][j+1] == '1') {
					y = x+1;
					union_op(x,y);
				}
			}
		}
	}
}