import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[] indegree, time, answer;
    private static ArrayList<ArrayList<Integer>> workList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        indegree = new int[N+1];    // 위상 정렬 세팅을 위한 배열
        time = new int[N+1];    // 각 작업에 소요되는 시
        answer = new int[N+1];
        workList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            workList.add(new ArrayList<Integer>());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            time[i] = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num; j++) {
                int preWork = Integer.parseInt(st.nextToken());
                workList.get(preWork).add(i);   // preWork 번호의 작업을 선행작업으로 가지고 있는 리스트
                indegree[i]++;  // 현재 작업이 가지고 있는 선행 작업 개수
            }
        }
        System.out.println(topologicalSort());
    }

    private static int topologicalSort() {
        Queue<Integer> q = new LinkedList<Integer>();

        for (int i = 1; i <= N; i++) {
            answer[i] = time[i];

            // 선행작업이 0인 것들을 큐에 삽입
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }

        while(!q.isEmpty()) {
            int now = q.poll();

            // 현재 작업과 연결된 작업들의 indegree 감소
            for (int i = 0; i < workList.get(now).size(); i++) {
                int index = workList.get(now).get(i);
                indegree[index]--;
                answer[index] = Math.max(answer[now] + time[index], answer[index]);

                if(indegree[index] == 0) {
                    q.offer(index);
                }
            }
        }

        int ret = 0;
        for (int i = 1; i <= N; i++) {
            ret = Math.max(ret, answer[i]);
        }
        return ret;
    }
}
