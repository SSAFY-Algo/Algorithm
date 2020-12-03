package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_2112_보호필름 {

	private static int[][] map;
	private static int D, W, K;
	static int answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[D][W];
			answer = Integer.MAX_VALUE;
			for(int i=0; i<D; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			if(test() == true || K==1) System.out.println("#"+tc+ " 0");
			else {
				solve(0, 0);
				System.out.println("#"+tc+ " " + answer);
			}
			
		}
	}

	static void solve(int row, int cnt) {
		if( test() ) {
			answer = Math.min(answer, cnt);
			return;
		}
	
		if( answer < cnt || row == D )
			return;
	

		solve(row + 1, cnt);

		int[] tmp = new int[W];
		for(int i = 0; i < W; i++)
			tmp[i] = map[row][i];
		
		for(int i = 0; i < W; i++)
			map[row][i] = 0;
		solve(row + 1, cnt + 1);
		
		for(int i = 0; i < W; i++)
			map[row][i] = 1;
		solve(row + 1, cnt + 1);
		for(int i = 0; i < W; i++)
			map[row][i] = tmp[i];
	}

	private static boolean test() {
		
		int totalCnt = 0;
		for(int i=0; i<W; i++) {
			int cnt = 1;
			boolean pass = false;
			for(int j=1; j<D; j++) {
				if(map[j-1][i] == map[j][i]) cnt++;
				else cnt = 1;
				
				if(cnt == K) {
					pass = true;
					break;
				}
			}
			if(!pass) return false;
		}
		return true;
	}

}
