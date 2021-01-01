package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_10814_나이순정렬 {
	static class Point implements Comparable<Point>{
		int age;
		String name;
		public Point(int age, String name) {
			this.age = age;
			this.name = name;
		}
		
		@Override
		public int compareTo(Point o) {
				return this.age - o.age;
			
		}
		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Point> list = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(new Point(Integer.parseInt(st.nextToken()), st.nextToken()));
		}
		
		Collections.sort(list);
		
		for (Point point : list) {
			System.out.println(point.age + " " + point.name);
		}
	}

}
