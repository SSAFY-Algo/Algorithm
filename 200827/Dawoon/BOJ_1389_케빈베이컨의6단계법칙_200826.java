package com.ssafy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1389_케빈베이컨의6단계법칙_200826 {
	
	static int N, M, MIN, MIN_N;
	static int[][] map;
	static LinkedList<Point> q;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st  =new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			map[from][to] = map[to][from] = 1;
		}
		
		MIN = 5000000;
		MIN_N = 100;
		q = new LinkedList<Point>();
		for(int i = 1; i <= N; i++) {
			q.offer(new Point(i, 0));
			check(i);
		}
		System.out.println(MIN_N);
	}
	public static void check(int n) {
		visit = new boolean[N+1];
		visit[n] = true;
		int sum = 0;
		while(!q.isEmpty()) {
			Point now = q.poll();
			sum += now.cnt;
			for (int i = 0; i < map.length; i++) {
				if(map[now.x][i] == 1 && visit[i] == false) {
					visit[i] = true;
					q.offer(new Point(i, now.cnt+1));
				}
			}
		}
		if(MIN > sum) {
			MIN = sum;
			MIN_N = n;
		}else if(MIN == sum) {
			if(MIN_N > n)
				MIN_N = n;
		}
	}
	static class Point{
		int x;
		int cnt;
		public Point(int x, int cnt) {
			super();
			this.x = x;
			this.cnt = cnt;
		}
		
		
	}

}
