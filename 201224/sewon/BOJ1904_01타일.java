package com.ssafy.newStudy4;

import java.util.Scanner;

public class BOJ1904_01타일 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] D = new int[N+1];
		
		D[0] = 1;
		D[1] = 1;
		for (int i = 2; i <=N; i++) {
			D[i] = (D[i-1] + D[i-2])%15746;
		}
		System.out.println(D[N]);
		sc.close();
	}

}
