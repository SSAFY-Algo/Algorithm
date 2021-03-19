import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static double answer;
    private static double[] percentage;
    private static boolean[][] isVisited;
    private static int[][] d = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        isVisited = new boolean[50][50];
        percentage = new double[4];
        for (int i = 0; i < 4; i++) {
            percentage[i] = Double.parseDouble(st.nextToken())/100;
        }

        isVisited[25][25] = true;
        dfs(0, 25, 25, 1.0f);

        System.out.println(answer);
    }

    private static void dfs(int cnt, int r, int c, double per) {
        // 기저 조건
        if(cnt == N) {
            answer += per;   // 확률 더하기
            return;
        }

        // 유도 조건
        for (int i = 0; i < 4; i++) {
            if(percentage[i] > 0) { // 그 방향으로 갈 확률이 있고
                int nr = r + d[i][0];
                int nc = c + d[i][1];

                if (!isVisited[nr][nc]) {   // 아직 방문하지 않은 곳이면 방문
                    isVisited[nr][nc] = true;
                    dfs(cnt + 1, nr, nc, per * percentage[i]);
                    isVisited[nr][nc] = false;
                }
            }
        }
    }
}