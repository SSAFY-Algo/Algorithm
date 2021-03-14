package com.ssafy;

import java.util.LinkedList;

public class PROG_43162_네트워크 {
	public static void main(String[] args) {
		Solution s = new Solution();
		int n = 0;
		int[][] computers = null;
		s.solution(n, computers);
	}
}

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visit = new boolean[computers.length];
        for(int i = 0; i < computers.length; i++){
            if(visit[i] == true)
                    continue;
            bfs(i, computers, visit);
            answer++;
        }
        return answer;
    }
    
    static void bfs(int n, int[][] computers, boolean[] visit){
        LinkedList<Integer> q = new LinkedList<Integer>();
        q.offer(n);
        visit[n] = true;
        
        while(!q.isEmpty()){
            int now = q.poll();
            for(int i = 0; i < computers.length; i++){
                if(visit[i] == false && computers[now][i] == 1){
                    q.offer(i);
                    visit[i] = true;
                }
            }
        }
    }
}
