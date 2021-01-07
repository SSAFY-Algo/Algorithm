package sc_210107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1932_Á¤¼ö»ï°¢Çü {

	static int dp[][],arr[][],max=Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n=Integer.parseInt(bf.readLine());
		dp=new int[n+1][n+1];
		arr=new int[n+1][n+1];
		
		for(int i=1;i<=n;i++) {
			st=new StringTokenizer(bf.readLine());
			for(int j=1;j<=i;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0]=arr[0][0];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				dp[i][j]=Math.max(arr[i][j]+dp[i-1][j], arr[i][j]+dp[i-1][j-1]);
				max=Math.max(dp[i][j], max);
			}
		}
		
		System.out.println(max);
	}

}
