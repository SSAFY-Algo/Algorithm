package BFS_DFS;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_15558_점프게임 {

	static int N,K,map[][],res=0,dir[][] = {{0,1},{0,-1},{1,0},{-1,0}};
	static boolean visited[][];
	static Queue<jump> q=new LinkedList<>();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st=new StringTokenizer(bf.readLine());
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		map=new int[2][200000];
		visited=new boolean[2][200000];	//N+K<=200000
		
		String left=bf.readLine();
		String right=bf.readLine();
		for(int i=0;i<N;i++) {
			map[0][i]=left.charAt(i)-'0';
			map[1][i]=right.charAt(i)-'0';
		}
		
		bfs();
		System.out.println(res);
	}
	private static void bfs() {
		// TODO Auto-generated method stub
		q.add(new jump(new Point(0,0),0));
		visited[0][0]=true;
		
		while(!q.isEmpty()) {
			jump j=q.poll();
			int r=j.p.x;
			int c=j.p.y;
			int curTime=j.time;
			
			if(curTime>=N)	//시간 초과
				break;
			
			for(int i=0;i<2;i++) {// 한단계씩 이동
				int nr=r+dir[i][0];
				int nc=c+dir[i][1];
				if(nc>=N) {
					res=1;
					return;
				}
				if(nr>=0&&nr<2&&nc>curTime&&nc<N) {	// 범위내에 있으면
					if(map[nr][nc]==1&&!visited[nr][nc]) {
						visited[nr][nc]=true;
						q.add(new jump(new Point(nr,nc),curTime+1));	// 시간 증가
					}
				}
					
			}
			
			for(int i=2;i<4;i++) {	// 반대편으로 이동하면서 k칸씩 증가
				int nr=r+dir[i][0];
				int nc=c+dir[i][1]+K;
				if(nc>=N) {
					res=1;
					return;
				}
				if(nr>=0&&nr<2&&nc>curTime&&nc<N) {
					if(map[nr][nc]==1&&!visited[nr][nc]) {
						visited[nr][nc]=true;
						q.add(new jump(new Point(nr,nc),curTime+1));
					}
				}
			}
		}
		
		
	}

}

class jump{
	Point p;
	int time;
	public jump(Point p, int time) {
		super();
		this.p = p;
		this.time = time;
	}
}