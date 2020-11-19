package com.ssafy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_14502_연구소_200818 {

	static int N, M, ans;
	static int[][] map;
	static boolean[][] visit;
	static Point[] comb = new Point[3];
	static LinkedList<Point> q = new LinkedList<Point>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					visit[i][j] = true;
					q.offer(new Point(i, j, 2));
				}
			}
		}
		combination(0, 0, 0);
		System.out.println(ans);
	}

	public static void combination(int x, int y, int cnt) {
		if( cnt == 3) {
			spread();
			return;
		}
		for (int i = x; i < x+1; i++) {
			for (int j = y; j < M; j++) {
				if(map[i][j] == 0 && visit[i][j] == false) {
					visit[i][j] = true;
					comb[cnt] = new Point(i, j, 0);
					combination(i, j, cnt+1);
					visit[i][j] = false;
				}
			}
		}
		
		for (int i = x+1; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0 && visit[i][j] == false) {
					visit[i][j] = true;
					comb[cnt] = new Point(i, j, 0);
					combination(i, j, cnt+1);
					visit[i][j] = false;
				}
			}
		}
		if(y == M-1 && x == N-1) return;
	}
	
	public static void spread() {
		int[][] mMap = mapCopy(map);
		mMap[comb[0].x][comb[0].y] = mMap[comb[1].x][comb[1].y] 
				= mMap[comb[2].x][comb[2].y] = 1; 
		bfs(mMap);
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void bfs(int[][] m) {
		LinkedList<Point> mQ = qCopy(q);
		boolean[][] mVisit = visitCopy(visit);
		while(!mQ.isEmpty()) {
			Point now = mQ.pop();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dr[i];
				int ny = now.y + dc[i];
				if(nx <0 || ny < 0 || nx >= N || ny >= M) continue;
				if(m[nx][ny] == 0 && mVisit[nx][ny] == false) {
					mVisit[nx][ny] = true;
					mQ.offer(new Point(nx, ny, 0));
					m[nx][ny] = 2;
				}
			}
		}
		check(m);
	}
	
	public static void check(int[][] m) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(m[i][j] == 0) 
					cnt++;
			}
		}
		if(ans < cnt)
			ans = cnt;
	}
	
	private static int[][] mapCopy(int[][] arr) {
        int[][] result = new int[arr.length][arr[0].length];
         
        for(int i=0; i<arr.length; i++){
            System.arraycopy(arr[i], 0, result[i], 0, arr[0].length);
        }
         
        return result;
    }
	
	private static boolean[][] visitCopy(boolean[][] arr) {
		boolean[][] result = new boolean[arr.length][arr[0].length];
         
        for(int i=0; i<arr.length; i++){
            System.arraycopy(arr[i], 0, result[i], 0, arr[0].length);
        }
         
        return result;
    }
	
	private static LinkedList<Point> qCopy(LinkedList<Point> q) {
		LinkedList<Point> result = new LinkedList<Point>();
         
        for(int i=0; i<q.size(); i++){
           result.add(new Point(q.get(i)));
        }
         
        return result;
    }

	static class Point {
		int x;
		int y;
		int weight;

		public Point(int x, int y, int weigth) {
			this.x = x;
			this.y = y;
			this.weight = weigth;
		}
		
		public Point(Point p) {
			this.x = p.x;
			this.y = p.y;
			this.weight = p.weight;
		}
	}
}
