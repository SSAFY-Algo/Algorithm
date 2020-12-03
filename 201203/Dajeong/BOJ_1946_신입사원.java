package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1946_신입사원 {

	static class Score implements Comparable<Score>{
		int s1;
		int s2;

		public Score(int s1, int s2) {
			this.s1 = s1;
			this.s2 = s2;
		}

		@Override
		public int compareTo(Score o) {
			return this.s1 - o.s1;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int s1[] = new int[N];
			int s2[] = new int[N];
			
			ArrayList<Score> list = new ArrayList<>();
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				s1[i] = Integer.parseInt(st.nextToken());
				s2[i] = Integer.parseInt(st.nextToken());
				list.add(new Score(s1[i], s2[i]));
			}
			
			Collections.sort(list);
			
			int num = list.get(0).s2;
			int max = 0;
			for(int i=0; i<N; i++) {
				
				if(num >= list.get(i).s2) {
					max++;
					num = list.get(i).s2;
				}
				
			}
			
			System.out.println(max);
		}

	}

}
