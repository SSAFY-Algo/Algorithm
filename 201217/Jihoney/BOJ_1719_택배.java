package GRAPH;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1719_택배 {
	static int n,m,res[],dist[];
	static ArrayList<Node> list[];
	static PriorityQueue<Node> pq;
	
	public static void main(String args[]) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		StringBuilder sb;
		int idx,v,w,index;
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		list=new ArrayList[n+1];	// 각 정점에 대하여 인접한 정점과 가중치를 저장하기
		
		for(int i=1;i<=n;i++) {
			list[i]=new ArrayList<>();
		}
		
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(bf.readLine());
			idx=Integer.parseInt(st.nextToken());
			v=Integer.parseInt(st.nextToken());
			w=Integer.parseInt(st.nextToken());
			
			list[idx].add(new Node(v,w));
			list[v].add(new Node(idx,w));	//양방향 그래프이므로 출발,도착정점에 둘다 저장
			
		}
		
		for(int i=1;i<=n;i++) {
			sb=new StringBuilder();
			init();
			dijkstra(i);
//			System.out.println(Arrays.toString(res));
			for(int j=1;j<=n;j++) {
				index=j;
				if(index==i)
					sb.append("-");
				else {
					if(res[index]==i) {// 직전 경유지가 루트 노드라면
						sb.append(index);
					}
					else {
						while(true) {
							if(res[index]==i) {	// 직전 경유지가 루트 노드라면
								sb.append(index);
								break;
							}
							index=res[index];	// 부모 찾아가기
						}
					}
				}
				sb.append(" ");
			}
			System.out.println(sb.toString());
		}
	}

	private static void init() {// 초기화
		// TODO Auto-generated method stub
		dist=new int[n+1];
		res=new int[n+1];
		pq=new PriorityQueue<Node>();
		Arrays.fill(dist, Integer.MAX_VALUE);
	}

	private static void dijkstra(int i) {
		// TODO Auto-generated method stub
		dist[i]=0;
		pq.add(new Node(i,dist[i]));
		
		while(!pq.isEmpty()) {
			Node node=pq.poll();
			int curNode=node.vertex;//현재부터 탐색할 노드
			int curWeight=node.weight;
			
			if(dist[curNode]<curWeight)// 최소값이 이미 있다면 넘어가기
				continue;
			
			for(Node next:list[curNode]) {	// 현재 노드와 인접한 노드
				if(dist[next.vertex]>dist[curNode]+next.weight) {
					dist[next.vertex]=dist[curNode]+next.weight;
					res[next.vertex]=curNode;	// next.vertex를 오기위해선 직전 curNode를 경유해야 함
					pq.add(new Node(next.vertex,dist[next.vertex]));
				}
			}
		}
	}
}

class Node implements Comparable<Node>{
	int vertex;	// 정점
	int weight; // 가중치
	
	public Node(int vertex, int weight) {
		super();
		this.vertex = vertex;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return this.weight-o.weight;
	}
}