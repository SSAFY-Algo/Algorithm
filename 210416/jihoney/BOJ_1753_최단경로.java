package sc_210416;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1753_최단경로 {

	static int dist[],graph[][];
	static boolean visited[];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		//input
		int V=Integer.parseInt(st.nextToken());
		int E=Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(bf.readLine());
		int K=Integer.parseInt(st.nextToken());
		
		dist=new int[V+1];
		visited=new boolean[V+1];
		graph=new int[V+1][V+1];
		
		for(int i=0;i<E;i++) {
			st=new StringTokenizer(bf.readLine());
			int u=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			
			graph[u][v]=w;
		}
		
		//init
		for(int i=1;i<=V;i++) {
			dist[i]=987654321;
		}
		
		//dijkstra
		dijkstra(K);
		
		//result
		for(int i=1;i<dist.length;i++) {
			if(dist[i]==987654321)
				System.out.println("INF");
			else
				System.out.println(dist[i]);
		}
	}
	private static void dijkstra(int start) {
		// TODO Auto-generated method stub
		dist[start]=0;
		visited[start]=true;
		
		for(int i=1;i<dist.length;i++) {
			if(!visited[i]&&graph[start][i]!=0) {
				dist[i]=graph[start][i];
			}
		}
		
		for(int i=1;i<dist.length;i++) {
			int idx=0;
			int minDist=987654321;
			for(int j=1;j<dist.length;j++) {
				//연결된 정점중 최소값
				if(!visited[j]&&dist[j]<minDist) {
					idx=j;
					minDist=dist[j];
				}
			}
			for(int k=1;k<dist.length;k++) {
				if(!visited[k]&&graph[idx][k]!=0) {
					if(dist[k]>dist[idx]+graph[idx][k]) {
						dist[k]=dist[idx]+graph[idx][k];
					}
				}
			}
			visited[idx]=true;
		}
	}
}
