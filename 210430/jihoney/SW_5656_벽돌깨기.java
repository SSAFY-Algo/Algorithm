package sc_210430;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_5656_벽돌깨기 {

	static int N, W, H, T, map[][], min, cnt = 0,
			dir[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static Queue<ball> q;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(bf.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			min=Integer.MAX_VALUE;
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			map = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			dfs(0, map);
			System.out.println("#"+tc+" "+min);
		}
	}

	private static void dfs(int idx, int[][] brick) {
		// TODO Auto-generated method stub
		if (idx == N) {
			min = Math.min(min, count(brick));
			return;
		}
		// i열에서 만나는 벽돌 지워주고
		// 연결되는 벽돌까지지우고
		// 공간없애기
		// 열만큼 돌리기
		for (int k = 0; k < W; k++) {
			int h = 0;
			for (int i = 0; i < H; i++) { // 떨어지는 위치 찾고
				if (brick[i][k] != 0) {
					h = i;
					break;
				}
			}
			int arr[][] = copyMap(brick);
			breakBrick(h, k, arr);
			check(arr);
			dfs(idx + 1, arr);
		}
	}
	private static int[][] copyMap(int[][] map) {
		// TODO Auto-generated method stub
		int arr[][] = new int[H][W];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				arr[i][j] = map[i][j];
			}
		}
		return arr;
	}
	private static void check(int[][] brick) {
		// 열 별로 체크
		for (int i = 0; i < W; i++) {
			for (int j = H - 1; j > 0; j--) {
				if (brick[j][i] == 0) {
					int k = j - 1;
//					for(int k=j-1;k>0;k--) {
//						if(brick[k][i]!=0) {
//							brick[j][i]=brick[k][i];
//							brick[k][i]=0;
//							break;
//						}
//					}
					while (k >= 0) {
						if (brick[k][i] != 0) {
							brick[j][i] = brick[k][i];
							brick[k][i] = 0;
							break;
						}
						k--;
					}
				}
			}
		}
	}
	private static void breakBrick(int r, int c, int[][] arr) {
		q = new LinkedList<>();
		q.add(new ball(new Point(r,c),arr[r][c]));

		while (!q.isEmpty()) {
			ball b = q.poll();
			int num = b.num;

			arr[b.p.x][b.p.y] = 0;

			for (int i = 0; i < dir.length; i++) {
				int nr = b.p.x;
				int nc = b.p.y;

				for (int j = 0; j < num - 1; j++) {
					nr += dir[i][0];
					nc += dir[i][1];
					
					if (nr < 0 || nr >= H || nc < 0 || nc >= W)
						break;
					if (arr[nr][nc] > 1) {
						q.add(new ball(new Point(nr,nc),arr[nr][nc]));
					}
					arr[nr][nc] = 0;
				}
			}
		}
	}

	private static int count(int[][] arr) {
		// TODO Auto-generated method stub
		int count = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (arr[i][j] != 0)
					count++;
			}
		}
		return count;
	}

}

class ball{
	Point p;
	int num;
	
	public ball(Point p,int num) {
		this.p=p;
		this.num=num;
	}
}
