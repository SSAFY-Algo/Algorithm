import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static class Info {
        int node;   // 도착정점
        int weight; // 가중치

        public Info(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    private static class Current implements Comparable<Current> {
        int node;
        int sum;    // 현재 노드까지의 가중치의 합

        public Current(int node, int sum) {
            this.node = node;
            this.sum = sum;
        }

        @Override
        public int compareTo(Current o) {
            return o.sum - sum;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int V = Integer.parseInt(st.nextToken());    // 정점개수
        int E = Integer.parseInt(st.nextToken());    // 간선개수
        int K = Integer.parseInt(br.readLine());    // 시작정점
        ArrayList<ArrayList<Info>> list = new ArrayList<>();    // 인접리스트
        int[] dis = new int[V + 1];   // K에서 i노드로 가는 경로의 가중치의 합(최소)
        boolean[] visit = new boolean[V + 1]; // 방문체크

        for (int i = 0; i <= V; i++) {
            list.add(new ArrayList<>());
        }

        // 인접리스트 입력받기
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.get(start).add(new Info(end, weight));
        }

        // 초기화
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[K] = 0;

        PriorityQueue<Current> pq = new PriorityQueue<>(Collections.reverseOrder());    // min heap
        pq.offer(new Current(K, 0));

        while (!pq.isEmpty()) {
            Current current = pq.poll();
            if (visit[current.node]) {
                continue;
            }
            visit[current.node] = true;

            // 선택된 정점과 연결된 다른 정점 탐색
            for (int i = 0; i < list.get(current.node).size(); i++) {
                int node = list.get(current.node).get(i).node;
                int weigth = list.get(current.node).get(i).weight;

                // dis 값 갱신
                if (dis[node] > current.sum + weigth) {
                    dis[node] = current.sum + weigth;
                    pq.offer(new Current(node, dis[node]));
                }
            }
        }

        // output
        for (int i = 1; i <= V; i++) {
            if (dis[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dis[i]);
            }
        }
    }
}
