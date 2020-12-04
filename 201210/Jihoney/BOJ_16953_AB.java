package BFS_DFS;

import java.util.Scanner;

public class BOJ_16953_AB {
	static int res=Integer.MAX_VALUE;
	static long A,B;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		A=sc.nextLong();
		B=sc.nextLong();
	
		int cnt=1;
		dfs(cnt,A);
		if(res==Integer.MAX_VALUE) {
			System.out.println("-1");
		}else {
			System.out.println(res);
		}
	}

	static void dfs(int cnt,long num) {
		if(num==B) {
			res=Math.min(res,cnt);
			return;
		}else if(num>B) {
			return;
		}
		else {
			dfs(cnt+1,num*2);		
			dfs(cnt+1,num*10+1);
		}
	}
}
