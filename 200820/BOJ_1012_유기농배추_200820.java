package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Baechoo {
	int x, y;

	public Baechoo(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BOJ_1012_유기농배추 {
	
	static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
	static int[] dy = {0, 0, -1, 1};
	static int col, row, count, baecho_num;
	static int[][] map;
 	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(bf.readLine());
		
		int T = Integer.parseInt(tk.nextToken());
		
		for(int tc=0; tc<T; tc++) {
			tk = new StringTokenizer(bf.readLine());
			col = Integer.parseInt(tk.nextToken());
			row = Integer.parseInt(tk.nextToken());
			baecho_num = Integer.parseInt(tk.nextToken());
			map = new int[row][col];
			count = 0;
			
 			// 배추 심은 자리에 1 setting
			for(int bc=0; bc<baecho_num; bc++) {
				tk = new StringTokenizer(bf.readLine());
				int y = Integer.parseInt(tk.nextToken());
				int x = Integer.parseInt(tk.nextToken());
				
				map[x][y]=1;
			}
			
			for(int i=0; i<row; i++) {
				for(int j=0; j<col; j++) {
					if(map[i][j]==1) {
						count++;
						bfs(i, j);
					}
				}
			}
			System.out.println(count);
		}
	}
	
	static void bfs(int a, int b) {
		Queue<Baechoo> q = new LinkedList<Baechoo>();
		q.add(new Baechoo(a, b));
		map[a][b]=0;
		
		while(!q.isEmpty()) {
			Baechoo bc = q.poll();
			int x = bc.x;
			int y = bc.y;
			
			for(int k=0; k<4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				
				if(nx<0 || nx>=row || ny<0 || ny>=col || map[nx][ny]==0) continue;
				else {
					q.add(new Baechoo(nx, ny));
					map[nx][ny]=0;
				}
			}
		}
		
	}
}
