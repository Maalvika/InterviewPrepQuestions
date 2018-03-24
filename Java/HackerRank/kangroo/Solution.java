import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String kangaroo(int x1, int v1, int x2, int v2) {
        if(x2>x1 && v2>=v1) {
            return "NO";
        } 
        double res = ((v2*x1)-(v1*x2))/(v2-v1);
        if(res>=0) {
            if((res-x1)/v1 == (int)(res-x2)/v2) {
                return "YES";
            }
        } 
        return "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();
        String result = kangaroo(x1, v1, x2, v2);
        System.out.println(result);
    }
}
