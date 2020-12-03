package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888_연산자끼워넣기 {
	//연산자 최대 개수 10
	static int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE,N,nums[],p,m,ml,d;
	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N=Integer.parseInt(bf.readLine());
		nums=new int[N];
		
		st=new StringTokenizer(bf.readLine());
		for(int i=0;i<N;i++) {
			nums[i]=Integer.parseInt(st.nextToken());
		}
		
		st=new StringTokenizer(bf.readLine());
		p=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		ml=Integer.parseInt(st.nextToken());
		d=Integer.parseInt(st.nextToken());
		
		dfs(nums[0],0,1,p,m,ml,d);
		System.out.println(max);
		System.out.println(min);
	}
	static void dfs(int res,int cnt,int idx,int plus, int minus,int multi,int divide) {
		if(cnt==N-1) {
			max=Math.max(max, res);
			min=Math.min(min, res);
		}
		else {
			if(plus>0) {
				dfs(res+nums[idx],cnt+1,idx+1,plus-1,minus,multi,divide);
			}
			if(minus>0) {
				dfs(res-nums[idx],cnt+1,idx+1,plus,minus-1,multi,divide);
			}
			if(multi>0) {
				dfs(res*nums[idx],cnt+1,idx+1,plus,minus,multi-1,divide);
			}
			if(divide>0) {
				dfs(res/nums[idx],cnt+1,idx+1,plus,minus,multi,divide-1);
			}

		}
		
		
		
	}
}
