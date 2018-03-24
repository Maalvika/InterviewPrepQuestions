import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int onceInATram(int x) {
		int left_num = x/1000;
		int right_num = x%1000;
		int next = find_next(sum(left_num), right_num);
		//System.out.println("val"+next);
		if(next < 1000) {
			return x-right_num+next;
		} else {
			left_num++;
			
			//System.out.println(Integer.parseInt(left_num+""+right_num));
			return onceInATram(left_num*1000);
		}
        
    }

    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int x = in.nextInt();
    int result = onceInATram(x);
    System.out.println(result);
    }
	
	static int sum(int n) {
		int sum = 0;
		int num = n;
		while(n!=0) {
			sum+=n%10;
			n/=10;
		}
		///System.out.println("n:"+num+" sum"+sum);
		return sum;
	}
	
	static int find_next(int sum, int rh){
		//System.out.println("sum in func"+sum);
		for(int i = rh+1; i<1000; i++) {
			
			if(sum(i)==sum) {
				return i;
			}
		}
		return 1000;
	}
	
	
}
