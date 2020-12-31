package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4615_����ִ¿����ΰ��� {
	private static int[][] board;
	private static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // ���� �� ���� ����
			int M = Integer.parseInt(st.nextToken()); // ���� ���� Ƚ��

			board = new int[N + 1][N + 1]; // �ٵ���

			// ** 1. ���� �⺻ setting �ٵϵ� 4�� ���� �����־�� ��!
			int basicX = N / 2;
			int basicY = N / 2;

			board[basicX][basicY] = board[basicX + 1][basicY + 1] = 2;
			board[basicX + 1][basicY] = board[basicX][basicY + 1] = 1;

			// 2. M�� ��ŭ �ٵϵ� ����
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());

				int y = Integer.parseInt(st.nextToken()); // y��ǥ
				int x = Integer.parseInt(st.nextToken()); // x��ǥ
				int color = Integer.parseInt(st.nextToken()); // 1�̸� �浹, 2�� �鵹

				board[x][y] = color;

				// 3. ���� ���� �����¿�, �밢�� 4��, �� 8���� ���ؼ� �浹, �鵹 ����
				for (int k = 0; k < 8; k++) {
					int nx = x + dr[k];
					int ny = y + dc[k];

					// ���� üũ
					if (nx <= N && nx >= 1 && ny <= N && ny >= 1) {
						if (board[x][y] != board[nx][ny]) { // Ȯ���ϴ� ��ġ�� �ڽŰ� �ٸ� ���� ���� �����ִ� ���
							// ���� ��(���簪, �ȹ��� Ž���� ��)�� ��ȯ�ϴ� �ڵ�
							if (board[nx][ny] == 0)
								continue;
							if (sameColorCheck(x, y, k, board[x][y])) {
								while (true) {
									if (board[x][y] == board[nx][ny])
										break;
									board[nx][ny] = board[x][y];
									nx += dr[k];
									ny += dc[k];
								}
							}
						}
					}
				}
			} // ���� ���� ��� ��찡 ������

			// board�� ���鼭 �浹(1)�� ����, �鵹(2)�� ���� ���
			int blackCount = 0; // �浹�� ����
			int whiteCount = 0; // �鵹�� ����

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (board[i][j] == 1)
						blackCount += 1;
					else if (board[i][j] == 2)
						whiteCount += 1;
				}
			}

			System.out.println("#" + tc + " " + blackCount + " " + whiteCount);

		} // end of testCase
	} // end of main

	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 }; // ���������� �ð�������� 8��
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 }; // ���������� �ð�������� 8��

	private static boolean sameColorCheck(int x, int y, int k, int color) {
		int nx = x;
		int ny = y;

		while (true) {
			nx += dr[k];
			ny += dc[k];

			if (nx > N || ny > N || nx < 0 || ny < 0 || board[nx][ny] == 0)
				break;

			if (board[nx][ny] == color)
				return true;

		}
		return false;
	}
}
