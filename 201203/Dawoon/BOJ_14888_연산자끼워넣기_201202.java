package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888_연산자끼워넣기_201202 {

	static int N, max, min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		int[] num = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < num.length; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		int[] operation = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < operation.length; i++) {
			operation[i] = Integer.parseInt(st.nextToken());
		}
		
		play(num, operation, num[0], 1);
		System.out.println(max);
		System.out.println(min);
	}

	private static void play(int[] num, int[] operation, int sum, int cnt) {
		if(cnt == N) {
			if(sum > max)
				max = sum;
			if(sum < min)
				min = sum;
			return;
		}
		for (int i = 0; i < operation.length; i++) {
			if(operation[i] > 0) {
				operation[i] -= 1;
				switch (i) {
				case 0:
					play(num, operation, sum+num[cnt], cnt+1);
					break;
				case 1:
					play(num, operation, sum-num[cnt], cnt+1);
					break;
				case 2:
					play(num, operation, sum*num[cnt], cnt+1);
					break;
				case 3:
					play(num, operation, sum/num[cnt], cnt+1);
					break;
				}
				operation[i] += 1;
			}
		}
	}

}
