package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1600_말이되고픈원숭이_201028 {

	static int[][] map;
	static int[][][] visit;
	static int W, H;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int K = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs(0, 0, K);

//		for (int i = 0; i < visit.length; i++) {
//			for (int j = 0; j < visit[i].length; j++) {
//				System.out.print(visit[i][j][1]);
//			}
//			System.out.println();
//		}
		
		int ans = 40001;
		for (int i = 0; i < visit[H-1][W-1].length; i++) {
			if(visit[H-1][W-1][i] != 0 && ans > visit[H-1][W-1][i])
				ans = visit[H-1][W-1][i];
		}
		if(ans == 40001)
			System.out.println(-1);
		else
			System.out.println(ans - 1);
	}

	static int[][] d = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};
	static int[][] d2 = { { 1, 2 }, { 2, 1 } };
	static int[][] d3 = { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 }};

	private static void bfs(int x, int y, int k) {
		LinkedList<Point> q = new LinkedList<Point>();
		q.offer(new Point(x, y, 1, 0));
		visit = new int[map.length][map[0].length][k+1];
		visit[0][0][0] = 1;

		while (!q.isEmpty()) {
			Point now = q.poll();

			for (int i = 0; i < d3.length; i++) {
				int nx = now.x + d3[i][0];
				int ny = now.y + d3[i][1];
				if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[nx].length)
					continue;
				if (map[nx][ny] == 0 && (visit[nx][ny][now.k_num] == 0)) {
					visit[nx][ny][now.k_num] = now.cnt + 1;
					q.offer(new Point(nx, ny, now.cnt+1, now.k_num));
				}
			}
			if(now.k_num < k) {
				for (int i = 0; i < d.length; i++) {
					int nx = now.x + d[i][0];
					int ny = now.y + d[i][1];
					if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[nx].length)
						continue;
					if (map[nx][ny] == 0 && (visit[nx][ny][now.k_num+1] == 0)) {
						visit[nx][ny][now.k_num+1] = now.cnt + 1;
						q.offer(new Point(nx, ny, now.cnt+1, now.k_num+1));
					}
				}
			}
		}
	}

	static class Point {
		int x;
		int y;
		int cnt;
		int k_num;

		public Point(int x, int y, int cnt, int k_num) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.k_num = k_num;
		}
	}
}
