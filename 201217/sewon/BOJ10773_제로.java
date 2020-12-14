package com.ssafy.newStudy3;

import java.util.Scanner;
import java.util.Stack;

public class BOJ10773_제로 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		Stack<Integer> stk = new Stack<Integer>();
		for (int i = 0; i < K; i++) {
			int num = sc.nextInt();
			if(num == 0)	stk.pop();
			else			stk.add(num);
		}
		
		int sum = 0;
		while(!stk.isEmpty()) {
			sum += stk.pop();
		}
		
		System.out.println(sum);
		sc.close();
	}

}
