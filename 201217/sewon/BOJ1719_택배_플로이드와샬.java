package com.ssafy.newStudy3;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ1719_택배_플로이드와샬 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] arr = new int[n+1][n+1];	
		int[][] path = new int[n+1][n+1];
		
		// init
		final int INF = 10000000;
		for (int i = 1; i <= n; i++) {
			Arrays.fill(arr[i], INF);
			arr[i][i] = 0;
		}
		
		// input
		for (int i = 0; i < m; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			int time = sc.nextInt();
			arr[s][e] = Math.min(arr[s][e], time);
			arr[e][s] = Math.min(arr[e][s], time);
			path[s][e] = e;
			path[e][s] = s;
		}
		
		// visit
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if(arr[i][k] + arr[k][j] < arr[i][j]) {
						arr[i][j] = arr[i][k] + arr[k][j];
						path[i][j] = path[i][k];
					}
				}
			}			
		}
		
		// output
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if(arr[i][j] >= INF || arr[i][j] == 0) 	System.out.print("- ");
				else 					System.out.print(path[i][j] + " ");
			}
			System.out.println();
		}
		sc.close();
	}

}
