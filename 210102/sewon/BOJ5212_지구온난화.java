package com.ssafy.newStudy5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ5212_지구온난화 {

	static int[][] dir = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][C];
		
		for (int r = 0; r < R; r++) {
			map[r] = br.readLine().toCharArray();
		}
		
		boolean[][] note = new boolean[R][C];
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(map[r][c] == 'X') {
					int count = 0;
					for (int i = 0; i <4; i++) {
						int nr = r + dir[i][0];
						int nc = c + dir[i][1];
						
						if(nr < 0 || nr >= R || nc < 0 || nc >= C)	count++;
						else if(nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == '.')	count++;
					}
					
					if(count >= 3)	note[r][c] = true;
				}
			}
		}
		
		
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(note[r][c])	map[r][c] = '.';
			}
		}
		
		int top, bottom, left, right;
		for (top = 0; top < R; top++) {
			boolean isEmpty = true;
			for (int c = 0; c < C; c++) {
				if(map[top][c] == 'X') {
					isEmpty = false;
					break;
				}
			}
			if(!isEmpty)	break;
		}
		
		for (bottom = R-1; bottom >= 0; bottom--) {
			boolean isEmpty = true;
			for (int c = 0; c < C; c++) {
				if(map[bottom][c] == 'X') {
					isEmpty = false;
					break;
				}
			}
			if(!isEmpty)	break;
		}
		
		for (left = 0; left < C; left++) {
			boolean isEmpty = true;
			for (int r = top; r <= bottom; r++) {
				if(map[r][left] == 'X') {
					isEmpty = false;
					break;
				}
			}
			if(!isEmpty)	break;
		}
		
		for (right = C-1; right >= 0; right--) {
			boolean isEmpty = true;
			for (int r = top; r <= bottom; r++) {
				if(map[r][right] == 'X') {
					isEmpty = false;
					break;
				}
			}
			if(!isEmpty)	break;
		}
		
		
		for (int i = top; i <= bottom; i++) {
			for (int j = left; j <= right; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}		
	}

}
