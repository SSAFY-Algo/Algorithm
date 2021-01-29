import java.awt.*;
import java.io.*;
import java.util.*;

public class BOJ2234_성곽 {
    static int[][] dir = { {0,-1}, {-1,0}, {0,1}, {1,0} };
    static int n, m, roomSize, roomSize2;
    static ArrayList<Integer> area = new ArrayList<Integer>();
    static int[][] map, room;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[m][n];
        room = new int[m][n];
        roomSize = Integer.MIN_VALUE;
        area.add(0);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 방 번호를 붙이기 위해 BFS
        int roomCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(room[i][j] == 0) bfs(i, j, ++roomCount);
            }
        }

        // 벽을 하나 제거했을 때
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                getMaxArea(i, j);
            }
        }


        bw.write(roomCount + "\n");
        bw.write(roomSize + "\n");
        bw.write(roomSize2 + "\n");
        bw.flush();
    }

    private static void getMaxArea(int r, int c) {
        for (int k = 0; k < 4; k++) {
            int nr = r + dir[k][0];
            int nc = c + dir[k][1];

            if(nr >= 0 && nr < m && nc >= 0 && nc <n) {
                // 벽이 있고, 다른 방이라면
                if((map[r][c] & (1<<k)) != 0 && room[r][c] != room[nr][nc]) {
                    int sum = area.get(room[r][c]) + area.get(room[nr][nc]);
                    roomSize2 = Math.max(roomSize2, sum);
                }
            }
        }
    }

    private static void bfs(int r, int c, int number) {
        Queue<Point> q = new LinkedList<Point>();
        q.add(new Point(r, c));
        room[r][c] = number;

        int size = 0;
        size++;

        while(!q.isEmpty()) {
            Point now = q.poll();

            for (int k = 0; k < 4; k++) {
                // 벽이 있으면 가지 않는다.
                if((map[now.x][now.y] & (1 << k)) != 0) continue;

                int nr = now.x + dir[k][0];
                int nc = now.y + dir[k][1];
                if(room[nr][nc] == 0) { // 아직 방문하지 않은 곳이면
                    room[nr][nc] = number;
                    q.add(new Point(nr, nc));
                    size++;
                }
            }
        }

        area.add(size);

        // 방 넓이 최댓값 갱신
        roomSize = Math.max(roomSize, size);
    }
}
