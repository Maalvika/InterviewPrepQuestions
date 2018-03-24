import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int divisibleSumPairs(int k, int[] ar) {
        // Complete this function
        int count = 0;
        for(int i=0; i<=k/2; i++) {
            int mod = ar[i];
            if(i == (k-i)%k) {
                count += (ar[i])*(ar[i]-1)/2;
            } else {
                count +=ar[i]*ar[(k-i)%k];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] ar = new int[k];
        
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[(in.nextInt())%k] +=1;;
        }
        
        for(int ar_i = 0; ar_i < k; ar_i++){
            System.out.println("Num:"+ar[ar_i]) ;
        }
        
        int result = divisibleSumPairs(k, ar);
        System.out.println(result);
    }
    
    
    
}		