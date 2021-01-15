package sc_210115;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_19238_스타트택시 {

	static int map[][], tmpDis, n, m, fuel, dir[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static Point taxi = new Point();
	static boolean visited[][];
	static Queue<Point> bfsQ = new LinkedList<>();
	static ArrayList<customer> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		fuel = Integer.parseInt(st.nextToken());

		// 입력
		map = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(bf.readLine());
		taxi.x = Integer.parseInt(st.nextToken());
		taxi.y = Integer.parseInt(st.nextToken());

		for (int k = 2; k < m + 2; k++) {
			st = new StringTokenizer(bf.readLine());

			int start_r = Integer.parseInt(st.nextToken());
			int start_c = Integer.parseInt(st.nextToken());
			int end_r = Integer.parseInt(st.nextToken());
			int end_c = Integer.parseInt(st.nextToken());

			Point start = new Point(start_r, start_c);
			Point end = new Point(end_r, end_c);
			map[start_r][start_c] = k;

			customer c = new customer(start, end, k);
			int distance = calcDistance(start, end);
			if (distance != -1) { // 출발지와 도착지의 거리계산
				c.seDis = distance;
				list.add(c);
			} else {
				fuel = -1;
				System.out.println(fuel);
				System.exit(0);
			}
		}

		while (m > 0) {
			// 택시로부터 처음 만난 사람중 거리 비교 같으면 행,열순서, 더 작은쪽으로 이동
			boolean find = false;
			customer custom = null;
			tmpDis = 0;
			bfsQ.clear();
			bfsQ.add(taxi);
			visited = new boolean[n + 1][n + 1];
			visited[taxi.x][taxi.y] = true;

			while (!bfsQ.isEmpty()) {
				int size = bfsQ.size();
				for (int s = 0; s < size; s++) {
					Point next = bfsQ.poll();

					int r = next.x;
					int c = next.y;
					if (map[r][c] >= 2) {
						if (!find) {
							taxi.x = r;
							taxi.y = c;
							find = true;
						} else {
							if (r < taxi.x) {
								taxi.x = r;
								taxi.y = c;
							} else if (r == taxi.x && c < taxi.y) {
								taxi.x = r;
								taxi.y = c;
							}
						}
					}
					for (int i = 0; i < dir.length; i++) {
						int nr = r + dir[i][0];
						int nc = c + dir[i][1];
						if (nr >= 1 && nr <= n && nc >= 1 && nc <= n && map[nr][nc] != 1 && !visited[nr][nc]) {
							visited[nr][nc] = true;
							bfsQ.add(new Point(nr, nc));
						}
					}
				}
				if (find) {
					break;
				}
				tmpDis++;
			}
			if (!find) {
				fuel = -1;
				System.out.println(fuel);
				System.exit(0);
			}

			// 택시로부터 가까운 출발좌표와 거리알아냈고
			fuel -= tmpDis;
			for (int i = 0; i < list.size(); i++) {
				if (map[taxi.x][taxi.y] == list.get(i).num) {
					custom = list.get(i);
					break;
				}
			}

			if (fuel - custom.seDis > 0) { // 이동할 수 있다면
				map[taxi.x][taxi.y] = 0;
				taxi.x = custom.end.x;
				taxi.y = custom.end.y;
				fuel += custom.seDis;
				m--;
			} else {
				fuel = -1;
				System.out.println(fuel);
				System.exit(0);
			}
		}
		System.out.println(fuel);
	}

	private static int calcDistance(Point p, Point q) {
		// TODO Auto-generated method stub
		tmpDis = 0;
		bfsQ.clear();
		bfsQ.add(p);
		visited = new boolean[n + 1][n + 1];
		visited[p.x][p.y] = true;

		while (!bfsQ.isEmpty()) {
			int size = bfsQ.size();
			for (int s = 0; s < size; s++) {
				Point tmp = bfsQ.poll();

				int r = tmp.x;
				int c = tmp.y;
				if (r == q.x && c == q.y) {
					return tmpDis;
				}

				for (int i = 0; i < dir.length; i++) {
					int nr = r + dir[i][0];
					int nc = c + dir[i][1];
					if (nr >= 1 && nr <= n && nc >= 1 && nc <= n && map[nr][nc] != 1 && !visited[nr][nc]) {
						visited[nr][nc] = true;
						bfsQ.add(new Point(nr, nc));
					}
				}
			}
			tmpDis++;
		}
		return -1;
	}

}

class customer { // 고객의 출발지와 도착지, 출발-도착 거리
	Point start;
	Point end;
	int seDis;
	int num;

	public customer(Point start, Point end, int num) {
		super();
		this.start = start;
		this.end = end;
		this.num = num;
	}

}