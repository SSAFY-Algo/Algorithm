package com.ssafy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_6588_골드바흐의추측_200810 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean[] prime = new boolean[1000001];
		for(int i = 2; i <= 1000000; i++) {
            prime[i] = true;
        }
        for(int i = 2; i <= 1000000; i++) {
            for(int j = i * 2; j <= 1000000; j += i) {
                if(!prime[j]) continue;
                prime[j] = false;
            }
        }
		
		while(true) {
			int N = sc.nextInt();
			boolean isWrong = true;
			if(N == 0)
				break;
			for(int i=2; i<=N; i++) {
				if(prime[i] && prime[N-i]) {
					System.out.println(N + " = " + i + " + " + (N-i));
					isWrong = false;
					break;
				}
			}
			
			if(isWrong)
				System.out.println("Goldbach's conjecture is wrong.");
		}

	}

}
