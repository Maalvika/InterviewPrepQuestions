#!/bin/python

import sys
import heapq

class Max_Heap:
	
	maxHeap = []
	def add_elem(self, elem):
		heapq.heappush(self.maxHeap, -1*elem);
	
	def remove_element(self):
		return -1 * heapq.heappop(self.maxHeap)
	
	def get_top(self):
		return -1 * self.maxHeap[0]
	
	def get_len(self):
		return len(self.maxHeap)

def arrange_heaps(elem):
	if(len(middle) == 0):
		middle.append(elem)
		middle.sort()
	else:
		if(elem < middle[0]):
			maxHeap.add_elem(elem)
		elif(elem > middle[len(middle)-1]):
			heapq.heappush(minHeap, elem)	
		else:
			middle.append(elem)
			middle.sort()
	
	rebalance();
	
	
	
def rebalance():
	if(maxHeap.get_len() > len(minHeap)):
		elem = maxHeap.remove_element()
		middle.append(elem)
		middle.sort()
	elif(maxHeap.get_len() < len(minHeap)):
		elem = heapq.heappop(minHeap)
		middle.append(elem)
		middle.sort()
	
	if(len(middle) >= 3):
		maxHeap.add_elem(middle[0])
		heapq.heappush(minHeap, middle[2]);
		middle.remove(middle[0])
		middle.remove(middle[1])
		

def get_median():
	if(len(middle)%2 == 0):
		return float(middle[0] + middle[1])/2
	else:
		return middle[0]

n = int(raw_input().strip())
middle = []
minHeap = []
maxHeap = Max_Heap()
a_i = 0
medians = []
for a_i in range(n):
   a_t = int(raw_input().strip())
   arrange_heaps(a_t)
   medians.append(get_median())
  
for a_i in range(n):
	print "%.1f" %medians[a_i]

