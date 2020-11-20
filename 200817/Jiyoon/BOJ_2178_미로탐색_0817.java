package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Miro {
	int x, y, cnt;

	public Miro(int x, int y, int cnt) {
		super();
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
	
}

public class BOJ_2178_미로탐색 {
	
	static int[] dx = {-1, 1, 0, 0};	// 상 하 좌 우
	static int[] dy = {0, 0, -1, 1};
	static int[][] map;
	static boolean[][] visited;
	static int M, N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(tk.nextToken());
		M = Integer.parseInt(tk.nextToken());
		
		// map 만들기
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String str = bf.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		
		dfs(0, 0, 0);
		
	}
	
	static void dfs(int x, int y, int cnt) {
		Queue<Miro> q = new LinkedList<Miro>();
		visited[x][y]= true;
		q.add(new Miro(x, y, cnt+1));
		
		while(!q.isEmpty()) {
			// q가 빌때까지
			Miro m = q.poll();	// 이부분 헷갈려
			
			if(m.x == N-1 && m.y == M-1) { 
				System.out.println(m.cnt); 
				break;
			}
			
			int mx = m.x;
			int my = m.y;
						
			for(int k=0; k<4; k++) {
				int nx = mx + dx[k];
				int ny = my + dy[k];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny]==0 || visited[nx][ny]==true) {
					continue;
				} else {
					visited[nx][ny] = true;
					q.add(new Miro(nx, ny, m.cnt+1));
				}
				
			}
		}
	}
}
