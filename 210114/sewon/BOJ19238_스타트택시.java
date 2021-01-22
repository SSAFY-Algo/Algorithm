import java.io.*;
import java.util.*;

public class BOJ19238_스타트택시 {
    public static class Customer implements Comparable<Customer> {
        int distance, startR, startC, endR, endC;

        public Customer(int startR, int startC, int endR, int endC) {
            this.startR = startR;
            this.startC = startC;
            this.endR = endR;
            this.endC = endC;
        }

        public Customer(int distance, int startR, int startC) {
            this.distance = distance;
            this.startR = startR;
            this.startC = startC;
        }

        @Override
        public int compareTo(Customer o) {
            if(this.distance == o.distance) {
                if (this.startR == o.startR) return this.startC - o.startC;
                return this.startR - o.startR;
            }
            return this.distance - o.distance;
        }
    }

    static int N;
    static int[][] map;
    static int[][] dir = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int fuel = Integer.parseInt(st.nextToken());
        int customerCount = 0;

        // intput
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        int taxiR = Integer.parseInt(st.nextToken()) - 1;
        int taxiC = Integer.parseInt(st.nextToken()) - 1;

        ArrayList<Customer> customers = new ArrayList<Customer>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int startR = Integer.parseInt(st.nextToken()) - 1;
            int startC = Integer.parseInt(st.nextToken()) - 1;
            int endR = Integer.parseInt(st.nextToken()) - 1;
            int endC = Integer.parseInt(st.nextToken()) - 1;
            map[startR][startC] = 2;

            customers.add(new Customer(startR, startC, endR, endC));
        }

        while(true) {
            int customerIndex = findCustomer(taxiR, taxiC, customers);
            if(customerIndex == -1) {   // 태울 승객을 못 찾음
                if(customerCount < M)   fuel = -1;
                break;
            }
            // 승객을 목적지까지 데려다 줌
            int startR = customers.get(customerIndex).startR;
            int startC = customers.get(customerIndex).startC;
            int endR = customers.get(customerIndex).endR;
            int endC = customers.get(customerIndex).endC;
            int distance = getDistance(startR, startC, endR, endC);

            // 택시가 승객을 태우러 못가거나, 출발지에서 목적지까지 갈 수 없는 경우
            if(fuel < customers.get(customerIndex).distance || distance == -1 || fuel-customers.get(customerIndex).distance < distance) {
                fuel = -1;
                break;
            }

            fuel = fuel - customers.get(customerIndex).distance + distance;
            taxiR = endR;
            taxiC = endC;
            customerCount++;
        }

        System.out.println(fuel);
    }

    private static int findCustomer(int R, int C, ArrayList<Customer> customers) {
        PriorityQueue<Customer> pq = new PriorityQueue<Customer>();
        boolean[][] visit = new boolean[N][N];
        pq.add(new Customer(0, R, C));
        visit[R][C] = true;

        int ret = -1;
        while(!pq.isEmpty()) {
            Customer customer = pq.poll();

            if(map[customer.startR][customer.startC] == 2) {
                for (int i = 0; i < customers.size(); i++) {
                    if(customers.get(i).startR == customer.startR && customers.get(i).startC == customer.startC) {
                        ret = i;
                        customers.get(i).distance = customer.distance;
                        map[customer.startR][customer.startC] = 0;
                    }
                }
                break;
            }

            for (int k = 0; k < 4; k++) {
                int nextR = customer.startR + dir[k][0];
                int nextC = customer.startC + dir[k][1];

                if(nextR >= 0 && nextR < N && nextC >= 0 &&nextC < N && map[nextR][nextC] != 1 && !visit[nextR][nextC]) {
                    visit[nextR][nextC] = true;
                    pq.add(new Customer(customer.distance+1, nextR, nextC));
                }

            }
        }
        return ret;
    }

    private static int getDistance(int startR, int startC, int endR, int endC) {
        int[][] distance = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        distance[startR][startC] = 0;
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[] {startR, startC});

        while(!q.isEmpty()) {
            int[] now = q.poll();

            for (int k = 0; k < 4; k++) {
                int nextR = now[0] + dir[k][0];
                int nextC = now[1] + dir[k][1];

                if(nextR == endR && nextC == endC) {
                    if(distance[nextR][nextC] > distance[now[0]][now[1]]+1) return distance[now[0]][now[1]]+1;
                    return distance[nextR][nextC];
                }

                if(nextR >= 0 && nextR < N && nextC >= 0 &&nextC < N && map[nextR][nextC] != 1) {
                    if(distance[nextR][nextC] > distance[now[0]][now[1]]+1) {
                        distance[nextR][nextC] = distance[now[0]][now[1]]+1;
                        q.add(new int[] {nextR, nextC});
                    }
                }
            }
        }
        return -1;
    }
}
