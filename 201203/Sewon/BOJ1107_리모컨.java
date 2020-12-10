package com.ssafy.newStudy1;

import java.util.Scanner;

public class BOJ1107_리모컨 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		boolean[] buttons = new boolean[10];
		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			buttons[x] = true ;
		}
		
		int answer = Math.abs(N - 100);	// 현재 채널이 100 이므로
		
		if(N == 100)	answer = 0;
		else {
			for (int ch = 0; ch < 1000000; ch++) {
				int len = getLen(buttons, Integer.toString(ch));
				if(len > 0) {
					int num = Math.abs(N-ch) + len;
					answer = Math.min(answer, num);
				}
			}
		}
		System.out.println(answer);
		sc.close();
	}

	private static int getLen(boolean[] broken, String ch) {
		
		for (int i = 0; i < ch.length(); i++) {
			int num = ch.charAt(i) - '0';
			
			if(broken[num])	return 0;	// 버튼으로 누를 수 없음
		}
		
		return ch.length();
	}
	
}
