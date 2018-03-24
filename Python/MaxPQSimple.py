#  This works like the data type in MinPQSimple.py, except that it implements a max priority queue
#   rather than a min priority queue
from MinPQSimple import MinPQ

class MaxPQ(object):
    def __init__(self, key = lambda i: i):
        self._M = MinPQ(lambda i: -key(i))

    def getSize(self):
        return self._M.getSize()

    def insert(self, item):    # insert item to a min priority queue with negative of keys
        self._M.insert(item)  #  to simulate a max priority queue

    def extractMax(self):           
        item = self._M.extractMin()
        return  item

    def findMax(self):
        item = self._M.findMin()
        return  item

    def __str__(self):
         return str(self._M)

   

