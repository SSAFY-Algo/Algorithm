package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2156_포도주시식_201201 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] wine = new int[N];
		int[] dp = new int[N];
		
		for (int i = 0; i < N; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}
		if(N == 1 || N == 2) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				sum += wine[i];
			}
			System.out.println(sum);
			System.exit(0);
		}
		dp[0] = wine[0];
		dp[1] = dp[0] + wine[1];
		dp[2] = Math.max(dp[0] + wine[2], Math.max(dp[1], wine[1] + wine[2]));
		for (int i = 3; i < N; i++) {
			dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + wine[i], dp[i - 3] + wine[i - 1] + wine[i]));
		}
		System.out.println(dp[N-1]);
	}

}
