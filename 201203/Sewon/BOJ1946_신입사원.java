package com.ssafy.newStudy1;

import java.util.Scanner;

public class BOJ1946_신입사원 {

	// 서류심사 성적과 면접시험 성적 중 적어도 하나가 다른 지원자보다 떨어지지 않는 자만 선발
	// 두 성적 중 하나만 높아도 선발
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-- > 0) {
			int N = sc.nextInt();
			int[] rank = new int[N+1];
			
			for (int i = 0; i < N; i++) {
				rank[sc.nextInt()] = sc.nextInt();	// index: 서류성적 순위, 값: 면접 성적 순위
			}
			
			int answer = 1;	// 서류 1등은 무조건 합격
			int row = rank[1];
			for (int i = 2; i <= N; i++) {
			
				if(row > rank[i]) {
					row = rank[i];
					answer++;
				}
			}
			
			System.out.println(answer);
		}
		sc.close();
	}

}
