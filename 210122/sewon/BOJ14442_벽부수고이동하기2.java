import java.io.*;
import java.util.*;

public class BOJ14442_벽부수고이동하기2 {

    private static class Point {
        int r, c, k, count;

        public Point(int r, int c, int k, int count) {
            this.r = r;
            this.c = c;
            this.k = k;
            this.count = count;
        }
    }

    static int[][] dir = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
    static int N, M, K, answer;
    static int[][] map;
    static boolean[][][] visit;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        answer = Integer.MAX_VALUE;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M][K+1];

        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = chars[j] - '0';
            }
        }

        // BFS
        Queue<Point> q = new LinkedList<Point>();
        q.add(new Point(0, 0, K, 1));

        while (!q.isEmpty()) {
            Point now = q.poll();
            visit[now.r][now.c][now.k] = true;

            // 목적지에 도착
            if(now.r == N-1 && now.c == M-1) {
                answer = Math.min(answer, now.count);
                break;
            }

            // 목적지에 도착 X
            for (int k = 0; k < 4; k++) {
                int nr = now.r + dir[k][0];
                int nc = now.c + dir[k][1];

                if(nr >= 0 && nr < N && nc >= 0 && nc < M) {    // 범위 내에 있고
                    if(map[nr][nc] == 0) {  // 벽이 없는 곳
                        if(!visit[nr][nc][now.k]) {
                            q.add(new Point(nr, nc, now.k, now.count+1));
                        }
                    }
                    else {    // 벽이 있는 곳
                       if(now.k > 0 && !visit[nr][nc][now.k-1]) {
                           q.add(new Point(nr, nc, now.k-1, now.count+1));
                       }
                    }
                }
            }

        }
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
        return;
    }
}
