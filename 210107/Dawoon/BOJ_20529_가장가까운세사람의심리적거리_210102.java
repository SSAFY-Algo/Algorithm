package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_20529_가장가까운세사람의심리적거리_210102 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		
		OUTER : for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			ArrayList<Person> pList = new ArrayList<Person>();
			for (int i = 0; i < N; i++) {
				pList.add(new Person(st.nextToken()));
			}
			
			int min = Integer.MAX_VALUE;
			
			int[][] dp = new int[N][N];
			for (int i = 0; i < dp.length; i++) {
				Arrays.fill(dp[i], -1);
			}
			for (int i = 0; i < pList.size()-2; i++) {
				for (int j = i+1; j < pList.size()-1; j++) {
					for (int k = j+1; k < pList.size(); k++) {
						min = Math.min(min, sumDistance(i, j, k, pList, dp));
						if(min == 0) {
							System.out.println(min);
							continue OUTER;
						}
					}
				}
			}
			System.out.println(min);
		}
	}

	private static int sumDistance(int i, int j, int k, ArrayList<Person> pList, int[][] dp) {
		int sum = 0;
		if(dp[i][j] == -1) {
			dp[i][j]= distance(i, j, pList);
			sum += dp[i][j];
		}
		else
			sum += dp[i][j];
		
		if(dp[j][k] == -1) {
			dp[j][k] = distance(j, k, pList);
			sum += dp[j][k];
		}
		else
			sum += dp[j][k];
		
		if(dp[i][k] == -1) {
			dp[i][k] = distance(i, k, pList);
			sum += dp[i][k];
		}
		else
			sum += dp[i][k];
		return sum;
	}

	private static int distance(int i, int j, ArrayList<Person> pList) {
		Person person1 = pList.get(i);
		Person person2 = pList.get(j);
		
		int sum = 0;
		if(person1.M != person2.M)
			sum++;
		if(person1.B != person2.B)
			sum++;
		if(person1.T != person2.T)
			sum++;
		if(person1.I != person2.I)
			sum++;
		return sum;
	}

	static class Person{
		int M;
		int B;
		int T;
		int I;
		
		public Person(String mbti) {
			if(mbti.contains("E"))
				M = 0;
			else
				M = 1;
			if(mbti.contains("S"))
				B = 0;
			else
				B = 1;
			if(mbti.contains("T"))
				T = 0;
			else
				T = 1;
			if(mbti.contains("J"))
				I = 0;
			else
				I = 1;
		}
	}
}
