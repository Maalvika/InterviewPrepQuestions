'''
This is an implementation of the adjacency-list representation of a graph
where the vertices are numbered from 0 through n-1.

The class has integer variables recording the number n of vertices
and number m of edges.  It has a list ._verts of length n of lists of integers.
The list that appears in position i of this list is the list of neighbors
of vertex i.  For example, if ._verts is [[1,2], [], [0]], then
there are three vertices, since there are three lists in it.  Vertex 0
has neighbors 1 and 2, vertex 1 has no neighbors, and vertex has 0 as
its only neighbor.
'''
class Graph(object):

  # return number of vertices
  def getn(self):
     return len(self._verts)

  # return number of edges
  def getm(self):
     return self._m

  def neighbors(self, i):
    return self._verts[i]

  def __init__ (self, numVerts, edgeList):
    self._m = len(edgeList)
    self._verts = [[] for i in range(numVerts)]
    for u, v in edgeList:
      self.neighbors(u).append(v)  # works because neighbors returns a reference
                                   #  to the neighbor list

  ''' String representation of the graph.  If G is an instance of the class,
      this is called with str(G).  It is called implicitly when a string
      is expected, e.g. in a call to print(G) '''
  def __str__(self):
     return 'n = ' + str(self.getn()) + ' m = ' + str(self.getm()) + '\n' + str(self._verts)


  ''' This is a varant on DFS that returns a list of vertices that
      were blackened during the call, in the order in which they finished. '''
  def finishOrder(self, i, colored, finished):
    colored[i] = True
    for j in self.neighbors(i):
      if not colored[j]:
        finished = self.finishOrder(j, colored, finished)
    finished.append(i)
    return finished

  def root(self, E):
      colored = [False]*n
      Order = self.finishOrder(0, colored, [])
      FinishTime = [0]*n
      for i in range(n):
          FinishTime[Order[i]] = i
      FinishTime
      EPrime = [i for i in E if FinishTime[i[0]] > FinishTime[i[1]]]
      D = Graph(n, EPrime)
      return D, Order

  def Solve(self, i, Ranges):
      if abs(Ranges[i][0]) < abs(Ranges[i][1]):
          minMax = 1
      else: 
          minMax = -1
      Nodeset = []
      self.FindSet(i, Ranges, minMax, Nodeset)
      Nodeset.sort()
      Nodeset = [i+1 for i in Nodeset]
      return Nodeset

  def FindSet(self, i, Ranges, minMax, Nodeset):
      Nodeset.append(i)
      if minMax == -1:
          NegNeighbors = [j for j in self.neighbors(i) if Ranges[j][0] < 0]
          for j in NegNeighbors:
              self.FindSet(j, Ranges, minMax, Nodeset)
      else:
          PosNeighbors = [j for j in self.neighbors(i) if Ranges[j][1] > 0]
          for j in PosNeighbors:
              self.FindSet(j, Ranges, minMax, Nodeset)

if __name__ == '__main__':
    n = int(raw_input())
    Labels = map(int, raw_input().strip().split(' '))
    for i in range(n):
        if Labels[i] == 0:
            Labels[i] = -1
    E = []
    for _ in range(n-1):
        u,v = map(int, raw_input().strip().split(' '))
        E.append((u-1,v-1))
        E.append((v-1,u-1)) 

    G = Graph(n, E)
    colored = [False]* n
    D, Order = G.root(E) 
    Ranges = [[0,0]]*n
    for i in Order:
        N = D.neighbors(i)   
        if len(N) == 0:
            Ranges[i] = [Labels[i], Labels[i]]
        else:
            First = Labels[i] + sum([Ranges[j][0] for j in N if Ranges[j][0] < 0])
            Second = Labels[i] + sum([Ranges[j][1] for j in N if Ranges[j][1] > 0])
            Ranges[i] = [First, Second]

    minVal = 0
    minNode = 0
    for i in range(n):
        if Ranges[i][0] < minVal:
            minVal = Ranges[i][0]
            minNode = i
    maxVal = 0
    maxNode = 0
    for i in range(n):
        if Ranges[i][1] > maxVal:
            maxVal = Ranges[i][1]
            maxNode = i
    if abs(Ranges[minNode][0]) < abs(Ranges[maxNode][1]):
        print Ranges[maxNode][1]
        Solution = D.Solve(maxNode, Ranges)
    else:
        print -Ranges[minNode][0]
        Solution = D.Solve(minNode, Ranges)
    print len(Solution)
    Outstring = ''
    for i in Solution:
        Outstring += str(i) + ' '
    print Outstring.strip() 
    
