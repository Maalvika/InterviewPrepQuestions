import java.util.*;

public class TwoSum {
	
	public int[] twoSum(int[] nums, int target) {
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i<nums.length; i++) {
			int diff = target - nums[i];
			if(!map.containsKey(nums[i])) {
				map.put(diff, i);
			} else {
				int[] res = {map.get(nums[i]), i};
				return res;
			}
		}
		return null;
	}
}