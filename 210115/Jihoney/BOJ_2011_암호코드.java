package sc_210115;

import java.util.Scanner;

public class BOJ_2011_암호코드 {
	// 1~26 => A~Z
	static int dp[],num[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String pw=sc.nextLine();
		
		num=new int[pw.length()+1];
		dp=new int[pw.length()+1];
		
		for(int i=0;i<pw.length();i++) {
			num[i+1]=pw.charAt(i)-'0';
		}
		
		dp[0]=1;
		for(int i=1;i<=pw.length();i++) {
			if(num[i]!=0)
				dp[i]=(dp[i]+dp[i-1])%1000000;
			
			int tmp=num[i]+num[i-1]*10;
			
			if(tmp>=10&&tmp<=26) {
				dp[i]=(dp[i]+dp[i-2])%1000000;
			}
		}
		
		for(int i=1;i<=pw.length();i++)
			System.out.println(i+": "+dp[i]);
		System.out.println(dp[pw.length()]);
		sc.close();
	}

}
