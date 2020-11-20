package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1780_종이의개수 {

	static int N;
	static int[] cnt = new int[3];
	static int[][] paper;

	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(bf.readLine());
		paper = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cntPaper(0,0,N);
		
		for(int i=0;i<cnt.length;i++)
			System.out.println(cnt[i]);
	}
	
	static void cntPaper(int r,int c,int N) {
		if(isSame(r,c,N)) {
			cnt[paper[r][c]+1]+=1;
			return;							//-1,0,1중 하나
		}
		N=N/3;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				cntPaper(r+i*N,c+j*N,N);	//  종이 9등분
			}
		}
		
		
	}
	
	static boolean isSame(int r,int c,int N) {
		for(int i=r;i<r+N;i++) {
			for(int j=c;j<c+N;j++) {
				if(paper[r][c]!=paper[i][j])
					return false;
			}
		}
		return true;
	}
	
	static int count(int r,int c,int N) {
		int cnt=0;
		for(int i=r;i<r+N;i++) {
			for(int j=c;j<c+N;j++) {
				cnt++;
			}
		}
		return cnt;
	}
}
