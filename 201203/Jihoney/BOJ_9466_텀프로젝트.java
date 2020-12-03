package GRAPH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//그래프 ANS: 전체노드-사이클을 이루는 노드의 개수
public class BOJ_9466_텀프로젝트 {

	static int n, input[], cnt;// cnt는 사이클의 개수가 아닌, 사이클을 이루는 노드의 개수!
	static boolean visited[], node[];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(bf.readLine());
		for (int t = 0; t < tc; t++) {
			n = Integer.parseInt(bf.readLine());
			cnt = 0;
			input = new int[n + 1];
			visited = new boolean[n + 1];
			node = new boolean[n + 1];
			st = new StringTokenizer(bf.readLine());
			for (int i = 1; i <= n; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			for (int j = 1; j <= n; j++) {
				if (!visited[j]) {
					dfs(j);
				}
			}
			System.out.println(n - cnt);
		}
	}

	static void dfs(int cur) {
		visited[cur] = true;
		int next = input[cur];
		if (!visited[next])
			dfs(next);
		else if (visited[next] && !node[next]) { // 사이클
			cnt++;// 자신
			for (int i = next; i != cur; i = input[i]) {//사이클 돌면서 체크
				cnt++;
				node[i] = true;
			}
		}
		node[cur] = true;//더 이상 방문하지 않아도되는 노드
	}
}
