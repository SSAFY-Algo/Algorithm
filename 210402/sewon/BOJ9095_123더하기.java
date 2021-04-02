import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] DP = new int[11];
        DP[0] = 1;
        DP[1] = 1;
        DP[2] = 2;
        for (int testCase = 0; testCase < T; testCase++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(get(DP, n));
        }
    }

    private static int get(int[] DP, int n) {
        if (DP[n] > 0) {
            return DP[n];
        }
        return get(DP, n - 1) + get(DP, n - 2) + get(DP, n - 3);
    }
}
