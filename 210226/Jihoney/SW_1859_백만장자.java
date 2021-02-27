package sc_210219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1859_백만장자 {

	static int N,input[],tmpMax;
	static long res;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc=Integer.parseInt(bf.readLine());
		for(int t=1;t<=tc;t++) {
			res=0;
			tmpMax=Integer.MIN_VALUE;
			N=Integer.parseInt(bf.readLine());
			input=new int[N+1];
			
			st=new StringTokenizer(bf.readLine());
			for(int i=1;i<=N;i++) {
				input[i]=Integer.parseInt(st.nextToken());
			}
			find();
			System.out.println("#"+t+" "+res);
		}
	}
	private static void find() {
		// TODO Auto-generated method stub
		tmpMax=input[N];
		for(int i=N-1;i>0;i--) {
			if(input[i]>=tmpMax) {
				tmpMax=input[i];
			}
			else {
				res+=(tmpMax-input[i]);
			}
		}
	}

}
