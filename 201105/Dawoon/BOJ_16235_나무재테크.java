package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_16235_나무재테크 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][N];
		int[][] food = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				food[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < map.length; i++) {
			Arrays.fill(map[i], 5);
		}
		
		
		ArrayList<ArrayList<ArrayList<Tree>>> list = new ArrayList<ArrayList<ArrayList<Tree>>>();
		for (int i = 0; i < map.length; i++) {
			list.add(new ArrayList<ArrayList<Tree>>());
			for (int j = 0; j < map.length; j++) {
				list.get(i).add(new ArrayList<Tree>());
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int age = Integer.parseInt(st.nextToken());
			list.get(x).get(y).add(new Tree(x, y, age));
		}
		
		int year = 0;
		
		while(true) {
			if(year == K) break;
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < list.get(i).size(); j++) {
					Collections.sort(list.get(i).get(j), new Comparator<Tree>() {

						@Override
						public int compare(Tree o1, Tree o2) {
							return o1.age- o2.age;
						}
						
					});
				}
			}
			int[][] dead = spring(map, list);
			summer(map, dead);
			fall(map, list);
			winter(map, food);
			year++;
		}
		
		int cnt = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				cnt += list.get(i).get(j).size();
			}
		}
		System.out.println(cnt);
	}

	private static int[][] spring(int[][] map, ArrayList<ArrayList<ArrayList<Tree>>> list) {
		int[][] dead = new int[map.length][map[0].length];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if(list.get(i).get(j).size() > 0) {
					for (int k = 0; k < list.get(i).get(j).size(); k++) {
						if(map[i][j] < list.get(i).get(j).get(k).age) {
							while(true) {
								if(k >= list.get(i).get(j).size()) break;
								dead[i][j] += list.get(i).get(j).get(k).age/2;
								list.get(i).get(j).remove(k);
							}
							break;
						}
						else
							map[i][j] -= list.get(i).get(j).get(k).age++;
					}
				}
			}
		}
		return dead;
	}
	
	private static void summer(int[][] map, int[][] dead) {
		for (int i = 0; i < dead.length; i++) {
			for (int j = 0; j < dead[i].length; j++) {
				map[i][j] += dead[i][j];
			}
		}
	}
	
	static int[][] delta = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
	private static void fall(int[][] map, ArrayList<ArrayList<ArrayList<Tree>>> list) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				for (int k = 0; k < list.get(i).get(j).size(); k++) {
					if(list.get(i).get(j).get(k).age%5 == 0) {
						for (int k2 = 0; k2 < delta.length; k2++) {
							int nx = i + delta[k2][0];
							int ny = j + delta[k2][1];
							if(nx < 0 || ny < 0 || nx >= map.length || ny >= map[nx].length) continue;
							list.get(nx).get(ny).add(new Tree(nx, ny, 1));
						}
					}
				}
			}
		}
		
	}
	
	private static void winter(int[][] map, int[][] food) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				map[i][j] += food[i][j];
			}
		}
		
	}

	static class Tree{
		int x;
		int y;
		int age;
		public Tree(int x, int y, int age) {
			this.x = x;
			this.y = y;
			this.age = age;
		}
	}
}
