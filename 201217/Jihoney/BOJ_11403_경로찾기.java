package GRAPH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11403_경로찾기 {

	static int N;
	static boolean map[][];
	public static void main(String args[]) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		N=Integer.parseInt(bf.readLine());
		
		map=new boolean[N+1][N+1];
		for(int i=1;i<=N;i++) {
			st=new StringTokenizer(bf.readLine());
			for(int j=1;j<=N;j++) {
				if(Integer.parseInt(st.nextToken())==1)
					map[i][j]=true;
			}
		}
		
		for(int k=1;k<=N;k++) {
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					if(map[i][k]&&map[k][j])// 경로가 존재한다면
						map[i][j]=true;
				}
			}
		}
		
		for(int i=1;i<=N;i++) {
			sb=new StringBuilder();
			for(int j=1;j<=N;j++) {
				if(map[i][j])
					sb.append("1 ");
				else
					sb.append("0 ");
			}
			System.out.println(sb.toString());
		}
	}
}
