import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.awt.Point;

public class BOJ20056_마법사상어와토네이도 {
    private static int dir[][] = { {0, -1}, {1, 0}, {0, 1}, {-1, 0} };
    private static float percent[][][] = {
            {
                    {1, 0, 0.01f}, {-1, 0, 0.01f}, {-1, -1, 0.07f}, {1, -1, 0.07f},
                    {-2, -1, 0.02f}, {2, -1, 0.02f}, {-1, -2, 0.1f}, {1, -2, 0.1f}, {0, -3, 0.05f}
            },
            {
                    {0, 1, 0.01f}, {0, -1, 0.01f}, {1, -1, 0.07f}, {1, 1, 0.07f},
                    {1, -2, 0.02f}, {1, 2, 0.02f}, {2, -1, 0.1f}, {2, 1, 0.1f}, {3, 0, 0.05f}
            },
            {
                    {1, 0, 0.01f}, {-1, 0, 0.01f}, {-1, 1, 0.07f}, {1, 1, 0.07f},
                    {-2, 1, 0.02f}, {2, 1, 0.02f}, {-1, 2, 0.1f}, {1, 2, 0.1f}, {0, 3, 0.05f}
            },
            {
                    {0, 1, 0.01f}, {0, -1, 0.01f}, {1, -1, 0.07f}, {1, 1, 0.07f},
                    {1, -2, 0.02f}, {1, 2, 0.02f}, {2, -1, 0.1f}, {2, 1, 0.1f}, {3, 0, 0.05f}
            },
    };
    private static int N, answer;   // 격자 크기, 격자 밖으로 나간 모래의 양
    private static int[][] A;   // 격자
    private static int k, moveDir, moveCount;  // moveDir 방향으로 k칸씩 이동, 이동할 방향, 2번 카운트

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        k = 1;
        Point x = new Point(N/2, N/2);    // 현재 위치

        while(x.x >= 0 && x.y >= 0) {
            // 1. 현재 위치 x의 다음 방향 y와 α설정
            Point y = new Point(x.x+dir[moveDir][0], x.y+dir[moveDir][1]);
            Point alpha = new Point(x.x+dir[moveDir][0]*2, x.y+dir[moveDir][1]*2);

            // 2. 모래 이동
            int sand = A[y.x][y.y];
            A[y.x][y.y] = 0;
            int temp = 0;

            for (int i = 0; i < 9; i++) {
                int nx = y.x + (int)percent[moveDir][i][0];
                int ny = y.y + (int)percent[moveDir][i][1];
                int newSand = (int)Math.floor(sand * percent[moveDir][i][2]);

                if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    temp += newSand;
                    A[nx][ny] += newSand;
                }
                else {  // 격자 밖으로 나간 것
                    answer += newSand;
                }
            }
            A[alpha.x][alpha.y] += sand - temp;


            // 3. x 이동
            x.x = x.x + dir[moveDir][0]*k;
            x.y = x.y + dir[moveDir][1]*k;

            // 4. 방향 전환 & moveCount 설정
            changeDir();
        }

        // 마지막 이동 처리 y = (0,0)
        int sand = A[0][0];
        A[0][0] = 0;
        int temp = 0;

        for (int i = 0; i < 9; i++) {
            int nx = 0 + (int)percent[0][i][0];
            int ny = 0 + (int)percent[0][i][1];
            int newSand = (int)Math.floor(sand * percent[0][i][2]);

            if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
                temp += newSand;
                A[nx][ny] += newSand;
            }
            else {  // 격자 밖으로 나간 것
                answer += newSand;
            }
        }
        answer += sand - temp;

        // output
        System.out.println(answer);
    }

    private static void changeDir() {
        // 좌, 하, 우, 상 순서로 변환
        moveDir = (moveDir + 1) % 4;

        // 방향 전환 체크 : 같은 간격으로 2번씩만 움직이도록
        if(moveCount + 1 == 2) {
            k++;
            moveCount = 0;
        }
        else {
            moveCount++;
        }
    }
}
