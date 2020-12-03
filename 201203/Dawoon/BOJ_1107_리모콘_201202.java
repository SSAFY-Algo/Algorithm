package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1107_리모콘_201202 {

	static int N, M, now;
	static int[] remote = new int[10];
	static int[] visit;
	static int[] comb = new int[6];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		if(M == 0) {
			if(Math.abs(N-100)>String.valueOf(N).length())
				System.out.println(String.valueOf(N).length());
			else
				System.out.println(Math.abs(N-100));
			return;
		}
		// 고장난거 1 아닌거 0
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			remote[Integer.parseInt(st.nextToken())] = 1;
		}
		now = 100;
		if (Math.abs(N - now) < String.valueOf(N).length()) {
			System.out.println(Math.abs(N - now));
			return;
		}

		int now = N;
		int move = 0;
		int min = 500000;
		while(true) {
			if(now < 0) break;
			if(!check(now)) {
				min = String.valueOf(now).length()+move;
				break;
			}else {
				move++;
				now--;
			}
		}
		now = N;
		move = 0;
		while(true) {
			if(now >1000000 || !check(now)) {
				if(min > String.valueOf(now).length()+move)
					min = String.valueOf(now).length()+move;
				break;
			}else {
				move++;
				now++;
			}
		}
		if(Math.abs(N-100) > min)
			System.out.println(min);
		else
			System.out.println(Math.abs(N-100));
	}

	public static boolean check(int n) {
		for(int i = 0; i < 10; i++) {
			if(remote[i] == 0) continue;
			if(String.valueOf(n).contains(String.valueOf(i))) {
				return true;
			}
		}
		return false;
	}

}
