package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14719_빗물 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		int[] block = new int[W];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<W; i++) {
			block[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = 0;
		
		for (int i = 1; i < W-1; i++) {
			int current = block[i];
			int left = 0;
			int right = 0;
			
			// 왼쪽
			for (int j = i-1; j >= 0; j--) {
				if(current < block[j] && left < block[j]) {
					left = block[j];
				}
			}
			
			// 오른쪽
			for (int k = i+1; k < W; k++) {
				if(current < block[k] && right < block[k]) {
					right = block[k];
				}
			}
			
			if(left > current && right > current) {
				if(left <= right) {
					answer += left - current;
				}
				else if(left > right) {
					answer += right - current;
				}
			}
		}
		
		System.out.println(answer);

	}

}
