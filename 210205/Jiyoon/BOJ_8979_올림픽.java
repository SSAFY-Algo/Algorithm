package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_8979_¿Ã¸²ÇÈ {
	private static class Medal implements Comparable<Medal> {
		int num, gold, silver, bronze, rank;

		public Medal(int num, int gold, int silver, int bronze) {
			super();
			this.num = num;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
			this.rank = 1;
		}

		@Override
		public int compareTo(Medal o) {
			if (this.gold > o.gold) {
				return -1;

			} else if (this.gold == o.gold) {
				if (this.silver > o.silver) {
					return -1;
				} else if (this.silver == o.silver) {
					if (this.bronze > o.bronze) {
						return -1;
					} else if (this.bronze == o.bronze) {
						return 0;
					}
				}
			}
			return 1;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Medal[] country = new Medal[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int countryNum = Integer.parseInt(st.nextToken());
			int gold = Integer.parseInt(st.nextToken());
			int silver = Integer.parseInt(st.nextToken());
			int bronze = Integer.parseInt(st.nextToken());
			country[i] = new Medal(countryNum, gold, silver, bronze);
		}

		Arrays.sort(country);

		for (int j = 1; j < N; j++) {
			if (country[j].gold == country[j - 1].gold && country[j].silver == country[j - 1].silver
					&& country[j].bronze == country[j - 1].bronze) {
				country[j].rank = country[j - 1].rank;
			} else {
				country[j].rank = j + 1;
			}
		}

		for (int i = 0; i < N; i++) {
			if (country[i].num == K) {
				System.out.println(country[i].rank);
				break;
			}
		}
	}
}
