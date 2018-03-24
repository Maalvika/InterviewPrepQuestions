import java.util.*;
import java.util.Collections;

public class Solution {
	
	public static PriorityQueue<Integer>  minHeap = new PriorityQueue<>();
	public static PriorityQueue<Integer>  maxHeap = new PriorityQueue<>(10, Collections.reverseOrder());
	public static List<Integer> middle = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		double[] result = new double[n];
		for(int i=0; i<n; i++) {
			int element = scan.nextInt();
			add_to_heap(element);
			result[i] = get_median(i+1);
		}
		
		for(int i=0; i<n; i++) {
			System.out.println(result[i]);
		}
	}
	
	public static void add_to_heap(int element){
		if(middle.size() == 0){
			middle.add(element);
			Collections.sort(middle);
		} else {
			if(element< middle.get(0)) {
				maxHeap.add(element);
			} else if(element>middle.get(middle.size()-1)) {
				minHeap.add(element);
			} else {
				middle.add(element);
				Collections.sort(middle);
			}
			
		}
		
		rebalance();
	}
	
	public static void rebalance(){
		
		if(minHeap.size() > maxHeap.size()) {
			middle.add(minHeap.poll());
			Collections.sort(middle);
		} else if(minHeap.size() < maxHeap.size()){
			middle.add(maxHeap.poll());
			Collections.sort(middle);
		}
		
		if(middle.size()>=3) {
			//System.out.println("Middle greater equal 3");
			int l = middle.get(0);
				//System.out.println("l:"+l);
			int r = middle.get(middle.size()-1);
				//System.out.println("r:"+r);
			maxHeap.add(l);
			minHeap.add(r);
			middle.remove(middle.indexOf(l));
			middle.remove(middle.indexOf(r));
		}
		
	}
	
	public static double get_median(int size){
		if(size%2==0){
			return (double)(middle.get(0)+middle.get(1))/(double)2;
		} else {
			return (double)(middle.get(0));
		}
	}
}