package BFS_DFS;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2178_미로탐색_200817{

	static int map[][], dir[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static boolean visited[][];
	static int N, M, cnt = 1;
	static Queue<Point> queue = new LinkedList<>();

	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1;
		String st2;
		st1 = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st1.nextToken());
		M = Integer.parseInt(st1.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st2 = bf.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = (st2.charAt(j) - '0');
			}
		}
		queue.add(new Point(0, 0));
		visited[0][0] = true;
		bfs();
	}

	private static void bfs() {
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			int r = p.y;
			int c = p.x;
			int nr, nc;
			for (int i = 0; i < dir.length; i++) {
				nr = r + dir[i][0];
				nc = c + dir[i][1];
				if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
					if (map[nr][nc] == 1 && visited[nr][nc] == false) {
						queue.add(new Point(nc, nr));
						map[nr][nc] = map[r][c] + 1;
						visited[nr][nc] = true;
					}
				}
				if (nr == N - 1 && nc == M - 1) {
					System.out.println(map[nr][nc]);
					System.exit(0);
				}
			}
		}
	}
}

