import java.util.*;

public class FindAnagrams{
	
	public List<Integer> findAnagrams(String s, String p) {
		int[] s_cnt = new int[26];
		int[] p_cnt = new int[26];
        List<Integer> result = new LinkedList<>();
        if(s.isEmpty() || p.isEmpty() || s.length()<p.length()) {
            return result;
        }
		
		for(int i=0; i<p.length(); i++) {
			p_cnt[p.charAt(i) - 'a']+= 1;
			s_cnt[s.charAt(i) - 'a']+= 1;
		}
		
        int i=0;
        int j = p.length()-1;
        
		while(j<s.length()) {
			
			if(Arrays.equals(s_cnt,p_cnt)) {
                //System.out.println("i in:"+i);
				result.add(i);
			}
            i++;
            j++;
            s_cnt[s.charAt(i-1) - 'a'] -=1 ;
            if(j<s.length()) {
			    s_cnt[s.charAt(j) - 'a'] += 1;
            }
            //System.out.println("i out:"+i);
			
		}
		return result;
	}
}