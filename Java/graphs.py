#!/usr/bin/python
from collections import defaultdict

class Graph:
    def __init__(self):
        self.graph = defaultdict(list)

    def addEdge(self, u, v):
        self.graph[u].append(v)

    def getSize(self):
        return len(self.graph)

    def printGraph(self):
        print self.graph

    """
    BFS : Breadth First Search
    """
    def BFS(self, s):

        print "Size of the graph is {0}".format(self.getSize())

        visited = [False]*(len(self.graph))

        queue = []

        queue.append(s)
        visited[s] = True

        while queue:
            s = queue.pop(0)
            print s,

            for i in self.graph[s]:
                #print i

                if visited[i] == False:
                    queue.append(i)

                    visited[i] = True

    """
    DFS : Depth First Search
    """

    def DFS_Util(self, s, visited):
        visited[s] = True
        print s,

        for i in self.graph[s]:
            if visited[i] == False:
                self.DFS_Util(i, visited)


    def DFS(self, s):
        visited = [False] * (len(self.graph))

        self.DFS_Util(s, visited)


    """
    Topological sorting
    """

    def topological_sorting_util(self, s, visited, stack):
        visited[s] = True

        for i in self.graph[s]:
            if visited[i] == False:
                self.topological_sorting_util(i, visited, stack)

        stack.insert(0, s)

    def topological_sorting(self, s):

        visited = [False] * (len(self.graph))
        stack = []
        for i in range(len(self.graph)):
            if visited[i] == False:
                self.topological_sorting_util(i, visited, stack)

        print stack

    """
    Detecting cycles in graph
    """

    def is_cyclic_util(self, node, visited, recursion_stack):

        visited[node] = True
        recursion_stack[node] = True

        for neighbor_node in self.graph[node]:
            if visited[neighbor_node] == False:
                if self.is_cyclic_util(neighbor_node, visited, recursion_stack) == True:
                    return True
            elif recursion_stack[neighbor_node] == True:
                return True

    def is_cyclic(self):
        visited = [False] * (len(self.graph))
        recursion_stack = [False] * (len(self.graph))
        for node in range(len(self.graph)):
            if visited[node] == False:
                if self.is_cyclic_util(node, visited, recursion_stack) == True:
                    return True
        return False

if __name__ == '__main__':
    g = Graph()

    g.addEdge(0, 1)
    g.addEdge(0, 2)
    g.addEdge(1, 2)
    g.addEdge(2, 0)
    g.addEdge(2, 3)
    g.addEdge(3, 3)

    print g.printGraph()

    print "BFS is :"
    g.BFS(2)
    print "\n"

    print "DFS is :"
    g.DFS(2)

    print "Topological sorting is :"
    g.topological_sorting(2)

    """To detect cycle"""

    detect_cycle = Graph()
    detect_cycle.addEdge(0, 1)
    detect_cycle.addEdge(0, 2)
    detect_cycle.addEdge(1, 2)
    detect_cycle.addEdge(2, 0)
    detect_cycle.addEdge(2, 3)
    detect_cycle.addEdge(3, 3)

    print "Detecting cycle in graph"
    print detect_cycle.is_cyclic()

