package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2133_타일채우기_201205 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] dp = new int[N + 1];
		dp[0] = 1;
		if (N >= 2)
			dp[2] = 3;
		if (N >= 4)
			dp[4] = 11;

		if (N >= 2) {
			int index = 2;
			while (true) {
				
				if (index % 2 == 1) {
					if(index == N)
						break;
					index++;
					continue;
				}
				dp[index] = dp[index - 2];
				for (int i = 0; i <= index - 2; i++) {
					dp[index] += dp[i] * 2;
				}
				if (index == N)
					break;
				index++;
			}
		}
//		for (int i = 5; i < dp.length; i++) {
//			dp[i] = dp[i-2];
//			for (int j = 0; j <= i-2; j++) {
//				dp[i] += dp[j]*2;
//			}
//		}

		System.out.println(dp[N]);
	}

}
