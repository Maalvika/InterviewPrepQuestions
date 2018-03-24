import java.util.*;

// Problem Number: 148
public class SortList {
	 
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public ListNode sortList(ListNode head) {
        
       if(head == null || head.next==null) {
            System.out.println("returning");
			return head;
		}
		ListNode mid = findMid(head);
		ListNode nextMid = mid.next;
        //System.out.println("mid value:"+mid.val);
		mid.next = null;
		ListNode left = sortList(head);
		ListNode right = sortList(nextMid);
		ListNode res = mergeandsort(left, right);
		return res;
    }
    
    public ListNode mergeandsort(ListNode p, ListNode q) {
		ListNode res = null;
        if(p == null) {
			return q;
		} 
		if(q==null) {
			return p;
		}
		if(p.val<=q.val) {
			res = p;
			res.next = mergeandsort(p.next, q);
		} else {
			res = q;
			res.next = mergeandsort(p, q.next);
		}
		return res;
    }
    
    public ListNode findMid(ListNode head) {
		ListNode slow, fast;
		slow = head;
		fast = head;
		while(fast.next!=null && fast.next.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	public static void main(String[] args) {
		
	}
}