import java.util.*;

public class TwoStacks{
	
	static class CustomQueue<T> {
		Stack<T> newVals = new Stack<>();
		Stack<T> oldVals = new Stack<>();
		
		public void enqueue(T val) {
			newVals.push(val);
		}
		
		public T dequeue(){
			
			if(oldVals.isEmpty() && newVals.isEmpty()) {
				return null;
			}
			if(!oldVals.isEmpty()) {
				return oldVals.pop();
			} else {
				while(!newVals.isEmpty()){
					oldVals.push(newVals.pop());
				}
				return oldVals.pop();
			}
		}
	}
	
	public static void main(String[] args) {
		CustomQueue<Integer> q = new CustomQueue<>();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		System.out.println("Dequeue results:"+q.dequeue());
		System.out.println("Dequeue results:"+q.dequeue());
		
		
	}
}