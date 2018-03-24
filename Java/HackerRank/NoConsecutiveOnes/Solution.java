import java.util.*;

public class Solution {
  
    public static int[] fibo = new int[32 + 1];
    public static int memo[] = new int [32+1];
    public static int findIntegers(int num) {
        int[] bits = new int[32 + 1];
        fibo[1] = 2;
        fibo[2] = 3;
        int i = 1;
        
        while(num!=0) {
            bits[i] = num%2;
            fibo[i+2] = fibo[i] + fibo[i+1];
            num = num/2;
            i++;
        }
        
		for(int j=1; j<=i; j++) {
			if(j<=2) {
				if(j==1) {
					if(bits[j] == 0) {
						memo[j] = 1;
					} else {
						memo[j] = 1;
					}
				} else { 
					if(bits[j] == 0) {
						memo[j] = memo[j-1];
					} else {
						memo[j] = 3;
					}
					
				}
			} else {
				if(bits[j] == 0) {
					memo[j] = memo[j-1];
				} else {
					if(bits[j-1] == 0) {
						memo[j] = memo[j-2] + fibo[j-1];
					} else {
						memo[j] = fibo[j-2] + fibo[j-1];
					}
				}
			}  
		}
		
		return memo[i];
        
    }
    
	
	public static void main(String[] args){
		
		Scanner scan  = new Scanner(System.in);
		int num = scan.nextInt();
		System.out.println(findIntegers(num));
		
		
	}
}