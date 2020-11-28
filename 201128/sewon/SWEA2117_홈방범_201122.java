import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2117_홈방범 {

	static int N, M, answer;
	static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int TC = 1; TC <= T; TC++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			answer = Integer.MIN_VALUE;	// 서비스를 제공할 수 있는 집의 수
			service(1);
			System.out.println("#"+TC+" "+answer);
		}
	}
	
	private static void service(int k) {	// k: 서비스 영역
		
		boolean canService = false;
		int price = getPrice(k);	// 서비스 운영비용
		
		// 완전 탐색
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				
				int house = getHouse(i, j, k);	// 서비스를 제공 할 수 있는 집의 수
				if(house > 0) {
					int money = (house*M) - price;	// 손해 계산
					if(money >= 0) {
						canService = true;
						answer = Math.max(answer, house);
					}
				}
				
			} // end j
		} // end i
		
		if(k > N)	return;	// 종료
		service(k+1);
	}

	private static int getHouse(int x, int y, int k) {
		int count = 0;
		int flag = 2;	// 더하는 수
		int len = 1;	// 마름모 길이
		
		int dx = (-1) * ((2*k -1) / 2);
		
		for (int i = 0; i < (2*k -1); i++) {	// 세로줄
			int dy = (-1) * (len / 2);
			for (int j = 0; j < len; j++) {		// 가로줄
				int nx = x + dx;
				int ny = y + dy++;
				
				if(nx >= 0 && ny >= 0 && nx < N && ny < N && map[nx][ny] == 1) {
					count++;
				}
			}
			
			if(i%k == k-1)	flag = -2;
			len += flag;
			dx++;
			
		}
		return count;
	}

	private static int getPrice(int k) {
		int price = 0;
		int flag = 2;
		int len = 1;
		for (int i = 0; i < (2*k -1); i++) {
			price += len;
			if(i%k == k-1)	flag = -2;
			len += flag;
		}
		return price;
	}

}
