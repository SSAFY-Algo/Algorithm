package sc_210107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9251_LCS {

	static int dp[][];
	static char[] str1,str2;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		str1=bf.readLine().toCharArray();
		str2=bf.readLine().toCharArray();
		
		dp=new int[str1.length+1][str2.length+1];
		
		for(int i=1;i<=str1.length;i++) {
			for(int j=1;j<=str2.length;j++) {
				if(str1[i-1]==str2[j-1]) {
					dp[i][j]=dp[i-1][j-1]+1;
				}
				else {
					dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		System.out.println(dp[str1.length][str2.length]);
	}

}
