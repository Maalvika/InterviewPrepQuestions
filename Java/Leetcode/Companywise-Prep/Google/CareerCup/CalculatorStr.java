import java.util.*;

public class CalculatorStr{
	
	public String big_sum(String s1, String s2) {
		int i = s1.length()-1;
		int j = s2.length()-1;
		StringBuilder sb = new StringBuilder();
		int carry = 0;
		while(i>=0 && j>=0) {
			int i1 = Integer.parseInt(String.valueOf(s1.charAt(i)));
			int i2 = Integer.parseInt(String.valueOf(s2.charAt(j)));
			int d = i1+i2+carry;
			carry = d/10;
			sb.insert(0, d%10);
			i--;
			j--;
		}
		while(i>=0) {
			int i1 = Integer.parseInt(String.valueOf(s1.charAt(i)));
			int d = i1+carry;
			carry = d/10;
			sb.insert(0, d%10);
			i--;
		}
		while(j>=0) {
			int i1 = Integer.parseInt(String.valueOf(s2.charAt(j)));
			int d = i1+carry;
			carry = d/10;
			sb.insert(0, d%10);
			j--;
		}
		if(carry == 1) {
			sb.insert(0, 1);
		}
		
		return sb.toString();
	}
	
	/
	public String big_multiply(String s1, String s2){
		byte[] sb1 = toByteArray(s1);
		byte[] sb2 = toByteArray(s2);
		int[] res = new int[s1.length()+s2.length()+1];
		for(int i=0; i<s1.length(); i++) {
			for(int j=0; j<s2.length(); j++) {
				res[i+j]+=sb1[i]*sb2[j];
			}
		}
		
		return adjust_carry(res);
		
	}
	
	public String adjust_carry(int[] res){
		StringBuilder sb = new StringBuilder();
		int carry = 0;
		for(int i = res.length - 1; i>=0; i--) {
			int d = res[i]%10;
			carry = res[i]/10;
			sb.insert(0,d);
		}
		return sb.toString();
	}
	
	public byte[] toByteArray(String s){
		byte[] s_byte = new byte[s.length()];
		for(int i=s.length()-1, j=0; i>=0; i--,j++) {
			s_byte[j] = (byte) s.charAt(i);
		}
		return s_byte;
	}
	public static void main(String[] args){
		CalculatorStr calc = new CalculatorStr();
		String n1 = "99999";
		String n2 = "90009";
		String sum = calc.big_sum(n1, n2);
		System.out.println("Sum of n1:"+n1+" and n2:"+n2+" is="+sum);
	}
}