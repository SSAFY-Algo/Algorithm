package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_6808_규영이와인영이의카드게임_201118 {

	static int[] INYOUNG = new int[9];
	static int winCnt, loseCnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			boolean[] visit = new boolean[19];
			int[] GYUYOUNG = new int[9];
			for (int i = 0; i < 9; i++) {
				GYUYOUNG[i] = Integer.parseInt(st.nextToken());
				visit[GYUYOUNG[i]] = true;
			}
			
			winCnt = 0;
			loseCnt = 0;
			for (int i = 1; i < visit.length; i++) {
				if(visit[i] == false) {
					visit[i] = true;
					dfs(i, 0, visit, GYUYOUNG);
					visit[i] = false;
				}
			}
			
			System.out.println("#" + tc + " " + winCnt + " " + loseCnt);
		}
	}

	private static void dfs(int n, int index, boolean[] visit, int[] GYUYOUNG) {
		INYOUNG[index] = n;
		if(index == 8) {
			int gv = 0, iv = 0;
			for (int i = 0; i < GYUYOUNG.length; i++) {
				if(GYUYOUNG[i] > INYOUNG[i])
					gv += GYUYOUNG[i] + INYOUNG[i];
				else if(GYUYOUNG[i] < INYOUNG[i])
					iv += GYUYOUNG[i] + INYOUNG[i];
			}
			if(gv > iv)
				winCnt++;
			else if(iv > gv)
				loseCnt++;
			
			return;
		}
		
		for (int i = 1; i < visit.length; i++) {
			if(visit[i] == false) {
				visit[i] = true;
				dfs(i, index+1, visit, GYUYOUNG);
				visit[i] = false;
			}
		}
	}
}
