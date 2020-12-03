package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1107_리모컨 {
	static boolean[] button;
	static int[] arr, result, numbers;
	static String channel;
	static int min = Integer.MAX_VALUE;
	static int answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		button = new boolean[10];
		Arrays.fill(button, true);
		
		// 이동하려고 하는 채널
		channel = br.readLine();
		
		// 고장난 버튼의 수
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N]; // 고장난 버튼 담을 배열
		numbers = new int[10-N]; // 고장나지 않은 버튼
		
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
		else if(N==0) { // 버튼 고장 안났을 때
			if(Math.abs(Integer.parseInt(channel)-100) < answer) {
				System.out.println(Math.abs(Integer.parseInt(channel)-100));
			}
			else {
				System.out.println(answer);
			}
			
		}
		else if(N==10) {	// 버튼이 모두 고장났을 때
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
				if(sb.toString().length()<=7)
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