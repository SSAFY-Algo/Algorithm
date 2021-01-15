import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2011_암호코드2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int n = str.length();
		
		if(str.charAt(0) -'0' == 0) {
			System.out.println("0");
		}
		else if(n==1 && str.charAt(0) -'0' >= 1 && str.charAt(0) -'0' <= 9 ) {
			System.out.println("1");
		}
		else {
			int[] code = new int[n];
			if(str.charAt(0) -'0' >= 1 && str.charAt(0) -'0' <= 9) 
				code[0] = 1;
			
			if(str.charAt(1) -'0'>= 1 && str.charAt(1) -'0' <= 9)
				code[1] = code[0] + code[1];
			
			int num = Integer.parseInt(str.substring(0,1)) * 10 + Integer.parseInt(str.substring(1, 2));
			if(num >= 10 && num <= 26)
				code[1]++;
			
			for (int i = 2; i < n; i++) {
				num = Integer.parseInt(str.substring(i, i+1));
				if(num >= 1 && num <= 9) 
					code[i] = code[i] + code[i-1];
				
					
				num = Integer.parseInt(str.substring(i-1,i)) * 10 + Integer.parseInt(str.substring(i, i+1));
				if(num >= 10 && num <= 26) 
					code[i] = code[i-2] + code[i];
					
				
				code[i] %= 1000000;
			}
			
			System.out.println(code[n-1]);
		}
		
		
		
		
	}

}