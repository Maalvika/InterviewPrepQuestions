import java.util.*;

//Problem No. 200
// This solution is based on path-compression implementation of Union Find
// Weighted isnt implemented due to overhead of the class to mantain rank at each node
public class NumIsland {
    
    public int parents[];
	public int cnt = 0;
    
    public int find_op(int x) {
		if(x!=parents[x]) {
			parents[x] = find_op(parents[x]);
		}
		return parents[x];
	}
    
    
	public void union_op(int x, int y){
        //System.out.println("here");
		int rootX = find_op(x);
		int rootY = find_op(y);
		if(rootX == rootY) {
            return;
        }
        parents[rootX] = rootY;
		cnt--;
	}
    
    public int numIslands(char[][] grid) {
        
        if(grid.length == 0) {
            return 0;
        }
        int r = grid.length;
        int c = grid[0].length;
        for(int i =0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(grid[i][j] == '1') {
					cnt++;
                }
			}
		}
		parents = new int[r*c];
		for(int i=0; i<r*c; i++) {
			parents[i] = i;
		}
        countIsland(grid);
        return cnt;
    }
    
    public void countIsland(char[][] grid){
        int r = grid.length;
		int c = grid[0].length;
		
		for(int i =0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(grid[i][j] == '0') {
					continue;
				}
                //System.out.println("here1");
				int x = i*c+j;
				int y;
				if (i>0 && grid[i-1][j]=='1') {
                    //System.out.println("here2");
					y = x - c;
					union_op(x,y);
				} 
				if(i<r-1 && grid[i+1][j] == '1') {
					y = x + c;
					union_op(x,y);
				}
				if(j>0 && grid[i][j-1] == '1') {
					y = x - 1;
					union_op(x,y);
				}
				if(j<c-1 && grid[i][j+1] == '1') {
					y = x + 1;
					union_op(x,y);
				}
			}
		}
    }
}