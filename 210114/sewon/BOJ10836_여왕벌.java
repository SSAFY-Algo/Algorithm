import java.io.*;
import java.util.*;

public class BOJ10836_여왕벌 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] map = new int[M][M];
        int[][] note = new int[M][M];
        int[] size = new int[3];
        ArrayList<Integer> order = new ArrayList<Integer>();

        // map init
        for (int i = 0; i < M; i++) {
            Arrays.fill(map[i], 1);
        }

        for (int i = 0; i < N; i++) {
            order.clear();
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                size[j] = Integer.parseInt(st.nextToken());
                if(size[j] == 0) continue;
                for (int k = 0; k < size[j]; k++) {
                    order.add(j);
                }
            }

            // 왼쪽, 위쪽 먼저 계산
            int count = 0;
            for (int r = M-1; r >= 0; r--) {
                note[r][0] = order.get(count++);
            }
            for (int c = 1; c < M; c++) {
                note[0][c] = order.get(count++);
            }

            // 나머지 계산
            for (int r = 1; r < M; r++) {
                for (int c = 1; c <M; c++) {
                    int maxSize = Integer.MIN_VALUE;
                    maxSize = Math.max(maxSize, note[r-1][c]);
                    maxSize = Math.max(maxSize, note[r][c-1]);
                    maxSize = Math.max(maxSize, note[r-1][c-1]);
                    note[r][c] = maxSize;
                }
            }

            // note를 map에 반영
            for (int r = 0; r < M; r++) {
                for (int c = 0; c < M; c++) {
                    map[r][c] += note[r][c];
                }
            }
        } // end for i

        for (int r = 0; r < M; r++) {
            for (int c = 0; c < M; c++) {
                System.out.print(map[r][c] + " ");
            }
            System.out.println();
        }
    }
}
