import java.util.*;

public class PermutationReccur{
	
	// It has running this of O(n^2*n!)
	void print_permutation(String str){
		//print_permutation_util(str, "");
		print_permutation_dp(str.toCharArray(), 0, str.length()-1);
	}
	
	void print_permutation_util(String str, String prefix){
		if(str.length() == 0) {
			System.out.println("----------- Prefix");
			System.out.println(prefix);
		} else {
			for(int i=0; i<str.length(); i++) {
				String rem = str.substring(0,i) + str.substring(i+1);
				System.out.println("----------- Remaining, prefix -----"+ rem + ","+ prefix);
				print_permutation_util(rem, prefix + str.charAt(i));
			}
		}
	}
	
	void print_permutation_dp(char[] str, int s, int e){ 
		if(s == e) {
			System.out.println(String.valueOf(str));
		} else {
			for(int i=s; i<=e; i++) {
				str = swap(str, i, s);
				System.out.println("----------- swap str-----"+ String.valueOf(str));
				print_permutation_dp(str, s+1, e);
				str = swap(str, i, s);
				System.out.println("----------- backtracked str-----"+ String.valueOf(str));
			}
		}
	}
	
	public char[] swap(char[] str, int i, int j) {
		char t = str[i];
		str[i] = str[j];
		str[j] = t;
		return str;
	}
	
	public static void main(String[] args){
		String s = "abc";
		PermutationReccur pr = new PermutationReccur();
		pr.print_permutation(s);
	}
}