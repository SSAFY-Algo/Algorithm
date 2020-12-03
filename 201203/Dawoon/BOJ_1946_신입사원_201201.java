package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1946_신입사원_201201 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			ArrayList<Person> list = new ArrayList<Person>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				list.add(new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			
			Collections.sort(list, new Comparator<Person>() {

				@Override
				public int compare(Person o1, Person o2) {
					return o1.text - o2.text;
				}
			});
			int cnt = 1;
			int talk = list.get(0).talk;
			for (int i = 1; i < list.size(); i++) {
				if(list.get(i).talk < talk) {
					cnt++;
					talk = list.get(i).talk;
				}
			}
			System.out.println(cnt);
//			for (int i = 0; i < list.size(); i++) {
//				System.out.println(list.get(i).text + " " + list.get(i).talk);
//			}
		}
	}
	
	static class Person{
		int text;
		int talk;
		Person(int text, int talk){
			this.text = text;
			this.talk = talk;
		}
	}
}
