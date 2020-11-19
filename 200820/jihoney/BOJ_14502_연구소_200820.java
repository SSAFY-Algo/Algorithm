package BFS_DFS;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502_연구소_200817 {

	static int[] tmp = new int[3]; // 세울 3개의 벽의 index를 저장하는 배열
	static int[][] map, cMap, dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int MAX=0, N, M; // N,M<=8, 빈칸 최소 3개 이상
	static Queue<Point> queue = new LinkedList<>();
	static ArrayList<Point> virus = new ArrayList<>();
	static ArrayList<Point> zeros = new ArrayList<>();

	public static void main(String[] args) throws IOException { // 세울 수 있는 벽 3개, 0: 빈칸,1:벽,2:바이러스
		// TODO Auto-generated method stub // 안전영역 최댓값
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					virus.add(new Point(i, j)); // 바이러스 좌표값 저장
				}
				if (map[i][j] == 0) {
					zeros.add(new Point(i, j)); // 0의 좌표값 저장
				}
			}
		}
		comb(0, 0);
		System.out.println(MAX);

	}

	static void makeQueue() {
		for (int i = 0; i < virus.size(); i++) {
			queue.offer(virus.get(i)); // 초기 바이러스 좌표값 큐에 저장
		}
	}

	static void comb(int cnt, int cur) { // 0의개수 C 3
		if (cnt == 3) {
			makeQueue();
			copyMap(); 
			for (int i = 0; i < tmp.length; i++) { // tmp에 저장된 0의 좌표값을 저장하는 index 대입
				Point p = zeros.get(tmp[i]);
				int nx = p.x;
				int ny = p.y;
				cMap[nx][ny] = 1; // 복사된 맵에 임의의 벽 3개 세우기
			}
			bfs();
			safeArea();
			return;
		}
		for (int i = cur; i < zeros.size(); i++) {
			tmp[cnt] = i;
			comb(cnt + 1, i + 1);
		}
	}

	static void bfs() {
		int nc, nr;
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			int r = p.x;
			int c = p.y;
			for (int i = 0; i < dir.length; i++) {
				nr = r + dir[i][0];
				nc = c + dir[i][1];
				if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
					if (cMap[nr][nc] == 0) {
						queue.add(new Point(nr, nc));
						cMap[nr][nc] = 2;
					}
				}
			}
		}
	}

	static void safeArea() { // bfs실행 후 0의 개수 계산
		int zeroCnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (cMap[i][j] == 0) {
					zeroCnt++;
				}
			}
		}
		if (MAX <= zeroCnt) {
			MAX = zeroCnt;
		}

	}

	static void copyMap() { // 각 경우의 수마다 맵을 탐색해야하므로 맵 복사
		cMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				cMap[i][j] = map[i][j];
			}
		}
	}
}