package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4615_재미있는오셀로게임 {
	private static int[][] board;
	private static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 보드 한 변의 길이
			int M = Integer.parseInt(st.nextToken()); // 돌을 놓을 횟수

			board = new int[N + 1][N + 1]; // 바둑판

			// ** 1. 먼저 기본 setting 바둑돌 4개 먼저 놓여있어야 해!
			int basicX = N / 2;
			int basicY = N / 2;

			board[basicX][basicY] = board[basicX + 1][basicY + 1] = 2;
			board[basicX + 1][basicY] = board[basicX][basicY + 1] = 1;

			// 2. M번 만큼 바둑돌 놓기
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());

				int y = Integer.parseInt(st.nextToken()); // y좌표
				int x = Integer.parseInt(st.nextToken()); // x좌표
				int color = Integer.parseInt(st.nextToken()); // 1이면 흑돌, 2면 백돌

				board[x][y] = color;

				// 3. 놓은 돌의 상하좌우, 대각선 4방, 총 8방을 비교해서 흑돌, 백돌 변경
				for (int k = 0; k < 8; k++) {
					int nx = x + dr[k];
					int ny = y + dc[k];

					// 범위 체크
					if (nx <= N && nx >= 1 && ny <= N && ny >= 1) {
						if (board[x][y] != board[nx][ny]) { // 확인하는 위치가 자신과 다른 색의 돌이 놓여있는 경우
							// 사잇 값(현재값, 팔방을 탐색한 값)을 변환하는 코드
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
			} // 돌을 놓는 모든 경우가 끝나면

			// board를 돌면서 흑돌(1)의 개수, 백돌(2)의 개수 출력
			int blackCount = 0; // 흑돌의 개수
			int whiteCount = 0; // 백돌의 개수

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

	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 }; // 위에서부터 시계방향으로 8방
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 }; // 위에서부터 시계방향으로 8방

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
