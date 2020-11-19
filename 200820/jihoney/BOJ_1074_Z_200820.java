<<<<<<< HEAD:200820/jihoney/BOJ_1074_Z_200820.java
package RECURSIVE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074_Z {

	static int N, cnt, r, c;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		Search(N);
		System.out.println(cnt);
	}

	static void Search(int N) { 
		int mul=0;
		while (true) {
			int s = (int) Math.pow(2, N) / 2;
			if(N==1) {
				if(r<s&&c<s)
					cnt+=0;
				else if(r<s&&c>=s)
					cnt+=1;
				else if(r>=s&&c<s)
					cnt+=2;
				else if(r>=s&&c>=s)
					cnt+=3;
				return;
			}
			if (r < s && c < s) {	// 2사분면
				mul = 0;
			} else if ( r < s&&c >= s) {	// 1사분면 
				mul=1;// 이전 사분면의 탐색 수 개수
			} else if (r >= s && c < s) {	// 3 사분면
				mul=2;
			} else if (r >= s && c >= s) {	// 4 사분면
				mul=3;
			}
			
			r%=s;
			c%=s;
			
			cnt += Math.pow(s, 2)*mul;
			N--;
		}
		
	}
}
=======
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074_Z_2 {

	static int N, r, c, size, ans;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(tk.nextToken());
		r = Integer.parseInt(tk.nextToken());
		c = Integer.parseInt(tk.nextToken());
		size = (int) Math.pow(2, N);
		ans = 0;
		reculsive(r, c, size);
		System.out.println(ans);
	}

	private static void reculsive(int x, int y, int size) {
		if (size == 2) {
			ans += 2 * x + y;
			return;
		}

		if (x < size / 2 && y < size / 2) {
			// 1��и�
			reculsive(x, y, size / 2);
		} else if (x < size / 2 && y >= size / 2) {
			// 2��и�
			ans += (size / 2 * size / 2);
			reculsive(x, y - size / 2, size / 2);
		} else if (x >= size / 2 && y < size / 2) {
			// 3��и�
			ans += (size / 2 * size);
			reculsive(x - size / 2, y, size / 2);
		} else if (x >= size / 2 && y >= size / 2) {
			// 4��и�
			ans += (size * size / 2 + size / 2 * size / 2);
			reculsive(x - size / 2, y - size / 2, size / 2);
		}
	}
}
>>>>>>> d883dafd17bdf4fae4881d310b878914f6dae1f0:200820/BOJ_1074_Z_200820.java
