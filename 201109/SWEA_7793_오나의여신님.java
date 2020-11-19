package SWEA;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_7793_오나의여신님 {

	static int tc, N, M, time, cnt, dir[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }, sc, sr;
	static char map[][];
	static boolean visited[][];
	static Queue<Point> devil = new LinkedList<>();
	static Queue<Point> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		tc = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= tc; t++) {
			time = 0;
			cnt = 0;
			st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			visited = new boolean[N][M];

			for (int i = 0; i < N; i++) {
				String str = bf.readLine();
				for (int j = 0; j < M; j++) {
					map[i][j] = str.charAt(j);
					if (map[i][j] == 'S') {
						q.add(new Point(i, j));
					}
					if (map[i][j] == '*')
						devil.add(new Point(i, j));
				}
			}
			bfs();
			if(cnt==0)
				System.out.println("Game Over");
			else
				System.out.println(cnt);
		}
	}
 
	static void bfs() {

		while (!q.isEmpty()) {
			
			int devlen = devil.size();
			for (int i = 0; i < devlen; i++) { // 1초에 이동할수 있는 상하좌우 범위가 존재하므로
				Point p = devil.poll();
				int dr = p.x;
				int dc = p.y;
				for (int d = 0; d < dir.length; d++) {
					int ndr = dr + dir[d][0];
					int ndc = dc + dir[d][1];

					if (ndr >= 0 && ndr < N && ndc >= 0 && ndc < M) {
						if (map[ndr][ndc] == '.' || map[ndr][ndc] == 'S') {
							map[ndr][ndc] = '*';
							devil.add(new Point(ndr, ndc));
						}
					}
				}
			}

			int len = q.size();
			for (int i = 0; i < len; i++) {
				Point p = q.poll();
				int r = p.x;
				int c = p.y;
				for (int d = 0; d < dir.length; d++) {
					int nr = r + dir[d][0];
					int nc = c + dir[d][1];

					if (nr >= 0 & nr < N && nc >= 0 && nc < M) {
						if (map[nr][nc] == '.') {
							q.add(new Point(nr, nc));
						}
						if (map[nr][nc] == 'D') {
							cnt = time + 1;
							return;
						}
					}
				}
			}
			time++;
		}

	}
}
