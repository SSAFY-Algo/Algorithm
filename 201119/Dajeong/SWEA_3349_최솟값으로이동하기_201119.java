package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_3349_최솟값으로이동하기_201119 {

	static int endx, endy;
	static int startx, starty;
	private static int W, H, result;
	
	static class Point {
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			startx = Integer.parseInt(st.nextToken());
			starty = Integer.parseInt(st.nextToken());
			
			for(int i=0; i<N-1; i++) {
				st = new StringTokenizer(br.readLine());
				endx = Integer.parseInt(st.nextToken());
				endy = Integer.parseInt(st.nextToken());
				
				if((startx < endx && starty < endy) || (startx > endx && starty > endy)) {
					if(startx < endx && starty < endy) {
						if(startx-endx > starty-endy) {
							result += Math.abs(starty-endy);
						}else {
							result += Math.abs(startx-endx);
						}
					}
					
					else {
						if(startx-endx < starty-endy) {
							result += Math.abs(starty-endy);
						}else {
							result += Math.abs(startx-endx);
						}
					}
				}else {
					result += Math.abs(startx-endx) + Math.abs(starty-endy);
				}
				
				startx = endx;
				starty = endy;
			}
			
			System.out.println("#"+tc+ " " +result);
			result=0;
		}
		
		
	}
	

}
