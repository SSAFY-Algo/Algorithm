package com.ssafy.newStudy5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ10814_나이순정렬 {

	public static class Member {
		int join, age;
		String name;

		public Member(int join, int age, String name) {
			this.join = join;
			this.age = age;
			this.name = name;
		}
	} 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Member[] member = new Member[N];
		for (int i = 0; i < N; i++) {
			int age = sc.nextInt();
			String name = sc.nextLine();
			member[i] = new Member(i, age, name);
		}
		
		Arrays.sort(member, new Comparator<Member>() {

			@Override
			public int compare(Member o1, Member o2) {
				if(o1.age == o2.age)	return o1.join - o2.join;
				return o1.age - o2.age;
			}
			
		});
		
		for (int i = 0; i < member.length; i++) {
			System.out.println(member[i].age + member[i].name);
		}
		sc.close();
	}

}
