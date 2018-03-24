import java.util.*;

public class MergeKList{
	
	static class ListNode{
		ListNode next;
		int val;
		public ListNode(int v) {
			val = v;
		}
	} 
	
	public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) {
            return null;
        }
        
        if(lists.length == 1) {
            return lists[0];
        } 
        ListNode ptr = new ListNode(0);
        ListNode res = ptr;
        //By default it is min heap
        Queue<ListNode> minHeap = new PriorityQueue<>(lists.length, new Comparator<ListNode>(){
            
            @Override
            public int compare(ListNode l1, ListNode l2){
                if (l1.val == l2.val) {
                    return 0;
                }
                
                int v = l1.val<l2.val? -1: 1;
				return v;
            }
        });
        
        for(ListNode l:lists) {
			if(l!=null) {
				minHeap.add(l);
			}
        }
        
        while(!minHeap.isEmpty()) {
            ListNode temp = minHeap.remove();
            ptr.next = temp;
			if(temp.next!=null) {
				minHeap.add(temp.next);
			}
            ptr = ptr.next;
        
        }
        return res.next;
    }
	
	public static void main(String[] args) {
		ListNode h1 = new ListNode(2);
		h1.next = new ListNode(3);
		h1.next.next = new ListNode(4);
		
		ListNode h2 = new ListNode(0);
		h2.next = new ListNode(1);
		h2.next.next = new ListNode(5);
		
		ListNode h3 = new ListNode(3);
		h3.next = new ListNode(4);
		h3.next.next = new ListNode(5);
		
		ListNode[] li = new ListNode[3];
		li[0] = h1;
		li[1] = h2;
		li[2] = h3;
		
		ListNode res = mergeKLists(li);
		while(res!=null) {
			System.out.print(" "+res.val);
			res = res.next;
		}
	}
}