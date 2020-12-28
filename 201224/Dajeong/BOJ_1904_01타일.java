package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1904_01타일 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N+1];
		
		arr[0] = 1;
		arr[1] = 1;
		
		for (int i = 3; i <= N; i++) {
			arr[i] = (arr[i-2] + arr[i-1]) % 15746;
		}
		
		System.out.println(arr[N]);
		
	}

}
