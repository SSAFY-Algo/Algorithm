package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1012_유기농배추 {

	static int tc,N,M,K,X,Y,cnt=0;
	static int map[][];
	static int dir[][]= {{-1,0},{1,0},{0,1},{0,-1}};
	static boolean visited[][];
	static int res[];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		tc=Integer.parseInt(bf.readLine());
		res=new int[tc]; //결과값 저장
		for(int t=0;t<tc;t++) {
			int cnt=0;
			st=new StringTokenizer(bf.readLine());
			M=Integer.parseInt(st.nextToken());
			N=Integer.parseInt(st.nextToken());
			K=Integer.parseInt(st.nextToken());
			map=new int[N][M];
			visited=new boolean[N][M];
			
			for(int k=0;k<K;k++) {
				st=new StringTokenizer(bf.readLine());
				X=Integer.parseInt(st.nextToken());
				Y=Integer.parseInt(st.nextToken());
				map[Y][X]=1;
			}

			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(map[i][j]==1&&!visited[i][j]) {
						dfs(i,j);
						cnt++;
					}
				}
			}
			res[t]=cnt;
		}
		for(int i=0;i<res.length;i++)
			System.out.println(res[i]);
		
	}
	
	private static void dfs(int r,int c) {
		visited[r][c]=true;
		int nr,nc;
		for(int i=0;i<dir.length;i++) {
			nr=r+dir[i][0];
			nc=c+dir[i][1];
			if(nr>=0&&nr<N&&nc>=0&&nc<M) {
				if(map[nr][nc]==1&&!visited[nr][nc]) {
					dfs(nr,nc);
					
				}
			}
			
		}
		
		
	}

}
