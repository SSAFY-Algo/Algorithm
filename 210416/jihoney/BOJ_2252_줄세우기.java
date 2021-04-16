package sc_210416;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2252_줄세우기 {

	static int N,M,indegree[];
	static ArrayList<Integer> list[];
	static ArrayList<Integer> res=new ArrayList<>();
	static Queue<Integer> q=new LinkedList<>();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		indegree=new int[N+1];
		// 1 3   1 --> 3, 2 3  2 --> 3
		list=new ArrayList[N+1];
		
		for(int i=1;i<=N;i++) {
			list[i]=new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(bf.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			
			list[a].add(b); // a보다 작은애들 = a,b 사이의 간선
			indegree[b]++;
		}
		sort();
		for(int i=0;i<res.size();i++) {
			System.out.print(res.get(i)+" ");
		}
	}
	private static void sort() {
		// TODO Auto-generated method stub
		for(int i=1;i<=N;i++) {
			if(indegree[i]==0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int num=q.poll();
			//간선 없애고, 하나 줄여주고
			for(int i=0;i<list[num].size();i++) {
				int node=list[num].get(i);
				indegree[node]--;
				if(indegree[node]==0) {
					q.add(node);
				}
			}
			res.add(num);
		}
	}

}
