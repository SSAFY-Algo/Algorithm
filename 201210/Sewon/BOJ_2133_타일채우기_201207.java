package com.ssafy.newStudy2;

import java.util.Scanner;

public class BOJ2133_타일채우기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] D = new int[N+1];
		
		D[0] = 1;
		for (int i = 1; i <= N; i++) {
			if(i == 1) {
				D[i] = 0;
				continue;
			}
			if(i == 2) {
				D[i] = 3;
				continue;
			}
			
			if(i % 2 == 0) {
				for (int j = 2; j <=i; j+=2) {
					D[i] += (j == 2) ? (D[i-j]*3) : (D[i-j]*2);
				}
			}
		}
		
		System.out.println(D[N]);
		sc.close();
	}

}
