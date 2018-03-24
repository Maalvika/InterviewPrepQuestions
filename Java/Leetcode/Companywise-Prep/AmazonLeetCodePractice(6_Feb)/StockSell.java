import java.util.*;

public StockSell{
	 public int maxProfit(int[] prices) {
		
		int n = prices.length;
        if(n==0){
            return 0;
        }
		int[] price = new int[n];
		price[0]  = 0;
		for(int i=1; i<n; i++) {
			price[i] = prices[i] - prices[i-1];
		}
		
		int[] sum = new int[n];
		int[] min = new int[n];
		sum[0] = price[0];
		min[0] = Math.max(0, price[0]);
		
		for(int i=1; i<n; i++) {
			sum[i] = sum[i-1] + price[i];
			min[i] = Math.min(min[i-1], sum[i]);
		}
		
		int max = Integer.MIN_VALUE;
		int[] res = new int[n];
		
		for(int i=0; i<n; i++) {
			res[i] = sum[i] - min[i];
			max = Math.max(res[i],max);
		}
		
		return max;
	 }
}