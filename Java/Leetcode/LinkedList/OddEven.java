import java.util.*;

//Problem Number: 328
public class OddEven{
	//Update Odd list and even list simultaneously
	//End node of odd should point to first node of even
	public ListNode oddEvenList(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode odd, even, last_odd = null, start_even;
        odd = head;
        even = head.next;
        start_even = even;
        while(odd!=null && even!=null){
            
            odd.next = odd.next.next;
            last_odd = odd;
            odd = odd.next;
            if(even.next!=null) {
                even.next = even.next.next;
                even = even.next;
            }
        }
        if(odd!=null) {
            odd.next = null;
            last_odd = odd;
            //odd = odd.next;
        }
        //System.out.println("lastodd:"+last_odd.val);
        //System.out.println("starteven:"+start_even.next.val);
        if(start_even!=null) {
        last_odd.next = start_even;
        }
        return head;
    }
	
	public static void main(String args[]){
		
	}
}