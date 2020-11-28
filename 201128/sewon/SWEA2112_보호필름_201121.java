import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA2112_보호필름 {

	static int D, W, K, answer;
	static int[][] film;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int TC = 1; TC <= T; TC++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			D = Integer.parseInt(st.nextToken());	// 세로
			W = Integer.parseInt(st.nextToken());	// 가로
			K = Integer.parseInt(st.nextToken());
			film = new int[D][W];
			
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < W; j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			answer = 13;
			int[] line = new int[D];
			if(K == 1) {	// K가 1이면 무조건 정답은 0
				answer = 0;
			}
			else dfs(0, 0, line);
			System.out.println("#"+TC+" "+answer);
		}
		
	}
	
	private static void dfs(int d, int count, int[] line) {	
		// d: 가로 index(약물 주입할 라인), count: 약물투입횟수
		
		if(count >= answer) return;
		
		if(d == D) {				
			int[][] tempFilm = new int[D][W];
			copyFilm(tempFilm);
			for (int i = 0; i < line.length; i++) {
				
				if(line[i] != 0) {	// 약물 투입
					
					for (int x = 0; x < W; x++) {
						tempFilm[i][x] = line[i]-1;
					}
				}
			}
						
			if(check(tempFilm)) {	// 성능 체크
				answer = Math.min(answer, count);
				return;
			}
			
			return;
		}
		
		dfs(d+1, count, line);	// 1. 약물을 안넣음
		line[d] = 1;
		dfs(d+1, count+1, line); // 2. A 약물 투입
		line[d] = 2;
		dfs(d+1, count+1, line); // 3. B 약물 투입
		
		line[d] = 0;
	}
	
	
	private static boolean check(int[][] tempFilm) {
		for (int i = 0; i < W; i++) {
			boolean isPass = false; // 성능검사 결과
			for (int j = 0; j <= D-K; j++) {
				int count = 0;	// 연속적인 셀 갯수
				for (int k = 0; k < K; k++) {
					if(tempFilm[j+k][i] == tempFilm[j][i]) count++;
					else break;					
				}
				
				if(count == K) {
					isPass = true;
					break;
				}
			} // end j

			if(!isPass) return false;
		} // end i
		return true;
	}

	private static void copyFilm(int[][] tempFilm) {
		for (int i = 0; i < D; i++) {
			for (int j = 0; j < W; j++) {
				tempFilm[i][j] = film[i][j];
			}
		}
	}
	
}
