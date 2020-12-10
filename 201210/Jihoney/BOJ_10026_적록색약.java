package BFS_DFS;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_10026_적록색약 {

	static int N,Acnt=0,RGcnt=0,dir[][]={{-1,0},{0,1},{1,0},{0,-1}};
	static char map[][];
	static boolean visited[][];
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N=Integer.parseInt(bf.readLine());
		map=new char[N][N];
		visited=new boolean[N][N];//R,G,B
		
		for(int i=0;i<N;i++) {	//입력 받기
			String str=bf.readLine();
			for(int j=0;j<N;j++) {
				map[i][j]=str.charAt(j);
			}
		}	
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j]) {	//적록색약 아닌 경우
					dfs(i,j);
					Acnt++;
				}
			}
		}
		
		for(int i=0;i<N;i++) {	//bool 배열초기화, G-R통일 
			for(int j=0;j<N;j++) {
				visited[i][j]=false;
				if(map[i][j]=='G')
					map[i][j]='R';
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j]) {	//적록색약인 경우
					dfs(i,j);
					RGcnt++;
				}
			}
		}
		
		System.out.println(Acnt+" "+RGcnt);
	}
	
	static void dfs(int r,int c) {
		visited[r][c]=true;
		for(int i=0;i<dir.length;i++) {
			int nr=r+dir[i][0];
			int nc=c+dir[i][1];
			
			if(nr>=0&&nr<N&&nc>=0&&nc<N&&!visited[nr][nc]&&map[r][c]==map[nr][nc]) {
				dfs(nr,nc);
			}
		}
		
	}

}
