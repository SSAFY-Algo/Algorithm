package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2117_홈방범서비스 {

	static int[][] map;
	private static int N, M, cost, max;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 답이 될 수 있는 최대 집의 개수
			int answer = 0;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					
					for(int k=1; k<=2*N-1; k++) {
						int cnt = 0;
						// 운영 비용
						int cost = k * k + (k-1) * (k-1);
						// x값의 범위 : 현재 좌표에서 k만큼 뺀 것 ~ k만큼 더한 것
						for(int x=i-k; x<=i+k; x++) {
							// y값의 범위 : 현재 좌표에서 k만큼 뺀 것 ~ k만큼 더한 것
							for(int y=j-k; y<=j+k; y++) {
								
								// 범위가 map 밖으로 넘어가는지 체크
								if(x < 0 || y < 0 || x > N-1 || y > N-1) continue;
								
								// 처음 좌표에서 x변화량 + y변화량의 합이 k보다 작아야 한다 
								if(Math.abs(i-x) + Math.abs(j-y) < k) {
									if(map[x][y] == 1) cnt++;
								}
							}
						}
						
						// 보안회사의 이익 계산하여 손해를 보지 않는다면 집의 개수를 세어준다
						if( M * cnt - cost >= 0) {		
							answer = Math.max(answer, cnt);
						}
						
					}
				}
			}
			
			System.out.println("#"+tc+" "+answer);
			
		}
	}
	

}
