package sc_210107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20529_가장가까운세사람 {
	// n<=100,000 => 시간초과
	static int selected[], N, T, min, dis;
	static String input[];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(bf.readLine());

		for (int t = 0; t < T; t++) {
			min = Integer.MAX_VALUE;

			N = Integer.parseInt(bf.readLine());
			input = new String[N];
			selected = new int[3];
			st = new StringTokenizer(bf.readLine());

			for (int i = 0; i < N; i++) {
				input[i] = st.nextToken();
			}
			if(N>16*16)
				min=0;
			else {
				combination(0, 0); // nC3				
			}
			System.out.println(min);
		}
	}

	private static void combination(int cnt, int cur) {
		// TODO Auto-generated method stub
		if (cnt == 3) {
			dis = 0;
			for (int i = 0; i < 2; i++) {
				for (int j = i+1; j < 3; j++) {
					if(dis>=min)
						return;
					if (!(input[selected[i]].equals(input[selected[j]]))) {
						for (int idx = 0; idx < 4; idx++) {
							if (input[selected[i]].charAt(idx) != input[selected[j]].charAt(idx))
								dis++;
						}
					}
				}
			}
			min = Math.min(dis,min);
			return;
		}
			for (int i = cur; i < N; i++) {
				selected[cnt] = i;
				combination(cnt + 1, i + 1);
		}
	}
}
