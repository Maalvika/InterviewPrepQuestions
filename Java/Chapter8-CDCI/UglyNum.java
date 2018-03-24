import java.util.*;

public class UglyNum {
	
	public static void main(String[] args) {
		int n=10;
		
		LinkedList<Integer> ugly = new LinkedList<>();
		int i2 = 0;
		int i3 = 0;
		int i5 = 0;
		
		while(n>0) {
			int mul2 = 2*i2;
			int mul3 = 3*i3;
			int mul5 = 5*i5;
			
			int min = Math.min(mul2,Math.min(mul3,mul5));
			ugly.add(min); 
			if (min == mul2){
				i2++;
			} 
			if (min == mul3){
				i3++;
			} 
			if (min == mul5){
				i5++;
			} 
			n--;
		}
		System.out.println(n+"th ugly number is: "+ugly.get(ugly.size()-1));
	}
}