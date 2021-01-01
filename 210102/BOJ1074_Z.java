package com.ssafy.newStudy5;

import java.util.Scanner;

public class BOJ1074_Z {

	static int N, r, c, count;
	static int[][] dir = { {0,0}, {0,1}, {1,0}, {1,1} };
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		
		count = 0;
		find(0, 0, N);
		sc.close();
	}

	private static void find(int i, int j, int n) {
		if(n == 1) {
			for (int k = 0; k < 4; k++) {
				int ni = i + dir[k][0];
				int nj = j + dir[k][1];
				if(ni == r && nj == c) {
					System.out.println(count);
					break;
				}
				count++;
			}
			return;
		}
		
		int half = (int)Math.pow(2, n-1);
		
		if(r < i+half && c < j+half) {
			find(i, j, n-1);
		}
		else if(r < i+half && c >= j+half) {
			count += half*half;
			find(i, j+half, n-1);
		}
		else if(r >= i+half && c < j+half) {
			count += half*half*2;
			find(i+half, j, n-1);
		}
		else if(r >= i+half && c >= j+half) {
			count += half*half*3;
			find(i+half, j+half, n-1);
		}
	}
}
