package com.ssafy;

import java.util.Scanner;

public class BOJ_9613_GCD합_200806 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i=1; i<=T; i++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			
			for(int j=0; j<arr.length; j++) {
				arr[j] = sc.nextInt();
			}
			
			long sum = 0;
			
			for(int k=0; k<arr.length-1; k++) {
				for(int l=k+1; l<arr.length; l++) {
					sum += gcd(arr[k], arr[l]);
				}
			}
			System.out.println(sum);
		}
	}
	
	private static int gcd(int a, int b) {	
		if(b==0)
			return a;
		else return gcd(b, a%b);
	}

}
