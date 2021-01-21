import java.util.*;
import java.io.*;

public class BOJ2805_나무자르기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] tree = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(tree);

        for (int H = tree[N-1]; H >= 0; H--) {
            int sum = 0;
            for (int i = N-1; i >= 0; i--) {
                if(H >= tree[i])    break;
                sum += tree[i] - H;
            }

            if(sum >= M) {
                System.out.println(H);
                return;
            }
        }

    }
}
