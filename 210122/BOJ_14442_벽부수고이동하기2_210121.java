package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_14442_벽부수고이동하기2_210121 {

	static int N, M, K, ans;
	static int[][] map;
	static boolean[][][] visit;
	static boolean isGo = false;
	static LinkedList<Point> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visit = new boolean[N][M][K + 1];
		ans = 1000000;
		q = new LinkedList<Point>();
		for (int i = 0; i < map.length; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = c[j] - '0';
			}
		}

		q.offer(new Point(0, 0, 0, 0));
		visit[0][0][0] = true;
		bfs();
		if (isGo)
			System.out.println(ans + 1);
		else
			System.out.println(-1);
	}

	// 하 우 상 좌
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, -1, 0, 1 };

	public static void bfs() {
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			if(now.x == N-1 && now.y == M-1) {
				isGo = true;
				if(now.cnt < ans)
					ans = now.cnt;
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dr[i];
				int ny = now.y + dc[i];
				if(nx <0 || ny < 0 || nx >=N || ny>=M) continue;
				if(map[nx][ny] == 0) {
					if(visit[nx][ny][now.k] == false) {
						visit[nx][ny][now.k] = true;
						q.offer(new Point(nx, ny, now.k, now.cnt+1));
					}
				}else if(now.k < K && visit[nx][ny][now.k+1] == false) {
					visit[nx][ny][now.k+1] = true;
					q.offer(new Point(nx, ny, now.k+1, now.cnt+1));
				}
			}
		}
	}

	static class Point {
		int x;
		int y;
		int k;
		int cnt;

		public Point(int x, int y, int k, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.k = k;
			this.cnt = cnt;
		}
	}
}