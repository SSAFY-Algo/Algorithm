package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10836_���չ� {
	private static int[][] map;
	private static int M;
	private static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		BOJ_10836_���չ� BeeProblem = new BOJ_10836_���չ�();

		M = Integer.parseInt(st.nextToken()); // ������ ũ��
		N = Integer.parseInt(st.nextToken()); // ������Ʈ �� �ֹ��� ����� ��

		map = new int[M][M];

		for (int tc = 0; tc < N; tc++) {
			int[] add = new int[2 * M - 1];
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			for (int i = 1; i < 3; i++) {
				int n = Integer.parseInt(st.nextToken());
				for (int k = 0; k < n; k++) { // 0, 1, 2�� ����
					add[idx++] = i;
				}
			}

			BeeProblem.beeHome(add); // ������ �ش� �迭�� �ѹ��� ������ update

		}

//		BeeProblem.insideUpdate();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				if (i >= 1 && j >= 1) {
					map[i][j] = map[i - 1][j];
				} else {
					map[i][j] = map[i][j] + 1;
				}
				sb.append(map[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

	private void beeHome(int[] add) {
		int r = M - 1;
		int c = 0;

		for (int i = 0; i < add.length; i++) {
			if (r > 0) {
				map[r--][0] += add[i];
			} else {
				map[0][c++] += add[i];
			}
		}

	}

	private void insideUpdate() {
		for (int i = 1; i < M; i++) {
			for (int j = 1; j < M; j++) {
				map[i][j] = map[i - 1][j];
			}
		}
	}
}
