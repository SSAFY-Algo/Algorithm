package com.ssafy.newStudy2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ10026_적록색약 {

	static int N;
	static char[][] grid;
	static int[][] visit, weakVisit;
	static int[][] dir = { {-1,0}, {1,0}, {0, -1}, {0,1} };
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		grid = new char[N][N];
		visit = new int[N][N];
		weakVisit = new int[N][N];
		for (int i = 0; i < N; i++) {
			grid[i] = br.readLine().toCharArray();
		}
		
		int count = 1;
		int weakCount = 1;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(visit[i][j] == 0) {
					BFS(i, j, count++, grid[i][j]);
				}
				
				if(weakVisit[i][j] == 0) {
					weakBFS(i, j, weakCount++, grid[i][j]);
				}
			}
		}
		
		System.out.println(--count + " " + --weakCount);
	}
	
	private static void weakBFS(int i, int j, int count, char color) {
		for (int k = 0; k < 4; k++) {
			int ni = i + dir[k][0];
			int nj = j + dir[k][1];
			
			if(ni >= 0 && ni < N && nj >=0 && nj < N && weakVisit[ni][nj] == 0) {
				if(color == 'B' && grid[ni][nj] == color) {
					weakVisit[ni][nj] = count;
					weakBFS(ni, nj, count, color);
				}
				else if((color == 'R' || color == 'G' ) && (grid[ni][nj] == 'R' || grid[ni][nj] == 'G')) {
					weakVisit[ni][nj] = count;
					weakBFS(ni, nj, count, color);
				}
			}
		}
	}

	private static void BFS(int i, int j, int count, char color) {
		for (int k = 0; k < 4; k++) {
			int ni = i + dir[k][0];
			int nj = j + dir[k][1];
			
			if(ni >= 0 && ni < N && nj >=0 && nj < N && visit[ni][nj] == 0 && grid[ni][nj] == color) {
				visit[ni][nj] = count;
				BFS(ni, nj, count, color);
			}
		}
	}

}
