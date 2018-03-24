class Graph:
	 
	n = None
	adj = None;
	visited = None
	
	def __init__(self, n):
		self.n = n
		self.adj = [[] for i in range(n)]
		for i in xrange(n): visited[i]=-1
	
	def add_directed_edge(self, u, v):
		self.adj[u].append(v)
		
	def add_undirected_edge(self, u, v):
		self.adj[u].append(v)
		self.adj[v].append(u)
				
	def DFS(self):
		index = 0;
		for i in xrange(n):
			if self.visted[i] == -1:
				index = index + 1
				self.DFSUtils(i, index)
			
	
	def DFSUtils(self, u, index):
		print u
		self.visited[u] = index
		if adj[u]!= None:
			for v in adj[u]:
				if self.visited[v] == -1:
					self.DFSUtils(v, index)
		
		
	
	
if __name__ == '__main__':

	print "Enter no of nodes"
	n = int(raw_input())
	graph = Graph(n)
	
	graph.add_directed_edge(0,1)
	graph.add_directed_edge(0,2)
	graph.add_directed_edge(1,2)
	graph.add_directed_edge(2,0)
	graph.add_directed_edge(2,3)
	graph.add_directed_edge(3,3)
	
	graph.DFS()
	
	
		