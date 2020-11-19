package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_6808_규영이와인영이의카드게임_201119 {

	static int wcount, lcount; // 규영이의 우승 횟수, 진 횟수
	private static int[] in;
	private static int[] gyu;
	private static int[] number;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			gyu = new int[9]; // 규영이의 배열
			in = new int[9]; // 인영이의 배열
			StringTokenizer st = new StringTokenizer(br.readLine());
			number = new int[19];// 인영이가 담을수 있는 숫자 배열

			for (int i = 0; i < 9; i++) {
				// 규영이가 뽑은 카드 담기
				int n = Integer.parseInt(st.nextToken());
				gyu[i] = n;
				number[gyu[i]] = 1; // 나중에 0 인 애들만 인영이 가능 배열로 넣어주기
			}

			wcount = 0; // 규영이의 우승횟수 초기화
			lcount = 0; // 규영이의 진 횟수 초기화
			Permutation(0);
			System.out.println("#" + tc + " " + wcount + " " + lcount);
		} // end of test case
	}

	private static void Permutation(int cnt) {

		if (cnt == 9) {
			// 이때 규영이 배열이랑 비교해서 우승하면 count ++
			int kSum = 0, iSum = 0;
			for (int i = 0; i < 9; i++) {
				if (gyu[i] > in[i]) {
					kSum += (gyu[i] + in[i]);
				} else
					iSum += (gyu[i] + in[i]);
			}
			if (kSum > iSum)
				wcount++;
			else if (kSum < iSum)// 규영이 지면
				lcount++;
			return;
		}

		for (int i = 1; i < 19; i++) {
			if (number[i] == 0) {
				number[i] = 1;
				in[cnt] = i;
				Permutation(cnt + 1);
				number[i] = 0;
			}
		}
	}
}
