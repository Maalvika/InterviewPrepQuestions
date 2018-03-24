#!/usr/bin/python

class Node:
	left= None
	right = None
	data = None
	
	def __init__(self, data):
		self.data = data
		self.right = None
		self.left = None

class Tree:
	
	root = None
	
	def __init__(self, root):
		self.root = root
	
	def getHeight(self, root):
		if root == None:
			return 0;
		else:
			return max(1+self.getHeight(root.left), 1+self.getHeight(root.right))
	
	def inorder(self, root):
		if(root == None):
			return
		self.inorder(root.left)
		print root.data
		self.inorder(root.right)

	def getMinHeight(self, root):
		if root == None:
			return 0;
		else:
			if root.right == None:
				return 1+self.getHeight(root.left)
			
			elif root.left == None:
				return 1+self.getHeight(root.right)
					
			return min(1+self.getHeight(root.left), 1+self.getHeight(root.right))
		
def create_minimalBST(arr, start, end):
	if (start>end):
		return None
	else:
		mid = (start+end)/2
		n = Node(arr[mid])
		n.left = create_minimalBST(arr, start, mid-1)
		n.right = create_minimalBST(arr, mid+1, end)
		return n
		
		
		
if __name__ == '__main__':
	
	#root = Node(5)
	#root.left = Node(4)
	#root.right = Node(6)
	#root.left.left = Node(2)
	#root.left.right = Node(3)
	#root.right.left = Node(7)
	#root.right.right = Node(8)
	#root.right.right.right = Node(18)
	
	arr = [1,2,3,4,5,6,7]
	root = create_minimalBST(arr,0,len(arr)-1)
	print "Minimal Tree is created"
	t = Tree(root)
	print t.getHeight(t.root);
	print t.inorder(t.root);
    
