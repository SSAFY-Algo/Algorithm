package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16987_계란으로계란치기_201028 {

	static int ans;
	static Egg[] eggList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		eggList = new Egg[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			eggList[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		Egg[] list = copyList(eggList);
		
		for (int j = 0; j < list.length; j++) {
			if(0 != j) {
				Egg[] temp = copyList(list);
				Hit(0, j, temp);
			}
		}
		
		System.out.println(ans);
	}

	private static Egg[] copyList(Egg[] eggList) {
		Egg[] temp = new Egg[eggList.length];
		for (int i = 0; i < eggList.length; i++) {
			temp[i] = new Egg(eggList[i]);
		}
		return temp;
	}

	private static void Hit(int i, int j, Egg[] list) {
		list[i].d -= list[j].w;
		list[j].d -= list[i].w;
		
		int sum = 0;
		for (int k = 0; k < list.length; k++) {
			if(list[k].d <= 0)
				sum++;
		}
		if(ans < sum)
			ans = sum;
		
		for (int k = i+1; k < list.length; k++) {
			if(list[k].d <= 0) continue;
			for (int k2 = 0; k2 < list.length; k2++) {
				if(list[k2].d <= 0) continue;
				if(k != k2) {
					Egg[] temp = copyList(list);
					Hit(k, k2, temp);
				}
			}
		}
	}
	
	public static class Egg{
		int d;
		int w;
		public Egg(int d, int w) {
			this.d = d;
			this.w = w;
		}
		public Egg(Egg e) {
			this.d = e.d;
			this.w = e.w;
		}
	}
}
