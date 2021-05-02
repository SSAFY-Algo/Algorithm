package sc_210430;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2583_영역구하기 {

	static int n,m,k,map[][],dir[][]= {{-1,0},{0,1},{1,0},{0,-1}};
	static ArrayList<Integer> list=new ArrayList<>();
	static Queue<Point> q=new LinkedList<>();
	static boolean visited[][];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		m=Integer.parseInt(st.nextToken());
		n=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		
		int a,b,c,d;
		map=new int[m][n];
		visited=new boolean[m][n];
		for(int t=0;t<k;t++) {
			st=new StringTokenizer(bf.readLine());
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			c=Integer.parseInt(st.nextToken());
			d=Integer.parseInt(st.nextToken());
			//(b,a), (d,c)   
			for(int i=b;i<d;i++) {
				for(int j=a;j<c;j++) {
					map[i][j]++;
					visited[i][j]=true;
				}
			}
		}
		int ans=0;
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j]==0&&!visited[i][j]) {
					list.add(bfs(i,j));
					ans++;
				}
			}
		}
		
		System.out.println(ans);
		Collections.sort(list);
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+" ");
		}
	}
	private static int bfs(int r, int c) {
		// TODO Auto-generated method stub
		q.add(new Point(r,c));
		visited[r][c]=true;
		int count=1;
		
		while(!q.isEmpty()) {
			Point p=q.poll();
			
			for(int i=0;i<dir.length;i++) {
				int nr=p.x+dir[i][0];
				int nc=p.y+dir[i][1];
				
				if(nr<0||nc<0||nr>=m||nc>=n||visited[nr][nc])
					continue;
				else {
					q.add(new Point(nr,nc));
					visited[nr][nc]=true;
					count++;
				}
			}
		}
		return count;
	}

}
