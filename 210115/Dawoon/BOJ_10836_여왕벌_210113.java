package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10836_여왕벌_210113 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		BOJ_10836_여왕벌_210113 Algo = new BOJ_10836_여왕벌_210113();

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		
		
		int[] line = new int[M * 2 - 1];
		
		int[] growList = new int[3];
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			growList[0] = Integer.parseInt(st.nextToken());
			growList[1] = Integer.parseInt(st.nextToken());
			growList[2] = Integer.parseInt(st.nextToken());

			for (int i = growList[0]; i < growList[0] + growList[1]; i++) {
				line[i]++;
			}

			for (int i = growList[0] + growList[1]; i < 2 * M - 1; i++) {
				line[i] += 2;
			}
		}

		Algo.print(line, M);

	}

	private void print(int[] line, int M) {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				if (j == 0)
					System.out.print(line[M - i - 1] + 1 + " ");
				else
					System.out.print(line[M + j - 1] + 1 + " ");
			}
			System.out.println();
		}

	}
}
