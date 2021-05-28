package sc_210528;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1058_Ä£±¸ {

	static int N,max,cnt;
	static int friends[][];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(bf.readLine());
		max=Integer.MIN_VALUE;
		friends=new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(i!=j) {
					friends[i][j]=987654321;					
				}
			}
		}
		for(int i=0;i<N;i++) {
			String str=bf.readLine();
			for(int j=0;j<N;j++) {
				if(str.charAt(j)=='Y') {
					friends[i][j]=1;
				}
			}
		}
		
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
						if(friends[i][j]>friends[i][k]+friends[k][j]) {
							friends[i][j]=friends[i][k]+friends[k][j];
					}
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			cnt=0;
			for(int j=0;j<N;j++) {
				if(friends[i][j]<=2&&friends[i][j]!=0) {
					cnt++;
				}
			}
			if(max<cnt)
				max=cnt;
		}
		System.out.println(max);
	}	
}
