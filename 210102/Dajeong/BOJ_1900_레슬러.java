package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1900_레슬러 {
	
	static class Player implements Comparable<Player> {
		int n;
		int p;
		int m;
		
		public Player(int n, int p, int m) {
			this.n = n;
			this.p = p;
			this.m = m;
		}

		@Override
		public int compareTo(Player o) {
			return (o.p + this.p * o.m) - (this.p + o.p * this.m);
		}
		
		
		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Player> list = new ArrayList<>();
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(new Player(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			
		}
		
		Collections.sort(list);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).n);
		}
		
	}

}
