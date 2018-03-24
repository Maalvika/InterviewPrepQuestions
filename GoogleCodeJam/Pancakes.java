import java.util.*;
import java.io.*;

public class Pancakes {
	
	public static void main(String args[]) throws IOException{
		
		//Scanner scan = new Scanner(System.in);
		File file = new File("A-large-practice.in");
		Scanner scan = new Scanner(file);
		String output_fileName = "output_small.txt";
		BufferedWriter writer = new BufferedWriter(new FileWriter(output_fileName));
		
		int k = scan.nextInt();
		for(int i=0; i<k; i++) {
			String s = scan.next();
			int flip = scan.nextInt();
			int res = calculateFlips(s, flip);
			if(res == -1) {
				writer.append("Case #"+(i+1)+": Impossible\n");
			} else {
				writer.append("Case #"+(i+1)+": "+res+"\n");
			}
		}
		writer.close();
	}
	
	public static int calculateFlips(String pancakes, int flip){
		int n = pancakes.length();
		char[] pkArray = pancakes.toCharArray();
		int cnt  = 0;
		for(int i=0; i<n-flip+1; i++) {
			if(pkArray[i] == '+') {
				continue;
			}
			
			for(int j = i; j<i+flip; j++) {
				if(pkArray[j]=='-') {
					pkArray[j] = '+';
				} else {
					pkArray[j] = '-';
				}
			}
			cnt++;
		}
		//System.out.println("Changed array is:"+String.valueOf(pkArray));
		if(String.valueOf(pkArray).contains("-")){
			return -1;
		}
		return cnt;
	}
}
