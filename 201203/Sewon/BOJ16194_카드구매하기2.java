package com.ssafy.newStudy1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16194_카드구매하기2 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] p = new int[N+1];
		for (int i = 1; i <= N; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		// D[N] = 카드를 N장 사는데 드는 최소 비용
		// D[N] = min( D[N-1] + D[1], D[N-2] + D[2], ... , D[N-N] + p[N])
		int[] D = new int[N+1];
		D[1] = p[1];
		for (int i = 2; i <= N; i++) {
			
			int min = Integer.MAX_VALUE;
			for (int j = 1; j <=i; j++) {
				int tmp = D[i-j] + p[j];
				min = Math.min(min, tmp);
			}
			D[i] = min;
		}
		
		System.out.println(D[N]);
	}

}
