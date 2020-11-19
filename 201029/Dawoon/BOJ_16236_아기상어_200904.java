package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_16236_아기상어_200904 {

	static int[][] map;
	static Shark shark;
	static int N;
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					shark = new Shark(i, j, 2, 0);
					map[i][j] = 0;
				}
			}
		}
		ans = 0;
		while(true) {
			if(!dfs(shark.x, shark.y))
				break;
		}
		System.out.println(ans);
	}
	
	static int[] dr = {-1, 0, 0, 1};
	static int[] dc = {0, -1, 1, 0};
	private static boolean dfs(int x, int y) {
		LinkedList<Point> q = new LinkedList<Point>();
		boolean[][] visit = new boolean[N][N];
		
		q.offer(new Point(x, y, 0));
		visit[x][y] = true;
		boolean isFirst = false;
		int dist = 0;
		Point temp = null;
		while(!q.isEmpty()) {
			Point now = q.poll();
			
			if(now.cnt != 0 && map[now.x][now.y] != 0 && map[now.x][now.y] < shark.level) {
				if(!isFirst) {
					isFirst = true;
					temp = now;
					continue;
				}
				if(temp.cnt == now.cnt) {
					if(now.x < temp.x) {
						temp = now;
					}else if(now.x == temp.x && now.y < temp.y) {
						temp = now;
					}
					continue;
				}
				map[temp.x][temp.y] = 0;
				shark.exp++;
				ans += temp.cnt;
				shark.x = temp.x;
				shark.y = temp.y;
				if(shark.exp == shark.level) {
					shark.level++;
					shark.exp = 0;
				}
				return true;
			}
			for (int i = 0; i < dr.length; i++) {
				int nx = now.x + dr[i];
				int ny = now.y + dc[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
				if(!visit[nx][ny] && map[nx][ny] <= shark.level) {
					q.offer(new Point(nx, ny, now.cnt+1));
					visit[nx][ny] = true;
				}
			}
		}
		if(temp != null) {
			map[temp.x][temp.y] = 0;
			shark.exp++;
			ans += temp.cnt;
			shark.x = temp.x;
			shark.y = temp.y;
			if(shark.exp == shark.level) {
				shark.level++;
				shark.exp = 0;
			}
			return true;
		}
		return false;
	}

	static class Point{
		int x;
		int y;
		int cnt;
		public Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
	static class Shark{
		int x;
		int y;
		int level;
		int exp;
		public Shark(int x, int y, int level, int exp) {
			this.x = x;
			this.y = y;
			this.level = level;
			this.exp = exp;
		}
	}
}
