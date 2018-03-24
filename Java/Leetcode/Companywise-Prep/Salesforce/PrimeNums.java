import java.util.*;

public class PrimeNums{
	
	public static void main(String[] args) {
		
		int n = 50;
		boolean[] isComposite = new boolean[n+1];
		for(int i=2; i*i<=n; i++) {
			if(isComposite[i]!=true) {
				for(int j=2*i; j<=n; j+=i) {
					isComposite[j] = true;
				}
			}
		}
		
		for(int i=2; i<=n; i++) {
			if(isComposite[i]!=true) {
				System.out.print(i+" ");
			}
		}
	}
}