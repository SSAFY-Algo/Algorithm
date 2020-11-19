package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502_연구소_200819 {

	static int N, M;
	static int max = 0;
	static int[][] map, newMap;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static ArrayList<Point> list = new ArrayList<Point>();
	static class Point {
		int x;
		int y;
		
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			StringTokenizer ST = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(ST.nextToken());
				if(map[i][j] == 2)
					list.add(new Point(i,j));
			}
		}
		
		
		wall(0);
		System.out.println(max);
	}
	
	static int[][] copy(int[][] arr){
		int[][] result = new int[arr.length][arr[0].length];
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				result[i][j] = arr[i][j];
			}
		}
		
		return result;
	}
	
	static void wall(int cnt) {
		if(cnt == 3) {
			bfs();
			return;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					wall(cnt+1);
					map[i][j] = 0;
				}
			}
		}
		
	}
	
	static void bfs() {
		Queue<Point> q = new LinkedList<Point>();
		for(int i=0; i<list.size(); i++) {
			q.add(list.get(i));
		}
		
		newMap = copy(map);
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for(int k=0; k<4; k++) {
				int nx = p.x + dx[k];
				int ny = p.y + dy[k];
				
				
				if(nx < 0 || ny < 0 || nx > N-1 || ny > M-1) continue;
				if(newMap[nx][ny] == 0) {
					newMap[nx][ny] = 2;
					q.add(new Point(nx,ny));
				}
			}
		}
		
		int count = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(newMap[i][j] == 0)
					count++;
			}
		}
		
		max = (count > max)?count:max;
	}
	
	
}
