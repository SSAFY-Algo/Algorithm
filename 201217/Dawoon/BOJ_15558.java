package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_15558 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		char[][] road = new char[2][];
		road[0] = br.readLine().toCharArray();
		road[1] = br.readLine().toCharArray();
		
		boolean[][] visited = new boolean[2][N];
		LinkedList<Point> q = new LinkedList<Point>();
		q.offer(new Point(0, 0, 0));
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			if(now.cnt > now.index) continue;
			int nl = now.line;
			int ni = now.index;
			if(ni+K >= road[nl].length) {
				System.out.println(1);
				return;
			}
			if(ni+1 < road[nl].length && road[nl][ni+1] == '1' && !visited[nl][ni+1]) {
				q.offer(new Point(nl, ni+1, now.cnt+1));
				visited[nl][ni+1] = true;
			}
			if(ni-1 >= 0 && road[nl][ni-1] == '1' && !visited[nl][ni-1]) {
				q.offer(new Point(nl, ni-1, now.cnt+1));
				visited[nl][ni-1] = true;
			}
			if(ni+K < road[nl].length && road[-(nl-1)][ni+K] == '1' && !visited[-(nl-1)][ni+K]) {
				q.offer(new Point(-(nl-1), ni+K, now.cnt+1));
				visited[-(nl-1)][ni+K] = true;
			}
		}
		System.out.println(0);
	}
	
	static class Point{
		int line;
		int index;
		int cnt;
		Point(int line, int index, int cnt) {
			this.line = line;
			this.index = index;
			this.cnt = cnt;
		}
	}
}
