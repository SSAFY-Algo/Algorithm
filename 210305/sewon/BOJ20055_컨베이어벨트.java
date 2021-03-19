import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int level = 0;
        int[] A = new int[2*N];
        boolean[] robot = new boolean[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 2*N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        while(!isEnd(A, K)) {
            level++;
            rotateBelt(A, robot);
            moveRobot(A, robot);
            addRobot(A, robot);
        }
        System.out.println(level);
    }

    // 올라가는 위치에 로봇 올리기(robot값 true처리, A값 계산)
    public static void addRobot(int[] A, boolean[] robot) {
        if(!robot[0] && A[0] > 0) {
            robot[0] = true;
            A[0]--;
        }
    }

    // 로봇 이동
    public static void moveRobot(int[] A, boolean[] robot) {
        // 가장 먼저 벨트에 올라간 로봇부터(N부터 for문) 다음칸으로 이동시킬 수 있는지 확인
        for (int i = robot.length-2; i >= 0; i--) {
            // 다음칸에 로봇이 없고, 내구도가 0보다 큰 곳이 있으면 이동
            if(robot[i] && !robot[i+1] && A[i+1] > 0) {
                robot[i] = false;
                robot[i+1] = true;
                A[i+1]--;
            }
        }
    }

    // 벨트 회전
    public static void rotateBelt(int[] A, boolean[] robot) {

        // A 이동
        int tmp = A[A.length-1];
        for (int i = A.length-1; i > 0 ; i--) {
            A[i] = A[i-1];
        }
        A[0] = tmp;


        // robot 이동
        robot[robot.length-1] = false;  // 내려가는 칸의 로봇은 항상 내림
        for (int i = robot.length-2; i > 0 ; i--) {
            robot[i] = robot[i-1];
        }
        robot[0] = false;
    }

    // A배열의 0의 갯수를 카운트해서 K보다 크면 level값을 출력하고 종료
    public static boolean isEnd(int[] A, int K) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) count++;
            if(count >= K)  return true;
        }
        return false;
    }
}
