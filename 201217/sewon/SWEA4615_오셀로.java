package com.ssafy.newStudy3;

import java.util.Scanner;

public class SWEA4615_오셀로 {

	static int N;
	static int[][] board;
	static int[][] dir = { {-1,0}, {-1,-1}, {0,-1}, {1,-1}, {1,0}, {1,1}, {0,1}, {-1, 1} };
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int TC = 1; TC <=T; TC++) {
			N = sc.nextInt();
			int M = sc.nextInt();
			board = new int[N+1][N+1];
			
			initBoard(N);
			
			for (int i = 0; i < M; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int color = sc.nextInt();
				
				board[x][y] = color;
				
				// 8방탐색 시작
				for (int k = 0; k < 8; k++) {
					int nx = x + dir[k][0];
					int ny = y + dir[k][1];
					
					if(nx>0 && nx<=N && ny>0 && ny<=N
							&& board[nx][ny] != 0 && board[nx][ny] != color) {	// 색이 다른 경우
						
						// 색이 같은 돌을 만날 수 있는 경우
						if(isOKtoGo(nx, ny, k, color)) {
							while(nx>0 && nx<=N && ny>0 && ny<=N && board[nx][ny] != color) {
								board[nx][ny] = color;
								nx += dir[k][0];
								ny += dir[k][1];
							}
						}
					}
				} // end for k
			}
			
			System.out.print("#"+TC+" ");
			countBoard();
		}
		sc.close();
	}

	private static boolean isOKtoGo(int x, int y, int k, int color) {
		int nx = x + dir[k][0];
		int ny = y + dir[k][1];
		
		while(nx>0 && nx<=N && ny>0 && ny<=N && board[nx][ny] != 0) {
			if(board[nx][ny] == color)	return true;
			
			nx += dir[k][0];
			ny += dir[k][1];
		}
		return false;
	}

	private static void countBoard() {
		int black = 0;
		int white = 0;
		for (int i = 1; i < board.length; i++) {
			for (int j = 1; j < board.length; j++) {
				if(board[i][j] == 1)	black++;
				else if(board[i][j] == 2)	white++;
			}
		}
		
		System.out.println(black + " " + white);
	}
	
	private static void initBoard(int n) {
		int s = 2;
		if(n == 6) {
			s = 3;
		}
		else if(n == 8) {
			s = 4;
		}
		board[s][s] = 2;
		board[s][s+1] = 1;
		board[s+1][s] = 1;
		board[s+1][s+1] = 2;
	}

}
