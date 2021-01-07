package sc_210107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_9375_ÆÐ¼Ç¿Õ½ÅÇØºó {
	static int T, N, res;
	static HashMap<String, Integer> map;

	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String name, kinds;
		T = Integer.parseInt(bf.readLine());
		for (int t = 0; t < T; t++) {
			res=1;
			map = new HashMap<>();
			N = Integer.parseInt(bf.readLine());

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine());
				name = st.nextToken();
				kinds = st.nextToken();

				if (map.containsKey(kinds)) {
					int cnt = map.get(kinds);
					map.put(kinds, cnt + 1);
				} else {
					map.put(kinds, 1);
				}
			}
			for(String s:map.keySet()) {
				res*=(map.get(s)+1);
			}
			System.out.println(res-1);
		}
	}
}
