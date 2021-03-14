package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1859_백만장자프로젝트 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] list = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				list[i] = Integer.parseInt(st.nextToken());
			}

			long ans = 0;
			int max = list[N - 1];
			for (int i = N - 2; i >= 0; i--) {
				if (list[i] > max)
					max = list[i];
				else
					ans += max - list[i];
			}
			System.out.println("#" + tc + " " + ans);
		}

	}

}
