package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_6808_규영이와인영이의카드게임_1117 {

	static int win, lose, cnt;
	static boolean[] visited;
	static int[] numbers;
	private static int[] gyu, in;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			gyu = new int[9];
			in = new int[9];
			
			boolean[] card = new boolean[19];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<9; i++) {
				gyu[i] = Integer.parseInt(st.nextToken());
				card[gyu[i]] = true;
			}
			int idx = 0;
			for(int i=1; i<19; i++) {
				if(!card[i]) in[idx++] = i;
			}
			
			win = lose = 0;
			visited = new boolean[9];
			numbers = new int[9];
			
			perm(0);
			System.out.println("#"+tc+" " +win + " " + lose);
			
			
			
		}
		
	}

	private static void perm(int index) {
		if(index == 9) {
			int score_gyu = 0;
			int score_in = 0;
			for(int k=0; k<numbers.length; k++) {
				if(numbers[k] < gyu[k])
					score_gyu += numbers[k] + gyu[k];
				else if(numbers[k] > gyu[k])
					score_in += numbers[k] + gyu[k];
			}
			if(score_gyu > score_in)
				win++;
			else if(score_gyu < score_in)
				lose++;
			
			return;
		}
		
		for(int i=0; i<9; i++) {
			if(visited[i] == true) continue;
			numbers[index] = in[i];
			visited[i] = true;
			perm(index+1);
			visited[i] = false;
			
		}
		
	}

}
