package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1717 {

	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		parent = new int[N+1];
		init();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int operation = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			switch (operation) {
			case 0:
				union(a, b);
				break;
			case 1:
				if(find(a) != find(b))
					System.out.println("NO");
				else
					System.out.println("YES");
				break;
			default:
				break;
			}
		}
	}

	private static int find(int a) {
		if(parent[a] == a)
			return a;
		else
			return parent[a] = find(parent[a]);
	}

	private static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if(a < b) {
			parent[pb] = pa;
		}else {
			parent[pa] = pb;
		}
	}

	private static void init() {
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
	}
	
	

}
