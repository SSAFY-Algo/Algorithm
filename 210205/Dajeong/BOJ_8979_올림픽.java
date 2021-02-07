import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class BOJ_8979_올림픽 {

	static class medal implements Comparable<medal>{
		int gold;
		int silver;
		int bronze;
		int num; // 국가 번호
		int rank; // 등수

		public medal(int gold, int silver, int bronze, int num, int rank) {
			super();
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
			this.num = num;
			this.rank = rank;
		}

		@Override
		public int compareTo(medal o) {
			if(this.gold == o.gold && this.silver == o.silver)
				return o.bronze - this.bronze;
			if(this.gold == o.gold)
				return o.silver - this.silver;
			return o.gold - this.gold;
			
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		ArrayList<medal> list = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.add(new medal(g, s, b, num, 0));
		}
		
		Collections.sort(list);
		list.get(0).rank = 1;
		int idx = 0;
		for (int i = 1; i < n; i++) {
			if(list.get(i).gold == list.get(i-1).gold && list.get(i).silver == list.get(i-1).silver && list.get(i).bronze == list.get(i-1).bronze) {
				list.get(i).rank = list.get(i-1).rank;
			}
			else {
				list.get(i).rank = i+1;
			}
			
			if(list.get(i).num == k) {
				idx = i;
				break;
			}
		}
		
		System.out.println(list.get(idx).rank);
		
	}

}
