package com.ssafy.newStudy5;

import java.util.*;

public class BOJ14235_크리스마스선물 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		PriorityQueue<Integer> gift = new PriorityQueue<Integer>(Collections.reverseOrder());
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			if(a == 0) {
				if(gift.isEmpty())	System.out.println(-1);
				else 				System.out.println(gift.poll());
			}
			else {
				for (int j = 0; j < a; j++) {
					gift.add(sc.nextInt());
				}
			}
		}
		sc.close();
	}

}
