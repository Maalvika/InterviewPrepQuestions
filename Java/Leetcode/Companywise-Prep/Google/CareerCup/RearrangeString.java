import java.util.*;

public class RearrangeString{
	
	public String arrange_string(String s1, String s2) {
		int n = s1.length();
		int m = s2.length();
		
		Map<Character, Integer> dict = new HashMap<>();
		for(int i=0; i<n; i++) {
			char c = s1.charAt(i);
			int cnt = dict.getOrDefault(c,0);
			dict.put(c, cnt+1);
		}
		
		int pos = 0;
		StringBuilder sb = new StringBuilder();
		while(pos<s2.length()) {
			if(!dict.containsKey(s2.charAt(pos))) {
				pos++;
				continue;
			}
			char c = s2.charAt(pos);
			int cnt = dict.get(c);
			//System.out.println
			while(cnt!=0) {
				sb.append(c);
				cnt--;
			}
			s1 = s1.replaceAll(String.valueOf(c),"");
			pos++;
			
		}
		pos = 0;
		while(pos<s1.length()) {
			sb.append(s1.charAt(pos));
			pos++;
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		RearrangeString rs = new RearrangeString();
		//String s1 = "Google";
		String s1 = "abcdedadf";
		//String s2 = "dog";
		String s2 = "cae";
		String res = rs.arrange_string(s1.toLowerCase(), s2.toLowerCase());
		System.out.println("Result:"+res);
	}
}