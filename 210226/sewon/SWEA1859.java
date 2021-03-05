import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int testcase = 1; testcase <= T; testcase++) {
			long answer = 0;
			int N = Integer.parseInt(br.readLine());
			int[] price = new int[N];
			int pivot = N-1;	// 현재 가리키고 있는 값(맨 뒤부터 시작)
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = N-2; i >= 0; i--) {
				if(price[i] < price[pivot]) {
					answer += price[pivot] - price[i];
				}
				else {
					pivot = i;
				}
			}
			
			System.out.println("#" + testcase + " " + answer);
		}
	}
}
