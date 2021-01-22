package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2805_나무자르기_210119 {

	static long answer = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		long M = Long.parseLong(st.nextToken());

		long[] tree = new long[N];
		
		st = new StringTokenizer(br.readLine());
		long max = 0;
		for (int i = 0; i < tree.length; i++) {
			tree[i] = Long.parseLong(st.nextToken());
			if(tree[i] > max)
				max = tree[i];
		}
		
		binarySearch(0, max, tree, M);
		
		System.out.println(answer);
	}

	private static void binarySearch(long start, long end, long[] tree, long m) {
		
		long pivot = (start+end)/2;
		
		long sum = 0;
		
		for (int i = 0; i < tree.length; i++) {
			if(tree[i] - pivot > 0)
				sum += tree[i]- pivot;
		}
		
		if(start > end)
			return;
		if (sum >= m){
			if(answer < pivot)
				answer = pivot;
			start = pivot + 1;
			binarySearch(start, end, tree, m);
        }
        else{
            end = pivot - 1;
            binarySearch(start, end, tree, m);
        }
	}

}
