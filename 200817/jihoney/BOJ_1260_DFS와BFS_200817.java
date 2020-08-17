package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1260_DFS와BFS_200817 {

	static int N, M, V;
	static boolean[] bfsVisited, dfsVisited;
	static boolean[][] map;

	static Queue<Integer> queue = new LinkedList<>();

	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int start, dest;
		st = new StringTokenizer(bf.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		map = new boolean[N + 1][N + 1];
		bfsVisited = new boolean[N + 1];
		dfsVisited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			start = Integer.parseInt(st.nextToken());
			dest = Integer.parseInt(st.nextToken());

			map[start][dest] = map[dest][start] = true;

		}

		dfs(V);
		System.out.println();
		bfs(V);
	}

	static void bfs(int vertex) {
		int front;
		queue.offer(vertex);
		bfsVisited[vertex] = true;
		while (!queue.isEmpty()) {
			front = queue.poll();
			System.out.print(front + " ");
			for (int i = 1; i <= N; i++) {
				if (map[front][i] == true && bfsVisited[i] == false) {// 간선이 존재하고 아직 방문하지 않았다면
					queue.offer(i);
					bfsVisited[i] = true;
				}
			}

		}

	}

	static void dfs(int vertex) {
		dfsVisited[vertex]=true;
		System.out.print(vertex+" ");
		for(int i=1;i<=N;i++) {
			if(map[vertex][i]==true&&dfsVisited[i]==false) {
				dfs(i);
			}
		}
		
	}
}
