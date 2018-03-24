import java.util.*;

// Problem Number:198
public class RobHouse{
	
	int[] memo;
    public int rob(int[] nums) {
        if(nums.length == 0) {
            return 0;
        } if(nums.length == 1) {
            return nums[0];
        }
        memo = new int[nums.length];
        memo[0] = nums[0];
        memo[1] = Math.max(nums[0], nums[1]);
        for(int i=2; i<nums.length; i++) {
            memo[i] = Math.max(memo[i-1], memo[i-2]+nums[i]);
        }
        return memo[nums.length-1];
    }
	
	public static void main(String[] args) {
		
	}
}