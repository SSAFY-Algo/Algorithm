package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_4386_별자리만들기 {
	
	static class Vertex {
		int start;
		int end;
		double distance;
		
		public Vertex(int start, int end, double distance) {
			this.start = start;
			this.end = end;
			this.distance = distance;
		}
		
	}
	private static int[] p;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		double[][] stars = new double[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			stars[i][0] = Double.parseDouble(st.nextToken());
			stars[i][1] = Double.parseDouble(st.nextToken());
		}
		
		ArrayList<Vertex> list = new ArrayList<>();
		for (int i = 0; i < n-1; i++) {
			for (int j = i+1; j < n; j++) {
				list.add(new Vertex(i, j, Math.sqrt( Math.pow(stars[j][0]-stars[i][0], 2) + Math.pow(stars[j][1] - stars[i][1], 2))  ));
			}
		}
		
		Collections.sort(list, new Comparator<Vertex>() {

			@Override
			public int compare(Vertex o1, Vertex o2) {
				return (o1.distance < o2.distance) ? -1 : 1;
			}
		});
		
		
		// make
		p = new int[n];
		for (int i = 0; i < n; i++) {
			p[i] = i;
		}
		
		int cnt = 0;
		double result = 0;
		for (Vertex v : list) {
			if(cnt == n-1) break;
			
			if(!union(v.start, v.end)) { 
				cnt++;
				result += v.distance;
			}
		}
		
		System.out.println(Math.round(result*100)/100.0);
		
		
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return true;
		
		if(aRoot < bRoot)
			p[bRoot] = aRoot;
		else if(aRoot > bRoot)
			p[aRoot] = bRoot;
		return false;
	}
	
	private static int find(int a) {
		if(a == p[a]) return a;
		return p[a] = find(p[a]);
	}

}
