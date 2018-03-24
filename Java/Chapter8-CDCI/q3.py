def magic_index(a, low, high):
	mid = (low+high)/2
	if(low > high):
		return -1
	elif a[mid] == mid:
		return mid
	elif a[mid] > mid:
		return magic_index(a, low, mid-1)
	else: return magic_index(a, mid+1, high)

n = int(raw_input().strip())
a = []
for i in range(n):
	a.append(int(raw_input().strip)))

val = magic_index(a, 0, n);

if(val != -1):
	print "Magic Index:", val
else:
	print "No Magic Index"