package practice;

import java.util.Scanner;

public class BOJ_1978_소수찾기_200808 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		int answer = 0;
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i = 0; i<N; i++) {
			int a = arr[i];
			int cnt = 0;
			for(int j=1; j<=a; j++) {
				if(a%j == 0)
					cnt++;
				if(cnt > 2) break;
			}
			if(cnt == 2) answer++;
		}
		
		System.out.println(answer);
	}

}