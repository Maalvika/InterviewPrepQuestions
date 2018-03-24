r = int(raw_input().strip())
c = int(raw_input().strip())

memo = [[0 for x in range(r)] for y in range(c)]

for i in range(r):
	memo[i][0] = 1

for j in range(c):
	memo[0][j] = 1

for i in range(1, r):
	for j in range (1,c):
		memo[i][j] = memo[i-1][j]+memo[i][j-1]


print memo[r-1][c-1]
