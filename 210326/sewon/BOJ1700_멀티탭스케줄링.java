import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int answer = 0;
        int[] isUsing = new int[N]; // 현재 멀티 탭에 꽂혀있는 전기용품 목록
        int[] order = new int[K];   // 전기용품 사용 스케쥴

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(st.nextToken());
            order[i] = num;
        }

        int usingIndex = 0;
        for (int i = 0; i < K; i++) {
            int now = order[i]; // now를 꽂으려 한다

            // 이미 꽂혀있는 용품인 경우는 PASS!
            if (!checkUsing(isUsing, now)) {
                if (usingIndex < N) {
                    isUsing[usingIndex++] = now;
                } else {
                    // 현재 꽂혀있는 용품 중 남은 사용횟수 중 가장 나중에 쓰면서, 가장 적게 남은 것을 갈아 끼운다
                    int changeIndex = change(isUsing, order, i);
                    isUsing[changeIndex] = now;
                    answer++;
                }
            }

        }

        System.out.println(answer);
    }

    private static int change(int[] isUsing, int[] order, int now) {
        int[] startIndex = new int[isUsing.length];

        // 현재 꽂혀있는 용품들이 now 이후에 처음 사용되는 때가 언제인지 찾는다.
        for (int i = 0; i < isUsing.length; i++) {
            startIndex[i] = findStart(order, now, isUsing[i]);
        }

        int index = 0;
        int maxStartIndex = startIndex[index];
        for (int i = 1; i < isUsing.length; i++) {
            if (startIndex[i] > maxStartIndex) {
                index = i;
                maxStartIndex = startIndex[index];
            }
        }
        return index;
    }

    private static int findStart(int[] order, int now, int num) {
        for (int k = now; k < order.length; k++) {
            if (order[k] == num) {
                return k;
            }
        }
        return Integer.MAX_VALUE;   // now 이후 더 이상 사용되지 않는다.
    }

    private static boolean checkUsing(int[] isUsing, int num) {
        for (int i = 0; i < isUsing.length; i++) {
            if (isUsing[i] == num) {
                return true;
            }
        }
        return false;
    }

}
