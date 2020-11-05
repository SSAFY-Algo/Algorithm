package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_4485_녹색옷입은애가젤다지_201105 {
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc = 1;
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			
			int[][] map = new int[N][N];
			int[][] visit = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int a[] : visit) {
				Arrays.fill(a, 400000);
			}
			bfs(0, 0, map, visit);
			
			System.out.println("Problem " + tc + ": " + visit[N-1][N-1]);
			tc++;
		}
	}

	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	private static void bfs(int x, int y, int[][] map, int[][] visit) {
		
		LinkedList<Point> q = new LinkedList<Point>();
		
		q.offer(new Point(x, y, map[x][y]));
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			for (int i = 0; i < dr.length; i++) {
				
				int nx = now.x + dr[i];
				int ny = now.y + dc[i];
				
				if(nx < 0 || ny < 0 || nx >= map.length || ny >= map[nx].length) continue;
				if(visit[nx][ny] > now.sum + map[nx][ny]) {
					visit[nx][ny] = now.sum + map[nx][ny];
					q.offer(new Point(nx, ny, visit[nx][ny]));
				}
			}
		}
	}
	
	static class Point{
		int x;
		int y;
		int sum;
		
		public Point(int x, int y, int sum) {
			super();
			this.x = x;
			this.y = y;
			this.sum = sum;
		}
	}
}
