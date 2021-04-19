package sc_210416;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16197_두동전 {

	static int map[][],N,M,ans=0,min=Integer.MAX_VALUE,dir[][] = {{-1,0},{0,1},{1,0},{0,-1}};
	static boolean flag=false;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N+2][M+2];
		Point coin[]=new Point[2];
		
		// 1:동전, 2:벽
		for(int i=1;i<=N;i++) {
			String str=bf.readLine();
			for(int j=1;j<=M;j++) {
				char ch=str.charAt(j-1);
				if(ch=='o') {
					map[i][j]=1;
					if(coin[0]==null) {
						coin[0]=new Point(i,j);
					}
					else {
						coin[1]=new Point(i,j);
					}
			}else if(ch=='#') {
					map[i][j]=2;
				}
			}
		}
		dfs(coin,0);
		if(min==Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
	}
	
	private static void dfs(Point coin[],int idx) {
		// TODO Auto-generated method stub
		if(idx>10 ||idx>min)
			return;
		
		//둘 중에 하나가 떨어졌으면
		if((check(coin[0].x,coin[0].y)&&!check(coin[1].x,coin[1].y))||
				(!check(coin[0].x,coin[0].y)&&check(coin[1].x,coin[1].y))) {
			min=Math.min(idx, min);
			return;	
		}
		// 둘 다 떨어졌으면
		if(check(coin[0].x,coin[0].y)&&check(coin[1].x,coin[1].y)){
			return;
		}
		
		for(int i=0;i<dir.length;i++) {
			int nr1=coin[0].x+dir[i][0];
			int nc1=coin[0].y+dir[i][1];
			
			int nr2=coin[1].x+dir[i][0];
			int nc2=coin[1].y+dir[i][1];
			
			//벽 만나면
			if(!check(nr1,nc1)&&map[nr1][nc1]==2) {
				nr1-=dir[i][0];
				nc1-=dir[i][1];
			}else if(!check(nr2,nc2)&&map[nr2][nc2]==2) {
				nr2-=dir[i][0];
				nc2-=dir[i][1];
			}
			
			coin[0].x=nr1;
			coin[0].y=nc1;
			coin[1].x=nr2;
			coin[1].y=nc2;
			
			dfs(coin,idx+1);
		}
	}

	private static boolean check(int r,int c) {
		// TODO Auto-generated method stub
		if(r==0||c==0||r==N+1||c==M+1)
			return true;
		return false;
	}
	
}
