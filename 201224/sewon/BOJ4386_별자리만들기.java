package com.ssafy.newStudy4;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ4386_별자리만들기 {

	public static class Star implements Comparable<Star> {
		int vertex;
		double edge;
		
		public Star(int vertex, double edge) {
			this.vertex = vertex;
			this.edge = edge;
		}
		
		@Override
		public int compareTo(Star o) {
			return Double.compare(this.edge, o.edge);
		}
	}
	
	public static void main(String[] args) {
		// input
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		double[][] vertex = new double[N][2];
		double[][] edge = new double[N][N];
		
		for (int i = 0; i < N; i++) {
			vertex[i][0] = sc.nextDouble();
			vertex[i][1] = sc.nextDouble();
			
            // 모든 별과 별 사이의 거리 구하기
			for (int j = 0; j < i; j++) {
				double distance = getDistance(vertex[i], vertex[j]);
				edge[i][j] = edge[j][i] = distance;
			}
		}

		// 첫번째 별 부터 출발
		PriorityQueue<Star> pq = new PriorityQueue<Star>();
		for (int i = 1; i < N; i++) {
			pq.add(new Star(i, edge[0][i]));
		}
		
		double answer = 0;  // 거리의 합

		int count = 1;
		boolean[] visit = new boolean[N];
		visit[0] = true;
		
		while(!pq.isEmpty()) {
			Star cur = pq.poll();
			
			if(!visit[cur.vertex]) {    // 아직 방문하지 않은 곳이면 방문
				count++;
				visit[cur.vertex] = true;
				answer += cur.edge;
				
				if(count == N)	break;  // 모든 정점을 다 방문했다면 종료
				
                // 이 정점에서 갈 수 있는 다른 모든 정점(아직 방문하지 않은)을 pq에 삽입
				for (int i = 0; i < N; i++) {
					if(!visit[i]) {
						pq.add(new Star(i, edge[cur.vertex][i]));
					}
				}
			}			
		}
		
		System.out.printf("%.2f", answer);
		sc.close();
	}
	
	// 두 점사이의 거리 구하기
	private static double getDistance(double[] v1, double[] v2) {
		return Math.sqrt( Math.pow(v1[0] - v2[0], 2) + Math.pow(v1[1] - v2[1], 2) );
	}

}
