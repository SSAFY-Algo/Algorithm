package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1439_뒤집기_210105 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		
		int cnt = 0;
		char now = S.charAt(0);
		for (int i = 1; i < S.length(); i++) {
			if(now != S.charAt(i)) {
				cnt++;
				now = S.charAt(i);
			}
		}
		System.out.println((cnt+1)/2);
	}

}
