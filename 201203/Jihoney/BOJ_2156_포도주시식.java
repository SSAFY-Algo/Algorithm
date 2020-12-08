package DP;

import java.util.Scanner;

public class BOJ_2156_포도주시식 {

	static int arr[],dp[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		arr=new int[N+1];
		dp=new int[N+1];
		for(int i=1;i<=N;i++) {
			arr[i]=sc.nextInt();
		}
		dp[1]=arr[1];
		dp[2]=arr[2]+arr[1];//max(arr[2],arr[2]+arr[1])
		
		for(int i=3;i<=N;i++) {
			dp[i]=Math.max(dp[i-1],Math.max(dp[i-3]+arr[i]+arr[i-1], dp[i-2]+arr[i]));
			//이전 포도주를 마셧을 경우, 현재 포도주와 이전 포도주를 마셧을 경우, 현재 포두주를 마시고 이전 포도주를 안마실 경우 
		}
		System.out.println(dp[N]);
	}

}
