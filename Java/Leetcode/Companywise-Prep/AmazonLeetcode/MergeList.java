import java.util.*;

//Problem Number:21
public class MergeList {
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null && l2==null) {
            return l1;
        }
        ListNode ptr = null;
        ListNode head = new ListNode(0);
        while(l1!=null && l2!=null) {
            if(ptr == null) {
                ptr = head;
            }
            //System.out.println("l1:"+l1.val);
            //System.out.println("l2:"+l2.val);
            if(l1.val<=l2.val) {
                head.next = l1;
                head = head.next;
                l1 = l1.next;
            } else {
                head.next = l2;
                head = head.next;
                l2 = l2.next;
            }
            
            
        }
        
        while(l1!=null) {
           if(ptr == null) {
                ptr = head;
            } 
           //System.out.println("l1#####################:"+l1.val);
            head.next = l1;
            head = head.next;
            l1 = l1.next;
        }
        
        while(l2!=null) {
            if(ptr == null) {
                ptr = head;
            }
           // System.out.println("l2###########################:"+l2.val);
            head.next = l2;
            head = head.next;
            l2 = l2.next;
        }
        head = null;
        return ptr.next;
    }
}