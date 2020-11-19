package study3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1780_종이의개수 {

	static int N;
	static int[][] arr;
	static int[] cnt;
	static int x, y;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		cnt = new int[3];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		divide(N, 0, 0);

		System.out.println(cnt[0]);
		System.out.println(cnt[1]);
		System.out.println(cnt[2]);
		
		
		
	}
	private static void divide(int n, int x, int y) {
		
		int c0 = 0;
		int c1 = 0;
		int c2 = 0;
		
		for(int i=x; i<x+n; i++) {
			for(int j=y; j<y+n; j++) {
				if(arr[i][j] == -1)
					c0++;
				if(arr[i][j] == 0)
					c1++;
				if(arr[i][j] == 1)
					c2++;
			}
		}
		
		if(c0 == n * n) {
			cnt[0]++;
			return;
		}
		else if(c1 == n * n) {
			cnt[1]++;
			return;
		}
		else if(c2 == n * n) {
			cnt[2]++;
			return;
		}
		
		divide(n/3, x, y);
		divide(n/3, x, y+n/3);
		divide(n/3, x, y+2*(n/3));
		divide(n/3, x+n/3, y);
		divide(n/3, x+n/3, y+n/3);
		divide(n/3, x+n/3, y+2*(n/3));
		divide(n/3, x+2*(n/3), y);
		divide(n/3, x+2*(n/3), y+n/3);
		divide(n/3, x+2*(n/3), y+2*(n/3));
		
		
		
	}
	

}
