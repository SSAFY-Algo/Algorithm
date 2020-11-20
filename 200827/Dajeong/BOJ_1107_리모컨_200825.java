package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1107_리모컨_200825 {
	static boolean[] button;
	static int[] arr, result, numbers;
	static String s, channel;
	static int min = Integer.MAX_VALUE;
	static int answer;
	
	public static void main(String[] args) throws Exception {
		button = new boolean[10];
		Arrays.fill(button, true);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		channel = br.readLine();
		
		s = br.readLine();
		int N = Integer.parseInt(s);
		
		arr = new int[N];
		numbers = new int[10-N];
		if(N != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				button[arr[i]] = false;
			}
		}
			
		int cnt = 0;
		for(int i=0; i<=9; i++) {
			if(button[i])
				numbers[cnt++] = i;
		}

		
		for(int i=1; i<=channel.length()+1; i++) {
			result = new int[i];
			p(0, i);
		}
		
		if(channel.equals("100")) {
			System.out.println("0");
		}
		else if(N==0) {
			if(Math.abs(Integer.parseInt(channel)-100) < answer) {
				System.out.println(Math.abs(Integer.parseInt(channel)-100));
			}
			else {
				System.out.println(answer);
			}
			
		}
		else if(N==10) {
			System.out.println(Math.abs(Integer.parseInt(channel)-100));
		}
		else {
			if(Math.abs(Integer.parseInt(channel)-100) < answer) {
				System.out.println(Math.abs(Integer.parseInt(channel)-100));
			}
			else {
				System.out.println(answer);
			}
		}
		
		
		
	}

	private static void p(int cnt, int i) {
		if(cnt == i) {
			StringBuilder sb = new StringBuilder();
			for(int j=0; j<result.length; j++) {
					sb.append(result[j]);
			}
			
			int re = Math.abs(Integer.parseInt(sb.toString()) - Integer.parseInt(channel));
			if(min > re) {
				min = re;
				answer = min + sb.toString().length();
			}
			
			return;
		}
		
		for(int k=0; k<numbers.length; k++) {
			result[cnt] = numbers[k];
			p(cnt+1, i);
		}
		
	}

}
