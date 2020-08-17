package GREEDY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_11399_ATM_200817 {//OR 오름차순 정렬

	static int N;
	static ArrayList<Integer> minute = new ArrayList<>();

	public static void main(String args[]) throws IOException {
		int sum = 0, people=0,min;
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		
		for (int i = 1; i <= N; i++) {
			minute.add(Integer.parseInt(st.nextToken()));
		}

		while (true) {
			min = 1000;
			for (int j = 0; j < minute.size(); j++) {	// 리스트 내 존재하는 수 중 최솟값 
				if (min >= minute.get(j)) {
					min = minute.get(j);
				}
			}
			if(minute.size()==0)
				break;
			people += min;	// 개인마다 걸리는 시간
			minute.remove(minute.indexOf(min));	// 리스트 내 최소값 삭제
			sum+=people;	// 개인마다 걸리는 시간의 합
		}
		System.out.println(sum);
	}
}
