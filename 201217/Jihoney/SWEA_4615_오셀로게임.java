package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4615_오셀로게임 {
	//1: 흑돌  2:백돌
	static int map[][],N,M,white,black,dir[][]= {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
	static boolean visited[][];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int r,c,color;
		int tc=Integer.parseInt(bf.readLine());
		for(int t=1;t<=tc;t++) {
			white=black=0;
			st=new StringTokenizer(bf.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			
			map=new int[N][N];
			visited=new boolean[N][N];
			setPos();
			
			for(int i=0;i<M;i++) {
				st=new StringTokenizer(bf.readLine());
				c=Integer.parseInt(st.nextToken())-1;
				r=Integer.parseInt(st.nextToken())-1;
				color=Integer.parseInt(st.nextToken());
				
				check(r,c,color);	//둘 수 있는곳일 경우에만 둔다
					
			}
			count();
			System.out.println("#"+t+" "+black+" "+white);
		}
	}
	private static void count() {
		// TODO Auto-generated method stub
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==1)
					black++;
				else if(map[i][j]==2)
					white++;
			}
		}
		
	}
	private static void check(int r, int c,int color) {
		// TODO Auto-generated method stub
		int nr=0,nc=0,mr=0,mc=0;
		boolean check=false;
		for(int d=0;d<dir.length;d++) {
			check=false;
			nr=r+dir[d][0];
			nc=c+dir[d][1];
			
			while(nr>=0&&nc>=0&&nr<N&&nc<N&&map[nr][nc]!=0) {
				if(map[nr][nc]==color) {
					mr=nr;
					mc=nc;
					check=true;
					break;
				}
				nr+=dir[d][0];
				nc+=dir[d][1];
			}
			while(check) {
				if(mr==r&&mc==c) {
					map[mr][mc]=color;
					break;
				}
				map[mr][mc]=color;
				mr-=dir[d][0];
				mc-=dir[d][1];
			}
		}
	}
	private static void setPos() {
		// TODO Auto-generated method stub
		map[N/2-1][N/2-1]=map[N/2][N/2]=2;	//백돌 초기 위치
		map[N/2-1][N/2]=map[N/2][N/2-1]=1;	//흑돌 초기 위치
		
		visited[N/2-1][N/2-1]=visited[N/2][N/2]=
		visited[N/2-1][N/2]=visited[N/2][N/2-1]=true;
	}
	

}
