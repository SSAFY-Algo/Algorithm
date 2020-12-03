package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9466_텀프로젝트 {

	private static int N, cnt;
	private static int[] arr;
	static boolean[] visited, check;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			visited = new boolean[N+1];
			check = new boolean[N+1];
			for(int i=1; i<=N; i++) {
				if(!visited[i])
					dfs(i);
			}
			
			System.out.println(N-cnt);
			cnt = 0;
		}
		
	}

	private static void dfs(int num) {
		visited[num] = true;
		int next = arr[num];
		
		if(!visited[next]) {
			dfs(next);
		}else if(visited[next] && !check[next]) {
			cnt++;
			for (int i = next; i != num; i = arr[i]) {
				cnt++;
			}
		}
		
		check[num] = true;
	}

}
