package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11399_ATM {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(bf.readLine());
		int[] numArr = new int[num];
		StringTokenizer tk = new StringTokenizer(bf.readLine());
		
		for(int i=0; i<num; i++) {
			numArr[i]=Integer.parseInt(tk.nextToken());
		}
		
		Arrays.sort(numArr);
		
		int Ans = 0;
		int j = 0;
		for(int k=num; k>0; k--) {
			Ans += numArr[j]*k;
			j++;
		}
		
		System.out.println(Ans);
		
	}

}
