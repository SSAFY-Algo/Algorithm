package com.ssafy.newStudy2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ15683_감시 {

	public static class CCTV {
		int n, m, dir;

		public CCTV(int n, int m, int dir) {
			this.n = n;
			this.m = m;
			this.dir = dir;
		}
	}
	
	static int N, M, answer;
	static int[][] office;
	static ArrayList<CCTV> cctvList;
	static int[][] dir = { {-1,0}, {0,-1}, {1, 0}, {0,1} };	// 상 좌 하 우
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		office = new int[N][M];
		cctvList = new ArrayList<CCTV>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				office[i][j] = Integer.parseInt(st.nextToken());
				if(office[i][j] >= 1 && office[i][j] <= 5) {
					cctvList.add(new CCTV(i, j, office[i][j]));
				}
			}
		}

		answer = Integer.MAX_VALUE;
		boolean[][] check = new boolean[N][M];
		dfs(0, check);
		
		System.out.println(answer);
	}
	
	private static void dfs(int count, boolean[][] check) {

		if(count == cctvList.size()) {
			answer = Math.min(answer, getRoom(check));
			return;
		}
		
		CCTV cctv = cctvList.get(count);
		boolean[][] tmpCheck = new boolean[N][M];
		copy(tmpCheck, check);
		switch(cctv.dir){
			case 1 :
				for (int k = 0; k < 4; k++) {
					int nn = cctv.n + dir[k][0];
					int nm = cctv.m + dir[k][1];
					while(nn>=0 && nn<N && nm>=0 && nm<M && office[nn][nm] != 6) {
						tmpCheck[nn][nm] = true;
						nn += dir[k][0];
						nm += dir[k][1];
					}
					dfs(count+1, tmpCheck);
					copy(tmpCheck, check);
				}
				break;
			case 2 :
				for (int k = 0; k < 2; k++) {
					int nn, nm;
					for (int l = 0; l <=2 ; l+=2) {
						nn = cctv.n + dir[k+l][0];
						nm = cctv.m + dir[k+l][1];
						while(nn>=0 && nn<N && nm>=0 && nm<M && office[nn][nm] != 6) {
							tmpCheck[nn][nm] = true;
							nn += dir[k+l][0];
							nm += dir[k+l][1];
						}
					}					
					dfs(count+1, tmpCheck);
					copy(tmpCheck, check);
				}
				break;
			case 3 : 
				for (int k = 0; k <4; k++) {
					int nn, nm;
					for (int l = 0; l < 2; l++) {
						nn = cctv.n + dir[(k+l)%4][0];
						nm = cctv.m + dir[(k+l)%4][1];
						while(nn>=0 && nn<N && nm>=0 && nm<M && office[nn][nm] != 6) {
							tmpCheck[nn][nm] = true;
							nn += dir[(k+l)%4][0];
							nm += dir[(k+l)%4][1];
						}
					}
					
					dfs(count+1, tmpCheck);
					copy(tmpCheck, check);
				}
				break;
			case 4 :
				for (int k = 0; k < 4; k++) {
					
					int nn, nm;
					for (int l = 0; l < 3; l++) {
						nn = cctv.n + dir[(k+l)%4][0];
						nm = cctv.m + dir[(k+l)%4][1];
						while(nn>=0 && nn<N && nm>=0 && nm<M && office[nn][nm] != 6) {
							tmpCheck[nn][nm] = true;
							nn += dir[(k+l)%4][0];
							nm += dir[(k+l)%4][1];
						}
						
					}
					dfs(count+1, tmpCheck);
					copy(tmpCheck, check);
				}
				break;
			case 5 :
				for (int k = 0; k < 4; k++) {
					int nn = cctv.n + dir[k][0];
					int nm = cctv.m + dir[k][1];
					
					while(nn>=0 && nn<N && nm>=0 && nm<M && office[nn][nm] != 6) {
						tmpCheck[nn][nm] = true;
						nn += dir[k][0];
						nm += dir[k][1];
					}
				}
				dfs(count+1, tmpCheck);
				break;
			default : break;
		}
	}

	private static void copy(boolean[][] tmpCheck, boolean[][] check) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tmpCheck[i][j] = check[i][j];
			}
		}
	}

	private static int getRoom(boolean[][] check) {
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(check[i][j] == false && office[i][j] == 0)	count++;
			}
		}
		return count;
	}

}
