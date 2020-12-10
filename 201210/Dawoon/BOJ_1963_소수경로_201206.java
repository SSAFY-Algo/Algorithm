package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1963_소수경로_201206 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		boolean[] sosu = new boolean[10000];
		for (int i = 2; i < 10000; i++) {
			if (!sosu[i]) {
				int j = i*2;
				while (j < 10000) {
					sosu[j] = true;
					j += i;
				}
			}
		}

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			bfs(N, M, sosu);
		}
	}

	private static void bfs(int n, int m, boolean[] sosu) {
		LinkedList<Point> q = new LinkedList<Point>();
		boolean[] visit = new boolean[10000];

		q.offer(new Point(n, 0));
		visit[n] = true;
		while (!q.isEmpty()) {
			Point now = q.poll();
			if (now.n == m) {
				System.out.println(now.cnt);
				return;
			}
			int temp = now.n;
			while (true) {
				temp += 1000;
				if (temp >= 10000)
					break;
				if (!sosu[temp] && !visit[temp]) {
					visit[temp] = true;
					q.offer(new Point(temp, now.cnt + 1));
				}
			}
			temp = now.n;
			while (true) {
				temp -= 1000;
				if (temp < 1000)
					break;
				if (!sosu[temp] && !visit[temp]) {
					visit[temp] = true;
					q.offer(new Point(temp, now.cnt + 1));
				}
			}
			temp = now.n;
			while (true) {
				temp += 100;
				if ((now.n /1000) != (temp/1000))
					break;
				if (!sosu[temp]  && !visit[temp]) {
					visit[temp] = true;
					q.offer(new Point(temp, now.cnt + 1));
				}
			}
			temp = now.n;
			while (true) {
				temp -= 100;
				if ((now.n /1000) != (temp/1000))
					break;
				if (!sosu[temp]  && !visit[temp]) {
					visit[temp] = true;
					q.offer(new Point(temp, now.cnt + 1));
				}
			}
			temp = now.n;
			while (true) {
				temp += 10;
				if ((now.n /100) != (temp/100))
					break;
				if (!sosu[temp]  && !visit[temp]) {
					visit[temp] = true;
					q.offer(new Point(temp, now.cnt + 1));
				}
			}
			temp = now.n;
			while (true) {
				temp -= 10;
				if ((now.n /100) != (temp/100))
					break;
				if (!sosu[temp]  && !visit[temp]) {
					visit[temp] = true;
					q.offer(new Point(temp, now.cnt + 1));
				}
			}
			temp = now.n;
			while (true) {
				temp += 1;
				if ((now.n /10) != (temp/10))
					break;
				if (!sosu[temp]  && !visit[temp]) {
					visit[temp] = true;
					q.offer(new Point(temp, now.cnt + 1));
				}
			}
			temp = now.n;
			while (true) {
				temp -= 1;
				if ((now.n /10) != (temp/10))
					break;
				if (!sosu[temp]  && !visit[temp]) {
					visit[temp] = true;
					q.offer(new Point(temp, now.cnt + 1));
				}
			}
		}
		System.out.println("Impossible");
	}

	static class Point {
		int n;
		int cnt;

		public Point(int n, int cnt) {
			this.n = n;
			this.cnt = cnt;
		}
	}
}
