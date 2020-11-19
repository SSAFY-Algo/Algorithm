package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3349_최솟값으로이동하기_201118 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int W = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());

			int ans = 0;

			st = new StringTokenizer(br.readLine());
			Point start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			for (int i = 1; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				Point end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

				int x = end.x - start.x;
				int y = end.y - start.y;
				
				if (x * y > 0) {
					ans += Math.max(Math.abs(x), Math.abs(y));
				} else if (x * y < 0) {
					ans += Math.abs(x - y);
				} else
					ans += Math.abs(x + y);
				start = end;
			}
			System.out.println("#" + tc + " " + ans);
		}
	}

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
