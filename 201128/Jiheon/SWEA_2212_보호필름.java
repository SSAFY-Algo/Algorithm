package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_2212_보호필름 {
	// dfs, 주입할 경우, A주입할 경우, B주입할 경우 - 막 별로
	static int D, W, K, res, film[][];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		StringTokenizer st;
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(bf.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			film = new int[D][W];
			res = Integer.MAX_VALUE;

			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < W; j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			if (check()) {
				res = 0;
			} else {
				dfs(0, 0);// cnt:넣은 약의 수,d:현재 층
			}
			System.out.println("#" + t + " " + res);
		}
	}

	static void dfs(int cnt, int d) {
		if (d == D) {
			if (check()) {
				res = Math.min(res,cnt);
			}
			return;
		}
		int[] temp = Arrays.copyOf(film[d], W);
		// 아무것도 안넣을 경우
		dfs(cnt, d + 1);
		
		//A
		Arrays.fill(film[d], 0);
		dfs(cnt + 1, d + 1);

		// B
		Arrays.fill(film[d], 1);
		dfs(cnt + 1, d + 1);
		
		// 되돌아왔을때 원래되로 되돌리기
		film[d] = Arrays.copyOf(temp, temp.length);				
	}

	static boolean check() {
		boolean flag = false;
		for (int j = 0; j < W; j++) {
			for (int i = 0; i < D - K + 1; i++) {
				for (int k = 1; k < K; k++) { // k개수만큼만 검사
					if (film[i][j] != film[i + k][j]) {
						flag = false;
						break;
					} else
						flag = true;
				}
				if (flag)
					break;
			}
			if (!flag)
				return false;
		}
		return true;
	}
}
