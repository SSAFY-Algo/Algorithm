package sc_210122;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2805_나무자르기 {

	static int N,M;
	static long tmpHeight=0,maxHeight=0,minSum=Long.MAX_VALUE,sum,trees[];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		trees=new long[N];
		
		st=new StringTokenizer(bf.readLine());
		
		for(int i=0;i<N;i++) {
			trees[i]=Integer.parseInt(st.nextToken());
			tmpHeight=Math.max(tmpHeight,trees[i]);
		}
		
		calcHeight(0,tmpHeight);
		System.out.println(maxHeight);
	}
	private static void calcHeight(long minH,long maxH) {
		// TODO Auto-generated method stub
		while(minH<=maxH) {
			sum=0;
			long tmp=(minH+maxH)/2;
			
			for(int i=0;i<N;i++) {
				if(trees[i]>tmp) {
					sum+=(trees[i]-tmp);
				}
			}
			
			if(sum==M) {
				maxHeight=tmp;
				break;
			}
			else if(sum<M) {
				maxH=tmp-1;
			}
			else if(sum>M) {
				if(minSum>sum) {
					minSum=sum;
					maxHeight=Math.max(maxHeight,tmp);
				}
				minH=tmp+1;
			}
		}
	}

}
