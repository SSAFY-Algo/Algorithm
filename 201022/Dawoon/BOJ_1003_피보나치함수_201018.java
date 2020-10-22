package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1003_피보나치함수_201018 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] dp = new int[41][2];
		int T = Integer.parseInt(br.readLine());
		
		dp[0][0] = 1;
		dp[0][1] = 0;
		dp[1][0] = 0;
		dp[1][1] = 1;
		
		for (int i = 2; i < dp.length; i++) {
			dp[i][0] = dp[i-1][0] + dp[i-2][0];
			dp[i][1] = dp[i-1][1] + dp[i-2][1];
			
		}
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			System.out.print(dp[N][0] + " ");
			System.out.println(dp[N][1]);
		}
	}
}
