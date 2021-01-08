import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20529_가장가까운세사람의심리적거리 {

	private static int N;
	private static String[] str;
	private static boolean[] visited;
	private static int[] selected;
	private static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			str = new String[N];
			visited = new boolean[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) {
				str[i] = st.nextToken();
			}
			
			min = Integer.MAX_VALUE;
			selected = new int[3];
			
			if(N <= 32)
				select(0);
			else
				min = 0;
			
			System.out.println(min);
			
			
		}
		
		
	}

	private static void select(int cnt) {
		if(cnt == 3) {
			int d = 0;
			
			O : for (int i = 0; i < 2; i++) {
				for (int j = i+1; j < 3; j++) {
					for (int k = 0; k < 4; k++) {
						if(d > min) break O;
						if(str[selected[i]].charAt(k) != str[selected[j]].charAt(k)) {
							d++;
						}
					}
				}
			}
			
			min = Math.min(d, min);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(visited[i]) continue;
			selected[cnt] = i;
			visited[i] = true;
			select(cnt+1);
			visited[i] = false;
		}
	}

}
