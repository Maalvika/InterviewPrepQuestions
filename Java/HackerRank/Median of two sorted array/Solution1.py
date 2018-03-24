class Solution1(object):
	def mediansAux(self, X, i1, j1, Y, i2, j2):
		#check for invalid input condition
		print "indices",i1,j1,i2,j2
		if(len(X)<=0 | len(Y)<=0):
			return [0,0]
		#base case condition
		if (j1-i1+1==2 & j2-i2+1 == 2):
			
			temp = X + Y
			temp.sort()
			print str(Y)
			if(len(temp)%2 == 0):
				return [temp[len(temp)/2], temp[len(temp)/2 -1]]
			else:
				return [temp[len(temp)/2], temp[len(temp)/2]]

		mx = X[i1+((j1-i1+1)/2)]
		my = Y[i2+((j2-i2+1)/2)]
		n = j1-i1
		if(mx == my):
			return [mx, mx]
		elif(mx<my):
			return self.mediansAux(X[i1+n/2:],i1+n/2,j1,Y[:(j2-n/2)+1],i2,j2-n/2)
		else:
			return self.mediansAux(X[:(j1-n/2)+1],i1,j1-n/2,Y[i2+n/2:],i2+n/2,j2)

	def adjustIndex(self, n1, n2):
		max_len = max(n1,n2)
		i = 1
		while(pow(2,i)-1<max_len):
			i+=1
		max_pow2 = pow(2,i)-1
		i1 = 0
		j1 = n1-1
		i2 = 0
		j2 = n2-1
		if n1 == max_len:
			while(j1-i1+1 != max_pow2):
				j1+=1
				i2-=1
			while(j2-i2+1<max_pow2):
				j2+=1
				i2-=1
			if j2-i2+1>max_pow2:
				i2+=1
		elif n2 == max_len:
			while(j2-i2+1 == max_pow2):
				j2+=1
				i1-=1
			while(j1-i1+1<=max_pow2):
				j1+=1
				i1-=1
			if j1-i1+1>max_pow2:
				i1+=1
		return [i1,j1, i2, j2]		
	def findMedianSortedArrays(self, num1, num2):
		if len(num1) == 0:
			#num2.sort();
			if len(num2)%2 == 0:
				return float((num2[len(num2)/2] + num2[len(num2)/2 - 1])/2.0)
			else:
				return float(num2[len(num2)/2])
		elif len(num2) == 0:
			#num1.sort();
			if len(num1)%2 == 0:
				return float((num1[len(num1)/2] + num1[len(num1)/2 - 1])/2.0)
			else:
				return float(num1[len(num1)/2])
		elif len(num1) + len(num2) <=4:
			temp = num1+num2
			temp.sort()
			print "res", str(temp[len(temp)/2])
			if(len(temp)%2==0):
				return float((temp[len(temp)/2-1] + temp[len(temp)/2])/2.0)
			else:
				return float(temp[len(temp)/2])
		else:
			indices = self.adjustIndex(len(num1), len(num2))
			res = self.mediansAux(num1, indices[0], indices[1], num2, indices[2], indices[3])
			print "array res", str(res)
			return float((res[0]+res[1])/2.0)
		
s = Solution1()
x = [1,3]
y = [2]

x = [1]
y = [2,3,4,5]
res = s.findMedianSortedArrays(x, y)
print "result",res
