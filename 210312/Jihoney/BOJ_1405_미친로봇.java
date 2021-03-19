package sc_210312;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1405_미친로봇 {
	static int cnt, dir[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static double direction[], res = 0;
	static boolean visited[][];

	// 전체경로의수 - 중첩되는경로의수 = 단순한 경로의 수
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		cnt = Integer.parseInt(st.nextToken());
		direction = new double[4];
		visited = new boolean[30][30];

		for (int i = 0; i < 4; i++)
			direction[i] = Double.parseDouble(st.nextToken()) / 100;

		visited[15][15]=true;
		dfs(15, 15, 0, 1);

		System.out.println(res);

	}

	private static void dfs(int r, int c, int move, double percentage) {
		// TODO Auto-generated method stub
		if (move == cnt) {
			res += percentage;
			return;
		}

		for (int d = 0; d < dir.length; d++) {
			int nr = r + dir[d][0];
			int nc = c + dir[d][1];

			if (nr >= 0 && nc >= 0 && nr < 30 && nc < 30 && !visited[nr][nc]) {
				visited[nr][nc] = true;
				dfs(nr, nc, move + 1, percentage * direction[d]);
				visited[nr][nc] = false;
			}
		}
	}

}
