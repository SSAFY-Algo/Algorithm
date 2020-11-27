package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA_2117_홈방범서비스_201128 {

	static int ans, ansHouse;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = 2 * N - 1;

			int[][] map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			ans = 0;
			ansHouse = 0;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					play(i, j, K, M, map);
				}
			}
			System.out.println("#" + (tc + 1) + " " + ansHouse);
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	private static void play(int x, int y, int K, int M, int[][] map) {
		LinkedList<int[]> q = new LinkedList<int[]>();
		boolean[][] visit = new boolean[map.length][map.length];
		int cntHouse = 0;

		// x, y, cnt
		int[] start = { x, y, 1 };
		int n = 1;
		q.offer(start);
		visit[x][y] = true;
		
		while (!q.isEmpty()) {
			int[] now = q.poll();
			if (now[2] == K)
				continue;

			if(n != now[2]) {
				int companyCost = (n * n) + ((n - 1) * (n - 1));
				int houseCost = cntHouse * M;
				if (houseCost - companyCost >= 0 && cntHouse > ansHouse) {
					ans = companyCost - houseCost;
					ansHouse = cntHouse;
				}
				n++;
			}
			if (map[now[0]][now[1]] == 1)
				cntHouse++;
			for (int i = 0; i < dr.length; i++) {
				int nx = now[0] + dr[i];
				int ny = now[1] + dc[i];
				if (nx < 0 || ny < 0 || nx >= map.length || ny >= map.length)
					continue;
				if (!visit[nx][ny]) {
					int[] p = { nx, ny, now[2] + 1 };
					q.offer(p);
					visit[nx][ny] = true;
				}
			}
		}

		int companyCost = (n * n) + ((n - 1) * (n - 1));
		int houseCost = cntHouse * M;
		if (houseCost - companyCost >= 0 && cntHouse > ansHouse) {
			ans = companyCost - houseCost;
			ansHouse = cntHouse;
		}
	}

}
