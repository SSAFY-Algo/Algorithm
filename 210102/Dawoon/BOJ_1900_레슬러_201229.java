package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1900_레슬러_201229 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Wrestler> wresList = new ArrayList<Wrestler>();
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int power = Integer.parseInt(st.nextToken());
			int ring = Integer.parseInt(st.nextToken());
			wresList.add(new Wrestler(i, power, ring));
		}
		
		fight(wresList);
		
		Collections.sort(wresList, new Comparator<Wrestler>() {

			@Override
			public int compare(Wrestler o1, Wrestler o2) {
				return o2.win - o1.win;
			}
		});
		
		for (int i = 0; i < wresList.size(); i++) {
			System.out.println(wresList.get(i).n);
		}
	}

	private static void fight(ArrayList<Wrestler> wresList) {
		for (int i = 0; i < wresList.size(); i++) {
			for (int j = i+1; j < wresList.size(); j++) {
				Wrestler a = wresList.get(i);
				Wrestler b = wresList.get(j);
				if(a.power + (a.ring * b.power) > b.power + (b.ring * a.power))
					a.win++;
				else
					b.win++;
			}
		}
		
	}

	static class Wrestler{
		int n;
		int power;
		int ring;
		int win = 0;
		public Wrestler(int n, int power, int ring) {
			super();
			this.n = n;
			this.power = power;
			this.ring = ring;
		}
	}
}
