package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1963_소수경로 {

	static class Point {
		int num;
		int cnt;
		
		public Point(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		boolean[] prime = new boolean[10000];
		
		for(int i = 2; i <= 9999; i++) {
            prime[i] = true;
        }
		
        for(int i = 2; i <= 9999; i++) {
            for(int j = i * 2; j <= 9999; j += i) {
                if(!prime[j]) continue;
                prime[j] = false;
            }
        }
		
        for(int tc=1; tc<=T; tc++) {
        	boolean[] visited = new boolean[10000];
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	int cnt = -1;
        	
        	Queue<Point> q = new LinkedList<>();
        	q.add(new Point(start, 0));
        	
        	while(!q.isEmpty()) {
        		Point p = q.poll();
        		if(p.num == end) {
        			cnt = p.cnt;
        			break;
        		}
        		
        		// 일의 자리 
        		for(int i=0; i<10; i++) {
        			int n = Integer.parseInt(Integer.toString(p.num).substring(0, 3) + Integer.toString(i));
        			if(visited[n] == false && n >= 1000 && n < 10000 && prime[n] == true) {
        				visited[n] = true;
            			q.add(new Point(n, p.cnt+1));
            		}
        		}
        		        		
        		// 십의 자리
        		for(int i=0; i<10; i++) {
        			int n = Integer.parseInt(Integer.toString(p.num).substring(0, 2) + Integer.toString(i) + Integer.toString(p.num).charAt(3));
        			if(visited[n] == false && n >= 1000 && n < 10000 && prime[n] == true) {
        				visited[n] = true;
            			q.add(new Point(n, p.cnt+1));
            		}
        		}
        		
        		// 백의 자리
        		for(int i=0; i<10; i++) {
        			int n = Integer.parseInt(Integer.toString(p.num).charAt(0) + Integer.toString(i) + Integer.toString(p.num).substring(2, 4));
        			if(visited[n] == false && n >= 1000 && n < 10000 && prime[n] == true) {
        				visited[n] = true;
            			q.add(new Point(n, p.cnt+1));
            		}
        		}
        		
        		// 천의 자리
        		for(int i=0; i<10; i++) {
        			int n = Integer.parseInt(Integer.toString(i) + Integer.toString(p.num).substring(1, 4));
        			if(visited[n] == false && n >= 1000 && n < 10000 && prime[n] == true) {
        				visited[n] = true;
            			q.add(new Point(n, p.cnt+1));
            		}
        		}
        		
        	}
        	
        	if(cnt == -1) System.out.println("Impossible");
        	else System.out.println(cnt);
        	
        }
        
	}

}
