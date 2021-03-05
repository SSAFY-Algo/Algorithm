import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7562_나이트의이동 {

	static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] dy = {-2, -1, 1, 2, -2, -1, 1, 2};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int l = Integer.parseInt(br.readLine());
			boolean[][] visited = new boolean[l][l];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			
			Queue<int[]> q = new LinkedList<>();
			q.add(new int[] {startX, startY, 0});
			
			int min = 0;
			
			while(!q.isEmpty()) {
				int[] a = q.poll();
				
				if(a[0] == endX && a[1] == endY) {
					min = a[2];
					break;
				}
				
				for (int k = 0; k < 8; k++) {
					int nx = a[0] + dx[k];
					int ny = a[1] + dy[k];
					
					if(nx < 0 || ny < 0 || nx > l-1 || ny > l-1 || visited[nx][ny]) continue;
					
					q.add(new int[] {nx, ny, a[2]+1});
					visited[nx][ny] = true;
					
				}
				

			}
			
				
			System.out.println(min);
			
			
			
		}
		

	}

}
