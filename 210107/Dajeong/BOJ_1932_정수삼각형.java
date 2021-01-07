import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1932_정수삼각형 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[n+1][n+1];
		
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= i; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		int[][] tri = new int[n+1][n+1];
		tri[1][1] = arr[1][1];
		
		int max = 0;
		
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				tri[i][j] = Math.max(tri[i-1][j-1], tri[i-1][j]) + arr[i][j];
				
				if(i == n) {
					max = Math.max(tri[i][j], max);
				}
			}
		}
		
		
		System.out.println(max);
		
		
	}

}
