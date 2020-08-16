package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와BFS_200816 {

	static int N, M, V;
	static int[][] map;
	static boolean[] visit;
	static LinkedList<Integer> q;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		visit = new boolean[N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			map[from][to] = 1;
			map[to][from] = 1;
		}
		
		dfs(V);
		System.out.println();
		
		visit = new boolean[N+1];
		q = new LinkedList<Integer>();
		q.offer(V);
		visit[V] = true;
		bfs(V);
	}
	
	
	
	public static void dfs(int v) {
		visit[v] = true;
		System.out.print(v + " ");
		for(int i = 1; i < N+1; i++) {
			if(map[v][i] == 1 && visit[i] == false) {
				dfs(i);
			}
		}
	}
	
	public static void bfs(int v) {
		while(!q.isEmpty()) {
			
			int now =  q.pop();
			
			System.out.print(now + " ");
			for(int i = 1; i < N+1; i++) {
				if(map[now][i] == 1 && visit[i] == false) {
					visit[i] = true;
					q.offer(i);
				}
			}
		}
	}
}
