import java.util.*;

public class ContiguousSum{
	
	// This works because when we take the contiguous sum, it includes the min element or the combination of them. 
	// This is incomplete solution; In case of all negative numbers return the one with the max value 
	public static void main(String[] args) {
		
		int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
		
		 if(nums.length==1){
            return nums[0];
        }
        boolean all_less = true;
        int max_all_less = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++) {
            if(max_all_less<nums[i]){
                max_all_less = nums[i];
            }
            if(nums[i]>0) {
                all_less = false;
                break;
            }
        }
        if(all_less == true) {
            return max_all_less;
        }
		
		LinkedList<Integer> sum = new LinkedList();
		LinkedList<Integer> min_sum = new LinkedList<>();
		LinkedList<Integer> diff = new LinkedList<>();
		
		sum.add(arr[0]);
		min_sum.add(Math.min(0,arr[0]));
		
		for(int i=1; i<arr.length; i++) {
			sum.add(sum.get(i-1) + arr[i]);
			min_sum.add(Math.min(min_sum.get(i-1), sum.get(i)));
		}
		
		for(int i=0; i<arr.length; i++) {
			diff.add(sum.get(i) - min_sum.get(i));
			
		}
		int max = Collections.max(diff);
		System.out.println("Max sum is:"+max);
		
	}
}