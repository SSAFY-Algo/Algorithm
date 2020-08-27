package GRAPH;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1389_케빈베이컨 {

	static int N, M,index;
	static boolean[] visited;
	static int[] min;
	static int[][] graph, kevins;
	static Queue<Integer> queue = new LinkedList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		graph = new int[N + 1][N + 1];
		min=new int[N+1];
		
		int r, c, MIN = 1000;
		for (int i = 0; i < M; i++) {
			r = sc.nextInt();
			c = sc.nextInt();
			graph[r][c] = graph[c][r] = 1;
		}

		for (int i = 1; i <= N; i++) {
			init();
			for (int j = 1; j <= N; j++) {
				if (graph[i][j] == 1) {
					queue.offer(j);
					visited[j]=true;
					kevins[i][j] =kevins[j][i]= 1;
				}
			}
			min[i]=bfs(i);
		}
		for(int i=1;i<=N;i++) {
			if(MIN>min[i]) {
				MIN=min[i];
				index=i;
			}
		}
		System.out.println(index);
		sc.close();
		
	}

	static void init() {
		kevins = new int[N + 1][N + 1];		
		visited=new boolean[N+1];
	}
	static int bfs(int n) {
		int sum=0;
		
		visited[n]=true;
		while(!queue.isEmpty()) {
			int ver=queue.poll();
			for(int i=1;i<=N;i++) {	//1 - 3,4 3-4
				if(graph[ver][i]==1&&!visited[i]) {
					queue.offer(i);
					visited[i]=true;
					kevins[n][i]=kevins[n][ver]+1;
				}
			}
		}
		for(int i=1;i<=N;i++) {
			sum+=kevins[n][i];
		}
		return sum;
	}

}
