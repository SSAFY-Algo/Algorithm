package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2156_포도주시식 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int[][] D = new int[N][3];
		D[0][0] = 0;
		D[0][1] = arr[0];
		
		if(N > 1) {
			D[1][0] = arr[0];
			D[1][1] = arr[1];
			D[1][2] = arr[0] + arr[1];
		}
		
		if(N > 2) { 
			for(int i=2; i<N; i++) {
				D[i][0] = Math.max(Math.max(D[i-1][0], D[i-1][1]), D[i-1][2]);
				D[i][1] = D[i-1][0] + arr[i];
				D[i][2] = D[i-1][1] + arr[i];
				
			}	
		}
		int max = 0;
		for(int i=0; i<3; i++) {
			max = Math.max(max, D[N-1][i]);
		}
		
		System.out.println(max);
	}
}
