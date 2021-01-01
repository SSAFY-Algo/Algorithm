package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1927_최소힙_201227 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i = 0; i < N; i++) {
			int X = Integer.parseInt(br.readLine());
			if(X == 0) {
				if(!pq.isEmpty())
					System.out.println(pq.poll());
				else
					System.out.println(0);
			}else {
				pq.add(X);
			}
		}
	}

}
