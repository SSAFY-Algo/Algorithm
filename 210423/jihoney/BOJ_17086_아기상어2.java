package sc_210420;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17086_아기상어2 {

	static int map[][],M,N,ans=Integer.MIN_VALUE,dist[][];
	static int dir[][]= {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
	static Queue<Point> q;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		map=new int[N][M];
		dist=new int[N][M];
		q=new LinkedList<>();
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(bf.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					q.add(new Point(i,j));
				}
			}
		}
		bfs();
		System.out.println(ans);
	}
	private static void bfs() {
		while(!q.isEmpty()) {
			Point p=q.poll();
			
			for(int i=0;i<dir.length;i++) {
				int nr=p.x+dir[i][0];
				int nc=p.y+dir[i][1];
				
				if(nr>=0&&nc>=0&&nr<N&&nc<M) {
					if(dist[nr][nc]!=0||map[nr][nc]==1)
						continue;
					dist[nr][nc]=dist[p.x][p.y]+1;
					if(ans<dist[nr][nc])
						ans=dist[nr][nc];
					q.add(new Point(nr,nc));
				}
			}
			
		}
	}
}