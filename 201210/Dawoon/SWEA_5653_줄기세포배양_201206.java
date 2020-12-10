package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_5653_줄기세포배양_201206 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			Cell[][] map = new Cell[651][651];

			ArrayList<Point> cellList = new ArrayList<Point>();
			for (int i = 300; i < 300 + N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 300; j < 300 + M; j++) {
					int age = Integer.parseInt(st.nextToken());
					if (age != 0) {
						map[i][j] = new Cell(0, age, 1);
						cellList.add(new Point(i, j, 0));
					}
				}
			}

			int turn = 0;

			while (turn < K) {

				int index = cellList.size();
				for (int i = 0; i < index; i++) {
					Point now = cellList.get(i);

					// 죽어있는데 전환될때
					if (map[now.x][now.y].age == map[now.x][now.y].hour && map[now.x][now.y].live == 0) {
						map[now.x][now.y].live = 1;
					}
					// 죽어있지만 시간이 되지 않았을때
					else if (map[now.x][now.y].age != map[now.x][now.y].hour && map[now.x][now.y].live == 0) {
						map[now.x][now.y].hour++;
					} 
					// 전환되고 바로 다음
					else if (map[now.x][now.y].live == 1) {
						for (int j = 0; j < dr.length; j++) {
							int nx = now.x + dr[j];
							int ny = now.y + dc[j];
							if(map[nx][ny] == null || (now.turn == turn+1 && map[nx][ny].age < map[now.x][now.y].age)) {
								map[nx][ny] = new Cell(0, map[now.x][now.y].age, 1);
								cellList.add(new Point(nx, ny, turn+1));
//								System.out.println("x : " + nx + " ny : " + ny +" 추가");
							}
						}
						map[now.x][now.y].live = 2;
						if(map[now.x][now.y].hour != 1)
							map[now.x][now.y].hour--;
						else {
							map[now.x][now.y].live = 3;
							cellList.remove(now);
							i--;
							index--;
//							System.out.println("x : " + now.x + " ny : " + now.y +" 삭제");
						}
					} 
					// 살아있고 시간확인
					else if(map[now.x][now.y].live == 2){
						if(map[now.x][now.y].hour != 1)
							map[now.x][now.y].hour--;
						else {
							map[now.x][now.y].live = 3;
							cellList.remove(now);
							i--;
							index--;
//							System.out.println("x : " + now.x + " ny : " + now.y +" 삭제");
						}
					}
				}
				
				turn++;
			}
			System.out.println("#" + (tc+1) + " " + cellList.size());
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Cell {
		//0 
		int live = 0;
		int age = 0;
		int hour = 0;

		public Cell(int live, int age, int hour) {
			this.live = live;
			this.age = age;
			this.hour = hour;
		}
	}

	static class Point {
		int x;
		int y;
		int turn;
		
		public Point(int x, int y, int turn) {
			this.x = x;
			this.y = y;
			this.turn = turn;
		}
	}
}
