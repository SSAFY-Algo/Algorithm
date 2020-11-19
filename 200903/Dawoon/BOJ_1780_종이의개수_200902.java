package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1780_종이의개수_200902 {

	static int N;
	static int[][] map;
	static int[] ans = new int[3];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		compress(N, 0, 0);
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
		
	}

	static void compress(int n, int y, int x) {

		if (n == 1) {
			ans[map[y][x]+1]++;
			return;
		}

		boolean minus_one = true, zero = true, one = true;

		for (int i = y; i < y + n; i++) {
			for (int j = x; j < x + n; j++) {

				if (map[i][j] != 0)
					zero = false;

				if (map[i][j] != 1)
					one = false;

				if (map[i][j] != -1)
					minus_one = false;
			}
		}
		if (zero)
			ans[1]++;

		else if (one)
			ans[2]++;

		else if(minus_one)
			ans[0]++;
		else
		{
			compress(n / 3, y, x);

			compress(n / 3, y, x + n / 3);

			compress(n / 3, y, x + (n / 3) * 2);

			compress(n / 3, y + n / 3, x);

			compress(n / 3, y + n / 3, x + n / 3);

			compress(n / 3, y + n / 3, x + (n / 3) * 2);

			compress(n / 3, y + (n / 3) * 2, x);

			compress(n / 3, y + (n / 3) * 2, x + n / 3);

			compress(n / 3, y + (n / 3) * 2, x + (n / 3) * 2);
		}
		return;
	}

}
