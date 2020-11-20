package com.ssafy;
import java.util.Scanner;

public class BOJ_1934_최소공배수_200803 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int i = 0; i < T; i++) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			
			System.out.println((num1 * num2) / calc(num1, num2));
			
		}
		

	}
	
	private static int calc(int num1, int num2) {
		
		if(num2 == 0) {
			return num1;
		}
		else {
			return calc(num2,num1%num2);
		}
		
	}

}
