package BFS_DFS;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_6087_레이저통신 {

	static int W,H,cnt=Integer.MAX_VALUE,count[][],dir[][] = {{0,0},{-1,0},{0,1},{1,0},{0,-1}};
	static char map[][];
	static Point start=null,end=null;
	static Queue<Node> q=new LinkedList<>();
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		W=Integer.parseInt(st.nextToken());
		H=Integer.parseInt(st.nextToken());
		
		map=new char[H][W];
		count=new int[H][W];	//현위치까지 최소 거울의 개수 저장
		
		for(int i=0;i<H;i++) {
			String str=bf.readLine();
			for(int j=0;j<W;j++) {
				map[i][j]=str.charAt(j);
				count[i][j]=Integer.MAX_VALUE;	//초기화
				if(map[i][j]=='C'&&start==null) {	//시작점 저장
					start=new Point(i,j);
					q.add(new Node(start,0,0));	//시작점, 방향, 거울개수
				}if(map[i][j]=='C'&&start!=null) {	// 종료점 저장
					end=new Point(i,j);
				}
			}
		}
		bfs();
		
	}
	private static void bfs() {
		int r,c,nr,nc,direction,mirror,nm;
		count[start.x][start.y]=0;
		
		while(!q.isEmpty()) {
			Node n=q.poll();
			r=n.p.x;
			c=n.p.y;
			direction=n.direction;
			mirror=n.mirror;
			if(r==end.x&&c==end.y) {
				cnt=Math.min(cnt,mirror);
			}
			for(int i=1;i<dir.length;i++) {
				nr=r+dir[i][0];
				nc=c+dir[i][1];
				nm=mirror;
//				mirror++;
				if(nr<0||nr>=H||nc<0||nc>=W||map[nr][nc]=='*') {
					continue;
				}
				if(direction!=i&&direction!=0) {	//이전 방향과 다를 경우 , 시작점저장할때 방향 0==시작점이 아니면서
					nm++;
				}
				if(count[nr][nc]<nm)
					continue;
				q.add(new Node(new Point(nr,nc),i,nm));
				count[nr][nc]= nm;
		}
	}
	System.out.println(cnt);
}
}

class Node{
	Point p;
	int direction;
	int mirror;
	
	public Node(Point p, int direction,int mirror) {
		this.p = p;
		this.direction = direction;
		this.mirror=mirror;
	}
}