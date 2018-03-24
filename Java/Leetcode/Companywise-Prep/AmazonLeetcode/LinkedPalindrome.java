import java.util.*;

//Problem number: 234
public class LinkedPalindrome {
	
	 public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
 
	
	public static void main(String[] args){
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		//head.next.next = new ListNode(3);
		//head.next.next.next = new ListNode(2);
		//head.next.next.next.next = new ListNode(1);
		
		System.out.println("Is palindrome:"+isPalindrome(head));
	}
	
	public static boolean isPalindrome(ListNode head) {
        if (head == null){
            return true;
        }
        ListNode mid = findMid(head);
		ListNode second_head = revList(mid.next);
		mid.next = second_head;
		while(second_head!=null) {
			if(head.val!=second_head.val) {
				return false;
				
			}
			head = head.next;
			second_head = second_head.next;
		}
		return true;
        
    }
    
	
	public static ListNode findMid(ListNode head){
		ListNode next, dnext;
		next = head;
		dnext = head;
		while(dnext.next!=null && dnext.next.next!=null) {
			next = next.next;
			dnext = next.next.next;
		}
		return next;
	}
	
	public static ListNode revList(ListNode head){
		
		ListNode p,c,n;
		p = null;
		c = head;
		while(c!=null) {
			n = c.next;
			c.next = p;
			p=c;
			c=n;
		}
		return p;
	}
}