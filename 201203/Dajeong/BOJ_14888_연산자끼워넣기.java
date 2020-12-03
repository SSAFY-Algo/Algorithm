package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14888_연산자끼워넣기 {
	
	static char[] p, op;
	private static int N;
	private static int[] arr;
	private static boolean[] visited;
	private static int max, min;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		op = new char[N-1];
		arr = new int[N];
		p = new char[N-1];
		visited = new boolean[N-1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int idx = 0;
		for(int i=0; i<4; i++) {
			int oper = Integer.parseInt(st.nextToken());
			
			for(int j=0; j<oper; j++) {
				if(i==0) 
					op[idx++] = '+';
				else if(i==1)
					op[idx++] = '-';
				else if(i==2)
					op[idx++] = '*';
				else
					op[idx++] = '/';
				
			}
		}
		
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		perm(0, arr[0], 1);
		System.out.println(max);
		System.out.println(min);
		
	}

	private static void perm(int index, int result, int num) {
		if(index == N-1) {
//			System.out.println(Arrays.toString(p));
//			System.out.println("result : " + result);
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}
		
		for(int i=0; i<N-1; i++) {
			if(visited[i] == true) continue;
			int temp = result;
//			System.out.println(result + " " + op[i] + " ");
			
			if(op[i] == '+')
				result += arr[num];
			else if(op[i] == '-')
				result -= arr[num];
			else if(op[i] == '*')
				result *= arr[num];
			else if(op[i] == '/')
				result /= arr[num];
			
//			p[index] = op[i];
			visited[i] = true;
			perm(index+1, result, num+1);
			
			result = temp;
			visited[i] = false;
		}
		
	}

}
