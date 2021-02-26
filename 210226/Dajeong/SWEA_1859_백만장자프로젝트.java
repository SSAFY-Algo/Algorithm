import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1859_백만장자프로젝트 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= T; i++) {
			int n = Integer.parseInt(br.readLine());
			
			int[] arr = new int[n];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			long answer = 0;
			int max = arr[n-1];
			
			for(int j=n-1; j>=0; j--) {
				if(arr[j] < max) {
					answer += max - arr[j];
				}
				else {
					max = arr[j];
				}
			}
			
			System.out.println("#"+i+ " "+answer);
			
		}
		
		

	}

}
