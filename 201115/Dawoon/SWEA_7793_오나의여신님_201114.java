package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA_7793_오나의여신님_201114 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[R][C];
			boolean[][] visit = new boolean[R][C];
			Point start = null;
			
			//input
			for (int i = 0; i < R; i++) {
				char[] c = br.readLine().toCharArray();
				for (int j = 0; j < C; j++) {
					switch (c[j]) {
					case 'D':
						map[i][j] = 10000;
						break;
					case '.':
						map[i][j] = 0;
						break;
					case '*':
						map[i][j] = 1;
						break;
					case 'X':
						map[i][j] = -1;
						break;
					case 'S':
						start = new Point(i, j, 0);
						break;
					default:
						break;
					}
				}
			}
			
			int cnt = go(start, map, visit);
			if(cnt != 0)
				System.out.println("#" + (tc+1) + " " + cnt);
			else
				System.out.println("#" + (tc+1) + " GAME OVER");
		}
	}

	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	private static int go(Point start, int[][] map, boolean[][] visit) {
		LinkedList<Point> q = new LinkedList<Point>();
		
		q.offer(start);
		
		Point now = start;
		
		while(!q.isEmpty()) {
			if(q.peek().cnt != now.cnt) {
				spread(map, now.cnt+1);
			}
			
			now = q.poll();
			
			if(map[now.x][now.y] == 10000)
				return now.cnt;
			if(map[now.x][now.y] != 0 )
				continue;
			for (int i = 0; i < dr.length; i++) {
				int nx = now.x + dr[i];
				int ny = now.y + dc[i];
				if(nx < 0 || ny < 0 || nx >= map.length || ny >= map[nx].length) continue;
				if((map[nx][ny] == 0 || map[nx][ny] == 10000)&& !visit[nx][ny]) {
					q.offer(new Point(nx, ny, now.cnt+1));
					visit[nx][ny] = true;
				}
			}
		}
		
		return 0;
	}

	private static void spread(int[][] map, int cnt) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if(map[i][j] == cnt) {
					for (int j2 = 0; j2 < dr.length; j2++) {
						int nx = i + dr[j2];
						int ny = j + dc[j2];
						if(nx < 0 || ny < 0 || nx >= map.length || ny >= map[nx].length) continue;
						if(map[nx][ny] == 0) {
							map[nx][ny] = cnt+1;
						}
					}
				}
			}
		}
		
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

}
