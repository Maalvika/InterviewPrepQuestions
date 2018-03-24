#!/usr/bin/python
import fileinput

def find_min(a, start, end):
    #print start, end

    if(start == end or start > end):
        return 0

    if a[start] == 0:
        return float('Inf')

    min = float('Inf')
    #print a[start]
    for i in range(start+1, start+a[start]+1):
        #print i
        jumps = find_min(a, i, end)
        if (jumps != float('Inf') and jumps+1 < min):
            min = jumps + 1
    return min



a = [1,3,6,3,2,3,6,8,9,5]
#a = [1, 6, 0, 4, 2, 3, 1, 2, 0, 4]
a = [1, 3, 6, 1, 0, 9]
print find_min(a, 0, len(a)-1)
