import java.util.*;

public class PrimeNums {
	
	public List<Integer> prime_number_v1(int num) {
		List<Integer> res = new LinkedList<>();
		boolean flag = true;
		for(int i=2; i<=num; i++) {
			flag = true;
			for (int j=2; j<i; j++) {
				if(i%j==0) {
					flag = false;
					break;
				}
			}
			if(flag == true) {
				res.add(i);
			}
			
		}
		return res;
	}
	
	public List<Integer> prime_number_v2(int num) {
		List<Integer> res = new LinkedList<>();
		boolean flag = true;
		for(int i=2; i<=num; i++) {
			flag = true;
			for (int j=2; j*j<=i; j++) {
				if(i%j==0) {
					flag = false;
					break;
				}
			}
			if(flag == true) {
				res.add(i);
			}
			
		}
		return res;
	}
	
	public List<Integer> prime_number_v3(int num) {
		List<Integer> res = new LinkedList<>();
		
		boolean[] flag = new boolean[num + 1];
		flag[0] = true;
		flag[1] = true;
		for(int i=2; i*i<num; i++) {
			for (int j=i*2; j<=num; j+=i) {
				flag[j] = true; 
			}
		}
		for(int i=0; i<flag.length; i++) {
			if(!flag[i]) {
				res.add(i);
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int n = 20;
		PrimeNums pm = new PrimeNums();
		List<Integer> res = pm.prime_number_v1(n);
		System.out.println("res 1:");
		for(Integer i: res) {
			System.out.print(i+" ");
		}
		
		res = pm.prime_number_v2(n);
		System.out.println("\n res 2:");
		for(Integer i: res) {
			System.out.print(i+" ");
		}
		
		res = pm.prime_number_v3(n);
		System.out.println("\n res 3:");
		for(Integer i: res) {
			System.out.print(i+" ");
		}
	}
	
}