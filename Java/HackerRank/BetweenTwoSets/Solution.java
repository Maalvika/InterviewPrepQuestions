import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int getTotalX(int[] a, int[] b){
        // Complete this function
        
        int lcm_a = a[0];
        for(int i=1; i<a.length; i++) {
            lcm_a = lcm_a*a[i]/HCF(a[i], lcm_a);
          
        }
		
		
		//System.out.println("lcm_a:"+lcm_a);
		//System.out.println("hcf_a:"+hcf_a);
        int hcf_b =b[0];
        for(int i=1; i<b.length; i++) {
            hcf_b = HCF(b[i], hcf_b);
        }
		//System.out.println("hcf_b:"+hcf_b);
		int count =0;
        for(int i=1; i<=hcf_b/lcm_a; i++) {
            if(hcf_b%(i*lcm_a)==0) {
				//System.out.println("i:"+i);
                count ++;
            }
        }
        return count;
        
            
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] b = new int[m];
        for(int b_i=0; b_i < m; b_i++){
            b[b_i] = in.nextInt();
        }
        int total = getTotalX(a, b);
        System.out.println(total);
    }
    
    static int HCF(int x, int y){
          
        if(x==0) {
            return y;
        } 
        return HCF(y%x, x);
    }
}
