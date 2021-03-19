package sc_210312;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_20056_마법사상어와파이어볼 {

	static int N, M, K, res = 0,
			dir[][] = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };
	static int even[] = { 0, 2, 4, 6 }, odd[] = { 1, 3, 5, 7 };
	static ArrayList<fireball> list = new ArrayList<>();
	static ArrayList<fireball> map[][];
	static Queue<fireball> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map=new ArrayList[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j]=new ArrayList<>();
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			list.add(new fireball(r, c, m, s, d));
		}

		while (K > 0) {
			for (int i = 0; i < list.size(); i++) {
				fireball f = list.get(i);
				// 속도 만큼 이동
//				int speed=f.s%N;				
//				int nr=(f.pos.x+N+dir[f.d][0] * speed)%N;
//				int nc=(f.pos.y+N+dir[f.d][1] * speed)%N;
//				f.pos.x=nr;
//				f.pos.y=nc;
				f.pos.x+=(dir[f.d][0] * f.s)%N;
				f.pos.y+=(dir[f.d][1] * f.s)%N;
				
				if(f.pos.x>=N) {
					f.pos.x-=N;
				}else if(f.pos.x<0) {
					f.pos.x+=N;
				}
				if(f.pos.y>=N) {
					f.pos.y-=N;
				}else if(f.pos.y<0) {
					f.pos.y+=N;
				}
				int nr=f.pos.x;
				int nc=f.pos.y;
				map[nr][nc].add(f);
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j].size()==1) {
						map[i][j].clear();
					}
					// 같은 위치에 2개 이상이라면
					else if (map[i][j].size() >= 2) {
						makeFireball(i, j);
					}
				}
			}
			K--;
		}

		for (int i = 0; i < list.size(); i++) {
			res += list.get(i).m;
		}
		System.out.println(res);
	}

	private static void makeFireball(int r, int c) {
		// TODO Auto-generated method stub
		int totalM = 0, totalS = 0, cnt=0;
		boolean evenFlag = false;
		boolean oddFlag = false;
		for(fireball fb:map[r][c]) {
			totalM += fb.m;
			totalS += fb.s;
			if (fb.d % 2 == 0) {
				evenFlag = true;
			} else {
				oddFlag = true;
			}
			list.remove(fb);
		}
		int newM=totalM/5;
		int size=map[r][c].size();
		map[r][c].clear();
		
		if(newM!=0) {
			if (evenFlag && oddFlag) {
				for (int i = 0; i < 4; i++) {
					list.add(new fireball(r, c, totalM / 5, totalS / size, odd[i]));
				}
			} else {
				for (int i = 0; i < 4; i++) {
					list.add(new fireball(r, c, totalM / 5, totalS / size, even[i]));
				}
			}
		}
	}
}

class fireball {
	Point pos;
	int m;
	int s;
	int d;

	public fireball(int r, int c, int m, int s, int d) {
		this.pos = new Point(r, c);
		this.m = m;
		this.s = s;
		this.d = d;
	}
}
