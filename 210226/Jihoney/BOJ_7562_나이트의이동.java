package sc_210219;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7562_나이트의이동 {

	static int map[][],cnt,size,minCnt,dir[][]= {{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};
	static Point start,end;
	static boolean visited[][];
	static Queue<int[]> bfs=new LinkedList<>();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc=Integer.parseInt(bf.readLine());
		
		for(int t=0;t<tc;t++) {
			start=new Point();
			end=new Point();
			minCnt=Integer.MAX_VALUE;
			size=Integer.parseInt(bf.readLine());
			map=new int[size][size];
			visited=new boolean[size][size];
			
			st=new StringTokenizer(bf.readLine());
			start.x=Integer.parseInt(st.nextToken());
			start.y=Integer.parseInt(st.nextToken());
			
			st=new StringTokenizer(bf.readLine());
			end.x=Integer.parseInt(st.nextToken());
			end.y=Integer.parseInt(st.nextToken());
			
			find();
			System.out.println(minCnt);
		}
	}
	private static void find() {
		// TODO Auto-generated method stub
		visited[start.x][start.y]=true;
		bfs.add(new int[]{start.x,start.y,0});
		while(!bfs.isEmpty()) {
			int arr[]=bfs.poll();
			int r=arr[0];
			int c=arr[1];
			int cnt=arr[2];
			
			if(r==end.x&&c==end.y) {
				minCnt=Math.min(cnt, minCnt);
			}
			
			for(int i=0;i<dir.length;i++) {
				int nr=r+dir[i][0];
				int nc=c+dir[i][1];
				
				if(nr>=0&&nc>=0&&nr<size&&nc<size&&!visited[nr][nc]) {
					bfs.add(new int[] {nr,nc,cnt+1});
					visited[nr][nc]=true;
				}
			}
		}
		
	}

}
