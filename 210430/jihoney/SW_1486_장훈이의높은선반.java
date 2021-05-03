package sc_210430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_1486_장훈이의높은선반 {

	static int tc,N,B,input[],res[],min,count=0;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		tc=Integer.parseInt(bf.readLine());
		
		for(int t=1;t<=tc;t++) {
			min=Integer.MAX_VALUE;
			st=new StringTokenizer(bf.readLine());
			N=Integer.parseInt(st.nextToken());
			B=Integer.parseInt(st.nextToken());
			
			st=new StringTokenizer(bf.readLine());
			input=new int[N];
			for(int i=0;i<N;i++) {
				input[i]=Integer.parseInt(st.nextToken());
			}
			res=new int[N];
			for(int i=1;i<=N;i++) {
				combi(0,0,i);
			}
			System.out.println("#"+t+" "+min+" "+count);
		}
	}
	private static void combi(int idx, int depth,int end) {
		// TODO Auto-generated method stub
		if(depth==end) {
			count++;
			int sum=0;
			for(int i=0;i<end;i++) {
				sum+=res[i];
			}
			if(sum-B>=0)
				min=Math.min(sum-B,min);
			return;
		}
		
		for(int i=idx;i<N;i++) {
			res[depth]=input[i];
			combi(i+1,depth+1,end);
		}
	}

}
