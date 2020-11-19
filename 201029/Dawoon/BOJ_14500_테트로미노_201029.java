package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_14500_테트로미노_201029 {

	static int ans = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		check1(map);
		check2(map);
		check3(map);
		check4(map);
		check5(map);
		
		System.out.println(ans);
		
	}
	private static void check1(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length-3; j++) {
				int sum = map[i][j] + map[i][j+1] + map[i][j+2] + map[i][j+3];
				if(sum > ans)
					ans = sum;
			}
		}
		
		for (int i = 0; i < map.length-3; i++) {
			for (int j = 0; j < map[i].length; j++) {
				int sum = map[i][j] + map[i+1][j] + map[i+2][j] + map[i+3][j];
				if(sum > ans)
					ans = sum;
			}
		}
		
	}
	
	private static void check2(int[][] map) {
		for (int i = 0; i < map.length-1; i++) {
			for (int j = 0; j < map[i].length-1; j++) {
				int sum = map[i][j] + map[i][j+1] + map[i+1][j] + map[i+1][j+1];
				if(sum > ans)
					ans = sum;
			}
		}
	}
	
	private static void check3(int[][] map) {
		for (int i = 0; i < map.length-1; i++) {
			for (int j = 0; j < map[i].length-2; j++) {
				int sum = map[i][j] + map[i+1][j] + map[i+1][j+1] + map[i+1][j+2];
				if(sum > ans)
					ans = sum;
			}
		}
		
		for (int i = 1; i < map.length; i++) {
			for (int j = 0; j < map[i].length-2; j++) {
				int sum = map[i][j] + map[i][j+1] + map[i][j+2] + map[i-1][j+2];
				if(sum > ans)
					ans = sum;
			}
		}
		
		for (int i = 0; i < map.length-2; i++) {
			for (int j = 0; j < map[i].length-1; j++) {
				int sum = map[i][j] + map[i+1][j] + map[i+2][j] + map[i+2][j+1];
				if(sum > ans)
					ans = sum;
			}
		}
		
		for (int i = 0; i < map.length-2; i++) {
			for (int j = 0; j < map[i].length-1; j++) {
				int sum = map[i][j] + map[i][j+1] + map[i+1][j+1] + map[i+2][j+1];
				if(sum > ans)
					ans = sum;
			}
		}
		
		for (int i = 2; i < map.length; i++) {
			for (int j = 0; j < map[i].length-1; j++) {
				int sum = map[i][j] + map[i][j+1] + map[i-1][j+1] + map[i-2][j+1];
				if(sum > ans)
					ans = sum;
			}
		}
		
		for (int i = 0; i < map.length-1; i++) {
			for (int j = 0; j < map[i].length-2; j++) {
				int sum = map[i][j] + map[i][j+1] + map[i][j+2] + map[i+1][j+2];
				if(sum > ans)
					ans = sum;
			}
		}
		
		for (int i = 0; i < map.length-2; i++) {
			for (int j = 0; j < map[i].length-1; j++) {
				int sum = map[i][j] + map[i+1][j] + map[i+2][j] + map[i][j+1];
				if(sum > ans)
					ans = sum;
			}
		}
		
		for (int i = 0; i < map.length-1; i++) {
			for (int j = 0; j < map[i].length-2; j++) {
				int sum = map[i][j] + map[i+1][j] + map[i][j+1] + map[i][j+2];
				if(sum > ans)
					ans = sum;
			}
		}
	}
	private static void check4(int[][] map) {
		for (int i = 0; i < map.length-2; i++) {
			for (int j = 0; j < map[i].length-1; j++) {
				int sum = map[i][j] + map[i+1][j] + map[i+1][j+1] + map[i+2][j+1];
				if(sum > ans)
					ans = sum;
			}
		}

		for (int i = 1; i < map.length; i++) {
			for (int j = 0; j < map[i].length-2; j++) {
				int sum = map[i][j] + map[i][j+1] + map[i-1][j+1] + map[i-1][j+2];
				if(sum > ans)
					ans = sum;
			}
		}
		
		for (int i = 0; i < map.length-2; i++) {
			for (int j = 1; j < map[i].length; j++) {
				int sum = map[i][j] + map[i+1][j] + map[i+1][j-1] + map[i+2][j-1];
				if(sum > ans)
					ans = sum;
			}
		}
		
		for (int i = 0; i < map.length-1; i++) {
			for (int j = 0; j < map[i].length-2; j++) {
				int sum = map[i][j] + map[i][j+1] + map[i+1][j+1] + map[i+1][j+2];
				if(sum > ans)
					ans = sum;
			}
		}
	}
	
	private static void check5(int[][] map) {
		for (int i = 0; i < map.length-1; i++) {
			for (int j = 0; j < map[i].length-2; j++) {
				int sum = map[i][j] + map[i][j+1] + map[i][j+2] + map[i+1][j+1];
				if(sum > ans)
					ans = sum;
			}
		}
		
		for (int i = 1; i < map.length; i++) {
			for (int j = 0; j < map[i].length-2; j++) {
				int sum = map[i][j] + map[i][j+1] + map[i][j+2] + map[i-1][j+1];
				if(sum > ans)
					ans = sum;
			}
		}
		
		for (int i = 0; i < map.length-2; i++) {
			for (int j = 0; j < map[i].length-1; j++) {
				int sum = map[i][j] + map[i+1][j] + map[i+2][j] + map[i+1][j+1];
				if(sum > ans)
					ans = sum;
			}
		}
		
		for (int i = 0; i < map.length-2; i++) {
			for (int j = 1; j < map[i].length; j++) {
				int sum = map[i][j] + map[i+1][j] + map[i+2][j] + map[i+1][j-1];
				if(sum > ans)
					ans = sum;
			}
		}
	}
}
