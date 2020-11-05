package GRAPH;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236_아기상어{

	static int size=2,N,map[][],dist[][],dir[][]= {{0,-1},{-1,0},{0,1},{1,0}},
			cnt=0,
			min_dist,minr,minc,eat=0,curr,curc;
	static Queue<Point> q=new LinkedList<>();
	public static void main(String args[]) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(bf.readLine());
		map=new int[N][N];
		dist=new int[N][N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(bf.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==9) {
					curr=i;
					curc=j;
				}
			}
		}
		
		while(true) {	//종료 조건 : 물고기가 없거나 현재 사이즈보다 큰 물고기만 남을 경우 
			min_dist=Integer.MAX_VALUE;
			minr=Integer.MAX_VALUE;
			minc=Integer.MAX_VALUE;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					dist[i][j]=-1;
				}
			}
			findFish(curr,curc);
			if(minr!=Integer.MAX_VALUE&&minc!=Integer.MAX_VALUE) {
				eat++;
				cnt+=dist[minr][minc];
				if(eat==size) {
					size++;
					eat=0;
				}
				map[minr][minc]=0;
				curr=minr;
				curc=minc;
				
			}else
				break;
		}
		System.out.println(cnt);
	}
	
	private static void findFish(int r,int c) {
		q.offer(new Point(r,c));
		map[r][c]=0;
		dist[r][c]=0;
		int nr,nc;
		while(!q.isEmpty()) {
			Point p=q.poll();
			r=p.x;
			c=p.y;
			for(int d=0;d<dir.length;d++) {
				nr=r+dir[d][0];
				nc=c+dir[d][1];
				if(nr<0||nr>=N||nc<0||nc>=N)
					continue;
				if(dist[nr][nc]!=-1||map[nr][nc]>size)	// 자신보다 사이즈가 클 경우
					continue;
				dist[nr][nc]=dist[r][c]+1;
				
				if(map[nr][nc]!=0&&map[nr][nc]<size) {	// 먹을수 있는 물고기라면
					if(min_dist>dist[nr][nc]) {
						min_dist=dist[nr][nc];
						minr=nr;
						minc=nc;
					}
					else if(min_dist==dist[nr][nc]) {
						if(minr==nr) {
							if(minc>nc) {
								minr=nr;
								minc=nc;
							}
						}else if(minr>nr) {
							minr=nr;
							minc=nc;
						}
					}
				}
				q.add(new Point(nr,nc));
			}
		}
	}	
}
