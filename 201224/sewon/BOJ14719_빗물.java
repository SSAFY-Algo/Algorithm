package com.ssafy.newStudy4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14719_빗물 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[] map = new int[W];
		int sum = 0;
		
		st = new StringTokenizer(br.readLine(), " ");
		int maxIndex = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < W; i++) {
			map[i] = Integer.parseInt(st.nextToken());
			if(map[i] > max) {
				max = map[i];
				maxIndex = i;
			}
		}
		
		// 왼쪽
		max = Integer.MIN_VALUE;
		for (int i = 0; i < maxIndex; i++) {
			if(map[i] > max) {
				max = map[i];
			}
			else {
				sum += max - map[i];
			}
		}
		
		// 오른쪽
		max = Integer.MIN_VALUE;
		for (int i = W-1; i > maxIndex; i--) {
			if(map[i] > max) {
				max = map[i];
			}
			else {
				sum += max - map[i];
			}
		}
		
		System.out.println(sum);
	}

}
