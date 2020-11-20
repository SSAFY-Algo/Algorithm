package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와BFS_200816 {

	static int N, M, V;
	static int[][] map;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for(int i=0; i<M; i++) {
			StringTokenizer ST = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(ST.nextToken());
			int B = Integer.parseInt(ST.nextToken());
			
			map[A][B] = 1;
			map[B][A] = 1;
		}
		
		
		dfs(V);
		System.out.println();
		Arrays.fill(visited, false);
		bfs(V);

	}
	
	static void dfs(int v) {
		visited[v] = true;
		System.out.print(v + " ");
		
		for(int i=1; i<N+1; i++) {
			if(map[v][i] == 1 && visited[i] == false) {
				dfs(i);
			}
		}
	}
	
	static void bfs(int v) {
		Queue<Integer> q = new LinkedList<Integer>();
		visited[v] = true;
		
		q.add(v);
		
		while(!q.isEmpty()) {
			v = q.poll();
			System.out.print(v + " ");
			
			for(int i=1; i<N+1; i++) {
				if(map[v][i] == 1 && visited[i] == false) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
		
		
		
	}
	
}
