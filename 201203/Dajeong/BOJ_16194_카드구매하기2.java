package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16194_카드구매하기2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N+1];
		int[] dp = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		// arr 배열 입력 받음
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 상향식 접근
		// i개의 카드를 갖고 있을 때 최소 값을 dp 배열에 넣어준다
		// C[n] = n-j>=0 -> C[n-j]+arr[j]
		
		for(int i=1; i<=N; i++) {
			int min = Integer.MAX_VALUE;
			for(int j=1; j<=N; j++) {
				if(i>=j && dp[i-j]+arr[j] < min) min = dp[i-j]+arr[j];
			}
			
			dp[i] = min;
		}
		System.out.println(dp[N]);

	}

}
