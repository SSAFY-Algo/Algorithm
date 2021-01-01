package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1026_보물 {

	private static int[] a, b, numbers;
	private static int N;
	private static boolean[] visited;
	private static int answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		a = new int[N];
		b = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}
	
		Arrays.sort(a);
		Arrays.sort(b);
		
		int answer = 0;
		for (int i = 0; i < N; i++) {
			answer += (a[i] * b[N-i-1]);
		}
		
		System.out.println(answer);
	}

	
}
