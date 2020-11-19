package com.ssafy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1389_케빈베이컨의6단계법칙_200826 {

	static int N, M;
	static int[][] arr;
	static int[] check;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N+1][N+1];
		
		
		for(int i=0; i<M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		
		int min = Integer.MAX_VALUE;
		int index = 0;
		
		for(int i=1; i<=N; i++) {
			if(min > bfs(i)) {
				min = bfs(i);
				index = i;
			}
		}

		System.out.println(index);
		

	}

	private static int bfs(int n) {
		check = new int[N+1];
		Arrays.fill(check, -1);
		check[n] = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i=1; i<=N; i++) {
			if(arr[n][i] == 1) {
				check[i] = 1;
				q.add(i);
			}
				
		}
		
		while(!q.isEmpty()) {
			int num = q.poll();
			
			
			for(int i=1; i<check.length; i++) {
				if(arr[num][i] == 1 && check[i] == -1) {
					q.add(i);
					check[i] = check[num]+1;
				}
			}
			
		}
		
		int cnt = 0;
		for(int i=1; i<check.length; i++) {
			cnt += check[i];
		}
		return cnt;
		
	}

	
	
	

}
