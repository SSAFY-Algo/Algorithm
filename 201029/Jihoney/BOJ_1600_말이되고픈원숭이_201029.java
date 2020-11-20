package BFS_DFS;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600_말이되고픈원숭이 {

	static int map[][],H,W,K;
	static int hDir[][]= {{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};
	static int mDir[][]= {{-1,0},{0,1},{1,0},{0,-1}};
	static boolean visited[][][];
	static Queue<monkey> q=new LinkedList<>();
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		K=Integer.parseInt(bf.readLine());
		
		StringTokenizer st=new StringTokenizer(bf.readLine());
		W=Integer.parseInt(st.nextToken());
		H=Integer.parseInt(st.nextToken());
		
		map=new int[201][201];
		visited=new boolean[201][201][K+1];
		
		for(int i=0;i<H;i++) {
			st=new StringTokenizer(bf.readLine());
			for(int j=0;j<W;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int k=0;k<K;k++) {
			visited[0][0][k]=true;	//시작점 
		}
		
		if(H==1&&W==1) {
			System.out.println("0");
		}else {
			System.out.println(bfs());
		}
	}
	
	static int bfs() {
		q.add(new monkey(new Point(0,0),0,0));
		
		while(!q.isEmpty()) {
			monkey m=q.poll();
			Point p=m.p;
			int k=m.k;
			int n=m.n;
			
			if(p.x==H-1&&p.y==W-1) {
				return n;
			}
			
			if(k<K) {
				for(int i=0;i<hDir.length;i++) {
					int nr=p.x+hDir[i][0];
					int nc=p.y+hDir[i][1];
					
					if(nr>=0&&nr<H&&nc>=0&&nc<W&&map[nr][nc]!=1&&!visited[nr][nc][k+1]) {
						visited[nr][nc][k+1]=true;
						q.add(new monkey(new Point(nr,nc),k+1,n+1));
					}
				}
			}
			
			for(int j=0;j<mDir.length;j++) {
				int mr=p.x+mDir[j][0];
				int mc=p.y+mDir[j][1];
				
				if(mr>=0&&mr<H&&mc>=0&&mc<W&&map[mr][mc]!=1&&!visited[mr][mc][k]) {
					visited[mr][mc][k]=true;
					q.add(new monkey(new Point(mr,mc),k,n+1));
				}
			}
		}
		return -1;
		
	}

}
	class monkey{
	Point p;
	int k;
	int n;
	
	monkey(Point p,int k,int n){
		this.p=p;
		this.k=k;
		this.n=n;
	}
}
