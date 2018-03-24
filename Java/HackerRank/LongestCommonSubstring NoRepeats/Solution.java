class Solution {
    
    public static Set<Character> letters = new HashSet<>();
    public int lengthOfLongestSubstring(String s) {
        char[] s_array =s.toCharArray();
        int max_len = Integer.MIN_VALUE;
        for(int i=0, j=0; j<s.length();) {
            
            if(!letters.contains(s_array[j])) {
                letters.add(s_array[j]);
                j++;
            } else {
                max_len = Math.max(max_len, j-i);
                System.out.println("Max value in loop:"+j +":"+i+":"+max_len);
                letters.remove(s_array[i]);
                i++;
                
            }   
        }
        System.out.println("ans"+max_len);
        return max_len;
    }
}