import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static int size = 1000000;

    static int maximumGcdAndSum(int[] A, int[] B) {
        boolean[] A_bool = new boolean[size+1];
        boolean[] B_bool = new boolean[size+1];
        int max_gcd = 1;
        for(int i = 0; i < A.length; i++){
            A_bool[A[i]] = true;
            B_bool[B[i]] = true;
        }
        int[] A_mul = new int[size+1];
        int[] B_mul = new int[size+1];
        for(int i = 1; i <=size; i++){
            for(int j=i; j<=size; j+=i) {
                if(A_bool[j] == true) {
                    A_mul[i] = j;
                }
            }
        }
        for(int i = 1; i <=size; i++){
            for(int j=i; j<=size; j+=i) {
                if(B_bool[j] == true) {
                    B_mul[i] = j;
                }
            }
        }
        for(int i=1; i <= size; i++) {
            if(A_mul[i]>0 && B_mul[i]>0) {
                max_gcd = i;
            }
        }
        
        return A_mul[max_gcd] + B_mul[max_gcd];
    }

    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] A = new int[n];
    for(int A_i = 0; A_i < n; A_i++){
        A[A_i] = in.nextInt();
    }
    int[] B = new int[n];
    for(int B_i = 0; B_i < n; B_i++){
        B[B_i] = in.nextInt();
    }
    int res = maximumGcdAndSum(A, B);
    System.out.println(res);
    }
}
