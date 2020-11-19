package com.ssafy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1043_거짓말_200826 {

	static int N, M, K;
	static boolean[] visit;
	static int[][] party, map;
	static LinkedList<Integer> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st  =new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st  = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		q = new LinkedList<Integer>();
		visit = new boolean[N+1];
		for (int i = 0; i < K; i++) {
			int n = Integer.parseInt(st.nextToken());
			q.offer(n);
			visit[n] = true;
		}
		
		party = new int[M][];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int party_N = Integer.parseInt(st.nextToken());
			int[] sub_party = new int[party_N];
			for (int j = 0; j < party_N; j++) {
				sub_party[j] = Integer.parseInt(st.nextToken());
			}
			party[i] = sub_party;
		}
		
		map = new int[N+1][N+1];
		checkMap();
		checkVisit();
		int ans = 0;
		OUTER : for(int i = 0; i < party.length; i++) {
			for (int j = 0; j < party[i].length; j++) {
				if(visit[party[i][j]] == true)
					continue OUTER;
			}
			ans++;
		}
		System.out.println(ans);
	}
	
	public static void checkMap() {
		for (int i = 0; i < party.length; i++) {
			for (int j = 0; j < party[i].length-1; j++) {
				map[party[i][j]][party[i][j+1]] = map[party[i][j+1]][party[i][j]] = 1;
			}
		}
	}
	
	public static void checkVisit() {
		while(!q.isEmpty()) {
			int now = q.poll();
			for (int i = 1; i < map.length; i++) {
				if(map[now][i] == 1 && visit[i] == false) {
					visit[i] = true;
					q.offer(i);
				}
			}
		}
	}

}
