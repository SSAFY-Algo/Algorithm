package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15683_감시 {

	static int N, M, map[][], res = Integer.MAX_VALUE,
			dir[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } },//0:^, 1:>, 2:v, 3:<
	cctv[][]= {{},{4,0},{2,0,2},{4,0,1},{4,0,1,3}};
	//index=cctv번호, cctv[index][0]=회전 횟수, dir[(ccvt[index][n]+1)%4] = 90도 회전

	static ArrayList<int[]> list=new ArrayList<>();	//cctv위치와 번호 저장

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]>=1&&map[i][j]<5) {
					list.add(new int[]{map[i][j],i,j});	
				}
			}
		}
		
		findFive(); // 5번 cctv는 회전할 필요가 없으므로 초기에 설정
		findMin(0);
		System.out.println(res);
	}

	private static void findFive() {
		// TODO Auto-generated method stub
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 5) {
					setDefault(i, j);
				}
			}
		}
	}
	private static void setDefault(int r, int c) {
		// TODO Auto-generated method stub
		for (int i = 0; i < dir.length; i++) {
			int nr = r, nc = c;
			nr += dir[i][0];
			nc += dir[i][1];
			while (nr < N && nr >= 0 && nc < M && nc >= 0) {
				if (map[nr][nc] == 6) // 벽이있다면 종료
					break;
				else if (map[nr][nc] == 0) {
					map[nr][nc] = -1;
				}
				nr += dir[i][0];
				nc += dir[i][1];
			}
		}
	}

	private static void findMin(int idx) {
		// TODO Auto-generated method stub
		if(idx==list.size()) {	//기저
			res=Math.min(res,count());
			return;
		}
		int tmp[][] = new int[N][M];
		int type=list.get(idx)[0];
		int r=list.get(idx)[1];
		int c=list.get(idx)[2];
		
		for(int i=0;i<cctv[type][0];i++) {
			copyMap(tmp,map);// 맵 복사해두기
			for(int j=1;j<cctv[type].length;j++) {
				setArea(r,c,type,cctv[type][j],j);
			}
			findMin(idx+1);
			copyMap(map,tmp);// 되돌려주기
		}

	}
	
	private static void setArea(int r, int c,int type,int direction,int index) {
		// TODO Auto-generated method stub
			r+=dir[direction][0];
			c+=dir[direction][1];
			while (r < N && r >= 0 && c < M && c >= 0) {
				if (map[r][c] == 6) // 벽이있다면 종료
					break;
				else if (map[r][c] == 0) {
					map[r][c] = -1;
				}
				r+=dir[direction][0];
				c+=dir[direction][1];
			}
			cctv[type][index]=(direction+1)%4;
	}

	private static void copyMap(int a[][],int b[][]) {//맵 복사
		// TODO Auto-generated method stub
		for (int i = 0; i < N; i++) {
			for(int j=0; j < M; j++) {
				a[i][j]=b[i][j];
			}
		}
	}
	
	private static int count() {//사각지대 결과값 리턴
		int cnt=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0)
					cnt++;
			}
		}
		return cnt;
	}
	

}
