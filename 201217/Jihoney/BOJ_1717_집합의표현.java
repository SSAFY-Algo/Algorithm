package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1717_집합의표현 {

	static int N,M,parents[];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		int mode,preSet,postSet;
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		make();
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(bf.readLine());
			mode=Integer.parseInt(st.nextToken());
			preSet=Integer.parseInt(st.nextToken());
			postSet=Integer.parseInt(st.nextToken());
			
			if(mode==0) {
				union(preSet,postSet);
			}else if(mode==1) {
				check(preSet,postSet);
			}
		}
	}
	private static void check(int preSet, int postSet) {
		// TODO Auto-generated method stub
		int x=find(preSet);
		int y=find(postSet);
		
		if(x==y)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
	
	private static int find(int num) {	//부모 노드 찾기
		// TODO Auto-generated method stub
		if(parents[num]==num)
			return num;
		
		return parents[num]=find(parents[num]);
	}
	
	private static void union(int preSet, int postSet) {
		// TODO Auto-generated method stub
		int x=find(preSet);
		int y=find(postSet);
	
		if(x<y)
			parents[y]=x;
		else
			parents[x]=y;
		
	}
	private static void make() {
		// TODO Auto-generated method stub
		parents=new int[N+1];
		for(int i=0;i<=N;i++) {
			parents[i]=i;	//{0},{1},{2},{3}....{n}
		}
	}

}
