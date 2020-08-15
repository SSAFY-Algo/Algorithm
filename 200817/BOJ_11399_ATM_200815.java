package com.ssafy;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11399_ATM_200815 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		int result = 0;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<=i; j++) {
				result += arr[j];
			}
		}
		
		System.out.println(result);
	}

}
