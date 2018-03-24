def find_path(i, j, r, c):
	if (i == r-1) or (j == c-1):
		return 1;
	else: 
		return find_path(i,j+1, r, c) + find_path(i+1, j, r, c)

r = int(raw_input().strip())
c = int(raw_input().strip())

print find_path(0,0,r,c)
