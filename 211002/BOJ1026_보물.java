import java.io.*;
import java.util.*;

public class BOJ1026_보물 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[2][N];
        int S = 0;

        for (int k = 0; k < 2; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                arr[k][i] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(arr[0]);
        Integer[] arrB = Arrays.stream(arr[1]).boxed().toArray(Integer[] :: new);
        Arrays.sort(arrB, Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            S += arr[0][i]* arrB[i];
        }
        System.out.println(S);
    }
}
