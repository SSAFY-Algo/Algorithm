package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_11403 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		int[][] map = new int[N][N]; 
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new ArrayList<Integer>());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1)
					list.get(i).add(j);
			}
		}

		for (int i = 0; i < N; i++) {
			LinkedList<Integer> q = new LinkedList<Integer>();
			boolean[] visit = new boolean[N];
			for (int j = 0; j < list.get(i).size(); j++) {
				q.offer(list.get(i).get(j));
			}
			ArrayList<Integer> numList = bfs(q, map, list, visit);
			for (int j = 0; j < numList.size(); j++) {
				map[i][numList.get(j)] = 1;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}

	private static ArrayList<Integer> bfs(LinkedList<Integer> q, int[][] map, ArrayList<ArrayList<Integer>> list, boolean[] visit) {
		ArrayList<Integer> numList = new ArrayList<Integer>();
		while(!q.isEmpty()) {
			int now = q.poll();
			numList.add(now);
			for (int i = 0; i < list.get(now).size(); i++) {
				int to = list.get(now).get(i);
				if(!visit[to]) {
					visit[to] = true;
					q.offer(to);
				}
			}
		}
		return numList;
	}

//	static class Node{
//		int v;
//		int to;
//		public Node(int v, int to) {
//			this.v = v;
//			this.to to;
//		}
//	}
}
