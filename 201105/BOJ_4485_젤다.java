package 구현;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4485_젤다 {

	static int N,map[][],dist[][],tc=1,dir[][]= {{-1,0},{0,1},{1,0},{0,-1}};

	static Queue<Point> q=new LinkedList<>();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		while(true) {
			N=Integer.parseInt(bf.readLine());
			if(N==0) {
				System.exit(0);
			}
			map=new int[N][N];
			dist=new int[N][N];
			for(int i=0;i<N;i++) {
				st=new StringTokenizer(bf.readLine());
				for(int j=0;j<N;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
					dist[i][j]=Integer.MAX_VALUE;
				}
			}
			
			bfs();
			
			System.out.println("Problem "+tc+": "+dist[N-1][N-1]);
			tc++;
		}
	}

	static void bfs() {
		q.add(new Point(0,0));
		dist[0][0]=map[0][0];
		
		while(!q.isEmpty()) {
			Point p=q.poll();
			int r=p.x;
			int c=p.y;
			
			for(int i=0;i<dir.length;i++) {
				int nr=r+dir[i][0];
				int nc=c+dir[i][1];
				
				if(nr>=0&&nr<N&&nc>=0&&nc<N) {
					if(dist[nr][nc]>dist[r][c]+map[nr][nc]) {
						dist[nr][nc]=dist[r][c]+map[nr][nc];
						q.add(new Point(nr,nc));
					}
				}
			}
		}	
	}
}
