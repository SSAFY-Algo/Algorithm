package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074_Z_2 {

	static int N, r, c, size, ans;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(tk.nextToken());
		r = Integer.parseInt(tk.nextToken());
		c = Integer.parseInt(tk.nextToken());
		size = (int) Math.pow(2, N);
		ans = 0;
		reculsive(r, c, size);
		System.out.println(ans);
	}

	private static void reculsive(int x, int y, int size) {
		if (size == 2) {
			ans += 2 * x + y;
			return;
		}

		if (x < size / 2 && y < size / 2) {
			// 1사분면
			reculsive(x, y, size / 2);
		} else if (x < size / 2 && y >= size / 2) {
			// 2사분면
			ans += (size / 2 * size / 2);
			reculsive(x, y - size / 2, size / 2);
		} else if (x >= size / 2 && y < size / 2) {
			// 3사분면
			ans += (size / 2 * size);
			reculsive(x - size / 2, y, size / 2);
		} else if (x >= size / 2 && y >= size / 2) {
			// 4사분면
			ans += (size * size / 2 + size / 2 * size / 2);
			reculsive(x - size / 2, y - size / 2, size / 2);
		}
	}
}
