#!/usr/bin/python

"""
 Assuming the both arrays are sorted and of same length
"""

def getMedian(ar1, ar2):

	if len(ar1) != len(ar2):
		return -1

	n = len(ar1)

	if(n <= 0):
		return -1

	if (n == 1):
		return(ar1[0]+ar2[0])/2

	if (n == 2):
		return(max(ar1[0],ar2[0])+min(ar1[1],ar2[1]))/2

	m1 = median(ar1, n)
	m2 = median(ar2, n)

	if(m1==m2):
		return m1

	if(m1<m2):
		return getMedian(ar1[m1:], ar2[:m1])
	else:
		return getMedian(ar1[:m1], ar2[m1:])

def median(ar, n):
	if(n%2 == 0):
		return (ar[n/2]+ar[n/2-1])/2
	else:
		return (ar[n/2])/2

if __name__ == '__main__':
	ar1 = [1,2,3,6]
	ar2 = [4,6,8,10]

	print getMedian(ar1, ar2)