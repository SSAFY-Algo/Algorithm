package com.ssafy.newStudy1;

import java.util.Scanner;

public class BOJ2156_포도주 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] wine = new int[n+1];
		for (int i = 1; i <= n; i++) {
			wine[i] = sc.nextInt();
		}
		
		int[] D = new int[n+1];
		D[1] = wine[1];
		D[2] = wine[1]+wine[2];
		
		for (int i = 3; i <= n; i++) {
			D[i] = Math.max(D[i-1], Math.max(D[i-2] + wine[i], D[i-3] + wine[i-1] + wine[i]));
		}
				
		System.out.println(D[n]);
		sc.close();
	}

}
