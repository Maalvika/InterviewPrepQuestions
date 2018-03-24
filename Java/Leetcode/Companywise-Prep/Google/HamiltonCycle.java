import java.util.*;

public class HamiltonCycle {
	int[][] graph;
	int V;
	int[] path;
	
	public HamiltonCycle(int[][] graph){
		this.graph = graph;
		V = graph.length;
		path = new int[V];
		
	}
	
	public boolean isSafe(int v, int pos){
		//System.out.println("pos:"+pos);
		//System.out.println("v:"+v);
		if(graph[path[pos-1]][v] == 0) {
			return false;
		}
		
		for(int i=0; i<pos; i++) {
			if(path[i]==v) {
				return false;
			}
		}
		return true;
	}
	
	public boolean hamiltonCycle_utils(int pos){
		if(pos == V) {
			//found the complete cycle
			//System.out.println("reached end");
			if(graph[path[V-1]][path[0]] == 1) {
				return true;
			}else {
				return false;
			}
		}
		
		for(int i=1; i<V; i++) {
			
			if(isSafe(i,pos)) {
				path[pos] = i;
				if(hamiltonCycle_utils(pos + 1)) {
					return true;
				}
				path[pos] = -1;
			}
		}
		return false;
	}
	
	public int hamiltonCycle(){
		//initialize
		for(int i=0; i<V; i++) {
			path[i] = -1;
		}
		path[0] = 0;
		
		if(!hamiltonCycle_utils(1)) {
			System.out.println("\nNo Cycle");
			return 0;
		}
		System.out.println("The path is:");
		for(int i=0; i<V; i++) {
			System.out.print(path[i]+" ");
		}
		System.out.print(path[0]);
		return 1;
		
	}
	
	public static void main(String[] args) {
		
		
        /* Let us create the following graph
           (0)--(1)--(2)
            |   / \   |
            |  /   \  |
            | /     \ |
           (3)-------(4)    */
        int graph1[][] = {{0, 1, 0, 1, 0},
            {1, 0, 1, 1, 1},
            {0, 1, 0, 0, 1},
            {1, 1, 0, 0, 1},
            {0, 1, 1, 1, 0},
        };
	HamiltonCycle hamiltonian =
                                new HamiltonCycle(graph1);
        // Print the solution
        hamiltonian.hamiltonCycle();
		
		int graph2[][] = {{0, 1, 0, 1, 0},
            {1, 0, 1, 1, 1},
            {0, 1, 0, 0, 1},
            {1, 1, 0, 0, 0},
            {0, 1, 1, 0, 0},
        };
		HamiltonCycle hamiltonian1 =
                                new HamiltonCycle(graph2);
		hamiltonian1.hamiltonCycle();
		
	}
}