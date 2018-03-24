import java.util.*;

public class TransformStr{
	
	public static void main(String[] args) {
		//String s = "aabbaa";
		String s = "aaabbdcccccf";
		StringBuilder sb = new StringBuilder();
		char prev = s.charAt(0);
		char curr;
		int count = 1;
		for(int i=1; i<s.length();i++) {
			curr = s.charAt(i);
			if(prev!=curr) {
				sb.append(prev).append(count);
				count = 1;
			} else {
				count++;
			}
			prev = curr; 
		}
		sb.append(prev).append(count);
		System.out.println("Result is:"+sb.toString());
		
	} 
}