class Solution(object):
    def mediansAux(self, num1, i1, j1, num2, i2, j2):
        print "num1", str(num1)
        print "num2", str(num2)
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
			
			#print "temp <=4", str(temp)
			if len(num1) + len(num2) == 2:
				return float((num1[0]+num2[0])/2.0)
			elif len(num1)==2 and len(num2) == 2:
				return float((max(num1[0],num2[0]) + min(num1[1],num2[1]))/2.0)
				
			else:
				temp = num1+num2
				temp.sort()
				#print "res", str(temp[len(temp)/2])
				if(len(temp)%2==0):
					return float((temp[len(temp)/2-1] + temp[len(temp)/2])/2.0)
				else:
					return float(temp[len(temp)/2])
				
        else:
            mx = float((num1[len(num1)/2] + num1[len(num1)/2 - 1])/2.0 if len(num1)%2 == 0 else num1[len(num1)/2])
            my = float((num2[len(num2)/2] + num2[len(num2)/2 - 1])/2.0 if len(num2)%2 == 0 else num2[len(num2)/2])
            n1 = j1-i1
            n2 = j2 - i2
            if(mx == my):
                return mx
            elif(mx<my):
                return self.mediansAux(num1[n1/2:],i1+n1/2,j1,num2[:n2/2+1],i1,j2-n2/2)
            else:
                return self.mediansAux(num1[:n2/2+1],i1,j1-n2/2,num2[n2/2:],i1+n2/2,j2)
            
    def findMedianSortedArrays(self, num1, num2):
        """
        :type num1: List[int]
        :type num2: List[int]
        :rtype: float
        """
        return self.mediansAux(num1, 0, len(num1)-1, num2, 0, len(num2)-1)
		
s = Solution()
x = [1,3]
y = [2]
print s.findMedianSortedArrays(x, y)