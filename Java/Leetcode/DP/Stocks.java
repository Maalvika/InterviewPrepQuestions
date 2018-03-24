import java.util.*;

// Problem Number:121
public class Stocks{
	
	public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[] diff_profit= new int[prices.length];
        diff_profit[0] = 0;
        for(int i=1; i<prices.length; i++) {
            diff_profit[i] = prices[i] - prices[i-1];
        }
        
        int[] sum = new int[prices.length];
        int[] min = new int[prices.length];
        sum[0] = diff_profit[0];
        min[0] = Math.min(0,diff_profit[0]);
        for(int i=1; i<prices.length; i++) {
            sum[i] = diff_profit[i]+sum[i-1];
            min[i] = Math.min(min[i-1], sum[i]);
        }
        int[] res = new int[prices.length];
        int max = Integer.MIN_VALUE;
        for(int i=0; i<prices.length; i++) {
            res[i] = sum[i] - min[i];
            if(max<res[i]) {
                max = res[i];
            }
        }
        
        return max;
    }
	
	public static void main(String[] args) {
		
	}
}