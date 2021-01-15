package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_19238_스타트택시_210110 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		BOJ_19238_스타트택시_210110 Algo = new BOJ_19238_스타트택시_210110();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int fuel = Integer.parseInt(st.nextToken());

		int[][] map = new int[N + 1][N + 1];
		for (int i = 1; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		int taxi_x = Integer.parseInt(st.nextToken());
		int taxi_y = Integer.parseInt(st.nextToken());

		Taxi taxi = new Taxi(taxi_x, taxi_y, fuel);

		Point[][] personMap = new Point[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start_x = Integer.parseInt(st.nextToken());
			int start_y = Integer.parseInt(st.nextToken());
			int end_x = Integer.parseInt(st.nextToken());
			int end_y = Integer.parseInt(st.nextToken());
			personMap[start_x][start_y] = new Point(end_x, end_y);
		}

		int personCnt = M;
		while (true) {
			if (personCnt <= 0)
				break;
			personCnt = Algo.searchPerson(taxi, map, personMap, personCnt);
		}
		if (personCnt == 0)
			System.out.println(taxi.fuel);
		else
			System.out.println(-1);

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	private int searchPerson(Taxi taxi, int[][] map, Point[][] personMap, int personCnt) {
		PriorityQueue<Point> personList = new PriorityQueue<Point>();

		LinkedList<Point> q = new LinkedList<Point>();
		q.add(new Point(taxi.x, taxi.y));

		boolean[][] visited = new boolean[map.length][map.length];
		visited[taxi.x][taxi.y] = true;

		int moveCnt = 400;
		while (!q.isEmpty()) {

			Point now = q.poll();
			if (now.cnt > moveCnt)
				break;
			if (personMap[now.x][now.y] != null) {
				personList.add(new Point(now.x, now.y, now.cnt));
				moveCnt = now.cnt;
			}

			for (int i = 0; i < dr.length; i++) {
				int nx = now.x + dr[i];
				int ny = now.y + dc[i];
				if (nx < 1 || ny < 1 || nx >= map.length || ny >= map[nx].length || map[nx][ny] == 1 || visited[nx][ny])
					continue;
				visited[nx][ny] = true;
				q.add(new Point(nx, ny, now.cnt + 1));
			}
		}

		if (!personList.isEmpty()) {
			Point now = personList.poll();
			taxi.fuel = taxi.fuel - now.cnt;
			Point destination = personMap[now.x][now.y];
			int destCnt = searchDest(now, destination, map);
			personMap[now.x][now.y] = null;
			if (taxi.fuel - destCnt < 0)
				return -1;
			taxi.x = destination.x;
			taxi.y = destination.y;
			taxi.fuel += destCnt;
			return personCnt - 1;
		}
		return -1;
	}

	private int searchDest(Point start, Point destination, int[][] map) {
		LinkedList<Point> q = new LinkedList<Point>();
		start.cnt = 0;
		q.add(start);

		boolean[][] visited = new boolean[map.length][map.length];
		visited[start.x][start.y] = true;

		while (!q.isEmpty()) {
			Point now = q.poll();
			for (int i = 0; i < dr.length; i++) {
				int nx = now.x + dr[i];
				int ny = now.y + dc[i];
				if (nx < 1 || ny < 1 || nx >= map.length || ny >= map[nx].length || map[nx][ny] == 1 || visited[nx][ny])
					continue;
				visited[nx][ny] = true;
				if (nx == destination.x && ny == destination.y) {
					return now.cnt + 1;
				}
				q.add(new Point(nx, ny, now.cnt + 1));
			}
		}
		return Integer.MAX_VALUE;
	}

	static class Point implements Comparable<Point> {
		int x;
		int y;
		int cnt = 0;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		public Point(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Point o) {
			if (this.x == o.x)
				return this.y - o.y;
			return this.x - o.x;
		}
	}

	static class Taxi {
		int x;
		int y;
		int fuel;

		public Taxi(int x, int y, int fuel) {
			super();
			this.x = x;
			this.y = y;
			this.fuel = fuel;
		}
	}
}
