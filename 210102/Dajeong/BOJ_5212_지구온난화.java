package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5212_지구온난화 {

	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine(); 
			map[i] = str.toCharArray();
		}
		
		Queue<int[]> q = new LinkedList<>();
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				
				if(map[i][j] == 'X') {
					int cnt = 0;
					for (int k = 0; k < 4; k++) {
						int nr = i + dr[k];
						int nc = j + dc[k];
						
						if(nr < 0 || nc < 0 || nr > R-1 || nc > C-1) {
							cnt++;
							continue;
						}
						
						if(map[nr][nc] == '.') cnt++;
					}
					if(cnt >= 3) q.add(new int[] {i,j});
				}
				
			}
		}
		while(!q.isEmpty()) {
			int[] arr = q.poll();
			int r = arr[0];
			int c = arr[1];
			map[r][c] = '.';
		}
		
		int min_r = R-1;
		int min_c = C-1;
		int max_r = 0;
		int max_c = 0;
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == 'X') {
					min_r = Math.min(min_r, i);
					min_c = Math.min(min_c, j);
					max_r = Math.max(max_r, i);
					max_c = Math.max(max_c, j);
				}
			}
		}
		
		for (int i = min_r; i <= max_r; i++) {
			for (int j = min_c; j <= max_c; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}

	}

}
