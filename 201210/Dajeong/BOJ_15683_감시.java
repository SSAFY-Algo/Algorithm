package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_15683_감시 {

	private static int N, M;
	static int answer = Integer.MAX_VALUE;
	static int[][] map;
	private static ArrayList<Point> list;
	static Stack<int[]> st = new Stack<>();
	
	// 상 하 좌 우
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	
	static int cctv[][][] = {
			{{0}, {1}, {2}, {3}},
			{{0,1}, {2,3}},
			{{0,3}, {0,2}, {1,2}, {1,3}},
			{{0,1,2}, {0,1,3}, {0,2,3}, {1,2,3}},
			{{0,1,2,3}}
	};
	
	static class Point {
		int type;
		int x;
		int y;
		
		public Point(int type, int x, int y) {
			this.type = type;
			this.x = x;
			this.y = y;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		list = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] >= 1 && map[i][j] <= 5) 
					list.add(new Point(map[i][j], i, j));
			}
		}
		
		dfs(0);
		
		System.out.println(answer);
		

	}
	private static void dfs(int cnt) {
		if(cnt == list.size()) {
			answer = Math.min(answer, count(map));
			return;
		}
		
		int x = list.get(cnt).x;
		int y = list.get(cnt).y;
		int type = list.get(cnt).type-1;
		
		for(int i=0; i<cctv[type].length; i++) {
			int st_cnt = 0;
			for(int j=0; j<cctv[type][i].length; j++) {
				int dir = cctv[type][i][j];
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				
				while(nx>=0 && ny>=0 && nx<N && ny<M && map[nx][ny] != 6 ) {
					if(map[nx][ny] == 0) {
						st_cnt++;
						st.add(new int[] {nx,ny});
						map[nx][ny] = 7;
					}
					nx += dx[dir];
					ny += dy[dir];
				}
			}
			
			dfs(cnt+1);
			re(st_cnt);
		}
		
		
	}
	private static void re(int st_cnt) {
		for(int i=0; i<st_cnt; i++) {
			int[] p = st.pop();
			map[p[0]][p[1]] = 0;
		}
		
	}
	private static int count(int[][] map) {
		int count = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 0) count++;
			}
		}
		return count;
	}
	

}
