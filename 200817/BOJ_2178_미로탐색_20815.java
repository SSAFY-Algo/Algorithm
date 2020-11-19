package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178_�̷�Ž��_20815 {
	
	static int N,M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static class Node{
		int x;
		int y;
		public Node(int x, int y) {
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
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j) -'0';
			}
		}
		
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(0,0));
		visited[0][0] = true;
		while(!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.poll().y;
			
			if(x == N-1 && y == M-1)
				break;
			for(int k=0; k<4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				
				if(nx < 0 || ny < 0 || nx > N-1 || ny > M-1) continue;
				if(map[nx][ny] == 1 && visited[nx][ny] == false) {
					visited[nx][ny] = true;
					map[nx][ny] = map[x][y] + 1;
					q.add(new Node(nx, ny));
				}
				
				
			}
			
		}
		
		System.out.println(map[N-1][M-1]);
		
		
		
		
	}

}
