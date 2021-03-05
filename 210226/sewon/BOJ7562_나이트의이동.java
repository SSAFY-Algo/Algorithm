import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {

	static class Night {
		Point pos;
		int count;
		
		public Night(Point pos, int count) {
			this.pos = pos;
			this.count = count;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[][] dir = { {-2, -1}, {-1, -2}, {-2, 1}, {-1, 2}, {2, -1}, {1, -2}, {2, 1}, {1, 2} };
		while(T-- > 0) {
			int length = Integer.parseInt(br.readLine());
			boolean[][] visited = new boolean[length][length];
			int count = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			Point now = new Point(x, y);
			
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			Point aim = new Point(x, y);
			
			Queue<Night> q = new LinkedList<Night>();
			q.offer(new Night(now, 0));
			visited[now.x][now.y] = true;
			
			while(!q.isEmpty()) {
				Night p = q.poll();
				if(p.pos.x == aim.x && p.pos.y == aim.y) {
					System.out.println(p.count);
					break;
				}
				
				for (int i = 0; i < 8; i++) {
					int nx = p.pos.x + dir[i][0];
					int ny = p.pos.y + dir[i][1];
					
					if(nx >= 0 && nx < length && ny >= 0 && ny < length && !visited[nx][ny]) {
						q.offer(new Night(new Point(nx, ny), p.count + 1));
						visited[nx][ny] = true;
					}
				}
			}
			
		}
	}

}
