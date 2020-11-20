package study3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14442_벽부수고이동하기2 {

		//벽을 부순 횟수가 다르면 서로 이동거리를 비교하는게 무의미하다 -> 포인트
		//왜냐하면 k개만큼 부수고 최단거리로 와서 dist을 다 갱신해버렸는데 마지막 도착지점이 벽으로 감싸져있다면? 올바른 정답을 구할 수 없다
	    static int N, M, K;
	    static int result = Integer.MAX_VALUE;
	    static int[][] map;
	    static int[][][] dist; 
	    
	    static int[] dx = {-1, 1, 0, 0};
	    static int[] dy = {0, 0, -1, 1};
	    
	    static class Point{
	        int x;
	        int y;
	        int wall;
	        int cnt;
	        public Point(int x, int y, int wall, int cnt) {
	            super();
	            this.x = x;
	            this.y = y;
	            this.wall = wall;
	            this.cnt = cnt; 
	        }
	    }
	    
	    public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());
	         
	        N = Integer.parseInt(st.nextToken());
	        M = Integer.parseInt(st.nextToken());
	        K = Integer.parseInt(st.nextToken());
	        
	        map = new int[N][M];
	        dist = new int[N][M][K+1]; 
	     
	        for(int i=0; i<N; i++) {
	            String str = br.readLine();
	            for(int j=0; j<M; j++) {
	                map[i][j] = str.charAt(j) - '0';
	            }
	        }

	        
	        for(int i=0;i<K;i++) {
	        	dist[N-1][M-1][i] = Integer.MAX_VALUE;
	        }
	        
	        
	        
	        dist[0][0][0] = 1;
	        bfs();
	        
	         
	        //결과가 존재하면 결과를 출력
	        if(result != Integer.MAX_VALUE) {
	        	System.out.println(result);
	        	return;
	        }
	        System.out.println("-1"); //결과가 없음
	    }

	    private static void bfs() {
	        Queue<Point> q = new LinkedList<>();
	        q.add(new Point(0, 0, 0, 1)); //1회로 시작
	        
	        while(!q.isEmpty()) {
	            Point p = q.poll();
	            
	            if(p.x == N-1 && p.y == M-1 && p.wall <= K) {
	                result = Math.min(dist[p.x][p.y][p.wall], result);
	            }
	            
	            for(int k=0; k<4; k++) {
	                int nx = p.x + dx[k];
	                int ny = p.y + dy[k];
	                
	                if((nx==0 && ny==0) || nx < 0 || ny < 0 || nx > N-1 || ny > M-1) continue;
	                
	                //벽이 없을때
	                if(map[nx][ny] == 0) { 
	                	if(dist[nx][ny][p.wall] > dist[p.x][p.y][p.wall] + 1 | dist[nx][ny][p.wall] == 0) {
	                		//0이면 그냥 넣기 아니면 벽 부순횟수가 '동일'할 때, 나보다 적게 이동하고 온 적이 있는가?
	                		dist[nx][ny][p.wall] = p.cnt + 1;
	                		q.add(new Point(nx, ny, p.wall, p.cnt+1));
	                	}
	                }
	                //벽이 있을때
	                else if(map[nx][ny] == 1 && p.wall < K) {
	                	if(dist[nx][ny][p.wall+1] > dist[p.x][p.y][p.wall] + 1 | dist[nx][ny][p.wall+1] == 0) {
	                		//0이면 온 적 없으니까 그냥 넣기 아니면 벽 부순 횟수+1 일때, 나보다 적게 이동하고 온 적이 있는가?
	                		dist[nx][ny][p.wall+1] = p.cnt + 1;
	                		q.add(new Point(nx, ny, p.wall+1, p.cnt+1));
	                	}            
	                }
	            }   
	        }
	    }

}
