package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2503_숫자야구 {

	static int[][] gameNum;
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());

		gameNum = new int[N][5];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			char[] num = st.nextToken().toCharArray();
			for (int j = 0; j < num.length; j++) {
				gameNum[i][j] = num[j] - '0';
			}
			gameNum[i][3] = Integer.parseInt(st.nextToken());
			gameNum[i][4] = Integer.parseInt(st.nextToken());
		}
		
		int[] comb = new int[3];
		for (int i = 1; i < 10; i++) {
			boolean[] visit = new boolean[10];
			comb[0] = i;
			visit[i] = true;
			dfs(comb, 1, visit);
		}
		System.out.println(ans);
	}

	private static void dfs(int[] comb, int cnt, boolean[] visit) {
		if(cnt == 3) {
			for (int i = 0; i < gameNum.length; i++) {
				int strike = 0;
				int ball = 0;
				for (int j = 0; j < 3; j++) {
					for (int k = 0; k < comb.length; k++) {
						if(gameNum[i][j] == comb[k] && j == k)
							strike++;
						else if(gameNum[i][j] == comb[k] && j != k)
							ball++;
					}
				}
				if(strike != gameNum[i][3] || ball != gameNum[i][4])
					return;
			}
			ans++;
			return;
		}
		
		for (int i = 1; i < 10; i++) {
			if(visit[i] == false) {
				visit[i] = true;
				comb[cnt] = i;
				dfs(comb, cnt+1, visit);
				visit[i] = false;
			}
		}
	}

}
