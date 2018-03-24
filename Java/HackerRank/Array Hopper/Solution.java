import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	
	static int[] memo;

    static void hop_array(int[] a) {
		for(int i=1;i<a.length; i++) {
			if(a[i] == 0) {
				memo[i] = Integer.MAX_VALUE;
			} else {
				int j = i-1;
				int pos = a[i];
				int min = Integer.MAX_VALUE;
				
				//System.out.println("j"+j);
				while(pos>=0 && j>=0) {
					//System.out.println("in here:"+min);
					
					min = Math.min(min, memo[j]);
					pos--;
					j--;
				}
				//System.out.println("final min:"+min);
				if(min == Integer.MAX_VALUE) {
					if(a[i]>i+1) {
						memo[i] = 1;
					}
					memo[i] = min;
					
				} else {
					memo[i] = min +1;
				}
				
			}
		}
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
       
        int[] a = new int[n];
		memo = new int[n];
		
        for(int a_i=n-1; a_i >= 0; a_i--){
            a[a_i] = in.nextInt();
        }
		if(a[0] == 0) {
			memo[0] = Integer.MAX_VALUE;
		} else {
			memo[0] = 1;
		}
		hop_array(a);
		int hop = 0;
		List<Integer> results = new LinkedList<>();
		for(int i=n-1; i >=0 ; i--){
			//System.out.println(memo[i]);
            if(hop!= memo[i] && memo[i]!=Integer.MAX_VALUE) {
				hop = memo[i];
				results.add(i);
			}
        }
		
		for(Integer i: results) {
			System.out.print((n-1)-i+", ");
		}
		System.out.println("out");
    }
    
    
}
