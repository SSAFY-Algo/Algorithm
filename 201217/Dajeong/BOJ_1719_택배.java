package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1719_택배 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] matrix = new int[n+1][n+1];
		int[][] result = new int[n+1][n+1];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			matrix[x][y] = t;
			matrix[y][x] = t;
			
		}
		
		for (int start = 1; start <= n; start++) {
			boolean[] visited = new boolean[n+1];
			int[] distance = new int[n+1];
			
			Arrays.fill(distance, Integer.MAX_VALUE);
			distance[start] = 0;
			
			int min = 0;
			int current = 0; // 경유지
			
			for (int i = 1; i <= n; i++) {	//마지막 for문을 돌았을때의 current값은 출발지에서 가장 먼 경유지가 된다
				min = Integer.MAX_VALUE;
				
				for (int j = 1; j <= n; j++) {
					if(!visited[j] && min > distance[j]) {
						min = distance[j];
						current = j;
					}
				}
				
				visited[current] = true;
				
				for (int j = 1; j <= n; j++) {
					if(!visited[j] && matrix[current][j] != 0 && distance[j] > min + matrix[current][j]) {
						distance[j] = min + matrix[current][j];
						result[j][start] = current;	// start에서 j까지의 최소경로를 찾는다.
								// 가장 마지막 current값은 출발지로부터 가장 멀리 떨어진(도착점으로부터 가장 가까운)경유지가 된다
					}
				}
				
			}			
		}
		
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if(result[i][j] == 0) {
					System.out.print("- ");
				}
				else {
					System.out.print(result[i][j]+ " ");
				}
			}
			System.out.println();
		}
		
	}

}
