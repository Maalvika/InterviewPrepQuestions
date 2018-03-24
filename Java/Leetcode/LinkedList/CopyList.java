import java.util.*;

//Problem Number: 138
public class CopyList{
	// There are 2 ways
	
	//Way1: Maintain a HashMap with new Node corresponding to the old one in the LinkedList
	// When updating the next and Random Pointers fetch the equivalent new Node and point the current one to it.
	//O(n) running time; O(n) space
	 public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode temp_head = head;
        HashMap<RandomListNode, RandomListNode> copy = new HashMap<>();
        while(temp_head!=null) {
            RandomListNode temp = new RandomListNode(temp_head.label);
            copy.put(temp_head, temp);
            temp_head = temp_head.next;
        }
        temp_head = head;
        while(temp_head!=null) {
            copy.get(temp_head).next = copy.get(temp_head.next);
            copy.get(temp_head).random = copy.get(temp_head.random);
            temp_head = temp_head.next;
        }
        return copy.get(head);
    }
	
	//Way2: Copy the data from previous node, say Node1 and insert it between Node1 and Node2.
	//Update the random pointers and revert the common list to old and new one.
	//Takes O(n) time and O(1) space
	public static void main(String[] args) {
		
	}
}