package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1543_문서검색_210119 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String compare_s = br.readLine();
		int cnt = 0;
		while (true) {
			int index = S.indexOf(compare_s);
			if (index == -1)
				break;
			S = S.substring(index + compare_s.length());
			cnt++;
		}

		System.out.println(cnt);
	}
}
