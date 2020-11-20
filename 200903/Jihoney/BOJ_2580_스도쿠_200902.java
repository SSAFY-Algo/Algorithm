package BackTracking;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2580_스도쿠_200902 {

	static int map[][] = new int[9][9];
	static ArrayList<Point> blank = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0)
					blank.add(new Point(i, j));	//공백 저장
			}
		}
		if (blank.size() == 0) // 빈칸이 없다면
			printMap();
		else {
			findNum(0);
		}
	}

	static void findNum(int cnt) {
		if (cnt == blank.size()) {
			printMap();
			return;
		}
		if(cnt>blank.size())
			return;

		int r = blank.get(cnt).x;
		int c = blank.get(cnt).y;
		
		for (int i = 1; i <= 9; i++) {
			if (Check(r, c, i)) {
				map[r][c] = i;
				findNum(cnt + 1);
				map[r][c] = 0;
			}
		}
	}

	static boolean Check(int r, int c, int num) {
		for (int i = 0; i < 9; i++) {
			if (map[r][i] == num) { // 해당 수가 이미 존재한다면 false
				return false;
			}
			if (map[i][c] == num) {
				return false;
			}
		}
		int nr = r / 3 * 3; // 3등분 좌상 시작점
		int nc = c / 3 * 3;

		for (int i = nr; i < nr + 3; i++) {
			for (int j = nc; j < nc + 3; j++) {
				if (map[nr][nc] == num) {
					return false;
				}
			}
		}
		return true;
	}

	static void printMap() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
