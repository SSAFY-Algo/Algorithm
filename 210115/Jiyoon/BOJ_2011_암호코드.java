package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2011_암호코드 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();

		int size = input.length; // 주어진 숫자의 size
		int[] N = new int[size + 1];
		int[] dp = new int[size + 1];

		for (int i = 0; i < size; i++) {
			N[i + 1] = input[i] - '0';
		}

		dp[0] = 1;

		for (int i = 1; i < N.length; i++) {
			if (N[i] != 0) {
				dp[i] = (dp[i - 1] + dp[i]) % 1000000;
			} 
			if (N[i - 1] * 10 + N[i] <= 26 && N[i - 1] * 10 + N[i] >= 10) {
				dp[i] = (dp[i - 2] + dp[i]) % 1000000;
			}
		}

		System.out.println(dp[N.length - 1]);

	}
}
