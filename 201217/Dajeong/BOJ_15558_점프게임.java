package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_15558_점프게임 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] map = new int[2][N];
		boolean[][] visited = new boolean[2][N];
		
		for (int i = 0; i < 2; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0, 0, 0});
		
		boolean flag = false;
		
		while(!q.isEmpty() && !flag) {
			int[] arr = q.poll();
			int x = arr[0];
			int y = arr[1];
			int step = arr[2];
			
			if(step >= N) break;
			
			int[] dx = {x, x, Math.abs(x-1)};
			int[] dy = {y+1, y-1, y+k};

			for(int d=0; d<3; d++) {
				int nx = dx[d];
				int ny = dy[d];
				
				if(ny > N-1) {
					flag = true;
				}
				
				if(nx < 0 || nx > 1 || ny <= step || ny > N-1) continue;
				if(map[nx][ny] == 1 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					q.add(new int[] {nx, ny, step+1});
				}
					
				
			}
			
			
			
		}
		
		if(flag == true) System.out.println("1");
		else System.out.println("0");
		
		
	}

}
