package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_4615_재미있는오셀로게임 {

	static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
	private static int N;
	private static int[][] map;
	private static boolean flag; 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			map = new int[N+1][N+1];
			
			// B:1, W:2
			map[N/2][N/2] = 2;
			map[N/2][N/2+1] = 1;
			map[N/2+1][N/2] = 1;
			map[N/2+1][N/2+1] = 2;
			
			Queue<int[]> q = new LinkedList<>();
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int color = Integer.parseInt(st.nextToken());
				
				map[r][c] = color;
				
				for (int k = 0; k < 8; k++) {
					int nr = r + dr[k];
					int nc = c + dc[k];
					
					flag = false;
					
					while(check(nr, nc, color)) {
						q.add(new int[] {nr, nc});
						nr += dr[k];
						nc += dc[k];
					}
					
					while(!q.isEmpty()) {
						int[] arr = q.poll();
						if(flag) {
							map[arr[0]][arr[1]] = color;
						}
					}
					
				}
				
			}
			
			int white = 0;
			int black = 0;
			
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(map[i][j] == 1) black++;
					if(map[i][j] == 2) white++;
				}
			}
			
			System.out.println("#"+tc+" "+black+" "+white);
		}
		
	}

	private static boolean check(int nr, int nc, int color) {
		if(nr >= 1 && nc >= 1 && nr <= N && nc <= N && map[nr][nc] == 3 - color ) return true;
		if(nr >= 1 && nc >= 1 && nr <= N && nc <= N && map[nr][nc] == color ) {
			flag = true;
			return false;
		}
		else return false;
	}

}
