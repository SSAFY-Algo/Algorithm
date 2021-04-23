import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    static HashSet<String> numberSet;
    static int[][] board;
    static int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};  // 동서남북 이동을 위한 delta

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int TestCase = 1; TestCase <= T; TestCase++) {
            numberSet = new HashSet<>();
            board = new int[4][4];  // 격자판
            int count = 0;  // 서로 다른 일곱 자리 수들의 개수

            StringTokenizer st = null;
            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < 4; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    DFS(i, j, 0, Integer.toString(board[i][j]));
                }
            }

            count = numberSet.size();
            System.out.println("#" + TestCase + " " + count);
        }
    }

    private static void DFS(int x, int y, int count, String str) {
        if (count == 6) {
            numberSet.add(str);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + d[i][0];
            int ny = y + d[i][1];

            if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4) {
                DFS(nx, ny, count + 1, str + Integer.toString(board[nx][ny]));
            }
        }
    }
}
