package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1717_집합의표현 {

	private static int[] p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		p = new int[n+1];
		for(int i=1; i<=n; i++) {
			p[i] = i;
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(num == 0) {
				union(a,b);
			}
			if(num == 1) {
				if(find(a) == find(b)) System.out.println("YES");
				else System.out.println("NO");
			}
		}
		
		
	}

	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return;
		
		if(aRoot > bRoot) p[bRoot] = aRoot;
		else p[aRoot] = bRoot;
		
		
	}

	private static int find(int x) {
		if(x == p[x]) return x;
		return p[x] = find(p[x]);
	}

}
