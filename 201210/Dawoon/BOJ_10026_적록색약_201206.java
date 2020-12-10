package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BOJ_10026_적록색약_201206 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		char[][] map = new char[N][N];
		boolean[][] visit1 = new boolean[N][N];
		boolean[][] visit2 = new boolean[N][N];

		for (int i = 0; i < map.length; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = c[j];
			}
		}

		bfs1(map, visit1);
		bfs2(map, visit2);
	}

	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void bfs1(char[][] map, boolean[][] visit1) {
		LinkedList<Point> q = new LinkedList<Point>();

		int ans = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (visit1[i][j] == false) {
					q.offer(new Point(i, j, map[i][j]));
					visit1[i][j] = true;
					while (!q.isEmpty()) {
						Point now = q.poll();

						for (int k = 0; k < dr.length; k++) {
							int nx = now.x + dr[k];
							int ny = now.y + dc[k];
							if(nx < 0 || ny < 0 || nx >= map.length || ny >= map[nx].length) continue;
							if(map[now.x][now.y] == map[nx][ny] && visit1[nx][ny] == false) {
								q.offer(new Point(nx, ny, map[nx][ny]));
								visit1[nx][ny] = true;
							}
						}
					}
					ans++;
				}
			}
		}
		System.out.print(ans+" ");
	}
	
	public static void bfs2(char[][] map, boolean[][] visit2) {
		LinkedList<Point> q = new LinkedList<Point>();

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if(map[i][j] == 'G')
					map[i][j] = 'R';
			}
		}
		int ans = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (visit2[i][j] == false) {
					q.offer(new Point(i, j, map[i][j]));
					visit2[i][j] = true;
					while (!q.isEmpty()) {
						Point now = q.poll();

						for (int k = 0; k < dr.length; k++) {
							int nx = now.x + dr[k];
							int ny = now.y + dc[k];
							if(nx < 0 || ny < 0 || nx >= map.length || ny >= map[nx].length) continue;
							if(map[now.x][now.y] == map[nx][ny] && visit2[nx][ny] == false) {
								q.offer(new Point(nx, ny, map[nx][ny]));
								visit2[nx][ny] = true;
							}
						}
					}
					ans++;
				}
			}
		}
		System.out.print(ans);
	}
	
	static class Point{
		int x;
		int y;
		char val;
		Point(int x, int y, char val){
			this.x = x;
			this.y = y;
			this.val = val;
		}
	}
}
