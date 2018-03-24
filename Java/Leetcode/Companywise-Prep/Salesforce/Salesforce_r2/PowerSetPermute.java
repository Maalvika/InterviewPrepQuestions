import java.util.*;

public class PowerSetPermute{
	
	public static void main(String[] args) {
		
		String s = "abcd";
		List<String> li = new LinkedList<>();
		int n = s.length();
		for(int i=0; i<(1<<n); i++) {
			StringBuilder sb = new StringBuilder();
			for(int j=0; j<n; j++) {
				
				if((i& (1<<j)) > 0) {
					System.out.println((byte)(i& (1<<j)) +":"+ j);
					sb.append(String.valueOf(s.charAt(j)));
				}
				
			}
			li.add(sb.toString());
		}
		System.out.println("rESULTS:   ");
		Collections.sort(li);
		for(String str: li) {
			System.out.println(str);
		}
		
	}
	
}