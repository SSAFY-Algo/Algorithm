package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_10026_적록색약 {

	private static char[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	private static int N;
	
	static class Point {
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			map[i] = str.toCharArray();
		}
		
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					bfs(i, j);
					cnt++;
				}
			}
		}
		
		visited = new boolean[N][N];
		int cnt2 = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					bfs2(i, j);
					cnt2++;
				}
			}
		}
		
		System.out.println(cnt + " " + cnt2);
		
	}

	private static void bfs(int x, int y) {
		visited[x][y] = true;
		
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for(int k=0; k<4; k++) {
				int nx = p.x + dx[k];
				int ny = p.y + dy[k];
				
				if(nx < 0 || ny < 0 || nx > N-1 || ny > N-1) continue;
				if(visited[nx][ny] == false && map[nx][ny] == map[x][y]) {
					visited[nx][ny] = true;
					q.add(new Point(nx, ny));
				}
			}
			
		}

	}
	
	
	private static void bfs2(int x, int y) {
		visited[x][y] = true;
		
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for(int k=0; k<4; k++) {
				int nx = p.x + dx[k];
				int ny = p.y + dy[k];
				
				if(nx < 0 || ny < 0 || nx > N-1 || ny > N-1) continue;
				if(visited[nx][ny] == false ) {
					if(map[nx][ny] == map[x][y] || (map[x][y] == 'R' && map[nx][ny] == 'G') || (map[x][y] == 'G' && map[nx][ny] == 'R')){
					visited[nx][ny] = true;
					q.add(new Point(nx, ny));
					}
				}
			
			}

		}
	}

}
