package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14442_벽부수기2_0903 {

	static int N, M, K, cnt;
	static int[][] map, dir = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static boolean[][][] visited;
	static Queue<int[]> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException { // 벽 부수면 경로 단축
		// TODO Auto-generated method stub

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M][K + 1];

		for (int i = 0; i < N; i++) {
			String str = bf.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		queue.offer(new int[] { 0, 0, 0, 1 });
		visited[0][0][0] = true;
		bfs();

		System.out.println(cnt);
	}

	private static void bfs() {
		int r, c, nr, nc, k, n;
		boolean flag=false;
		while (!queue.isEmpty()) {
			int[] arr = queue.poll();
			r = arr[0];
			c = arr[1];
			k = arr[2];
			n = arr[3];

			if (r == N - 1 && c == M - 1) {
				cnt = n;
				flag=true;
				break;
			}
			for (int d = 0; d < dir.length; d++) {
				nr = r + dir[d][0];
				nc = c + dir[d][1];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
				else {
					if (!visited[nr][nc][k]) {
						if (map[nr][nc] == 0) {
							queue.offer(new int[] { nr, nc, k, n + 1 });
							visited[nr][nc][k] = true;
						} else if (map[nr][nc] == 1) {
							if (k < K) {
								queue.offer(new int[] { nr, nc, k + 1, n + 1 });
								visited[nr][nc][k + 1] = true;
							}
						}
					}
				}
			}
		}
		if(!flag)
			cnt=-1;
	}

}
