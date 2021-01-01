package com.ssafy.newStudy4;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ3187_양치기꿍 {

	static int R, C, wolfCount, sheepCount;
	static char[][] map;
	static int[][] dir = { {0,-1}, {0,1}, {-1,0}, {1,0} };
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			map[i] = str.toCharArray();
		}
		
		boolean[][] visit = new boolean[R][C];
		
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] != '#' && !visit[i][j]) {
					bfs(i, j, visit);
				}
			}
		}
		
		System.out.println(sheepCount + " " + wolfCount);
	}
	
	private static void bfs(int r, int c, boolean[][] visit) {
		
		int wolf = 0;
		int sheep = 0;
		
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(r, c));
		visit[r][c] = true;
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			
			if(map[now.x][now.y] == 'v')	wolf++;
			if(map[now.x][now.y] == 'k')	sheep++;
			
			for (int k = 0; k < 4; k++) {
				int nr = now.x + dir[k][0];
				int nc = now.y + dir[k][1];
				
				if(nr<0 || nr>=R || nc<0 || nc>=C) return;

				if(map[nr][nc] != '#' && !visit[nr][nc]) {
					visit[nr][nc] = true;
					q.add(new Point(nr, nc));
				}				
			}
		}
		
		// wolf와 sheep 비교
		if(wolf < sheep) sheepCount += sheep;
		else wolfCount += wolf;
	}

}
