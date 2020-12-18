package com.ssafy.newStudy3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1717_집합의표현 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] set = new int[n+1];
		initSet(set);
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(x == 0) {
				union(a, b, set);
				
//				for (int j = 0; j < set.length; j++) {
//					System.out.print(set[j] + " ");
//				}
//				System.out.println();
			}
			else {
				System.out.println(isSet(a, b, set));
			}
		}
	}

	private static void initSet(int[] set) {
		for (int i = 0; i < set.length; i++) {
			set[i] = i;
		}
	}

	private static void union(int a, int b, int[] set) {
		int aRoot = findRoot(a, set);
		int bRoot = findRoot(b, set);
		
		if(aRoot < bRoot) {
			set[bRoot] = aRoot;
		}
		else {
			set[aRoot] = bRoot;
		}
	}

	private static int findRoot(int a, int[] set) {
		if(set[a] == a)	return a;
		return set[a] = findRoot(set[a], set);
	}

	private static String isSet(int a, int b, int[] set) {
		if(findRoot(a, set) == findRoot(b, set))	return "YES";
		return "NO";
	}

}
