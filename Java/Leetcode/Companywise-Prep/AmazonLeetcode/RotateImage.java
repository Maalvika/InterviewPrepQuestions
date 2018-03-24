import java.util.*;

//Problem Number: 48
public class RotateImage{
	
	public void rotate(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
       // System.out.println("c"+c);
        int n = r;
        for(int i=0; i<=r/2; i++){
            for(int j=i; j<c-1-i; j++) {
                //System.out.println("i:"+i+" j:"+j);
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];     
                matrix[j][n-1-i] = temp;
                
            }
        }
    }
}