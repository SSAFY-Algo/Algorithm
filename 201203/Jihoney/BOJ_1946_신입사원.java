package GREEDY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1946_신입사원 {

	static int res[],ans,n,idx;
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc=Integer.parseInt(bf.readLine());
		for(int t=0;t<tc;t++) {
			n=Integer.parseInt(bf.readLine());
			res=new int[n+1];
			for(int i=1;i<=n;i++) {
				st=new StringTokenizer(bf.readLine());
				idx=Integer.parseInt(st.nextToken());
				res[idx]=Integer.parseInt(st.nextToken());	//서류 순위 = 배열의 인덱스, 면접 순위 = 배열의 값
			}
			check();
			System.out.println(ans);
		}
	}
	static void check() {
		ans=1;
		int tmp=res[1];//서류 1순위의 면접 순위
		for(int i=2;i<=n;i++) {
			if(res[i]<tmp) {//나보다 낮은 서류 순위의 면접순위가 더 높으면  
				ans++;
				tmp=res[i];
			}
		}	
	}
}
