package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1010_다리놓기2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스

		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[][] dp = new int[N + 1][M + 1]; // 서쪽 N개, 동쪽 M개

			for (int n = 2; n <= N; n++) {
				dp[n][1] = 0;
			}

			for (int m = 1; m <= M; m++) {
				dp[1][m] = m;
			}

			for (int i = 2; i <= N; i++) {
				for (int j = 2; j <= M; j++) {
					dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
				}
			}

			System.out.println(dp[N][M]);
		}
	}
}
