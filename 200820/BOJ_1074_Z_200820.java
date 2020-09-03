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
