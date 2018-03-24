# This is an implementation of a priority queue with a heap.  It does not support 'delete'
#  or 'reduceKey' because it doesn't carry a lookup table for finding an element quickly
#  in the heap.  
class MinPQ(object):

   def __init__(self, key = lambda i: i):
       self._H = [0]
       self._size = 0
       self._allocation = 1
       self._key = key

   def getSize(self):
      return self._size

   def insert(self, item):
      if self._size == self._allocation:
         self._H = self._H + [0] * self._allocation
         self._allocation = self._allocation * 2
      pos = self._size
      self._H[pos] = item
      self._size += 1
      self.bubbleUp(pos)
 
   def extractMin(self):
       if self._size == 0:  return None
       else:
          item = self._H[0]
          self.swap(0, self._size - 1)
          self._size = self._size - 1
          if self._size < self._allocation / 4:
              self._allocation /= 2
              self._H = self._H[0:self._allocation]
          self.heapify(0)
          return item
       
   def findMin(self):
       item = self._H[0]
       return item


  # ----------------   Private methods -------------------

   # get current allocation
   def getAllocation(self):
      return self._allocation

   # get a reference to the heap array
   def getArray(self):
      return self._H

   #  Find the parent of index pos, or return None if it's the root.
   #    There is no check to see if pos >= self._size
   #    Example of a call:  P.parent(i).  This assigns the reference in P
   #    to 'self' and the reference to the integer in pos to i.
   def parent(self, pos):
      if pos <= 0: return None
      else: return (pos - 1) / 2

   # Restore the heap property by bubbling up an element whose key is smaller than
   #  its parent
   def bubbleUp(self, pos):
      while pos > 0 and self._key(self._H[self.parent(pos)]) > self._key(self._H[pos]):
         self.swap(self.parent(pos), pos)
         pos = self.parent(pos)

   def leftChildPos(self, pos):
       j = (pos+1)*2 - 1
       if j < self._size: return j
       else: return None

   def rightChildPos(self, pos):
       j = (pos+1)*2
       if j < self._size: return j
       else:  return None
      
   #  Swap the elements at pos1 and pos2 of the heap array.  Leave the
   #    structure unchanged if one or more of the indices are not in
   #    {0, 1, 2, ... getSize()-1}.  Otherwise, swap the elements.
   def swap (self, pos1, pos2):
       s = self.getSize()
       if 0 <= pos1 and 0 <= pos2 and pos1 < s and pos2 < s:
           self._H[pos1], self._H[pos2] = self._H[pos2], self._H[pos1]

   def heapify(self, pos):
       left= self.leftChildPos(pos)
       right= self.rightChildPos(pos)
       if left == None:
           return
       else: 
           minChildPos = left
           if right != None:
               if self._key(self._H[right]) < self._key(self._H[left]):
                   minChildPos =right 
           if self._key(self._H[minChildPos]) < self._key(self._H[pos]):
               self.swap(pos, minChildPos)
               self.heapify(minChildPos)  # recursive call on subtree
             



