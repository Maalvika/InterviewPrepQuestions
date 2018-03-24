import java.util.*;

// Problem No 1
class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> diff = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            int sub = target - nums[i];
            if(diff.containsKey(sub)) {
                res[0] = i;
                res[1] = diff.get(sub);
                return res;
            } else {
                diff.put(nums[i], i);
            }
        }
        return res;
        
    }
}