package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2112_보호필름_201121 {

	static int D, W, K, ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[D][W];
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			ans = 0;
			if(K == 1) {
				System.out.println("#" + (tc+1) + " " + ans);
				continue;
			}
			
			for (int i = 0; i <= K; i++) {
				boolean[] visit = new boolean[D];
				int[][] comb = new int[i][2];
				if(combination(i, 0, visit, comb, map))
					break;
			}
			
			System.out.println("#" + (tc+1) + " " + ans);
		}
	}


	private static boolean combination(int n, int index, boolean[] visit, int[][] comb, int[][] map) {
		if(index == n) {
			if(check(visit, comb, map)) {
				ans = n;
				return true;
			}
			return false;
		}
		int k = 0;
		if(index > 0)
			k = comb[index-1][0];
		for (int i = k; i < D; i++) {
			if(!visit[i]) {
				visit[i]= true;
				comb[index][0] = i;
				comb[index][1] = 0;
				if(combination(n, index+1, visit, comb, map))
					return true;
				comb[index][1] = 1;
				if(combination(n, index+1, visit, comb, map))
					return true;
				visit[i] = false;
			}
		}
		return false;
	}

	private static boolean check(boolean[] visit, int[][] comb, int[][] map) {
		int cnt = 1;
		OUTER: for (int i = 0; i < map[0].length; i++) {
			int now = map[0][i];
			if(comb.length >0 && comb[0][0] == 0)
				now = comb[0][1];
			cnt = 1;
			for (int j = 1; j < map.length; j++) {
				boolean isCheck = false;
				for (int l = 0; l < comb.length; l++) {
					if(j == comb[l][0]) {
						isCheck = true;
						if(now == comb[l][1]) {
							cnt++;
							if(cnt == K)
								continue OUTER;
						}else {
							now = comb[l][1];
							cnt = 1;
						}
						break;
					}
				}
				if(!isCheck) {
					if(now == map[j][i]) {
						cnt++;
						if(cnt == K)
							continue OUTER;
					}else {
						now = map[j][i];
						cnt = 1;
					}
				}
			}
			return false;
		}
	if(cnt != K)
		return false;
	return true;
	}

}
