import java.io.*;
import java.util.*;

public class BOJ10816_숫자카드 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> cards = new HashMap<Integer, Integer>();

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(!cards.containsKey(num)) {
                cards.put(num, 1);
            }
            else cards.put(num, cards.get(num)+1);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(!cards.containsKey(num)) {
                bw.write("0 ");
            }
            else bw.write(cards.get(num) + " ");
        }
        bw.close();
    }
}
