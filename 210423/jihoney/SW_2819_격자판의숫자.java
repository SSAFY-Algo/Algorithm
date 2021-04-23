package sc_210420;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SW_2819_격자판의숫자 {

	static int tc;
	static int map[][]=new int[4][4];
	static int dir[][]= {{-1,0},{0,1},{1,0},{0,-1}};
	static HashMap<String,Integer> list;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		tc=Integer.parseInt(st.nextToken());
		
		for(int t=1;t<=tc;t++) {
			list=new HashMap<>();
			 for(int i=0;i<4;i++) {
				 st=new StringTokenizer(bf.readLine());
				 for(int j=0;j<4;j++) {
					 map[i][j]=Integer.parseInt(st.nextToken());
				 }
			 }
			 
			 for(int i=0;i<4;i++) {
				 for(int j=0;j<4;j++) {
					 String str="";
					 dfs(str,i,j,0);
				 }
			 }
			 
			 System.out.println("#"+t+" "+list.size());
		}
	}
	private static void dfs(String str, int r,int c,int cnt) {
		if(cnt==7) {
			list.put(str,list.getOrDefault(str,0)+1);
			return;
		}
		
		str+=map[r][c];
		
		for(int i=0;i<dir.length;i++) {
			int nr=r+dir[i][0];
			int nc=c+dir[i][1];
			
			if(nr>=0&&nc>=0&&nr<4&&nc<4)
				dfs(str,nr,nc,cnt+1);
		}
	}

}
