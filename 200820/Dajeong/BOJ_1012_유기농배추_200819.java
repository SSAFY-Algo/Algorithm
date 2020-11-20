package com.ssafy;
import java.util.Scanner;
public class BOJ_1012_유기농배추_200819 {

	static int N, M, K, cnt;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i=0; i<T; i++) {
			M = sc.nextInt();
			N = sc.nextInt();
			K = sc.nextInt();
			
			map = new int[M][N];
			visited = new boolean[M][N];
			for(int j=0; j<K; j++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				map[a][b] = 1;
			}
			

			cnt = 0;
			for(int a=0; a<M; a++) {
				for(int b=0; b<N; b++) {
					if(map[a][b] == 1 && visited[a][b] == false) {
						dfs(a,b);
						cnt++;
					}
				}
			}
		
			System.out.println(cnt);
		}

	}
	
	static void dfs(int a, int b) {
		visited[a][b] = true;
		
		for(int k=0; k<4; k++) {
			int x = a + dx[k];
			int y = b + dy[k];
			
			if(x >= 0 && y >= 0 && x < M && y < N) {
				if(map[x][y] == 1 && visited[x][y] == false) {
					visited[x][y] = true;
					dfs(x,y);
				}
			}
		}
	}

}
