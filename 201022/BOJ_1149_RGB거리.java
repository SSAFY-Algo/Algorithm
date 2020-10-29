package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149_RGB거리 {

	static int color[][],n,dp[][];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(bf.readLine());
		color=new int[1001][3];
		dp=new int[1001][3];
		StringTokenizer st;
		
		for(int i=1;i<=n;i++) {
			st=new StringTokenizer(bf.readLine());
			for(int k=0;k<3;k++) {
				color[i][k]=Integer.parseInt(st.nextToken());				
			}
		}
		
		for(int i=1;i<=n;i++) {
			dp[i][0]=Math.min(dp[i-1][1], dp[i-1][2])+color[i][0];
			dp[i][1]=Math.min(dp[i-1][0], dp[i-1][2])+color[i][1];
			dp[i][2]=Math.min(dp[i-1][0], dp[i-1][1])+color[i][2];
		}
		
		int tmp=Math.min(dp[n][0], dp[n][1]);
		System.out.println(Math.min(tmp, dp[n][2]));
	}

}
