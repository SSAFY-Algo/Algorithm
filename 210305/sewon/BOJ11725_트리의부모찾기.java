import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> graph[] = new ArrayList[N+1];
        int[] parents = new int[N+1];

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        // 인접 행렬 채우기
        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        Arrays.fill(parents, -1);   // 방문체크하기 위해 초기화
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1);
        parents[1] = 0;
        while(!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < graph[now].size() ; i++) {
                int node = graph[now].get(i);
                if(parents[node] < 0) {
                    q.add(node);
                    parents[node] = now;
                }
            }
        }

        for (int i = 2; i <= N; i++) {
            System.out.println(parents[i]);
        }
    }
}
