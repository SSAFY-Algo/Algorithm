package SWEA;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5653_줄기세포배양2 {

	static int N,M,K,map[][],dir[][]= {{-1,0},{0,1},{1,0},{0,-1}};
	static boolean visited[][];
	static PriorityQueue<Node> pq;
	static Queue<Node> q;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc=Integer.parseInt(bf.readLine());
		for(int t=1;t<=tc;t++) {
			pq=new PriorityQueue<>();
			q=new LinkedList<>();
			st=new StringTokenizer(bf.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			K=Integer.parseInt(st.nextToken());
			
			map=new int[N+600][M+600];
			visited=new boolean[N+600][M+600];
			
			for(int i=300;i<300+N;i++) {
				st=new StringTokenizer(bf.readLine());
				for(int j=300;j<300+M;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
					if(map[i][j]>0) {
						q.add(new Node(new Point(i,j),map[i][j],map[i][j]+1,map[i][j]*2));
						visited[i][j]=true;
					}
				}
			}
			
			for(int i=1;i<=K;i++) {
				check(i);//번식해야될 노드 우선순위 큐에담기
				bfs(i);//번식
			}
			System.out.println("#"+" "+t+" "+q.size());
		}
	}
	private static void bfs(int t) {
		// TODO Auto-generated method stub
		int size=pq.size();
		for(int i=0;i<size;i++) {
			Node pn=pq.poll();
			int r=pn.p.x;
			int c=pn.p.y;
				
			for(int d=0;d<dir.length;d++) {
				int nr=r+dir[d][0];
				int nc=c+dir[d][1];
				
				if(!visited[nr][nc]) {// 우선순위큐이므로 생명력 비교할 필요 없음
					map[nr][nc]=pn.lifetime;
					visited[nr][nc]=true;
					
					q.add(new Node(new Point(nr,nc),map[nr][nc],t+map[nr][nc]+1,t+map[nr][nc]*2));
				}
			}

			if(t<pn.dead)
				q.add(pn);	//다시 큐에 넣어주기 - 활성화상태
		}
	}
	private static void check(int t) {
		// TODO Auto-generated method stub
		int size=q.size();
		for(int i=0;i<size;i++) {
			Node n=q.poll();
			
			if(t==n.start) {//번식
				pq.add(n);
			}else if(t<n.start) {//비활성화 상태
				q.add(n);
			}else if(t>n.start&&t<n.dead) {//활성화 상태
				q.add(n);
			}
		}
	}

}

class Node implements Comparable<Node>{
	Point p;
	int lifetime;//생명력
	int start;//활성화 될 시간=번식시간
	int dead;	//죽는 시간
	
	public Node(Point p, int lifetime, int start,int dead) {
		super();
		this.p = p;
		this.lifetime = lifetime;
		this.start = start;
		this.dead=dead;
	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return -(this.lifetime-o.lifetime);
	}
}
