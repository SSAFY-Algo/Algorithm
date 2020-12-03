package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_9466_텀프로젝트_201202 {

	static int team, not_team, N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			int[] stuList = new int[N+1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				stuList[i] = Integer.parseInt(st.nextToken());
			}
			
			team = 0;
			not_team = 0;
			boolean[] visit = new boolean[N+1];
			for (int i = 1; i <= N; i++) {
				if(!visit[i]) {
					visit[i] = true;
					Stack<Integer> stack = new Stack<Integer>();
					stack.push(i);
					dfs(i, stuList, visit, 1, i, stack);
				}
			}
			System.out.println(not_team);
		}
	}
	private static void dfs(int n, int[] stuList, boolean[] visit, int cnt, int start, Stack<Integer> stack) {
		if(visit[stuList[n]] == true) {
			if(stuList[n] == start)
				team += cnt-1;
			else {
				boolean isCycle = false;
				while(!stack.isEmpty()) {
					int now = stack.pop();
					if(now == stuList[n]) {
						isCycle = true;
						team += cnt - stack.size();
						not_team += stack.size();
						break;
					}
				}
				if(!isCycle) {
					not_team += cnt;
				}
			}
		}else {
			visit[stuList[n]] = true;
			stack.push(stuList[n]);
			dfs(stuList[n], stuList, visit, cnt+1, start, stack);
		}
	}
}
