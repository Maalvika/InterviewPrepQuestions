///////////////////////////////// 139. Word Break

class WordBreak {
	
	/////////// This is the recursive solution. It times out on long input string
	public boolean wordBreak(String s, List<String> wordDict) {
        return  wordBreak_helper(s, wordDict, 0);
    }
    
    public boolean wordBreak_helper(String s, List<String> wordDict, int pos) {
        if(pos==s.length()) {
            return true;
        }
        
        for(String word: wordDict) {
            int size = word.length();
            if(pos+size>s.length()) {
                continue;
            }
            if(s.substring(pos, pos+size).equals(word)) {
               if(wordBreak_helper(s, wordDict, pos+size)){
                   return true;
               }
            }
        }
        return false;
    }
	
	/// This is the iterative dynamic programming solution
    public boolean wordBreakDP(String s, List<String> wordDict) {
        
        boolean[] memo = new boolean[s.length()+1];
        memo[0] = true;
        for(int i=0; i<s.length(); i++){
            if(!memo[i]) {
                continue;
            }
            
            for(String word:wordDict) {
                int len = word.length();
                int end = i+len;
                if(end>s.length()) {
                    continue;
                }
                if(memo[end]) {
                    continue;
                }
                
                if(s.substring(i,end).equals(word)) {
                    memo[end] = true;
                }
            }
        }
        return memo[s.length()];
    }
}