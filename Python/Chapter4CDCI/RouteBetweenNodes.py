import Queue

class Graph:
	
	def __init__(self, n):
		self.n = n
		self.adj = [[] for i in xrange(n)]
	
	def directed_edge(self, u, v):
		self.adj[u].append(v)
		
	def undirected_edge(self, u, v):
		self.adj[u].append(v)
		self.adj[v].append(u)
		
	def isRoute(self, u, v):
		q = Queue.Queue()
		q.put(u)
		while q.empty() == False:
			temp = q.get()
			if(temp == v):
				return True
			for x in self.adj[temp]:
				q.put(x)
		
		return False
	
	
if __name__ == '__main__':
	
	print "Enter number of edges:"
	n = int(raw_input())
	
	g = Graph(n)
	
	g.directed_edge(0,1)
	g.directed_edge(0,2)
	g.directed_edge(2,0)
	g.directed_edge(1,2)
	g.directed_edge(2,3)
	g.directed_edge(3,3)
	
	print "Is Route?!",g.isRoute(1,3)
			