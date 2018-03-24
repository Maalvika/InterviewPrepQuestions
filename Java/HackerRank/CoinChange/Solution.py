 #!/bin/python

import sys

memo = []
def getWays(n, index, c):
    # Complete this function
	#print n, index
	if(n == 0):
		return 1;
	elif n<0:
		return 0;
	elif index>=len(c):
		return 0;
	else:
		return getWays(n-c[index], index, c) + getWays(n, index+1, c);

n, m = raw_input().strip().split(' ')
n, m = [int(n), int(m)]
c = map(long, raw_input().strip().split(' '))
# Print the number of ways of making change for 'n' units using coins having the values given by 'c'
ways = getWays(n, 0, c)
print ways
