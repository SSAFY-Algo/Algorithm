package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_7699_수지의수지맞는여행 {

	static int tc,R,C,dir[][]= {{-1,0},{0,1},{1,0},{0,-1}},ans;
	static boolean visited[];
	static char map[][];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		tc=Integer.parseInt(bf.readLine());
		for(int t=1;t<=tc;t++) {
			ans=0;
			st=new StringTokenizer(bf.readLine());
			R=Integer.parseInt(st.nextToken());
			C=Integer.parseInt(st.nextToken());
			map=new char[R][C];
			visited=new boolean[26];
			
			for(int i=0;i<R;i++) {
				String str=bf.readLine();
				for(int j=0;j<C;j++) {
					map[i][j]=str.charAt(j);
				}
			}
			visited[map[0][0]-'A']=true;
			dfs(0,0,1);
			System.out.println("#"+t+" "+ans);
		}
	}
	
	static void dfs(int r,int c,int cnt) {
		if(ans<cnt)
			ans=cnt;
		for(int i=0;i<dir.length;i++) {
			int nr=r+dir[i][0];
			int nc=c+dir[i][1];
			
			if(nr>=0&&nr<R&&nc>=0&&nc<C) {
				if(visited[map[nr][nc]-'A']==false) {
					
					visited[map[nr][nc]-'A']=true;
					dfs(nr,nc,cnt+1);
					visited[map[nr][nc]-'A']=false;
				}
			}
		}
		
	}

}
