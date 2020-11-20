package com.ssafy;

import java.util.Scanner;

public class BOJ_1074_Z_200819 {
	static int[][] arr;
	static int r,c;
	static int result=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		
		fun((int)Math.pow(2, N), r, c);
		
	}
	
	static void fun(int num, int x, int y) {
		if(num == 2) {
			if(x == 0 && y == 0)
				System.out.println(result);
			if(x == 0 && y == 1)
				System.out.println(result+1);
			if(x == 1 && y == 0)
				System.out.println(result+2);
			if(x == 1 && y == 1)
				System.out.println(result+3);
			return;
		}
		
		if(x < num/2 && y < num/2) {
			fun(num/2, x,y);
		}
		
		else if(x < num/2 && y >= num/2) {
			result += (num*num)/4 * 1;
			fun(num/2, x, y-num/2);
		}
		
		else if(x >= num/2 && y < num/2) {
			result += (num*num)/4 * 2;
			fun(num/2, x-num/2, y);
		}
		
		else if(x >= num/2 && y >= num/2) {
			result += (num*num)/4 * 3;
			fun(num/2, x-num/2, y-num/2);
		}
		
	}
	
	

}
