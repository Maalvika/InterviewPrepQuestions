import java.util.*;

public class MultiplyStr{
	
	public static void main(String[] args){
		String a = "123";
		String b = "456";
		int[] res = new int[a.length()+b.length()+1];
		byte[] a_arr = toByteArray(a);
		byte[] b_arr = toByteArray(b);
		for(int i = 0; i<a_arr.length; i++) {
			for(int j = 0; j<b_arr.length; j++) {
			
				res[i+j] += a_arr[i]*b_arr[j];
			}
		}
		
		System.out.println("Product is:"+handleCarry(res));
	}
	
	public static String handleCarry(int[] res){
		int carry = 0;
		Stack<Integer> stack = new Stack<>();
		StringBuilder s = new StringBuilder();
		for(int i=0;i<res.length;i++) {
			res[i] += carry;
			carry = res[i]/10;
			stack.push(res[i]%10); 
		}
		while(!stack.isEmpty()) {
			s.append(stack.pop());
		}
		return s.toString();
	}
	
	 public static byte[] toByteArray(String s) {
		
		byte[] bArr = new byte[s.length()];
		for (int i = s.length()-1, j=0; i >=0; i--,j++) {
		  // Convert each character into its corresponding integer representation
		  bArr[j] = (byte)(s.charAt(i) - '0');
		}

		return bArr;
	}

}