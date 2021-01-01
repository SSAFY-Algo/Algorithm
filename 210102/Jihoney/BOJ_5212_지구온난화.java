package 구현;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5212_지구온난화 {

	static int dir[][]= {{-1,0},{0,1},{1,0},{0,-1}},maxR=-1,maxC=-1,minR=Integer.MAX_VALUE,minC=Integer.MAX_VALUE;
	static char map[][];
	static Queue<Point> q=new LinkedList<>();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		int r=Integer.parseInt(st.nextToken());
		int c=Integer.parseInt(st.nextToken());
		
		map=new char[r+2][c+2];
		for(int i=0;i<r+2;i++) {
			for(int j=0;j<c+2;j++) {
				map[i][j]='.';
			}
		}
		
		for(int i=1;i<1+r;i++) {
			String str=bf.readLine();
			for(int j=1;j<1+c;j++) {
				map[i][j]=str.charAt(j-1);
			}
		}
		
		for(int i=1;i<r+1;i++) {
			for(int j=1;j<c+1;j++) {
				if(map[i][j]=='X')
					after(i,j);
			}
		}
		
		delete();
		
		for(int i=minR;i<=maxR;i++) {
			for(int j=minC;j<=maxC;j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
	}	
	private static void delete() {
		while(!q.isEmpty()) {
			Point p=q.poll();
			map[p.x][p.y]='.';
		}
	}
	private static void after(int i,int j) {
			boolean flag=false;
			int cnt=0;
			for(int d=0;d<dir.length;d++) {
				int ni=i+dir[d][0];
				int nj=j+dir[d][1];
				if(map[ni][nj]=='.')
					cnt++;
				if(cnt>=3)
					flag=true;
			}
			if(flag)
				q.add(new Point(i,j));
			if(!flag) {
				maxR=Math.max(maxR, i);
				maxC=Math.max(maxC, j);
				minR=Math.min(minR, i);
				minC=Math.min(minC, j);
			}
	}
}
