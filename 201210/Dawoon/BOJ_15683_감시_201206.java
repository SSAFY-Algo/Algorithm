package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_15683_감시_201206 {

	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		ArrayList<Point> cctvList = new ArrayList<Point>();
		ans = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] > 0 && map[i][j] < 6) {
					cctvList.add(new Point(i, j));
				}
			}
		}

		dfs(cctvList, map, 0);
		System.out.println(ans);
	}

	private static void dfs(ArrayList<Point> cctvList, int[][] map, int n) {
		LinkedList<Point> q = new LinkedList<Point>();
		if(n == cctvList.size()) {
			int count = 0;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if(map[i][j] == 0)
						count++;
				}
			}
			if(ans > count)
				ans = count;
			return;
		}
		Point now = cctvList.get(n);
		switch (map[now.x][now.y]) {
		case 1:
			for (int i = 0; i < 4; i++) {
				play1(i, map, q, now);
				dfs(cctvList, map, n+1);
				while(!q.isEmpty()) {
					Point temp = q.poll();
					map[temp.x][temp.y] = 0;
				}
			}
			break;
		case 2:
			for (int i = 0; i < 2; i++) {
				play2(i, map, q, now);
				dfs(cctvList, map, n+1);
				while(!q.isEmpty()) {
					Point temp = q.poll();
					map[temp.x][temp.y] = 0;
				}
			}
			break;
		case 3:
			for (int i = 0; i < 4; i++) {
				play3(i, map, q, now);
				dfs(cctvList, map, n+1);
				while(!q.isEmpty()) {
					Point temp = q.poll();
					map[temp.x][temp.y] = 0;
				}
			}
			break;
		case 4:
			for (int i = 0; i < 4; i++) {
				play4(i, map, q, now);
				dfs(cctvList, map, n+1);
				while(!q.isEmpty()) {
					Point temp = q.poll();
					map[temp.x][temp.y] = 0;
				}
			}
			break;
		case 5:
			for (int i = 0; i < 1; i++) {
				play5(i, map, q, now);
				dfs(cctvList, map, n+1);
				while(!q.isEmpty()) {
					Point temp = q.poll();
					map[temp.x][temp.y] = 0;
				}
			}
			break;
		default:
			break;
		}
	}

	private static void play1(int type, int[][] map, LinkedList<Point> q, Point now) {
		int x = now.x;
		int y = now.y;
		switch (type) {
		case 0:
			while(true) {
				y += 1;
				if(y >= map[x].length || map[x][y] == 6) break;
				if(map[x][y] == 0) {
					map[x][y] = -1;
					q.offer(new Point(x, y));
				}
			}
			break;
		case 1:
			while(true) {
				y -= 1;
				if(y < 0 || map[x][y] == 6) break;
				if(map[x][y] == 0) {
					map[x][y] = -1;
					q.offer(new Point(x, y));
				}
			}
			break;
		case 2:
			while(true) {
				x -= 1;
				if(x < 0 || map[x][y] == 6) break;
				if(map[x][y] == 0) {
					map[x][y] = -1;
					q.offer(new Point(x, y));
				}
			}
			break;
		case 3:
			while(true) {
				x += 1;
				if(x >= map.length || map[x][y] == 6) break;
				if(map[x][y] == 0) {
					map[x][y] = -1;
					q.offer(new Point(x, y));
				}
			}
			break;
		default:
			break;
		}
	}
	
	private static void play2(int type, int[][] map, LinkedList<Point> q, Point now) {
		int x = now.x;
		int y = now.y;
		switch (type) {
		case 0:
			while(true) {
				y += 1;
				if(y >= map[x].length || map[x][y] == 6) break;
				if(map[x][y] == 0) {
					map[x][y] = -1;
					q.offer(new Point(x, y));
				}
			}
			y = now.y;
			while(true) {
				y -= 1;
				if(y < 0 || map[x][y] == 6) break;
				if(map[x][y] == 0) {
					map[x][y] = -1;
					q.offer(new Point(x, y));
				}
			}
			break;
		case 1:
			while(true) {
				x -= 1;
				if(x < 0 || map[x][y] == 6) break;
				if(map[x][y] == 0) {
					map[x][y] = -1;
					q.offer(new Point(x, y));
				}
			}
			x = now.x;
			while(true) {
				x += 1;
				if(x >= map.length || map[x][y] == 6) break;
				if(map[x][y] == 0) {
					map[x][y] = -1;
					q.offer(new Point(x, y));
				}
			}
			break;
		default:
			break;
		}
		
	}
	
	private static void play3(int type, int[][] map, LinkedList<Point> q, Point now) {
		int x = now.x;
		int y = now.y;
		switch (type) {
		case 0:
			while(true) {
				y += 1;
				if(y >= map[x].length || map[x][y] == 6) break;
				if(map[x][y] == 0) {
					map[x][y] = -1;
					q.offer(new Point(x, y));
				}
			}
			y = now.y;
			while(true) {
				x -= 1;
				if(x < 0 || map[x][y] == 6) break;
				if(map[x][y] == 0) {
					map[x][y] = -1;
					q.offer(new Point(x, y));
				}
			}
			break;
		case 1:
			while(true) {
				y += 1;
				if(y >= map[x].length || map[x][y] == 6) break;
				if(map[x][y] == 0) {
					map[x][y] = -1;
					q.offer(new Point(x, y));
				}
			}
			y = now.y;
			while(true) {
				x += 1;
				if(x >= map.length || map[x][y] == 6) break;
				if(map[x][y] == 0) {
					map[x][y] = -1;
					q.offer(new Point(x, y));
				}
			}
			break;
		case 2:
			while(true) {
				y -= 1;
				if(y < 0 || map[x][y] == 6) break;
				if(map[x][y] == 0) {
					map[x][y] = -1;
					q.offer(new Point(x, y));
				}
			}
			y = now.y;
			while(true) {
				x += 1;
				if(x >= map.length || map[x][y] == 6) break;
				if(map[x][y] == 0) {
					map[x][y] = -1;
					q.offer(new Point(x, y));
				}
			}
			break;
		case 3:
			while(true) {
				y -= 1;
				if(y < 0 || map[x][y] == 6) break;
				if(map[x][y] == 0) {
					map[x][y] = -1;
					q.offer(new Point(x, y));
				}
			}
			y = now.y;
			while(true) {
				x -= 1;
				if(x < 0 || map[x][y] == 6) break;
				if(map[x][y] == 0) {
					map[x][y] = -1;
					q.offer(new Point(x, y));
				}
			}
			break;
		default:
			break;
		}
		
	}
	
	private static void play4(int type, int[][] map, LinkedList<Point> q, Point now) {
		int x = now.x;
		int y = now.y;
		switch (type) {
		case 0:
			while(true) {
				y += 1;
				if(y >= map[x].length || map[x][y] == 6) break;
				if(map[x][y] == 0) {
					map[x][y] = -1;
					q.offer(new Point(x, y));
				}
			}
			y = now.y;
			while(true) {
				y -= 1;
				if(y < 0 || map[x][y] == 6) break;
				if(map[x][y] == 0) {
					map[x][y] = -1;
					q.offer(new Point(x, y));
				}
			}
			y = now.y;
			while(true) {
				x -= 1;
				if(x < 0 || map[x][y] == 6) break;
				if(map[x][y] == 0) {
					map[x][y] = -1;
					q.offer(new Point(x, y));
				}
			}
			break;
		case 1:
			while(true) {
				y += 1;
				if(y >= map[x].length || map[x][y] == 6) break;
				if(map[x][y] == 0) {
					map[x][y] = -1;
					q.offer(new Point(x, y));
				}
			}
			y = now.y;
			while(true) {
				x += 1;
				if(x >= map.length || map[x][y] == 6) break;
				if(map[x][y] == 0) {
					map[x][y] = -1;
					q.offer(new Point(x, y));
				}
			}
			x = now.x;
			while(true) {
				x -= 1;
				if(x < 0 || map[x][y] == 6) break;
				if(map[x][y] == 0) {
					map[x][y] = -1;
					q.offer(new Point(x, y));
				}
			}
			break;
		case 2:
			while(true) {
				y += 1;
				if(y >= map[x].length || map[x][y] == 6) break;
				if(map[x][y] == 0) {
					map[x][y] = -1;
					q.offer(new Point(x, y));
				}
			}
			y = now.y;
			while(true) {
				y -= 1;
				if(y < 0 || map[x][y] == 6) break;
				if(map[x][y] == 0) {
					map[x][y] = -1;
					q.offer(new Point(x, y));
				}
			}
			y = now.y;
			while(true) {
				x += 1;
				if(x >= map.length || map[x][y] == 6) break;
				if(map[x][y] == 0) {
					map[x][y] = -1;
					q.offer(new Point(x, y));
				}
			}
			break;
		case 3:
			while(true) {
				y -= 1;
				if(y < 0 || map[x][y] == 6) break;
				if(map[x][y] == 0) {
					map[x][y] = -1;
					q.offer(new Point(x, y));
				}
			}
			y = now.y;
			while(true) {
				x += 1;
				if(x >= map.length || map[x][y] == 6) break;
				if(map[x][y] == 0) {
					map[x][y] = -1;
					q.offer(new Point(x, y));
				}
			}
			x = now.x;
			while(true) {
				x -= 1;
				if(x < 0 || map[x][y] == 6) break;
				if(map[x][y] == 0) {
					map[x][y] = -1;
					q.offer(new Point(x, y));
				}
			}
			break;
		default:
			break;
		}
		
	}
	
	private static void play5(int type, int[][] map, LinkedList<Point> q, Point now) {
		int x = now.x;
		int y = now.y;
		while(true) {
			y += 1;
			if(y >= map[x].length || map[x][y] == 6) break;
			if(map[x][y] == 0) {
				map[x][y] = -1;
				q.offer(new Point(x, y));
			}
		}
		y = now.y;
		while(true) {
			y -= 1;
			if(y < 0 || map[x][y] == 6) break;
			if(map[x][y] == 0) {
				map[x][y] = -1;
				q.offer(new Point(x, y));
			}
		}
		y = now.y;
		while(true) {
			x += 1;
			if(x >= map.length || map[x][y] == 6) break;
			if(map[x][y] == 0) {
				map[x][y] = -1;
				q.offer(new Point(x, y));
			}
		}
		x = now.x;
		while(true) {
			x -= 1;
			if(x < 0 || map[x][y] == 6) break;
			if(map[x][y] == 0) {
				map[x][y] = -1;
				q.offer(new Point(x, y));
			}
		}
	}

	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
