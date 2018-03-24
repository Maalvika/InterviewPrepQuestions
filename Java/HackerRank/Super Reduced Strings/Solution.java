import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
		char []  s_chars = s.toCharArray();
		Stack stack = new Stack();
		
		for(int i=0; i<s_chars.length; i++) {
			
			if(stack.empty() == true) {
				stack.push(s_chars[i]);
			} else if((char)stack.peek() == s_chars[i]) {
				stack.pop();
			} else {
				stack.push(s_chars[i]);
			}
		}
		
		if(stack.empty()) {
			System.out.println("Empty String");
		} else {
			char[] result = new char[stack.size()];
			for(int i=stack.size()-1; i>=0; i--) {
				result[i] = (char)stack.pop();
			}
			for(int i=0; i<result.length; i++) {
				System.out.print(result[i]);
			}
		}
		
    }
}
