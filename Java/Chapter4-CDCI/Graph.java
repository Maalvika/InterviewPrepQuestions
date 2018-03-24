import java.util.*;

public class Graph{
	
	ArrayList<Integer> adj[];
	int size;
	
	public Graph(int n) {
		adj = new ArrayList[n+1];
		size = n;
		for(int i=1; i<n+1; i++){
			adj[i] = new ArrayList<>();
		}
	}
	
	public void addEdge(int u, int v){
		adj[u].add(v);
	}
	public void addUndirectedEdge(int u, int v){
		adj[u].add(v);
		adj[v].add(u);
	}
	////////////////////////////////////// Topological Sort/////////////////////
	public Stack<Integer> DFS(){
		boolean[] visited = new boolean[size+1];
		Stack<Integer> s = new Stack<>();
		for(int i=1; i<=size; i++) {
			if(visited[i]==false) {
				DFS_Visit(i, visited, s);
			}
		}
		return s;
	}
	
	public void DFS_Visit(int u, boolean[] visited, Stack<Integer> s){
		visited[u] = true;

		for(Integer v: adj[u]){
			if(visited[v]==false)
				DFS_Visit(v, visited, s);
		}
		s.push(u);
		
	}
	////////////////////////////////// END TOPOSORT////////////////////////////
	
	
	public boolean findRoute(int n1, int n2){
		
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[size+1];
		q.add(n1);
		visited[n1] = true;
		while(!q.isEmpty()) {			
			int temp = q.remove();
			if(temp == n2) {
				return true;
			}
			for(int i: adj[temp]) {
				if(!visited[i]) {
					q.add(i);
				}
			}
		}
		return false;
	}
	////////////////////// Chapter 4 Question 1 END/////////////////////////////////
	
	////////////////////// Union-Find detect cycles in undirected graph ////////////
	int[] parent;
	public void union(int m, int n) {
		int parm = find(m);
		int parn = find(n);
		
		parent[parm] = parn;
	}
	
	public int find(int n) {
		if(parent[n] != n) {
			parent[n]= find(parent[n]);
		}
		return parent[n];
	}
	
	boolean isCycle(){
		parent = new int[size+1];
		for(int i =1; i<=size; i++) {
			parent[i] = i;
		}
		
		for(int i=1; i<=size; i++){
			for(Integer j:adj[i]) {
				int pari = find(i);
				int parj = find(j);
				System.out.println("i:"+i+" pari:"+pari);
				System.out.println("j:"+j+" parj:"+parj);
				if(pari == parj) {
					return true;
				}
				union(i, j);
			}
			
		}
		return false;
		
	}
	
	////////////////////// DFS detect cycles in undirected graph ////////////
	boolean dfs(){
		boolean[] visited = new boolean[size + 1];
		for(int i = 1; i<=size; i++) {
			if(!visited[i]) {
				if(dfs_visit(i, visited, -1)) {
					return true;
				}
			}
		}
		return false;
	}
	
	boolean dfs_visit(int i, boolean[] visited, int parent) {
		visited[i] = true;
		for(int j: adj[i]) {
			if(!visited[j]) {
				if(dfs_visit(j, visited, i)) {
					return true;
				}
			}else if(j != parent) {
				return true;
			}
		}
		return false;
	} 
	
	////////////////////// DFS detect cycles in directed graph ////////////
	Set<Integer> white = new HashSet<>();
	Set<Integer> grey = new HashSet<>();
    Set<Integer> black = new HashSet<>();
	public boolean dfs_directed() {
        
		for(int i=1; i<=size; i++) {
			white.add(i);
		}
        while(!white.isEmpty()) {
			Integer c= white.iterator().next();
			if(dfs_visit_directed(c)){
				return true;
			}
		}
        return false;
    }
    
    public boolean dfs_visit_directed(int u) {
        white.remove(u);
		grey.add(u);
        for(Integer v: adj[u]) {
            if(white.contains(v)) {
				if(dfs_visit_directed(v)){
					return true;
				}
			} else if(grey.contains(v)){
				return true;
			}
        }
        grey.remove(u);
		black.add(u);
        return false;
    }
	
	
	
	public static void main(String[] args) {
		int n = 6;
		Graph g = new Graph(n);
		g.addEdge(1,4);
		g.addEdge(6,2);
		g.addEdge(2,4);
		g.addEdge(6,1);
		g.addEdge(4,3);
		Stack<Integer> s = g.DFS();
		int temp;
		System.out.println("Topological Sort:");
		while(!s.isEmpty()){
			temp = s.pop();
			System.out.print(temp+" ");
			
		}
		int n1 = 6;
		int n2 = 3;
		System.out.println("\nIs path between "+n1+"->"+n2+" :" + g.findRoute(n1,n2));
		n1 = 1;
		n2 = 2;
		System.out.println("\nIs path between "+n1+"->"+n2+" :" + g.findRoute(n1,n2));
		n = 3;
		Graph g2 = new Graph(n);
		g2.addEdge(1,2);
		g2.addEdge(2,3);
		g2.addEdge(3,1);
		//System.out.println("is cycle:"+g2.isCycle());
		System.out.println("is cycle DFS:"+g2.dfs_directed());
		
	}
	
}