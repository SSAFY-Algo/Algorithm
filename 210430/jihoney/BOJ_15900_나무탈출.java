package sc_210430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15900_³ª¹«Å»Ãâ {

	static int N,ans=0;
	static boolean visited[];
	static ArrayList<ArrayList<Integer>> list;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N=Integer.parseInt(bf.readLine());
		visited=new boolean[N+1];
		list=new ArrayList<>();
		
		for(int i=0;i<=N;i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i=0;i<N-1;i++) {
			st=new StringTokenizer(bf.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		visited[1]=true;
		dfs(1,0);
		if(ans%2==0) {
			System.out.println("No");
		}else
			System.out.println("Yes");
	}
	private static void dfs(int n, int cnt) {
		if(n!=1&&list.get(n).size()==1&&!visited[n]) {
			ans+=cnt;
			return;
		}
		
		visited[n]=true;
		int size=list.get(n).size();
		
		for(int i=0;i<size;i++) {
			int num=list.get(n).get(i);
			if(!visited[num]) {
				dfs(num,cnt+1);
			}
		}
	}

}
