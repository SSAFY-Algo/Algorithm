package com.ssafy;

import java.util.Scanner;

public class BOJ_1541_잃어버린괄호_201018 {
	static int min = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();

		// 맨 처음 나오는 - 앞에 있는 것들 더하기
		String[] str = input.split("-");
		min += sum(str[0].split("[+]"));

		// 그 뒤로 나오는 -까지 덩어리들의 합
		for (int i = 1; i < str.length; i++) {
			min -= sum(str[i].split("[+]"));
		}

		System.out.println(min);
	}


	static int sum(String[] input) {
		int result = 0;
		for (String num : input) {
			result += Integer.parseInt(num);
		}
		return result;
	}
}
