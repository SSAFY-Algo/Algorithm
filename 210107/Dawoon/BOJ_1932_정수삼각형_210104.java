package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1932_정수삼각형_210104 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] triangle = new int[N][N];
		
		for (int i = 0; i < triangle.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < i+1; j++) {
				triangle[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] dp = new int[N][N];
		dp[0][0] = triangle[0][0];
		for (int i = 1; i < triangle.length; i++) {
			dp[i][0] = dp[i-1][0] + triangle[i][0];
			for (int j = 1; j < i+1; j++) {
				dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
			}
			dp[i][i] = dp[i-1][i-1] + triangle[i][i];
		}
		int ans = 0;
		for (int i = 0; i < dp.length; i++) {
			if(dp[dp.length-1][i] >ans)
				ans = dp[dp.length-1][i];
		}
		System.out.println(ans);
	}

}
