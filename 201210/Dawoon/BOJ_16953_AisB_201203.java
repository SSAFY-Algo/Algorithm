package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_16953_AisB_201203 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int count = 1;
		while(true) {
			if(M % 10 == 1) {
				M = M/10;
				count++;
			}else if(M % 2 == 0) {
				M = M/2;
				count++;
			}else {
				System.out.println(-1);
				break;
			}
			
			if(M == N) {
				System.out.println(count);
				break;
			}else if(M < N) {
				System.out.println(-1);
				break;
			}
		}
	}
}
