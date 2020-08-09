package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_9613_GCD합 {
	
	static int[] tgt_number, input_num;
	static int count;
	static int sum;
	static ArrayList<Integer> ans_list = new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(bf.readLine());
		
		int T = Integer.parseInt(tk.nextToken());
		
		for(int i=0; i<T; i++) {
			tk = new StringTokenizer(bf.readLine());
			int M = Integer.parseInt(tk.nextToken());
			sum = 0;
			
			input_num = new int[M];
			tgt_number = new int[2];
			
			for(int j=0; j<M; j++) {
				input_num[j]=Integer.parseInt(tk.nextToken());
			}
			
			combination(0,0);
			
			ans_list.add(sum);
		}
		
		for(int ans:ans_list) {
			System.out.println(ans);
		}
	}
	
	static void combination(int tgt_idx,int input_idx) {
	
			if(tgt_idx==2) {
				// 연산 처리
				sum += gcd(tgt_number[0], tgt_number[1]);
				return;
			}
			
			if(input_idx>=input_num.length) return;

			tgt_number[tgt_idx]=input_num[input_idx];

			combination(tgt_idx+1, input_idx+1);
			combination(tgt_idx, input_idx +1);
		
	}
	
	static int gcd(int a, int b) {
		// 최대공약수 구하는 공식
		int x = Math.max(a, b);
		int y = Math.min(a, b);
		
		if(x%y==0) return y;
		else return gcd(x%y, y);
	}
}
