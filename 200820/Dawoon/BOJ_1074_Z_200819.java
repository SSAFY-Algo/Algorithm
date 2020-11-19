package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074_Z_200819 {

	static int N, R, C, ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		ans = 0;
		check(N, R, C);
		System.out.println(ans);
	}
	
	public static void check(int n, int r, int c) {
		if(n == 0) return;
		int max = squareTwo(n);
		int area = 0;
		if(max/2 > r && max/2 > c) {
			area = 0;
			ans += area * (max/2) * (max/2);
			check(n-1, r, c);
		}
		else if(max/2 > r && max/2 <= c) {
			area = 1;
			ans += area * (max/2) * (max/2);
			check(n-1, r , c- (max/2));
		}
		else if(max/2 <= r && max/2 > c) {
			area = 2;
			ans += area * (max/2) * (max/2);
			check(n-1, r- (max/2), c);
		}
		else { 
			area = 3;
			ans += area * (max/2) * (max/2);
			check(n-1, r - (max/2), c - (max/2));
		}
	}

	public static int squareTwo(int x) {
		int result = 1;
		for (int i = 0; i < x; i++) {
			result *= 2;
		}
		return result;
	}
}
