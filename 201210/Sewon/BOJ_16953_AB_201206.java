package com.ssafy.newStudy2;

import java.util.Scanner;

public class BOJ16953_AB {

	static boolean flag = false;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long A = sc.nextLong();
		long B = sc.nextLong();
	
		cal(A, B, 0);
		
		if(!flag)	System.out.println(-1);
		sc.close();
	}
	
	private static void cal(long a, long b, int count) {
		if(a == b) {
			System.out.println(count+1);
			flag = true;
			return;
		}
		
		if(a > b || flag) return;
		
		cal(a*2, b, count+1);
		cal(plusOne(a), b, count+1);
	}

	private static long plusOne(long a) {
		String str = Long.toString(a);
		str += "1";
		return Long.parseLong(str);
	}

}
