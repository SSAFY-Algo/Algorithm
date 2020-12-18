package com.ssafy.newStudy3;

import java.io.*;
import java.util.*;

public class BOJ15558_점프게임 {

	public static class Player {
		int dir, pos, time;

		public Player(int dir, int pos, int time) {
			this.dir = dir;
			this.pos = pos;
			this.time = time;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		String[] line = new String[2];
		
		for (int i = 0; i < 2; i++) {
			line[i] = br.readLine();
		}
		
		int dir = 0;
		int pos = 0;
		int time = 0;
		
		Queue<Player> q = new LinkedList<Player>();
		boolean[][] visit = new boolean[2][N];
		q.add(new Player(dir, pos, time));
		visit[dir][pos] = true;
		
		
		while(!q.isEmpty()) {
			Player now = q.poll();
			int nDir = 0;
			if(now.dir == 0)	nDir = 1;
			else 				nDir = 0;
			
			// 게임이 끝났는지 확인
			if(now.pos+1 >= N || now.pos+k >= N) {
				System.out.println(1);
				return;
			}

			// 게임 진행
			if(line[now.dir].charAt(now.pos+1) == '1' && !visit[now.dir][now.pos+1]) {
				visit[now.dir][now.pos+1] = true;
				q.add(new Player(now.dir, now.pos+1, now.time+1));
			}
			
			if(now.pos-1 > now.time && line[now.dir].charAt(now.pos-1) == '1' && !visit[now.dir][now.pos-1]) {
				visit[now.dir][now.pos-1] = true;
				q.add(new Player(now.dir, now.pos-1, now.time+1));
			}
			
			if(line[nDir].charAt(now.pos+k) == '1' && !visit[nDir][now.pos+k]) {
				visit[nDir][now.pos+k] = true;
				q.add(new Player(nDir, now.pos+k, now.time+1));
			}
		}
		
		System.out.println(0);
	}

}
