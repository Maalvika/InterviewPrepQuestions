#!/bin/python

import sys
import heapq

def rebalance(maxHeap_list, minHeap_list):
    bigger = maxHeap_list if (len(maxHeap_list)  > len(minHeap_list)) else minHeap_list
    smaller = minHeap_list if (len(minHeap_list) < len(maxHeap_list)) else maxHeap_list

    if (len(bigger) - len(smaller) >= 2):
        smaller.append(bigger[0])
        heapq._heapify_max(smaller)
        bigger.remove(bigger[0])
        heapq.heapify(bigger)

def addNumber(number, maxHeap_list, minHeap_list):
    if len(minHeap_list) == 0 or number < maxHeap_list[0]:
        maxHeap_list.append(number)
        heapq._heapify_max(maxHeap_list)
    else:
        minHeap_list.append(number)
        heapq.heapify(minHeap_list)



def getMedian(maxHeap_list, minHeap_list):
    bigger = maxHeap_list if (len(maxHeap_list)  > len(minHeap_list)) else minHeap_list
    smaller = minHeap_list if (len(minHeap_list) < len(maxHeap_list)) else maxHeap_list

    if (len(bigger) == len(smaller)):
        return(float(bigger[0] + smaller[0])/2)
    else:
        return bigger[0]


n = int(raw_input().strip())
a = []
a_i = 0
maxHeap_list = []
minHeap_list = []
medians = [0]*len(a)

for a_i in xrange(n):
    a_t = int(raw_input().strip())
    a.append(a_t)
    addNumber(a_t, maxHeap_list, minHeap_list)
    rebalance(maxHeap_list, minHeap_list)
    #print maxHeap_list, minHeap_list
    #medians.append("%.1f" %getMedian(maxHeap_list, minHeap_list))
    print "%.1f" %getMedian(maxHeap_list, minHeap_list)