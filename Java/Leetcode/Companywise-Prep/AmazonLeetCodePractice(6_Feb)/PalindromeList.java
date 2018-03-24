import java.util.*;

public class PalindromeList {
	
	 static public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	 
	
	public boolean isPalindrome(ListNode head) {
		ListNode mid = find_mid(head);
		ListNode mid_head = reverse_list(mid.next);
		ListNode t = mid_head;
		
		mid.next = null;
		while(head!=null && mid_head!=null) {
			if(head.val!=mid_head.val) {
				return false;
			}
			head = head.next;
			mid_head = mid_head.next;
		}
        return true;
    }
	
	public ListNode reverse_list(ListNode head) {
		//System.out.println
		ListNode prev = null;
		ListNode curr = head;
		ListNode next;
		
		while(curr!=null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
	
	public ListNode find_mid(ListNode head) {
		
		ListNode slow = head;
		ListNode fast = head;
		while(fast.next!=null){
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	public static void main(String args[]) {
		PalindromeList pl = new PalindromeList();
		ListNode n = new ListNode(1);
		n.next = new ListNode(2);
		n.next.next = new ListNode(3);
		n.next.next.next = new ListNode(2);
		n.next.next.next.next = new ListNode(1);
		//ListNode mid = pl.find_mid(n);
		//System.out.println("Mid:"+mid.val);
		
		System.out.println("Is palindrome:"+pl.isPalindrome(n));
		
	}
}