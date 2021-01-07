import java.io.*;
import java.util.*;

public class BOJ9375_패션왕 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> fashion = new HashMap<>();
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                String cloth = st.nextToken();
                String type = st.nextToken();
                if(fashion.containsKey(type))   fashion.put(type, fashion.get(type)+1);
                else                            fashion.put(type, 1);
            }

            int answer = 1;
            for (String key : fashion.keySet()) {
                answer *= fashion.get(key) + 1;
            }
            System.out.println(answer-1);
        }
    }
}
