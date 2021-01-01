package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5904_Moo게임_201229 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] mooLen = new int[32];

		int index = calMoolen(mooLen, N);
		
		System.out.println(dfs(index, N, mooLen));
	}

	private static String dfs(int index, int n, int[] mooLen) {
		if(index == 0) {
			if(n == 1)
				return "m";
			else
				return "o";
		}
		
		if(mooLen[index-1] >= n)
			return dfs(index-1, n, mooLen);
		else if(mooLen[index-1] + index + 3 >= n) {
			if(n == mooLen[index-1] + 1)
				return "m";
			else
				return "o";
		}else {
			return dfs(index-1, n-(mooLen[index-1] + index + 3), mooLen);
		}
		
	}

	private static int calMoolen(int[] mooLen, int n) {
		mooLen[0] = 3;
		for (int i = 1; i < mooLen.length; i++) {
			mooLen[i] = mooLen[i - 1] * 2 + (i + 3);
			if(mooLen[i] > n)
				return i;
		}
		return mooLen.length;
	}

}
