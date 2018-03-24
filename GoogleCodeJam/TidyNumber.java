import java.util.*;
import java.io.*;

public class TidyNumber {
	
	public static void main(String args[]) throws IOException{
		
		File file = new File("B-large-practice.in");
		Scanner scan = new Scanner(file);
		String output_fileName = "output_large_B.txt";
		BufferedWriter writer = new BufferedWriter(new FileWriter(output_fileName));
		
		//Scanner scan = new Scanner(System.in);
		int k = scan.nextInt();
		for(int i=0; i<k; i++) {
			String num = scan.next();
			int[] digits = get_digits(num);
			String res = find_tidy(digits);
			//System.out.println(res);
			writer.append("Case #"+(i+1)+": "+res+"\n");
			//System.out.println("Tidy num: "+find_tidy(digits));
		}
		writer.close();
	}
	
	public static String find_tidy(int[] d){
		StringBuilder res = new StringBuilder();
		if(d.length == 1) {
			res.append(d[0]);
			return res.toString();
		}
		
		for(int i= d.length-1; i>0; i--) {
			if(d[i]<d[i-1]) {
				int j = i;
				while(j<d.length) {
					d[j] = (d[j] == 9)? d[j]:9;
					j++;
				}
				d[i-1]--;
			}
		}
		for(int i = 0; i<d.length; i++) {
			if(i==0 && d[i] == 0) {
				continue;
			}
			res.append(d[i]);
		}
		
		return res.toString();		
	}
	
	public static int[] get_digits(String s) {
		int[] digits = new int[s.length()];
		for(int i=0; i<s.length(); i++) {
			digits[i] = s.charAt(i) - '0';
		}
		return digits;
	}
	
	
}