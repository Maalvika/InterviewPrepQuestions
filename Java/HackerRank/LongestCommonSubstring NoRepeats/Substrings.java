import java.util.*;

public class Substrings{
	
	public static void main(String args[]) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter String:");
		String s = scan.nextLine();
		produceSubstrings(s);
		
	}
	
	public static void produceSubstrings(String s){
		
		for(int i=0; i< s.length(); i++) {
			for(int j=i+1; j<s.length(); j++) {
				printSubStr(s, i, j);
			}
		}
		
	}
	
	public static void printSubStr(String s, int i, int j) {
		for(int s_i=i; s_i<=j; s_i++){
			System.out.print(s.charAt(s_i));
		}
		System.out.println();
	}
}