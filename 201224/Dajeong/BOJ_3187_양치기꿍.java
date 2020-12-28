package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3187_양치기꿍 {

	private static int R, C, v, k;
	private static char[][] map;
	
	// 상 하 좌 우
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static boolean[][] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			map[i] = str.toCharArray();
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(!visited[i][j] && (map[i][j] == 'v' || map[i][j] == 'k')) {
					bfs(i, j);
				}
			}
		}
		
		System.out.println(k + " " + v);
	}

	private static void bfs(int i, int j) {
		int vCnt = 0;
		int kCnt = 0;
		
		if(map[i][j] == 'v')
			vCnt++;
		if(map[i][j] == 'k')
			kCnt++;
		
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {i,j});
		visited[i][j] = true;
		
		while(!q.isEmpty()) {
			int[] arr = q.poll();
			int r = arr[0];
			int c = arr[1];
			
			for (int k = 0; k < 4; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				
				if(nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nr][nc] && map[nr][nc] != '#') {
					if(map[nr][nc] == 'v')
						vCnt++;
					if(map[nr][nc] == 'k')
						kCnt++;
					visited[nr][nc] = true;
					q.add(new int[] {nr,nc});
				}
			}
		}
		
		if(kCnt > vCnt) {
			k += kCnt;
		}else {
			v += vCnt;
		}
			
	}

}
