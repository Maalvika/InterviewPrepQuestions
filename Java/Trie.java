import java.util.*;

public class Trie{
	
	class TrieNode {
		
		char c;
		TrieNode[] children = new TrieNode[26];
		boolean isEnd;
		
		public TrieNode(){
			isEnd = false;
		}
		
		public TrieNode(char c){
			this.c = c; 
			isEnd = false;
		}
		
	}
	
	TrieNode root;
	
	/** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] wordArray = word.toCharArray();
		TrieNode temp = root;
		for(int i=0; i<wordArray.length; i++) {
			if(temp.children[wordArray[i]-'a'] == null) {
				TrieNode n = new TrieNode(wordArray[i]);
				temp.children[wordArray[i]-'a'] = n;
			}
			if(n == wordArray.length-1) {
				n.isEnd = true;
			}
			temp = n;
			
		}
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] wordArray = word.toCharArray();
		TrieNode temp = root;
		for(int i=0; i<wordArray.length; i++) {
			TrieNode n = temp.children[wordArray[i]-'a'];
			if( n == null) {
				return false;
			}
			if(n == wordArray.length-1 && n.isEnd == true) {
				return true;
			}
			temp = n;
			
		}
		return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
		
		char[] wordArray = word.toCharArray();
		TrieNode temp = root;
		for(int i=0; i<wordArray.length; i++) {
			TrieNode n = temp.children[wordArray[i]-'a'];
			if( n == null) {
				return false;
			}
			if(n == wordArray.length-1 && n.isEnd != true) {
				return true;
			}
			temp = n;
			
		}
		return false;
        
    }
}