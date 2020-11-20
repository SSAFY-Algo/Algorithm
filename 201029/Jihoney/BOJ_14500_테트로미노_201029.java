package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14500_테트로미노 {

	static int N,M,paper[][],max,sum,res=0;	//4<=n,m<=500
	static int dir[][]= {{-1,0},{0,1},{1,0},{0,-1}};
	static boolean visited[][];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		paper=new int[N][M];
		visited=new boolean[N][M];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(bf.readLine());
			for(int j=0;j<M;j++) {
				paper[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				visited[i][j]=true;
				res=Math.max(res,dfs(i,j,1));
				res=Math.max(res, middleDfs(i,j));
				visited[i][j]=false;
			}
		}
		System.out.println(res);
		
	}
	static int dfs(int r,int c,int cnt) {
		if(cnt==4) {
			return paper[r][c];
		}
		sum=0;
		for(int i=0;i<dir.length;i++) {
			int nr=r+dir[i][0];
			int nc=c+dir[i][1];
			
			if(nr>=0&&nr<N&&nc>=0&&nc<M&&!visited[nr][nc]) {
				visited[nr][nc]=true;
				sum=Math.max(sum,paper[r][c]+dfs(nr,nc,cnt+1));
				visited[nr][nc]=false;
			}
		}
		
		return sum;
	}
	
	static int middleDfs(int r,int c) {
		int resSum=0;
		if(r>=1&&r<N-1&&c>=1) {//ㅓ
			resSum=Math.max(resSum,paper[r][c]+paper[r-1][c]+paper[r][c-1]+paper[r+1][c]);
		}
		if(r>=1&&c<M-1&&c>=1) {//ㅗ
			resSum=Math.max(resSum, paper[r][c-1]+paper[r][c]+paper[r-1][c]+paper[r][c+1]);
		}
		if(r<N-1&&c<M-1&&r>=1) {//ㅏ
			resSum=Math.max(resSum, paper[r][c]+paper[r-1][c]+paper[r+1][c]+paper[r][c+1]);
		}
		if(r<N-1&&r>=0&&c<M-1&&c>=1) {//ㅜ
			resSum=Math.max(resSum, paper[r][c-1]+paper[r][c]+paper[r][c+1]+paper[r+1][c]);
		}
		return resSum;
	}

	
}
