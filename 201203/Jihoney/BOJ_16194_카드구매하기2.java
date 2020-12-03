package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16194_카드구매하기2 {

	static int N, arr[],dp[];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(bf.readLine());
		arr=new int[N+1];
		dp=new int[N+1];
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		for(int i=1;i<=N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}

		for(int t=1;t<=N;t++)
			dp[t]=Integer.MAX_VALUE;//max 초기화
		
		dp[1]=arr[1];
		for(int j=2;j<=N;j++) {
			for(int k=1;k<=j;k++) {
				dp[j]=Math.min(dp[j],dp[j-k]+arr[k]);
			}
		}
		
		System.out.println(dp[N]);
		
	}

}
