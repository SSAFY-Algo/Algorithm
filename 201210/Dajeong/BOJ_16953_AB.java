package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16953_AB {

	static class P{
		long num;
		int cnt;
		
		public P(long num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		if(A == B) {
			System.out.println("0");
		}
		else {
			Queue<P> q = new LinkedList<>();
			q.add(new P(A, 1));
			
			int answer = -1;
			
			while(!q.isEmpty()) {
				P p = q.poll();
				if(p.num == B) {
					answer = p.cnt;
					break;
				}
				
				if(p.num * 2 <= B)
					q.add(new P(p.num * 2, p.cnt+1));
				if(Long.parseLong(Long.toString(p.num)+1) <= B)
					q.add(new P(Integer.parseInt(Long.toString(p.num)+1), p.cnt+1));
				
			}
			
			System.out.println(answer);
		}
	}

}
