package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_6808_규영이와인영이 {

	static int tc, win, draw;
	static boolean num[], isSelected[];
	static int ky[], ey[];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		tc = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= tc; t++) {
			win = draw = 0;
			num = new boolean[19];
			isSelected = new boolean[9];
			ky = new int[9];
			ey = new int[9];
			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < 9; i++) {
				ky[i] = Integer.parseInt(st.nextToken());
				num[ky[i]] = true;
			}
			int tmp = 0;
			for (int i = 1; i <= 18; i++) {
				if (!num[i]) {
					ey[tmp++] = i;
				}
			}

			perm(0, 0, 0);// 라운드, 규영이 점수, 인영이 점수
			int total=pact();
			System.out.println("#"+t+" "+win+" "+(total-win-draw));
		}

	}

	static int pact() {
		return 9*8*7*6*5*4*3*2*1;
	}
	static void perm(int round, int kyScore, int eyScore) {
		if (round == 9) {
			if (kyScore > eyScore)
				win++;
			if (kyScore == eyScore)
				draw++;
			return;
		}
		for (int i = 0; i < 9; i++) {
			if (isSelected[i])
				continue;
			else {
				isSelected[i] = true;
				if (ky[round] > ey[i]) {
					perm(round + 1, kyScore + ky[round]+ey[i], eyScore);
				} else {
					perm(round + 1, kyScore, eyScore + ky[round]+ey[i]);
				}
				isSelected[i] = false;
			}
		}
	}

}
