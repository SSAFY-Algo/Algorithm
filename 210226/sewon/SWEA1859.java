import java.io.*;
import java.util.*;

class Solution
{
	static int N;
	static int[] price;
	static long answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int testcase = 1; testcase <= T; testcase++) {
			answer = Integer.MIN_VALUE;
			N = Integer.parseInt(br.readLine());
			price = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine(), &quot; &quot;);
			for (int i = 0; i < N; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			
			calc(1, 0-price[0], 1);	// 첫번째 날 사는 경우
			calc(1, 0, 0); 			// 첫번째 날 안사는 경우
			
			System.out.println(&quot;#&quot; + testcase + &quot; &quot; + answer);
		}
	}
	
	static public void calc(int day, long sum, int cnt) {
		
		if(day == N) {
			answer = Math.max(answer, sum);
			return;
		}
		
		calc(day+1, sum-price[day], cnt+1); // case 1 : 산다
		calc(day+1, sum, cnt); // case 2 : 안산다
		calc(day+1, sum+(price[day]*cnt), 0); // case 3 : 판다
	} 
}
