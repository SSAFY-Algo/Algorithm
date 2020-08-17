package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와BFS {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(tk.nextToken());	// 정점의 개수
		int M = Integer.parseInt(tk.nextToken());	// 간선의 개수
		int S = Integer.parseInt(tk.nextToken());	// 시작 정점
		int[][] map = new int[N+1][N+1];
		boolean[] visited = new boolean[N+1];
		
		// 간선을 보고 그래프 만들기
		for(int i=0; i<M; i++) {
			tk = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(tk.nextToken());
			int b = Integer.parseInt(tk.nextToken());
			
			map[a][b] = map[b][a] = 1;
			
		}
		
		dfs(map, visited, S);
		System.out.println();
		visited = new boolean[N+1];
		bfs(map, visited, S);
		
		
		// 인접 행렬 확인
//		for(int j=1; j<N+1; j++) {
//			for(int k=1; k<N+1; k++) {
//				System.out.print(map[j][k]);
//			}
//			System.out.println();
//		}
		
	}

	private static void dfs(int[][] map, boolean[] visited, int v) {
		int n = map.length-1;
		visited[v] = true;
		System.out.print(v+" ");
		
		for(int i=1; i<=n; i++) {
			if(map[v][i]==1 && !visited[i]) {
				dfs(map, visited, i);
			}
		}
	}
	
	private static void bfs(int[][] map, boolean[] visited, int s) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		visited[s]=true;

		while(!q.isEmpty()) {
			int v = q.poll();
			System.out.print(v+ " ");
			
			for(int i=1; i<map.length; i++) {
				if(!visited[i] && map[v][i]==1) {
					visited[i]=true;
					q.add(i);
				}
			}
		}
		
	}
}
