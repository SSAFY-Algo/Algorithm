package sc_210205;

import java.util.Scanner;

public class BOJ_1010_다리놓기 {
//조합론 => nCn=nC0=1, nCr=n-1Cr-1+n-1Cr
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int dp[][]=new int[31][31];
		
		for(int i=0;i<31;i++) {
			dp[i][i]=1;
			dp[i][0]=1;
			for(int j=1;j<=i;j++) {
				dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
			}
		}
		int tc=sc.nextInt();
		for(int i=0;i<tc;i++) {
			int m=sc.nextInt();
			int n=sc.nextInt();
			System.out.println(dp[n][m]);
		}
	}

}
