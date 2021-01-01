package day1220;

import java.util.Scanner;

public class BOJ_1904_01타일_201220 {
	
	static int n = 0;
	static int[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sc.close();
		
		dp = new int[n+1];
		
		dp[0] = 0;
		dp[1] = 1;
		if(n >= 2) dp[2] = 2;
		
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		System.out.println(dp[n]%15746);
	}

}
