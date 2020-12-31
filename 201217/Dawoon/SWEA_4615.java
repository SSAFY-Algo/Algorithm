package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA_4615 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N+1][N+1];
			init(N, map);
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int color = Integer.parseInt(st.nextToken());
				map[x][y] = color;
				othello(x, y, color, map);
			}
			int black = 0, white = 0;
			for (int i = 1; i < map.length; i++) {
				for (int j = 1; j < map[i].length; j++) {
					if(map[i][j] == 1)
						black++;
					else if(map[i][j] == 2)
						white++;
				}
			}
			
			System.out.println("#" + tc + " " + black + " " + white);
		}
	}

	private static void init(int n, int[][] map) {
		int x = n/2;
		int y = n/2;
		map[x][y] = 2;
		map[x][y+1] = 1;
		map[x+1][y] = 1;
		map[x+1][y+1] = 2;
	}

	static int[][] delta = {{-1, 0}, {-1, -1}, {-1, 1}, {0, -1}, {0, 1}, {1, 0}, {1, -1}, {1, 1}};
	private static void othello(int x, int y, int color, int[][] map) {
		for (int i = 0; i < delta.length; i++) {
			int nx = x + delta[i][0];
			int ny = y + delta[i][1];
			if(nx <= 0 || ny <= 0 || nx >= map.length || ny >= map[nx].length || map[nx][ny] == 0 || map[nx][ny] == color) continue;
			LinkedList<Point> q = new LinkedList<Point>();
			q.offer(new Point(nx, ny));
			while(true) {
				nx += delta[i][0];
				ny += delta[i][1];
				if(nx <= 0 || ny <= 0 || nx >= map.length || ny >= map[nx].length || map[nx][ny] == 0) break;
				if(map[nx][ny] != color) {
					q.offer(new Point(nx, ny));
					continue;
				}
				if(map[nx][ny] == color) {
					while(!q.isEmpty()) {
						Point now = q.poll();
						map[now.x][now.y] = color;
					}
					break;
				}
			}
		}
		
	}
	
	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
