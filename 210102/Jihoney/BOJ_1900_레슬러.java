package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1900_레슬러 {

	static int n, player[][], comb[], win[];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		player = new int[n + 1][2];
		comb = new int[2];
		win = new int[n+1];

		int power, ring,idx=0,cnt=0,max=Integer.MIN_VALUE;

		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			power = Integer.parseInt(st.nextToken());
			ring = Integer.parseInt(st.nextToken());

			player[i][0] = power;
			player[i][1] = ring;
		}
		combination(0, 1);
		
		while(true) {
			if(cnt==n) {
				break;
			}
			max=Integer.MIN_VALUE;
			for(int i=1;i<=n;i++) {
				if(max<=win[i]) {
					max=win[i];
				}
			}

			for(int i=1;i<=n;i++) {
				if(max==win[i]) {
					idx=i;
					win[idx]=-1;
					break;
				}
			}
			System.out.println(idx+" ");
			cnt++;
		}
		
	}

	// nC2
	private static void combination(int cnt, int cur) {
		if (cnt == 2) {
//			System.out.println(Arrays.toString(play));
			int left=comb[0];
			int right=comb[1];
			
			int leftperf=player[left][0]+(player[right][0]*player[left][1]);
			int rightperf=player[right][0]+(player[left][0]*player[right][1]);
			
			if(leftperf>rightperf) {
				win[left]++;
			}
			else {
				win[right]++;
			}
			return;
		} else {
			for (int i = cur; i <= n; i++) {
				comb[cnt] = i;
				combination(cnt + 1, i + 1);
			}
		}
	}
}
